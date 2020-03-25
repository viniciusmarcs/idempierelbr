package org.idempierelbr.base.callout;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.idempierelbr.base.model.MLBRDocLineCOFINS;
import org.idempierelbr.base.model.MLBRDocLineICMS;
import org.idempierelbr.base.model.MLBRDocLineIPI;
import org.idempierelbr.base.model.MLBRDocLinePIS;
import org.idempierelbr.base.model.MLBRNFS;
import org.idempierelbr.base.model.MLBRNotaFiscal;
import org.idempierelbr.base.model.MLBRNotaFiscalLine;
import org.idempierelbr.base.wrapper.I_W_C_BPartner;
import org.idempierelbr.base.wrapper.I_W_C_BPartner_Location;

/**
 * Esta classe é uma implementação da callout factory.
 * Ela fornece uma forma centralizada para o mecanismo de callout.
 *
 * @author Alan <alan.lesc1@gmail.com>
 */
public class CalloutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName,
			String columnName) {
		List<IColumnCallout> callouts = new ArrayList<IColumnCallout>();
		
		// Tabela C_BPartner
		if (tableName.equals(MBPartner.Table_Name)) {
			if (columnName.equals(I_W_C_BPartner.COLUMNNAME_LBR_BPTypeBR) ||
					columnName.equals(I_W_C_BPartner.COLUMNNAME_LBR_TypeIE))
				 callouts.add(new CalloutBPartner());
		}
		
		// Tabela C_BPartner_Location
		if (tableName.equals(MBPartnerLocation.Table_Name)) {
			if (columnName.equals(I_W_C_BPartner_Location.COLUMNNAME_LBR_TypeIE))
				 callouts.add(new CalloutBPartner());
		}
		
		// Tabela C_Order
		if (tableName.equals(MOrder.Table_Name)) {
			if (columnName.equals(MOrder.COLUMNNAME_C_BPartner_ID))
				 callouts.add(new CalloutOrder());
		}
		
		// Tabela C_Invoice
		if (tableName.equals(MInvoice.Table_Name)) {
			if (columnName.equals(MInvoice.COLUMNNAME_C_BPartner_ID))
				 callouts.add(new CalloutInvoice());
		}
		
		// Tabela LBR_DocLine_ICMS
		if (tableName.equals(MLBRDocLineICMS.Table_Name)) {
			if (columnName.equals(MLBRDocLineICMS.COLUMNNAME_LBR_ICMSRegime) ||
					columnName.equals(MLBRDocLineICMS.COLUMNNAME_LBR_ICMS_TaxStatusSN) ||
					columnName.equals(MLBRDocLineICMS.COLUMNNAME_LBR_ICMS_TaxStatusTN))
				 callouts.add(new CalloutDocLine());
		}
		
		// Tabela LBR_DocLine_IPI
		if (tableName.equals(MLBRDocLineIPI.Table_Name)) {
			if (columnName.equals(MLBRDocLineIPI.COLUMNNAME_LBR_IPI_TaxStatus))
				 callouts.add(new CalloutDocLine());
		}
		
		// Tabela LBR_DocLine_PIS
		if (tableName.equals(MLBRDocLinePIS.Table_Name)) {
			if (columnName.equals(MLBRDocLinePIS.COLUMNNAME_LBR_PIS_TaxStatus))
				 callouts.add(new CalloutDocLine());
		}
		
		// Tabela LBR_DocLine_COFINS
		if (tableName.equals(MLBRDocLineCOFINS.Table_Name)) {
			if (columnName.equals(MLBRDocLineCOFINS.COLUMNNAME_LBR_COF_TaxStatus))
				 callouts.add(new CalloutDocLine());
		}
		
		// Tabela LBR_NotaFiscal
		if (tableName.equals(MLBRNotaFiscal.Table_Name)) {
			if (columnName.equals(MLBRNotaFiscal.COLUMNNAME_C_BPartner_ID) ||
					columnName.equals(MLBRNotaFiscal.COLUMNNAME_C_DocType_ID))
				 callouts.add(new CalloutNotaFiscal());
		}
		
		// Tabela LBR_NotaFiscalLine
		if (tableName.equals(MLBRNotaFiscalLine.Table_Name)) {
			if (columnName.equals(MLBRNotaFiscalLine.COLUMNNAME_Qty) ||
					columnName.equals(MLBRNotaFiscalLine.COLUMNNAME_PriceActual))
				 callouts.add(new CalloutNotaFiscal());
		}
		
		// Tabela LBR_NFS
		if (tableName.equals(MLBRNFS.Table_Name)) {
			if (columnName.equals(MLBRNFS.COLUMNNAME_M_Product_ID)
					|| columnName.equals(MLBRNFS.COLUMNNAME_C_DocTypeTarget_ID)) {
				callouts.add(new CalloutNFS());
			}
		}
		
		return callouts != null ? callouts.toArray(new IColumnCallout[0]) : new IColumnCallout[0];
	}
}
