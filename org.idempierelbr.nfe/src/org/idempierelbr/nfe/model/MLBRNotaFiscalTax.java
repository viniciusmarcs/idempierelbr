/******************************************************************************
 * Copyright (C) 2013 Elaine Tan                                              *
 * Copyright (C) 2013 Trek Global
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.idempierelbr.nfe.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;

import org.compiere.model.MTax;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;

/**
 * 
 * @author Elaine
 *
 */
public class MLBRNotaFiscalTax extends X_LBR_NotaFiscalTax
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8702466449639865049L;

	/**
	 * 	Get Tax Line for Brazilian Fiscal Invoice (Nota Fiscal) Line
	 *	@param line Brazilian Fiscal Invoice (Nota Fiscal) line
	 *	@param precision currency precision
	 *	@param oldTax get old tax
	 *	@param trxName transaction
	 *	@return existing or new tax
	 */
	public static MLBRNotaFiscalTax get (MLBRNotaFiscalLine line, int precision, 
		boolean oldTax, String trxName)
	{
		MLBRNotaFiscalTax retValue = null;
		if (line == null || line.getLBR_NotaFiscal_ID() == 0)
		{
			s_log.fine("No Brazilian Fiscal Invoice (Nota Fiscal)");
			return null;
		}
		int C_Tax_ID = line.getC_Tax_ID();
		boolean isOldTax = oldTax && line.is_ValueChanged(MLBRNotaFiscalTax.COLUMNNAME_C_Tax_ID); 
		if (isOldTax)
		{
			Object old = line.get_ValueOld(MLBRNotaFiscalTax.COLUMNNAME_C_Tax_ID);
			if (old == null)
			{
				s_log.fine("No Old Tax");
				return null;
			}
			C_Tax_ID = ((Integer)old).intValue();
		}
		if (C_Tax_ID == 0)
		{
			s_log.fine("No Tax");
			return null;
		}
		
		String sql = "SELECT * FROM LBR_NotaFiscalTax WHERE LBR_NotaFiscal_ID=? AND C_Tax_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, trxName);
			pstmt.setInt (1, line.getLBR_NotaFiscal_ID());
			pstmt.setInt (2, C_Tax_ID);
			rs = pstmt.executeQuery ();
			if (rs.next ())
				retValue = new MLBRNotaFiscalTax (line.getCtx(), rs, trxName);
		}
		catch (Exception e)
		{
			s_log.log(Level.SEVERE, sql, e);
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		if (retValue != null)
		{
			retValue.setPrecision(precision);
			retValue.set_TrxName(trxName);
			if (s_log.isLoggable(Level.FINE)) s_log.fine("(old=" + oldTax + ") " + retValue);
			return retValue;
		}
		// If the old tax was required and there is no MOrderTax for that
		// return null, and not create another MOrderTax - teo_sarca [ 1583825 ]
		else {
			if (isOldTax)
				return null;
		}
		
		//	Create New
		retValue = new MLBRNotaFiscalTax(line.getCtx(), 0, trxName);
		retValue.set_TrxName(trxName);
		retValue.setClientOrg(line);
		retValue.setLBR_NotaFiscal_ID(line.getLBR_NotaFiscal_ID());
		retValue.setC_Tax_ID(line.getC_Tax_ID());
		retValue.setPrecision(precision);
		retValue.setIsTaxIncluded(line.getParent().isTaxIncluded());
		if (s_log.isLoggable(Level.FINE)) s_log.fine("(new) " + retValue);
		return retValue;
	}
    
	/**	Static Logger	*/
	private static CLogger	s_log	= CLogger.getCLogger (MLBRNotaFiscalTax.class);
	
	/**************************************************************************
	 * 	Persistence Constructor
	 *	@param ctx context
	 *	@param ignored ignored
	 *	@param trxName transaction
	 */
	public MLBRNotaFiscalTax (Properties ctx, int ignored, String trxName)
	{
		super(ctx, 0, trxName);
		if (ignored != 0)
			throw new IllegalArgumentException("Multi-Key");
		setTaxAmt (Env.ZERO);
		setTaxBaseAmt (Env.ZERO);
		setIsTaxIncluded(false);
	}

	/**
	 * 	Load Constructor.
	 * 	Set Precision and TaxIncluded for tax calculations!
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MLBRNotaFiscalTax (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}
	
	/** Tax							*/
	private MTax 		m_tax = null;
	/** Cached Precision			*/
	private Integer		m_precision = null;

	/**
	 * 	Get Precision
	 * 	@return Returns the precision or 2
	 */
	private int getPrecision ()
	{
		if (m_precision == null)
			return 2;
		return m_precision.intValue();
	}	//	getPrecision

	/**
	 * 	Set Precision
	 *	@param precision The precision to set.
	 */
	protected void setPrecision (int precision)
	{
		m_precision = new Integer(precision);
	}	//	setPrecision

	/**
	 * 	Get Tax
	 *	@return tax
	 */
	protected MTax getTax()
	{
		if (m_tax == null)
			m_tax = MTax.get(getCtx(), getC_Tax_ID());
		return m_tax;
	}	//	getTax
	
	/**************************************************************************
	 * 	Calculate/Set Tax Amt from Brazilian Fiscal Invoice (Nota Fiscal) Lines
	 * 	@return true if calculated
	 */
	public boolean calculateTaxFromLines ()
	{
		BigDecimal taxBaseAmt = Env.ZERO;
		BigDecimal taxAmt = Env.ZERO;
		//
		boolean documentLevel = getTax().isDocumentLevel();
		MTax tax = getTax();
		//
		String sql = "SELECT LineNetAmt FROM LBR_NotaFiscalLine WHERE LBR_NotaFiscal_ID=? AND C_Tax_ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement (sql, get_TrxName());
			pstmt.setInt (1, getLBR_NotaFiscal_ID());
			pstmt.setInt (2, getC_Tax_ID());
			rs = pstmt.executeQuery ();
			while (rs.next ())
			{
				BigDecimal baseAmt = rs.getBigDecimal(1);
				taxBaseAmt = taxBaseAmt.add(baseAmt);
				//
				if (!documentLevel)		// calculate line tax
					taxAmt = taxAmt.add(tax.calculateTax(baseAmt, isTaxIncluded(), getPrecision()));
			}
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, get_TrxName(), e);
			taxBaseAmt = null;
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		//
		if (taxBaseAmt == null)
			return false;
		
		//	Calculate Tax
		if (documentLevel)		//	document level
			taxAmt = tax.calculateTax(taxBaseAmt, isTaxIncluded(), getPrecision());
		setTaxAmt(taxAmt);

		//	Set Base
		if (isTaxIncluded())
			setTaxBaseAmt (taxBaseAmt.subtract(taxAmt));
		else
			setTaxBaseAmt (taxBaseAmt);
		if (log.isLoggable(Level.FINE)) log.fine(toString());
		return true;
	}	//	calculateTaxFromLines

	/**
	 * 	String Representation
	 *	@return info
	 */
	public String toString ()
	{
		StringBuffer sb = new StringBuffer ("MLBRNotaFiscalTax[")
			.append("LBR_NotaFiscal_ID=").append(getLBR_NotaFiscal_ID())
			.append(", C_Tax_ID=").append(getC_Tax_ID())
			.append(", Base=").append(getTaxBaseAmt())
			.append(", Tax=").append(getTaxAmt())
			.append ("]");
		return sb.toString ();
	}	//	toString
}
