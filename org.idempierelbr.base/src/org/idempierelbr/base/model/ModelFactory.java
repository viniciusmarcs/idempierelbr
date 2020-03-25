package org.idempierelbr.base.model;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

/**
 * Esta classe é uma implementação da model factory.
 * Ela fornece uma forma centralizada para o mecanismo de models.
 *
 * @author Alan <alan.lesc1@gmail.com>
 */
public class ModelFactory implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (tableName.equals(MLBRNCM.Table_Name)) // Model MLBRNCM
			return MLBRNCM.class;
		else if (tableName.equals(X_LBR_LegalMessage.Table_Name)) // Model X_LBR_LegalMessage
			return X_LBR_LegalMessage.class;
		else if (tableName.equals(MLBRTaxGroup.Table_Name)) // Model MLBRTaxGroup
			return MLBRTaxGroup.class;
		else if (tableName.equals(X_LBR_FiscalGroup_Product.Table_Name)) // Model X_LBR_FiscalGroup_Product
			return X_LBR_FiscalGroup_Product.class;
		else if (tableName.equals(X_LBR_FiscalGroup_BPartner.Table_Name)) // Model X_LBR_FiscalGroup_BPartner
			return X_LBR_FiscalGroup_BPartner.class;
		else if (tableName.equals(X_LBR_ProductCategory.Table_Name)) // Model X_LBR_ProductCategory
			return X_LBR_ProductCategory.class;
		else if (tableName.equals(X_LBR_BPartnerCategory.Table_Name)) // Model X_LBR_BPartnerCategory
			return X_LBR_BPartnerCategory.class;
		else if (tableName.equals(MLBRTaxName.Table_Name)) // Model MLBRTaxName
			return MLBRTaxName.class;
		else if (tableName.equals(MLBRFormula.Table_Name)) // Model MLBRFormula
			return MLBRFormula.class;
		else if (tableName.equals(MLBRTaxFormula.Table_Name)) // Model MLBRTaxFormula
			return MLBRTaxFormula.class;
		else if (tableName.equals(X_LBR_TaxStatus.Table_Name)) // Model X_LBR_TaxStatus
			return X_LBR_TaxStatus.class;
		else if (tableName.equals(X_LBR_TaxBaseType.Table_Name)) // Model X_LBR_TaxBaseType
			return X_LBR_TaxBaseType.class;
		else if (tableName.equals(MLBRTax.Table_Name)) // Model MLBRTax
			return MLBRTax.class;
		else if (tableName.equals(MLBRTaxLine.Table_Name)) // Model MLBRTaxLine
			return MLBRTaxLine.class;
		else if (tableName.equals(X_LBR_NCMTax.Table_Name)) // Model X_LBR_NCMTax
			return X_LBR_NCMTax.class;
		else if (tableName.equals(MLBRICMSMatrix.Table_Name)) // Model MLBRICMSMatrix
			return MLBRICMSMatrix.class;
		else if (tableName.equals(MLBRISSMatrix.Table_Name)) // Model MLBRISSMatrix
			return MLBRISSMatrix.class;
		else if (tableName.equals(MLBRTaxConfiguration.Table_Name)) // Model MLBRTaxConfiguration
			return MLBRTaxConfiguration.class;
		else if (tableName.equals(X_LBR_TaxConfig_BPartner.Table_Name)) // Model X_LBR_TaxConfig_BPartner
			return X_LBR_TaxConfig_BPartner.class;
		else if (tableName.equals(X_LBR_TaxConfig_BPGroup.Table_Name)) // Model X_LBR_TaxConfig_BPGroup
			return X_LBR_TaxConfig_BPGroup.class;
		else if (tableName.equals(X_LBR_TaxConfig_Region.Table_Name)) // Model X_LBR_TaxConfig_Region
			return X_LBR_TaxConfig_Region.class;
		else if (tableName.equals(X_LBR_TaxConfig_Product.Table_Name)) // Model X_LBR_TaxConfig_Product
			return X_LBR_TaxConfig_Product.class;
		else if (tableName.equals(X_LBR_TaxConfig_ProductGroup.Table_Name)) // Model X_LBR_TaxConfig_ProductGroup
			return X_LBR_TaxConfig_ProductGroup.class;
		else if (tableName.equals(MLBRTaxDefinition.Table_Name)) // Model MLBRTaxDefinition
			return MLBRTaxDefinition.class;
		else if (tableName.equals(MLBRCFOP.Table_Name)) // Model MLBRCFOP
			return MLBRCFOP.class;
		else if (tableName.equals(X_LBR_CFOPLine.Table_Name)) // Model X_LBR_CFOPLine
			return X_LBR_CFOPLine.class;
		else if (tableName.equals(MLBRDocLineDetails.Table_Name)) // Model MLBRDocLineDetails
			return MLBRDocLineDetails.class;
		else if (tableName.equals(MLBRDocLineICMS.Table_Name)) // Model MLBRDocLineICMS
			return MLBRDocLineICMS.class;
		else if (tableName.equals(MLBRDocLineIPI.Table_Name)) // Model MLBRDocLineIPI
			return MLBRDocLineIPI.class;
		else if (tableName.equals(MLBRDocLinePIS.Table_Name)) // Model MLBRDocLinePIS
			return MLBRDocLinePIS.class;
		else if (tableName.equals(MLBRDocLineCOFINS.Table_Name)) // Model MLBRDocLineCOFINS
			return MLBRDocLineCOFINS.class;
		else if (tableName.equals(MLBRDocLineImportTax.Table_Name)) // Model MLBRDocLineImportTax
			return MLBRDocLineImportTax.class;
		else if (tableName.equals(MLBRDocLineISSQN.Table_Name)) // Model MLBRDocLineISSQN
			return MLBRDocLineISSQN.class;
		else if (tableName.equals(X_LBR_DI.Table_Name)) // Model X_LBR_DI
			return X_LBR_DI.class;
		else if (tableName.equals(X_LBR_DI_Addition.Table_Name)) // Model X_LBR_DI_Addition
			return X_LBR_DI_Addition.class;
		else if (tableName.equals(X_LBR_DI_AdditionProd.Table_Name)) // Model X_LBR_DI_AdditionProd
			return X_LBR_DI_AdditionProd.class;
		else if (tableName.equals(MLBRCestNCMProd.Table_Name)) // Model MLBRCestNCMProd
			return MLBRCestNCMProd.class;
		else if (tableName.equals(MLBRDocLineOTHER.Table_Name)) // Model MLBRDocLineOTHER
			return MLBRDocLineOTHER.class;
		else if (tableName.equals(MLBRNCMMono.Table_Name)) // Model MLBRNCMMono
			return MLBRNCMMono.class;
		else if (tableName.equals(MLBRNotaFiscal.Table_Name)) // Model MLBRNotaFiscal
			return MLBRNotaFiscal.class;
		else if (tableName.equals(MLBRNotaFiscalLine.Table_Name)) // Model MLBRNotaFiscalLine
			return MLBRNotaFiscalLine.class;
		else if (tableName.equals(MLBRNotaFiscalTax.Table_Name)) // Model MLBRNotaFiscalTax
			return MLBRNotaFiscalTax.class;
		else if (tableName.equals(MLBRNotaFiscalTransp.Table_Name)) // Model MLBRNotaFiscalTransp
			return MLBRNotaFiscalTransp.class;
		else if (tableName.equals(X_LBR_NotaFiscalTrailer.Table_Name)) // Model X_LBR_NotaFiscalTrailer
			return X_LBR_NotaFiscalTrailer.class;
		else if (tableName.equals(MLBRNotaFiscalPackage.Table_Name)) // Model MLBRNotaFiscalPackage
			return MLBRNotaFiscalPackage.class;
		else if (tableName.equals(MLBRNotaFiscalPay.Table_Name)) // Model MLBRNotaFiscalPay
			return MLBRNotaFiscalPay.class;
		else if (tableName.equals(MLBRNotaFiscalPaySched.Table_Name)) // Model MLBRNotaFiscalPaySched
			return MLBRNotaFiscalPaySched.class;
		else if (tableName.equals(X_LBR_NotaFiscalNote.Table_Name)) // Model X_LBR_NotaFiscalNote
			return X_LBR_NotaFiscalNote.class;
		else if (tableName.equals(X_LBR_NotaFiscalProc.Table_Name)) // Model X_LBR_NotaFiscalProc
			return X_LBR_NotaFiscalProc.class;
		else if (tableName.equals(MLBRNotaFiscalDocRef.Table_Name)) // Model MLBRNotaFiscalDocRef
			return MLBRNotaFiscalDocRef.class;
		else if (tableName.equals(MLBRDigitalCertificate.Table_Name)) // Model MLBRDigitalCertificate
			return MLBRDigitalCertificate.class;
		else if (tableName.equals(MLBRNFeWebService.Table_Name)) // Model MLBRNFeWebService
			return MLBRNFeWebService.class;
		else if (tableName.equals(MLBRNotaFiscalLot.Table_Name)) // Model MLBRNotaFiscalLot
			return MLBRNotaFiscalLot.class;
		else if (tableName.equals(MLBRNotaFiscalLotLine.Table_Name)) // Model MLBRNotaFiscalLotLine
			return MLBRNotaFiscalLotLine.class;
		else if (tableName.equals(MLBRNotaFiscalEvent.Table_Name)) // Model MLBRNotaFiscalEvent
			return MLBRNotaFiscalEvent.class;
		else if (tableName.equals(MLBRNotaFiscalEventLine.Table_Name)) // Model MLBRNotaFiscalEventLine
			return MLBRNotaFiscalEventLine.class;
		else if (tableName.equals(MLBRNotaFiscalDI.Table_Name)) // Model MLBRNotaFiscalDI
			return MLBRNotaFiscalDI.class;
		else if (tableName.equals(MLBRNotaFiscalInut.Table_Name)) // Model MLBRNotaFiscalInut
			return MLBRNotaFiscalInut.class;
		else if (tableName.equals(MLBRCSC.Table_Name)) // Model MLBRCSC
			return MLBRCSC.class;
		else if (tableName.equals(MLBRNFS.Table_Name))
			return MLBRNFS.class;
		else if (tableName.equals(MLBRNFSTax.Table_Name))
			return MLBRNFSTax.class;
		else if (tableName.equals(MLBRNFSConfig.Table_Name))
			return MLBRNFSConfig.class;
		else if (tableName.equals(MLBRNFSeWS.Table_Name))
			return MLBRNFSeWS.class;
		else if (tableName.equals(MLBRNFSLot.Table_Name))
			return MLBRNFSLot.class;
		else if (tableName.equals(MLBRNFSLotLine.Table_Name))
			return MLBRNFSLotLine.class;
		
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (tableName.equals(MLBRNCM.Table_Name)) // Model MLBRNCM
			return new MLBRNCM(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_LegalMessage.Table_Name)) // Model X_LBR_LegalMessage
			return new X_LBR_LegalMessage(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxGroup.Table_Name)) // Model MLBRTaxGroup
			return new MLBRTaxGroup(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_FiscalGroup_Product.Table_Name)) // Model X_LBR_FiscalGroup_Product
			return new X_LBR_FiscalGroup_Product(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_FiscalGroup_BPartner.Table_Name)) // Model X_LBR_FiscalGroup_BPartner
			return new X_LBR_FiscalGroup_BPartner(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_ProductCategory.Table_Name)) // Model X_LBR_ProductCategory
			return new X_LBR_ProductCategory(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_BPartnerCategory.Table_Name)) // Model X_LBR_BPartnerCategory
			return new X_LBR_BPartnerCategory(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxName.Table_Name)) // Model MLBRTaxName
			return new MLBRTaxName(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRFormula.Table_Name)) // Model MLBRFormula
			return new MLBRFormula(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxFormula.Table_Name)) // Model MLBRTaxFormula
			return new MLBRTaxFormula(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxStatus.Table_Name)) // Model X_LBR_TaxStatus
			return new X_LBR_TaxStatus(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxBaseType.Table_Name)) // Model X_LBR_TaxBaseType
			return new X_LBR_TaxBaseType(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTax.Table_Name)) // Model MLBRTax
			return new MLBRTax(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxLine.Table_Name)) // Model MLBRTaxLine
			return new MLBRTaxLine(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_NCMTax.Table_Name)) // Model X_LBR_NCMTax
			return new X_LBR_NCMTax(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRICMSMatrix.Table_Name)) // Model MLBRICMSMatrix
			return new MLBRICMSMatrix(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRISSMatrix.Table_Name)) // Model MLBRISSMatrix
			return new MLBRISSMatrix(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxConfiguration.Table_Name)) // Model MLBRTaxConfiguration
			return new MLBRTaxConfiguration(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_BPartner.Table_Name)) // Model X_LBR_TaxConfig_BPartner
			return new X_LBR_TaxConfig_BPartner(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_BPGroup.Table_Name)) // Model X_LBR_TaxConfig_BPGroup
			return new X_LBR_TaxConfig_BPGroup(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_Region.Table_Name)) // Model X_LBR_TaxConfig_Region
			return new X_LBR_TaxConfig_Region(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_Product.Table_Name)) // Model X_LBR_TaxConfig_Product
			return new X_LBR_TaxConfig_Product(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_ProductGroup.Table_Name)) // Model X_LBR_TaxConfig_ProductGroup
			return new X_LBR_TaxConfig_ProductGroup(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRTaxDefinition.Table_Name)) // Model MLBRTaxDefinition
			return new MLBRTaxDefinition(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRCFOP.Table_Name)) // Model MLBRCFOP
			return new MLBRCFOP(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_CFOPLine.Table_Name)) // Model X_LBR_CFOPLine
			return new X_LBR_CFOPLine(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineDetails.Table_Name)) // Model MLBRDocLineDetails
			return new MLBRDocLineDetails(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineICMS.Table_Name)) // Model MLBRDocLineICMS
			return new MLBRDocLineICMS(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineIPI.Table_Name)) // Model MLBRDocLineIPI
			return new MLBRDocLineIPI(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLinePIS.Table_Name)) // Model MLBRDocLinePIS
			return new MLBRDocLinePIS(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineCOFINS.Table_Name)) // Model MLBRDocLineCOFINS
			return new MLBRDocLineCOFINS(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineImportTax.Table_Name)) // Model MLBRDocLineImportTax
			return new MLBRDocLineImportTax(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineISSQN.Table_Name)) // Model MLBRDocLineISSQN
			return new MLBRDocLineISSQN(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_DI.Table_Name)) // Model X_LBR_DI
			return new X_LBR_DI(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_DI_Addition.Table_Name)) // Model X_LBR_DI_Addition
			return new X_LBR_DI_Addition(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_DI_AdditionProd.Table_Name)) // Model X_LBR_DI_AdditionProd
			return new X_LBR_DI_AdditionProd(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRCestNCMProd.Table_Name)) // Model MLBRCestNCMProd
			return new MLBRCestNCMProd(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDocLineOTHER.Table_Name)) // Model MLBRDocLineOTHER
			return new MLBRDocLineOTHER(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNCMMono.Table_Name)) // Model MLBRNCMMono
			return new MLBRNCMMono(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscal.Table_Name)) // Model MLBRNotaFiscal
			return new MLBRNotaFiscal(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalLine.Table_Name)) // Model MLBRNotaFiscalLine
			return new MLBRNotaFiscalLine(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalTax.Table_Name)) // Model MLBRNotaFiscalTax
			return new MLBRNotaFiscalTax(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalTransp.Table_Name)) // Model MLBRNotaFiscalTransp
			return new MLBRNotaFiscalTransp(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalTrailer.Table_Name)) // Model X_LBR_NotaFiscalTrailer
			return new X_LBR_NotaFiscalTrailer(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalPackage.Table_Name)) // Model MLBRNotaFiscalPackage
			return new MLBRNotaFiscalPackage(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalPay.Table_Name)) // Model MLBRNotaFiscalPay
			return new MLBRNotaFiscalPay(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalPaySched.Table_Name)) // Model MLBRNotaFiscalPaySched
			return new MLBRNotaFiscalPaySched(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalNote.Table_Name)) // Model X_LBR_NotaFiscalNote
			return new X_LBR_NotaFiscalNote(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalProc.Table_Name)) // Model X_LBR_NotaFiscalProc
			return new X_LBR_NotaFiscalProc(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalDocRef.Table_Name)) // Model MLBRNotaFiscalDocRef
			return new MLBRNotaFiscalDocRef(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRDigitalCertificate.Table_Name)) // Model MLBRDigitalCertificate
			return new MLBRDigitalCertificate(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFeWebService.Table_Name)) // Model MLBRNFeWebService
			return new MLBRNFeWebService(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalLot.Table_Name)) // Model MLBRNotaFiscalLot
			return new MLBRNotaFiscalLot(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalLotLine.Table_Name)) // Model MLBRNotaFiscalLotLine
			return new MLBRNotaFiscalLotLine(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalEvent.Table_Name)) // Model MLBRNotaFiscalEvent
			return new MLBRNotaFiscalEvent(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalEventLine.Table_Name)) // Model MLBRNotaFiscalEventLine
			return new MLBRNotaFiscalEventLine(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalDI.Table_Name)) // Model MLBRNotaFiscalDI
			return new MLBRNotaFiscalDI(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNotaFiscalInut.Table_Name)) // Model MLBRNotaFiscalInut
			return new MLBRNotaFiscalInut(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRCSC.Table_Name)) // Model MLBRCSC
			return new MLBRCSC(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFS.Table_Name))
			return new MLBRNFS(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFSTax.Table_Name))
			return new MLBRNFSTax(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFSConfig.Table_Name))
			return new MLBRNFSConfig(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFSeWS.Table_Name))
			return new MLBRNFSeWS(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFSLot.Table_Name))
			return new MLBRNFSLot(Env.getCtx(), Record_ID, trxName);
		else if (tableName.equals(MLBRNFSLotLine.Table_Name))
			return new MLBRNFSLotLine(Env.getCtx(), Record_ID, trxName);
			
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (tableName.equals(MLBRNCM.Table_Name)) // Model MLBRNCM
			return new MLBRNCM(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_LegalMessage.Table_Name)) // Model X_LBR_LegalMessage
			return new X_LBR_LegalMessage(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxGroup.Table_Name)) // Model MLBRTaxGroup
			return new MLBRTaxGroup(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_FiscalGroup_Product.Table_Name)) // Model X_LBR_FiscalGroup_Product
			return new X_LBR_FiscalGroup_Product(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_FiscalGroup_BPartner.Table_Name)) // Model X_LBR_FiscalGroup_BPartner
			return new X_LBR_FiscalGroup_BPartner(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_ProductCategory.Table_Name)) // Model X_LBR_ProductCategory
			return new X_LBR_ProductCategory(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_BPartnerCategory.Table_Name)) // Model X_LBR_BPartnerCategory
			return new X_LBR_BPartnerCategory(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxName.Table_Name)) // Model MLBRTaxName
			return new MLBRTaxName(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRFormula.Table_Name)) // Model MLBRFormula
			return new MLBRFormula(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxFormula.Table_Name)) // Model MLBRTaxFormula
			return new MLBRTaxFormula(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxStatus.Table_Name)) // Model X_LBR_TaxStatus
			return new X_LBR_TaxStatus(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxBaseType.Table_Name)) // Model X_LBR_TaxBaseType
			return new X_LBR_TaxBaseType(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTax.Table_Name)) // Model MLBRTax
			return new MLBRTax(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxLine.Table_Name)) // Model MLBRTaxLine
			return new MLBRTaxLine(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_NCMTax.Table_Name)) // Model X_LBR_NCMTax
			return new X_LBR_NCMTax(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRICMSMatrix.Table_Name)) // MLBRICMSMatrix
			return new MLBRICMSMatrix(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRISSMatrix.Table_Name)) // MLBRISSMatrix
			return new MLBRISSMatrix(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxConfiguration.Table_Name)) // MLBRTaxConfiguration
			return new MLBRTaxConfiguration(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_BPartner.Table_Name)) // X_LBR_TaxConfig_BPartner
			return new X_LBR_TaxConfig_BPartner(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_BPGroup.Table_Name)) // X_LBR_TaxConfig_BPGroup
			return new X_LBR_TaxConfig_BPGroup(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_Region.Table_Name)) // X_LBR_TaxConfig_Region
			return new X_LBR_TaxConfig_Region(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_Product.Table_Name)) // X_LBR_TaxConfig_Product
			return new X_LBR_TaxConfig_Product(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_TaxConfig_ProductGroup.Table_Name)) // X_LBR_TaxConfig_ProductGroup
			return new X_LBR_TaxConfig_ProductGroup(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRTaxDefinition.Table_Name)) // MLBRTaxDefinition
			return new MLBRTaxDefinition(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRCFOP.Table_Name)) // MLBRCFOP
			return new MLBRCFOP(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_CFOPLine.Table_Name)) // X_LBR_CFOPLine
			return new X_LBR_CFOPLine(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineDetails.Table_Name)) // MLBRDocLineDetails
			return new MLBRDocLineDetails(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineICMS.Table_Name)) // MLBRDocLineICMS
			return new MLBRDocLineICMS(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineIPI.Table_Name)) // MLBRDocLineIPI
			return new MLBRDocLineIPI(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLinePIS.Table_Name)) // MLBRDocLinePIS
			return new MLBRDocLinePIS(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineCOFINS.Table_Name)) // MLBRDocLineCOFINS
			return new MLBRDocLineCOFINS(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineImportTax.Table_Name)) // MLBRDocLineImportTax
			return new MLBRDocLineImportTax(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineISSQN.Table_Name)) // MLBRDocLineISSQN
			return new MLBRDocLineISSQN(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_DI.Table_Name)) // Model X_LBR_DI
			return new X_LBR_DI(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_DI_Addition.Table_Name)) // Model X_LBR_DI_Addition
			return new X_LBR_DI_Addition(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_DI_AdditionProd.Table_Name)) // Model X_LBR_DI_AdditionProd
			return new X_LBR_DI_AdditionProd(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRCestNCMProd.Table_Name)) // Model MLBRCestNCMProd
			return new MLBRCestNCMProd(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDocLineOTHER.Table_Name)) // Model MLBRDocLineOTHER
			return new MLBRDocLineOTHER(Env.getCtx(), rs, trxName);		
		else if (tableName.equals(MLBRNCMMono.Table_Name)) // Model MLBRNCMMono
			return new MLBRNCMMono(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscal.Table_Name)) // Model MLBRNotaFiscal
			return new MLBRNotaFiscal(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalLine.Table_Name)) // Model MLBRNotaFiscalLine
			return new MLBRNotaFiscalLine(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalTax.Table_Name)) // Model MLBRNotaFiscalTax
			return new MLBRNotaFiscalTax(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalTransp.Table_Name)) // Model MLBRNotaFiscalTransp
			return new MLBRNotaFiscalTransp(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalTrailer.Table_Name)) // Model X_LBR_NotaFiscalTrailer
			return new X_LBR_NotaFiscalTrailer(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalPackage.Table_Name)) // Model MLBRNotaFiscalPackage
			return new MLBRNotaFiscalPackage(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalPay.Table_Name)) // Model MLBRNotaFiscalPay
			return new MLBRNotaFiscalPay(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalPaySched.Table_Name)) // Model MLBRNotaFiscalPaySched
			return new MLBRNotaFiscalPaySched(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalNote.Table_Name)) // Model X_LBR_NotaFiscalNote
			return new X_LBR_NotaFiscalNote(Env.getCtx(), rs, trxName);
		else if (tableName.equals(X_LBR_NotaFiscalProc.Table_Name)) // Model X_LBR_NotaFiscalProc
			return new X_LBR_NotaFiscalProc(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalDocRef.Table_Name)) // Model MLBRNotaFiscalDocRef
			return new MLBRNotaFiscalDocRef(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRDigitalCertificate.Table_Name)) // MLBRDigitalCertificate
			return new MLBRDigitalCertificate(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFeWebService.Table_Name)) // MLBRNFeWebService
			return new MLBRNFeWebService(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalLot.Table_Name)) // MLBRNotaFiscalLot
			return new MLBRNotaFiscalLot(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalLotLine.Table_Name)) // MLBRNotaFiscalLotLine
			return new MLBRNotaFiscalLotLine(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalEvent.Table_Name)) // MLBRNotaFiscalEvent
			return new MLBRNotaFiscalEvent(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalEventLine.Table_Name)) // MLBRNotaFiscalEventLine
			return new MLBRNotaFiscalEventLine(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalDI.Table_Name)) // Model MLBRNotaFiscalDI
			return new MLBRNotaFiscalDI(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNotaFiscalInut.Table_Name)) // Model MLBRNotaFiscalInut
			return new MLBRNotaFiscalInut(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRCSC.Table_Name)) // Model MLBRCSC
			return new MLBRCSC(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFS.Table_Name))
			return new MLBRNFS(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFSTax.Table_Name))
			return new MLBRNFSTax(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFSConfig.Table_Name))
			return new MLBRNFSConfig(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFSeWS.Table_Name))
			return new MLBRNFSeWS(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFSLot.Table_Name))
			return new MLBRNFSLot(Env.getCtx(), rs, trxName);
		else if (tableName.equals(MLBRNFSLotLine.Table_Name))
			return new MLBRNFSLotLine(Env.getCtx(), rs, trxName);
		
		return null;
	}

}
