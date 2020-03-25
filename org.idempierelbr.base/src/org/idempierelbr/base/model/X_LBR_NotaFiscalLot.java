/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.idempierelbr.base.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LBR_NotaFiscalLot
 *  @author iDempiere (generated) 
 *  @version Release 2.0 - $Id$ */
public class X_LBR_NotaFiscalLot extends PO implements I_LBR_NotaFiscalLot, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20140606L;

    /** Standard Constructor */
    public X_LBR_NotaFiscalLot (Properties ctx, int LBR_NotaFiscalLot_ID, String trxName)
    {
      super (ctx, LBR_NotaFiscalLot_ID, trxName);
      /** if (LBR_NotaFiscalLot_ID == 0)
        {
			setDocumentNo (null);
			setLBR_LotQueried (false);
			setLBR_LotSent (false);
			setLBR_ProcessingType (null);
        } */
    }

    /** Load Constructor */
    public X_LBR_NotaFiscalLot (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 1 - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LBR_NotaFiscalLot[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_ValueNoCheck (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set NF-e Lot Queried.
		@param LBR_LotQueried 
		Indicate if the NF-e Lot was queried correctly to Sefaz
	  */
	public void setLBR_LotQueried (boolean LBR_LotQueried)
	{
		set_Value (COLUMNNAME_LBR_LotQueried, Boolean.valueOf(LBR_LotQueried));
	}

	/** Get NF-e Lot Queried.
		@return Indicate if the NF-e Lot was queried correctly to Sefaz
	  */
	public boolean isLBR_LotQueried () 
	{
		Object oo = get_Value(COLUMNNAME_LBR_LotQueried);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set NF-e Lot Queried On.
		@param LBR_LotQueriedOn 
		The date+time (expressed in decimal format) when the NF-e Lot has been queried
	  */
	public void setLBR_LotQueriedOn (Timestamp LBR_LotQueriedOn)
	{
		set_Value (COLUMNNAME_LBR_LotQueriedOn, LBR_LotQueriedOn);
	}

	/** Get NF-e Lot Queried On.
		@return The date+time (expressed in decimal format) when the NF-e Lot has been queried
	  */
	public Timestamp getLBR_LotQueriedOn () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LBR_LotQueriedOn);
	}

	/** 100 - Autorizado o uso da NF-e = 100 */
	public static final String LBR_LOTQUERYSTATUS_100_AutorizadoOUsoDaNF_E = "100";
	/** Set NF-e Lot Query Status.
		@param LBR_LotQueryStatus 
		Indicates the status of the query process to Sefaz
	  */
	public void setLBR_LotQueryStatus (String LBR_LotQueryStatus)
	{

		set_Value (COLUMNNAME_LBR_LotQueryStatus, LBR_LotQueryStatus);
	}

	/** Get NF-e Lot Query Status.
		@return Indicates the status of the query process to Sefaz
	  */
	public String getLBR_LotQueryStatus () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotQueryStatus);
	}

	/** Set NF-e Lot Sending Protocol.
		@param LBR_LotSendingProt 
		Indicates the protocol of the sending process to Sefaz
	  */
	public void setLBR_LotSendingProt (String LBR_LotSendingProt)
	{
		set_Value (COLUMNNAME_LBR_LotSendingProt, LBR_LotSendingProt);
	}

	/** Get NF-e Lot Sending Protocol.
		@return Indicates the protocol of the sending process to Sefaz
	  */
	public String getLBR_LotSendingProt () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotSendingProt);
	}

	/** Set NF-e Lot Sending Receipt.
		@param LBR_LotSendingRec 
		Indicates the receipt of the sending process to Sefaz
	  */
	public void setLBR_LotSendingRec (String LBR_LotSendingRec)
	{
		set_Value (COLUMNNAME_LBR_LotSendingRec, LBR_LotSendingRec);
	}

	/** Get NF-e Lot Sending Receipt.
		@return Indicates the receipt of the sending process to Sefaz
	  */
	public String getLBR_LotSendingRec () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotSendingRec);
	}

	/** 100 - Autorizado o uso da NF-e = 100 */
	public static final String LBR_LOTSENDINGSTATUS_100_AutorizadoOUsoDaNF_E = "100";
	/** Set NF-e Lot Sending Status.
		@param LBR_LotSendingStatus 
		Indicates the status of the sending process to Sefaz
	  */
	public void setLBR_LotSendingStatus (String LBR_LotSendingStatus)
	{

		set_Value (COLUMNNAME_LBR_LotSendingStatus, LBR_LotSendingStatus);
	}

	/** Get NF-e Lot Sending Status.
		@return Indicates the status of the sending process to Sefaz
	  */
	public String getLBR_LotSendingStatus () 
	{
		return (String)get_Value(COLUMNNAME_LBR_LotSendingStatus);
	}

	/** Set NF-e Lot Sent.
		@param LBR_LotSent 
		Indicate if the NF-e Lot was sent correctly to Sefaz
	  */
	public void setLBR_LotSent (boolean LBR_LotSent)
	{
		set_Value (COLUMNNAME_LBR_LotSent, Boolean.valueOf(LBR_LotSent));
	}

	/** Get NF-e Lot Sent.
		@return Indicate if the NF-e Lot was sent correctly to Sefaz
	  */
	public boolean isLBR_LotSent () 
	{
		Object oo = get_Value(COLUMNNAME_LBR_LotSent);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set NF-e Lot Sent On.
		@param LBR_LotSentOn 
		The date+time (expressed in decimal format) when the NF-e Lot has been sent
	  */
	public void setLBR_LotSentOn (Timestamp LBR_LotSentOn)
	{
		set_Value (COLUMNNAME_LBR_LotSentOn, LBR_LotSentOn);
	}

	/** Get NF-e Lot Sent On.
		@return The date+time (expressed in decimal format) when the NF-e Lot has been sent
	  */
	public Timestamp getLBR_LotSentOn () 
	{
		return (Timestamp)get_Value(COLUMNNAME_LBR_LotSentOn);
	}

	/** Set NF-e Lot.
		@param LBR_NotaFiscalLot_ID 
		Identifies a NF-e Lot
	  */
	public void setLBR_NotaFiscalLot_ID (int LBR_NotaFiscalLot_ID)
	{
		if (LBR_NotaFiscalLot_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscalLot_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscalLot_ID, Integer.valueOf(LBR_NotaFiscalLot_ID));
	}

	/** Get NF-e Lot.
		@return Identifies a NF-e Lot
	  */
	public int getLBR_NotaFiscalLot_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_NotaFiscalLot_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Brazilian Fiscal Invoice (Nota Fiscal).
		@param LBR_NotaFiscal_UU 
		Brazilian Fiscal Invoice (Nota Fiscal) Identifier
	  */
	public void setLBR_NotaFiscal_UU (String LBR_NotaFiscal_UU)
	{
		set_ValueNoCheck (COLUMNNAME_LBR_NotaFiscal_UU, LBR_NotaFiscal_UU);
	}

	/** Get Brazilian Fiscal Invoice (Nota Fiscal).
		@return Brazilian Fiscal Invoice (Nota Fiscal) Identifier
	  */
	public String getLBR_NotaFiscal_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_NotaFiscal_UU);
	}

	/** Synchronous = S */
	public static final String LBR_PROCESSINGTYPE_Synchronous = "S";
	/** Asynchronous = A */
	public static final String LBR_PROCESSINGTYPE_Asynchronous = "A";
	/** Set Processing Type.
		@param LBR_ProcessingType Processing Type	  */
	public void setLBR_ProcessingType (String LBR_ProcessingType)
	{

		set_ValueNoCheck (COLUMNNAME_LBR_ProcessingType, LBR_ProcessingType);
	}

	/** Get Processing Type.
		@return Processing Type	  */
	public String getLBR_ProcessingType () 
	{
		return (String)get_Value(COLUMNNAME_LBR_ProcessingType);
	}

	/** Set Query NF-e Lot.
		@param LBR_ProcQueryNFeLot 
		Process to query NF-e Lot to Sefaz
	  */
	public void setLBR_ProcQueryNFeLot (String LBR_ProcQueryNFeLot)
	{
		set_Value (COLUMNNAME_LBR_ProcQueryNFeLot, LBR_ProcQueryNFeLot);
	}

	/** Get Query NF-e Lot.
		@return Process to query NF-e Lot to Sefaz
	  */
	public String getLBR_ProcQueryNFeLot () 
	{
		return (String)get_Value(COLUMNNAME_LBR_ProcQueryNFeLot);
	}

	/** Set Send NF-e Lot.
		@param LBR_ProcSendNFeLot 
		Process to send NF-e Lot to Sefaz
	  */
	public void setLBR_ProcSendNFeLot (String LBR_ProcSendNFeLot)
	{
		set_Value (COLUMNNAME_LBR_ProcSendNFeLot, LBR_ProcSendNFeLot);
	}

	/** Get Send NF-e Lot.
		@return Process to send NF-e Lot to Sefaz
	  */
	public String getLBR_ProcSendNFeLot () 
	{
		return (String)get_Value(COLUMNNAME_LBR_ProcSendNFeLot);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}