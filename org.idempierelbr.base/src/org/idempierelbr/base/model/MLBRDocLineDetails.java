package org.idempierelbr.base.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.adempiere.model.POWrapper;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MProduct;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.idempierelbr.base.util.TextUtil;
import org.idempierelbr.base.wrapper.I_W_C_BPartner;
import org.idempierelbr.base.wrapper.I_W_C_Tax;
import org.idempierelbr.base.wrapper.I_W_M_Product;

public class MLBRDocLineDetails extends X_LBR_DocLine_Details
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -697605258747714507L;

	private static final CLogger log = CLogger.getCLogger(MLBRDocLineDetails.class);
	protected MLBRDocLineDetails m_DetailsFrom = null;

	/**
	 *  Default Constructor
	 *  @param Properties ctx
	 *  @param int ID (0 create new)
	 *  @param String trx
	 */
	public MLBRDocLineDetails (Properties ctx, int LBR_DocLine_Details_ID, String trxName)
	{
		super (ctx, LBR_DocLine_Details_ID, trxName);
	}

	/**
	 *  Load Constructor
	 *  @param ctx context
	 *  @param rs result set record
	 *  @param trxName transaction
	 */
	public MLBRDocLineDetails (Properties ctx, ResultSet rs, String trxName)
	{
		super (ctx, rs, trxName);
	}
	
	public BigDecimal getDiscountAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DiscountAmt);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getFreightAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FreightAmt);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getInsuredAmount () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_InsuredAmount);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getLBR_GrossAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LBR_GrossAmt);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getLBR_PriceTax () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LBR_PriceTax);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getLBR_QtyTax () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LBR_QtyTax);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getSurcharges () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Surcharges);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	public BigDecimal getTaxLineTotal () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_TaxLineTotal);
		
		if (bd == null)
			return Env.ZERO;
		
		return bd;
	}
	
	/**
	 * 	Calculate the discount amount
	 * 	@param qty quantity of a product (base UOM)
	 * 	@param priceList
	 * 	@param lineNetAmt
	 * 	@return Calculated amount
	 */
	public BigDecimal calculateDiscountAmt(BigDecimal qty, BigDecimal priceList, BigDecimal lineNetAmt) {
		BigDecimal priceListTotal = priceList.multiply(qty).setScale(2, RoundingMode.HALF_UP);
		BigDecimal discount = priceListTotal.subtract(lineNetAmt);
		
		if (discount.signum() == 1)
			return discount.setScale(2, RoundingMode.HALF_UP);
		else
			return Env.ZERO;
	}
	
	/**
	 * 	Delete all children (taxes) of Doc Line Details
	 */
	protected void deleteChildren() {
		PO[] poArray = MLBRDocLineICMS.getOfDetails(this);

		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLineIPI.getOfDetails(this);

		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLinePIS.getOfDetails(this);

		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLineCOFINS.getOfDetails(this);
		
		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLineImportTax.getOfDetails(this);
		
		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLineISSQN.getOfDetails(this);
		
		for (PO po : poArray) {
			po.deleteEx(true);
		}
		
		poArray = MLBRDocLineOTHER.getOfDetails(this);

		for (PO po : poArray) {
			po.deleteEx(true);
		}
	}
	
	protected boolean beforeDelete() {
		deleteChildren();
		return true;		
	}
	
	
	
	/**
	 * 	Create all children (taxes) of Doc Line Details
	 */
	protected void createChildren(Map<Integer, Object[]> taxes, MLBRTax tax,
			int C_Tax_ID, MProduct product, int C_BPartner_ID,
			int C_BPartnerLocationTo_ID, String LBR_TransactionType,
			Timestamp dateDoc) {
		
		for (MLBRTaxLine tl : tax.getLines()) {
			//if (tl.getLBR_TaxAmt() == null || tl.getLBR_TaxAmt().compareTo(Env.ZERO) == 0 || !tl.isLBR_PostTax())
			if (!tl.isLBR_PostTax())
				continue;
			
			Integer key = tl.getChild_Tax_ID(C_Tax_ID);
			
			if (key <= 0)
				continue;
			else if (taxes.containsKey(key)) {
				MTax taxChild = new MTax(getCtx(), key, get_TrxName());
				I_W_C_Tax taxChildW = POWrapper.create(taxChild, I_W_C_Tax.class);
				
				// Try to get Tax Status through Name field
				X_LBR_TaxStatus taxStatus = new X_LBR_TaxStatus(getCtx(), tl.getLBR_TaxStatus_ID(), get_TrxName());

				// Some taxes requires Tax Status
				if ((taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMS_NAME) ||
						taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_IPI_NAME) ||
						taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_PIS_NAME) ||
						taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_COFINS_NAME)) &&					
						(taxStatus.getName() == null || taxStatus.getName().isEmpty())) {
					log.warning("Couldn't find a valid Tax Status for " + tl + ". An entry won't be created.");
					continue;
				}
				
				// Try to get Tax Base Type through Name field
				X_LBR_TaxBaseType taxBaseType = new X_LBR_TaxBaseType(getCtx(), tl.getLBR_TaxBaseType_ID(), get_TrxName());
				Integer taxBaseTypeCode = null;
				
				try {
					taxBaseTypeCode = new Integer(taxBaseType.getValue());
				} catch (Exception e) {
					log.fine("Couldn't get Tax Base Type for " + tl);
				}
				
				if (taxBaseTypeCode == null ||
						(taxBaseTypeCode != null && !(taxBaseTypeCode == MLBRTax.TYPE_RATE_OR_IVA ||
							taxBaseTypeCode == MLBRTax.TYPE_TARIFF ||
							taxBaseTypeCode == MLBRTax.TYPE_LIST_MAX ||
							taxBaseTypeCode == MLBRTax.TYPE_AMOUNT ||
							taxBaseTypeCode == MLBRTax.TYPE_LIST_POSITIVE ||
							taxBaseTypeCode == MLBRTax.TYPE_LIST_NEUTRAL ||
							taxBaseTypeCode == MLBRTax.TYPE_LIST_NEGATIVE))) {
					taxBaseTypeCode = MLBRTax.TYPE_RATE_OR_IVA;
					log.info("A default Tax Base Type will be used for " + tl);
				}
				
				// ICMS or ICMS-ST
				if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMS_NAME) ||
						taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMSST_NAME)) {
					
					createICMS(taxStatus.getName(), taxBaseTypeCode, tl, product, taxChildW, 
							C_BPartner_ID, C_BPartnerLocationTo_ID, LBR_TransactionType, dateDoc);
				} 
				// IPI
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_IPI_NAME)) {
					createIPI(taxStatus.getName(), tl);
				}
				// PIS
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_PIS_NAME)) {
					createPIS(taxStatus.getName(), tl);
				}
				// COFINS
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_COFINS_NAME)) {
					createCOFINS(taxStatus.getName(), tl);
				}
				// Import Tax
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_II_NAME)) {
					createImportTax(tl);
				}
				// ISSQN
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ISSQN_NAME)) {
					createISSQN(tl, product);
				}
				// OTHERS
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_IR_NAME)) {
					createOTHER(tl, taxChildW.getLBR_TaxGroup_ID());
				}
			}
		}
	}
	
	/**
	 * 	Create ICMS (child of Doc Line Details)
	 */
	private void createICMS(String taxStatus, Integer taxBaseTypeCode, MLBRTaxLine tl, MProduct product, 
			I_W_C_Tax taxChildW, int C_BPartner_ID, int C_BPartnerLocationTo_ID, String LBR_TransactionType, Timestamp dateDoc) {
		
		String productSource = product.get_ValueAsString("LBR_ProductSource");
		
		if (productSource != null && productSource.isEmpty())
			productSource = null;	
		
		MLBRDocLineICMS[] icmsArray = MLBRDocLineICMS.getOfDetails(this);
		MLBRDocLineICMS icms = new MLBRDocLineICMS(getCtx(), 0, get_TrxName());
		
		if (icmsArray.length > 0) {
			icms = icmsArray[0];
		} else {
			icms.setAD_Org_ID(getAD_Org_ID());
			icms.setLBR_DocLine_Details_ID(get_ID());
			icms.setLBR_ProductSource(productSource);
		}
		
		I_LBR_TaxName LBR_TaxName = tl.getLBR_TaxName();
		
		if (LBR_TaxName != null && LBR_TaxName.getName().equals("ICMSPROD")) {
			icms.setIsTaxIncluded(tl.isTaxIncluded());
		
			String icmsRegime = MSysConfig.getValue("LBR_ICMS_REGIME", "TN", getAD_Client_ID(), getAD_Org_ID());
			icms.setLBR_ICMSRegime(icmsRegime);
		
			if (icmsRegime.equals("TN"))
				icms.setLBR_ICMS_TaxStatusTN(taxStatus);
			else
				icms.setLBR_ICMS_TaxStatusSN(taxStatus);
		}
		
		// ICMS-ST don't need a Tax Status. We get it from ICMS
		if (taxStatus == null || (taxStatus != null && taxStatus.isEmpty()))
			taxStatus = icms.getLBR_ICMS_TaxStatusTN();
		
		if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMS_NAME) && TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_00_TributadaIntegralmente,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_10_TributadaEComCobrancaDoICMSPorSubTributaria,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_20_ComReducaoDeBaseDeCalculo,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_51_Diferimento,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_70_ComRedDeBaseDeCalcECobrDoICMSPorSubTrib,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_90_Outras)) {

			icms.setLBR_ICMS_TaxBaseType(new Integer(taxBaseTypeCode - 100).toString());
			icms.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			icms.setLBR_TaxRate(tl.getLBR_TaxRate());
			icms.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		}
		
		if (TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_40_Isenta,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_41_Nao_Tributada,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_50_Suspensao) && tl.getLBR_TaxAmt().signum() > 0) {

			icms.setLBR_TaxAmt(tl.getLBR_TaxAmt());
			
			MBPartner bp = new MBPartner(getCtx(), C_BPartner_ID, get_TrxName());
			I_W_C_BPartner bpW = POWrapper.create(bp, I_W_C_BPartner.class);
			
			// TODO: Criar condições para preencher outros valores
			if (bpW.getLBR_Suframa() != null && !bpW.getLBR_Suframa().isEmpty())
				icms.setLBR_ICMS_TaxReliefType(MLBRDocLineICMS.LBR_ICMS_TAXRELIEFTYPE_SUFRAMA);
			else
				icms.setLBR_ICMS_TaxReliefType(MLBRDocLineICMS.LBR_ICMS_TAXRELIEFTYPE_Other);
		}
		
		// Tax Base
		if (TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_20_ComReducaoDeBaseDeCalculo,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_51_Diferimento,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_70_ComRedDeBaseDeCalcECobrDoICMSPorSubTrib,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_90_Outras,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_900_Outros)) {
				
			if (tl.getLBR_TaxBase() != null && tl.getLBR_TaxBase().signum() == 1) {
				if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMS_NAME))
					icms.setLBR_TaxBase(tl.getLBR_TaxBase());
				else if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMSST_NAME))
					icms.setLBR_ICMSST_TaxBase(tl.getLBR_TaxBase());
			}
		}
		
		//	ICMS-ST
		if (taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMSST_NAME) && TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_10_TributadaEComCobrancaDoICMSPorSubTributaria,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_30_IsentaOuNao_TribEComCobrDoICMSPorSubTribut,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_70_ComRedDeBaseDeCalcECobrDoICMSPorSubTrib,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_90_Outras,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_201_TributadaComPermissaoDeCredito,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_202_TributadaSemPermissaoDeCredito,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_203_IsencaoDoICMSParaFaixaDeReceitaBruta,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_900_Outros)) {

			icms.setLBR_ICMSST_TaxBaseType(new Integer(taxBaseTypeCode - 100).toString());
			
			if (tl.getLBR_TaxBase().compareTo(Env.ZERO) != 0)
				icms.setLBR_ICMSST_TaxBase(tl.getLBR_TaxBase());
			
			BigDecimal iva = getIVAST(new MLBRTax(getCtx(), tl.getLBR_Tax_ID(), get_TrxName()));
			if (iva.compareTo(Env.ZERO) != 0)
				icms.setLBR_ICMSST_TaxAdded(iva);
			
			icms.setLBR_ICMSST_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			icms.setLBR_ICMSST_TaxRate(tl.getLBR_TaxRate());
			icms.setLBR_ICMSST_TaxAmt(tl.getLBR_TaxAmt());
		}
		
		// IVA
		//if (tl.getLBR_TaxName_ID() == 1000012) {
			// Adjust IVA-ST
		//	if (getIVARateFromTaxTransaction() != null && getIVARateFromTaxTransaction().signum() == 1)
		//		icms.setLBR_ICMSST_TaxAdded(tl.getLBR_TaxRate());
		//}

		if (TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_60_ICMSCobradoAnteriormentePorSubstituicaoTributaria,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_500_ICMSCobradoAnteriormente)) {
			
			icms.setLBR_ICMSST_TaxBAmtWhd(tl.getLBR_TaxBaseAmt());
			icms.setLBR_ICMSST_TaxAmtWhd(tl.getLBR_TaxAmt());
		}
		
		if (TextUtil.match (taxStatus,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_101_TributadaComPermissaoDeCredito,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_201_TributadaComPermissaoDeCredito,
				MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_900_Outros)) {
			
			icms.setLBR_TaxRateCredit(tl.getLBR_TaxRate());
			icms.setLBR_TaxAmtCredit(tl.getLBR_TaxAmt());
		}
		
		/*
		 * Fill CEST
		 */
		MLBRCestNCMProd m_cest = MLBRCestNCMProd.get(getCtx(), product.get_ID(), getLBR_NCM_ID(), get_TrxName());
		if (m_cest != null && m_cest.get_ID() > 0) {
			icms.set_ValueOfColumn("LBR_CEST_ID", m_cest.getLBR_CEST_ID());
		}
		
		
		/* 
		 * Calculate DIFAL
		 *  
		 * Only when: Não Contribuinte de ICMS 
		 * 				+ Venda Interestadual 
		 * 				+ Consumidor Final 
		 * 				+ Não Possuí ST 
		 * 				+ Possuí ICMS Integral
		*/  
		if (TextUtil
				.match(taxStatus,
						MLBRDocLineICMS.LBR_ICMS_TAXSTATUSTN_00_TributadaIntegralmente,
						MLBRDocLineICMS.LBR_ICMS_TAXSTATUSSN_101_TributadaComPermissaoDeCredito)
				&& MBPartner.get(getCtx(), C_BPartner_ID)
						.get_ValueAsString("LBR_TypeIE")
						.equals(I_W_C_BPartner.LBR_TYPEIE_NãoContribuinte)
				&& LBR_TransactionType != null
				&& LBR_TransactionType.equals("END")
				&& getLBR_CFOP_ID() > 0
				&& getLBR_CFOP().getValue().startsWith("6")
				&& taxChildW.getLBR_TaxGroup_ID() == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_ICMS_NAME)) {
		
			// do calc 
			calculateDIFAL(icms, C_BPartnerLocationTo_ID, dateDoc, tl);
		}
		
		icms.saveEx();
	}
	
	
	/**
	 * Calculate DIFAL - NT 2015-003
	 * 
	 * @param icms
	 * @param C_BPartnerLocationTo_ID
	 * @param dateDoc
	 */
	private void calculateDIFAL(MLBRDocLineICMS icms, int C_BPartnerLocationTo_ID, Timestamp dateDoc, MLBRTaxLine tl) {

		// local vars 
		BigDecimal taxBaseAmt = Env.ZERO;
		BigDecimal internalTaxRate = Env.ZERO;
		BigDecimal externalTaxRate = Env.ZERO;
		BigDecimal partRate = Env.ZERO;
		BigDecimal taxAmtSenderUF = Env.ZERO;
		BigDecimal taxAmtReceiverUF = Env.ZERO;
		BigDecimal fcpTaxAmt = Env.ZERO;
		BigDecimal fcpTaxRate = Env.ZERO;
		BigDecimal diffTaxRate = Env.ZERO;
		BigDecimal diffTaxAmt = Env.ZERO;
		
		// org info
		MOrgInfo orgInfo = MOrgInfo.get(getCtx(), icms.getAD_Org_ID(),
				get_TrxName());
		if (orgInfo.getC_Location_ID() <= 0
				|| orgInfo.getC_Location().getC_Region_ID() <= 0) {
			log.severe("DIFAL não pode ser calculado. Erro: UF da Organização é inválida!");
			return;
		}

		// bpartner location to
		MBPartnerLocation bpLocationTo = new MBPartnerLocation(getCtx(),
				C_BPartnerLocationTo_ID, get_TrxName());
		if (bpLocationTo.getC_Location_ID() <= 0
				|| bpLocationTo.getC_Location().getC_Region_ID() <= 0) {
			log.severe("DIFAL não pode ser calculado. Erro: UF do Parceiro de Negócios é inválida!");
			return;
		}

		// check is is the same location, if true, return
		if (bpLocationTo.getC_Location().getC_Region_ID() == orgInfo
				.getC_Location().getC_Region_ID())
			return;

		// receiver internal tax, from icmsmatrix
		MLBRICMSMatrix internalTax = MLBRICMSMatrix.get(getCtx(), icms
				.getAD_Org_ID(), bpLocationTo.getC_Location().getC_Region_ID(),
				bpLocationTo.getC_Location().getC_Region_ID(), dateDoc,
				get_TrxName());

		// check receiver internal tax
		if (internalTax == null || internalTax.getLBR_Tax_ID() <= 0) {
			log.severe("DIFAL não pode ser calculado. Erro: Nenhuma Alíquota interna definida para a UF do Destinatário!");
			return;
		}

		// icms from internal tax matrix
		MLBRTax tax = new MLBRTax(getCtx(), internalTax.getLBR_Tax_ID(), get_TrxName());
		for (MLBRTaxLine taxLine : tax.getLines()) {
			if (taxLine.getLBR_TaxName_ID() > 0
					&& taxLine.getLBR_TaxName().getName().equals("ICMSPROD")) {
				internalTaxRate = taxLine.getLBR_TaxRate();
				break;
			}
		}

		// check internal rate
		if (internalTaxRate == null || internalTaxRate.signum() == 0) {
			log.severe("DIFAL não pode ser calculado. Erro: Alíquota Interna definida para a UF do Destinatário é inválida!");
			return;
		}

		// tax base amt of icms record
		taxBaseAmt = icms.getLBR_TaxBaseAmt();
		if (taxBaseAmt == null || taxBaseAmt.signum() == 0) {
			log.severe("DIFAL não pode ser calculado. Erro: Base de cálculo do ICMS é inválida!");
			return;
		}

		// get transaction tax rate (external) of icms record
		externalTaxRate = icms.getLBR_TaxRate();
		if (externalTaxRate == null
				|| !(externalTaxRate.compareTo(new BigDecimal(12)) == 0
						|| externalTaxRate.compareTo(new BigDecimal(7)) == 0 || externalTaxRate
						.compareTo(new BigDecimal(4)) == 0)) {
			log.severe("DIFAL não pode ser calculado. Erro: Alíquota Externa utilizada na transação com a UF do Destinatário é inválida!");
			return;
		}
	
		// get icms share part by date
		Calendar cal = new GregorianCalendar ();
		cal.setTimeInMillis(dateDoc.getTime());
		if (cal.before (new GregorianCalendar (2017, 0, 1)))
			partRate = new BigDecimal (40);
		else if (cal.before (new GregorianCalendar (2018, 0, 1)))
			partRate = new BigDecimal (60);
		else if (cal.before (new GregorianCalendar (2019, 0, 1)))
			partRate = new BigDecimal (80);
		else
			partRate = new BigDecimal (100);
		
		// set scale for all calc vars
		fcpTaxRate = getFCP(new MLBRTax(getCtx(), tl.getLBR_Tax_ID(), get_TrxName()));
		internalTaxRate = internalTaxRate.setScale(17, RoundingMode.HALF_UP);
		externalTaxRate = externalTaxRate.setScale(17, RoundingMode.HALF_UP);
		partRate = partRate.setScale(17, RoundingMode.HALF_UP);
		taxBaseAmt = taxBaseAmt.setScale(17, RoundingMode.HALF_UP);
				
		// tax rate diff = (internal - external)/100
		diffTaxRate = (internalTaxRate.subtract(externalTaxRate)).divide(Env.ONEHUNDRED);

		// calc diff tax amt = tax base amt * diff tax rate
		diffTaxAmt = taxBaseAmt.multiply(diffTaxRate);

		// calc receiver part
		taxAmtReceiverUF = diffTaxAmt.multiply(partRate.divide(Env.ONEHUNDRED));

		// calc sender part
		taxAmtSenderUF = diffTaxAmt.subtract(taxAmtReceiverUF);
		
		// calculate FCP
		if (fcpTaxRate.signum() != 0) {
			
			// taxamt = taxamt * taxrate
			fcpTaxAmt = taxBaseAmt.multiply(fcpTaxRate.divide(Env.ONEHUNDRED));
		}
		
		// DIFAL
		icms.setLBR_DIFAL_RateICMSInterPart(partRate.setScale(2, RoundingMode.HALF_UP));
		icms.setLBR_DIFAL_TaxRateICMSUFDest(internalTaxRate.setScale(2, RoundingMode.HALF_UP));
		icms.setLBR_DIFAL_TaxAmtICMSUFDest(taxAmtReceiverUF.setScale(2, RoundingMode.HALF_UP));
		icms.setLBR_DIFAL_TaxAmtICMSUFRemet(taxAmtSenderUF.setScale(2, RoundingMode.HALF_UP));
		
		// FCP
		icms.setLBR_DIFAL_TaxBaseFCPUFDest(taxBaseAmt.setScale(2, RoundingMode.HALF_UP));	
		icms.setLBR_DIFAL_TaxRateFCPUFDest(fcpTaxRate.setScale(2, RoundingMode.HALF_UP));
		icms.setLBR_DIFAL_TaxAmtFCPUFDest(fcpTaxAmt.setScale(2, RoundingMode.HALF_UP));		
	}
	

	/**
	 * 	Create IPI (child of Doc Line Details)
	 */
	private void createIPI(String taxStatus, MLBRTaxLine tl) {
		MLBRDocLineIPI[] ipiArray = MLBRDocLineIPI.getOfDetails(this);
		MLBRDocLineIPI ipi = new MLBRDocLineIPI(getCtx(), 0, get_TrxName());
		
		if (ipiArray.length > 0)
			ipi = ipiArray[0];

		ipi.setAD_Org_ID(getAD_Org_ID());
		ipi.setLBR_DocLine_Details_ID(get_ID());
		ipi.setIsTaxIncluded(tl.isTaxIncluded());
		ipi.setLBR_IPI_TaxStatus(taxStatus);
		
		if (TextUtil.match (taxStatus,
				MLBRDocLineIPI.LBR_IPI_TAXSTATUS_00_EntradaComRecuperacaoDeCredito,
				MLBRDocLineIPI.LBR_IPI_TAXSTATUS_49_OutrasEntradas,
				MLBRDocLineIPI.LBR_IPI_TAXSTATUS_50_SaidaTributada,
				MLBRDocLineIPI.LBR_IPI_TAXSTATUS_99_OutrasSaidas)) {

			ipi.setCalculationType("PER");
			ipi.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			ipi.setLBR_TaxRate(tl.getLBR_TaxRate());
			ipi.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		}
		
		ipi.saveEx();
	}
	
	/**
	 * 	Create PIS (child of Doc Line Details)
	 */
	private void createPIS(String taxStatus, MLBRTaxLine tl) {
		MLBRDocLinePIS[] pisArray = MLBRDocLinePIS.getOfDetails(this);
		MLBRDocLinePIS pis = new MLBRDocLinePIS(getCtx(), 0, get_TrxName());
		
		if (pisArray.length > 0)
			pis = pisArray[0];

		pis.setAD_Org_ID(getAD_Org_ID());
		pis.setLBR_DocLine_Details_ID(get_ID());
		pis.setIsTaxIncluded(tl.isTaxIncluded());
		pis.setLBR_PIS_TaxStatus(taxStatus);
		
		if (TextUtil.match (taxStatus,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_01_OperacaoTributavelCumulativoNaoCumulativo,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_02_OperacaoTributavelAliquotaDiferenciada,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_49_OutrasOperacoesDeSaida,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_50_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_51_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_52_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_53_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_54_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_55_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_56_OperacaoComDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_60_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_61_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_62_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_63_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_64_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_65_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_66_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_67_CreditoPresumido,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_70_OperacaoDeAquisicaoSemDireitoACredito,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_71_OperacaoDeAquisicaoComIsencao,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_72_OperacaoDeAquisicaoComSuspensao,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_73_OperacaoDeAquisicaoAAliquotaZero,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_74_OperacaoDeAquisicaoSemIncidenciaDaContribuicao,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_75_OperacaoDeAquisicaoPorSubstituicaoTributaria,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_98_OutrasOperacoesDeEntrada,
				MLBRDocLinePIS.LBR_PIS_TAXSTATUS_99_OutrasOperacoes)) {
			
			pis.setCalculationType("PER");
			pis.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			pis.setLBR_TaxRate(tl.getLBR_TaxRate());
			pis.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		}
		
		pis.saveEx();
	}
	
	/**
	 * 	Create COFINS (child of Doc Line Details)
	 */
	private void createCOFINS(String taxStatus, MLBRTaxLine tl) {
		MLBRDocLineCOFINS[] cofinsArray = MLBRDocLineCOFINS.getOfDetails(this);
		MLBRDocLineCOFINS cofins = new MLBRDocLineCOFINS(getCtx(), 0, get_TrxName());
		
		if (cofinsArray.length > 0)
			cofins = cofinsArray[0];

		cofins.setAD_Org_ID(getAD_Org_ID());
		cofins.setLBR_DocLine_Details_ID(get_ID());
		cofins.setIsTaxIncluded(tl.isTaxIncluded());
		cofins.setLBR_COF_TaxStatus(taxStatus);
		
		if (TextUtil.match (taxStatus,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_01_OperacaoTributavelCumulativoNaoCumulativo,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_02_OperacaoTributavelAliquotaDiferenciada,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_49_OutrasOperacoesDeSaida,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_50_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_51_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_52_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_53_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_54_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_55_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_56_OperacaoComDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_60_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_61_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_62_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_63_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_64_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_65_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_66_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_67_CreditoPresumido,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_70_OperacaoDeAquisicaoSemDireitoACredito,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_71_OperacaoDeAquisicaoComIsencao,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_72_OperacaoDeAquisicaoComSuspensao,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_73_OperacaoDeAquisicaoAAliquotaZero,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_74_OperacaoDeAquisicaoSemIncidenciaDaContribuicao,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_75_OperacaoDeAquisicaoPorSubstituicaoTributaria,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_98_OutrasOperacoesDeEntrada,
				MLBRDocLineCOFINS.LBR_COF_TAXSTATUS_99_OutrasOperacoes)) {
			
			cofins.setCalculationType("PER");
			cofins.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			cofins.setLBR_TaxRate(tl.getLBR_TaxRate());
			cofins.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		}
		
		cofins.saveEx();
	}
	
	/**
	 * 	Create Import Tax (child of Doc Line Details)
	 */
	private void createImportTax(MLBRTaxLine tl) {
		MLBRDocLineImportTax[] iiArray = MLBRDocLineImportTax.getOfDetails(this);
		MLBRDocLineImportTax ii = new MLBRDocLineImportTax(getCtx(), 0, get_TrxName());
		
		if (iiArray.length > 0)
			ii = iiArray[0];

		ii.setAD_Org_ID(getAD_Org_ID());
		ii.setLBR_DocLine_Details_ID(get_ID());
		ii.setIsTaxIncluded(tl.isTaxIncluded());
		ii.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
		ii.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		ii.saveEx();
	}	

	/**
	 * 	Create ISSQN (child of Doc Line Details)
	 */
	private void createISSQN(MLBRTaxLine tl, MProduct m_product) {

		// get existing tax
		MLBRDocLineISSQN[] issqnArray = MLBRDocLineISSQN.getOfDetails(this);
		MLBRDocLineISSQN issqn;

		// if exists, replace, else, create
		if (issqnArray.length > 0)
			issqn = issqnArray[0];
		else
			issqn = new MLBRDocLineISSQN(getCtx(), 0, get_TrxName());

		//
		issqn.setAD_Org_ID(getAD_Org_ID());
		issqn.setLBR_DocLine_Details_ID(get_ID());
		issqn.setIsTaxIncluded(tl.isTaxIncluded());
		issqn.setLBR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
		issqn.setLBR_TaxRate(tl.getLBR_TaxRate());
		issqn.setLBR_TaxAmt(tl.getLBR_TaxAmt());
		issqn.setLBR_ISS_WithholdingAmt(Env.ZERO);

		// normal transaction
		if (issqn.getLBR_TaxAmt().signum() == -1 && issqn.getLBR_TaxBaseAmt().signum() == 1) {
			issqn.setLBR_HasWithHold(true);
			issqn.setLBR_ISS_WithholdingAmt(issqn.getLBR_TaxAmt().multiply(Env.ONE.negate()));

			// reverse transaction
		} else if (issqn.getLBR_TaxAmt().signum() == 1 && issqn.getLBR_TaxBaseAmt().signum() == -1) {
			issqn.setLBR_HasWithHold(true);
			issqn.setLBR_ISS_WithholdingAmt(issqn.getLBR_TaxAmt().multiply(Env.ONE.negate()));
		}

		/*
		 * Default Value TODO: choose a better plate to put this info (into product,
		 * bpartner...)
		 */
		issqn.setLBR_ResponsavelRetencao(MLBRDocLineISSQN.LBR_RESPONSAVELRETENCAO_Tomador);
		issqn.setLBR_ISS_Chargeability(MLBRDocLineISSQN.LBR_ISS_CHARGEABILITY_Exigivel);
		issqn.setLBR_TaxIncentive(MLBRDocLineISSQN.LBR_TAXINCENTIVE_No);

		// default ZERO
		issqn.setLBR_CondDiscountAmt(Env.ZERO);
		issqn.setLBR_UncondDiscountAmt(Env.ZERO);
		issqn.setLBR_OtherWithholdingsAmt(Env.ZERO);
		issqn.setLBR_TaxBaseDeductionAmt(Env.ZERO);

		//
		if (m_product != null) {
			issqn.setLBR_ServiceCode(m_product.get_ValueAsString("LBR_ServiceCode"));
			issqn.setLBR_ServiceCodeOfCity(m_product.get_ValueAsString("LBR_ServiceCodeOfCity"));
		}

		//
		issqn.saveEx();

	}	
	
	/**
	 * Create ISSQN tax
	 * 
	 * @param tl
	 */
	private void createOTHER(MLBRTaxLine tl, int LBR_TaxGroup_ID) {

		// get existing tax
		MLBRDocLineOTHER[] otherTaxesArr = MLBRDocLineOTHER.getOfDetails(this);
		MLBRDocLineOTHER otherTax;

		// if exists, replace, else, create
		if (otherTaxesArr.length > 0)
			otherTax = otherTaxesArr[0];
		else
			otherTax = new MLBRDocLineOTHER(getCtx(), 0, get_TrxName());

		//
		otherTax.setAD_Org_ID(getAD_Org_ID());
		otherTax.setLBR_DocLine_Details_ID(get_ID());

		// IR
		if (LBR_TaxGroup_ID == MLBRTax.getTaxGroupID(MLBRTax.TAX_GROUP_IR_NAME)) {
			otherTax.setLBR_IR_TaxBaseAmt(tl.getLBR_TaxBaseAmt());
			otherTax.setLBR_IR_TaxRate(tl.getLBR_TaxRate());
			otherTax.setLBR_IR_TaxAmt(tl.getLBR_TaxAmt());

		}

		//
		otherTax.saveEx();
	}

	/**
	 * 	Verifica todas as linhas do imposto
	 * 
	 * 	@param taxes
	 * 	@param C_Tax_ID
	 * 	@param tax
	 */
	protected void processTax (Map<Integer, Object[]> taxes,
			MLBRTax tax, int C_Tax_ID) {
		
		for (MLBRTaxLine tl : tax.getLines()) {
			BigDecimal taxAmt 		= tl.getLBR_TaxAmt();
			BigDecimal taxBaseAmt	= tl.getLBR_TaxBaseAmt();
			BigDecimal taxTotal 	= Env.ZERO;
			BigDecimal taxBaseTotal = Env.ZERO;
			
			//if (taxAmt == null 
			//		|| taxAmt.compareTo(Env.ZERO) == 0
			//		|| !tl.isLBR_PostTax())
			//	continue;
			
			if (!tl.isLBR_PostTax())
				continue;
			
			Integer key = tl.getChild_Tax_ID(C_Tax_ID);
			
			if (key <= 0)
				continue;
			
			else if (taxes.containsKey(key))
			{
				taxTotal 		= (BigDecimal) taxes.get(key)[0];	//	Amt
				taxBaseTotal 	= (BigDecimal) taxes.get(key)[1];	//	Base
				taxes.remove(key);
			}
			
			taxes.put (key, new Object[]{taxTotal.add(taxAmt), 		//	0-Amt
					taxBaseTotal.add(taxBaseAmt),					//	1-Base
					tl.isTaxIncluded()});							//	2-Tax Included
		}
	}
	
	/**
	 * 	Copy to this details the fields of another details
	 */
	public void copyFrom(MLBRDocLineDetails detailsFrom) {
		if (detailsFrom == null)
			return;
		
		int C_OrderLine_ID = getC_OrderLine_ID();
		int C_InvoiceLine_ID = getC_InvoiceLine_ID();
		int M_RMALine_ID = getM_RMALine_ID();
		int LBR_NotaFiscalLine_ID = getLBR_NotaFiscalLine_ID();
		int LBR_NFS_ID = get_ValueAsInt("LBR_NFS_ID");
		
		// Copy
		MLBRDocLineDetails.copyValues(detailsFrom, this, getAD_Client_ID(), getAD_Org_ID());
		
		// Restore some important fields
		setC_OrderLine_ID(C_OrderLine_ID);
		setC_InvoiceLine_ID(C_InvoiceLine_ID);
		setM_RMALine_ID(M_RMALine_ID);
		setLBR_NotaFiscalLine_ID(LBR_NotaFiscalLine_ID);
		set_ValueOfColumn("LBR_NFS_ID", LBR_NFS_ID < 1 ? null : LBR_NFS_ID);
		
		copyTaxTransactionFrom(detailsFrom);
		m_DetailsFrom = detailsFrom;
	}
	
	/**
	 * 	Copy to this details the Tax Transaction of another details
	 */
	public void copyTaxTransactionFrom(MLBRDocLineDetails detailsFrom) {
		if (detailsFrom == null)
			return;
		
		// Use a copy instead of original
		MLBRTax tax = new MLBRTax(getCtx(), detailsFrom.getLBR_Tax_ID(), get_TrxName());
		setLBR_Tax_ID(tax.copyTo().get_ID());
	}
	
	/**
	 * 	Copy to this details the children of another details
	 */
	public void copyChildren(MLBRDocLineDetails detailsFrom) {
		MLBRDocLineICMS.copy(detailsFrom, this);
		MLBRDocLineIPI.copy(detailsFrom, this);
		MLBRDocLinePIS.copy(detailsFrom, this);
		MLBRDocLineCOFINS.copy(detailsFrom, this);
		MLBRDocLineImportTax.copy(detailsFrom, this);
		MLBRDocLineISSQN.copy(detailsFrom, this);
	}
	
	/**
	 * 	Get total tax amount not included on product price
	 */
	public BigDecimal getNotIncludedTaxAmt() {
		BigDecimal lineTaxAmt = Env.ZERO;
		
		// ICMS and ICMS-ST
		MLBRDocLineICMS[] icmsLines = MLBRDocLineICMS.getOfDetails(this);
		if (icmsLines.length > 0) {
			MLBRDocLineICMS icms = icmsLines[0];
			
			// ICMS
			if (icms.getLBR_TaxAmt() != null) {
				if (!icms.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(icms.getLBR_TaxAmt());
			}
			
			// ICMS-ST
			if (icms.getLBR_ICMSST_TaxAmt() != null) {
				if (!icms.isLBR_ICMSST_IsTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(icms.getLBR_ICMSST_TaxAmt());
			}
		}
		
		// IPI
		MLBRDocLineIPI[] ipiLines = MLBRDocLineIPI.getOfDetails(this);
		if (ipiLines.length > 0) {
			MLBRDocLineIPI ipi = ipiLines[0];
			
			if (ipi.getLBR_TaxAmt() != null) {
				if (!ipi.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(ipi.getLBR_TaxAmt());
			}
		}
		
		// PIS
		MLBRDocLinePIS[] pisLines = MLBRDocLinePIS.getOfDetails(this);
		if (pisLines.length > 0) {
			MLBRDocLinePIS pis = pisLines[0];
			
			if (pis.getLBR_TaxAmt() != null) {
				if (!pis.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(pis.getLBR_TaxAmt());
			}
		}
		
		// COFINS
		MLBRDocLineCOFINS[] cofinsLines = MLBRDocLineCOFINS.getOfDetails(this);
		if (cofinsLines.length > 0) {
			MLBRDocLineCOFINS cofins = cofinsLines[0];
			
			if (cofins.getLBR_TaxAmt() != null) {
				if (!cofins.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(cofins.getLBR_TaxAmt());
			}
		}
		
		// Import Tax
		MLBRDocLineImportTax[] importTaxLines = MLBRDocLineImportTax.getOfDetails(this);
		if (importTaxLines.length > 0) {
			MLBRDocLineImportTax importTax = importTaxLines[0];
			
			if (importTax.getLBR_TaxAmt() != null) {
				if (!importTax.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(importTax.getLBR_TaxAmt());
			}
		}
		
		// ISSQN
		MLBRDocLineISSQN[] issqnTaxLines = MLBRDocLineISSQN.getOfDetails(this);
		if (issqnTaxLines.length > 0) {
			MLBRDocLineISSQN issqnTax = issqnTaxLines[0];

			if (issqnTax.getLBR_TaxAmt() != null) {
				if (!issqnTax.isTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(issqnTax.getLBR_TaxAmt());
			}
		}

		// Other Taxes
		MLBRDocLineOTHER[] othetTaxLines = MLBRDocLineOTHER.getOfDetails(this);
		if (othetTaxLines.length > 0) {
			MLBRDocLineOTHER otherTax = othetTaxLines[0];

			if (otherTax.getLBR_IR_TaxAmt() != null) {
				if (!otherTax.isLBR_IR_IsTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(otherTax.getLBR_IR_TaxAmt());
			}

			if (otherTax.getLBR_INSS_TaxAmt() != null) {
				if (!otherTax.isLBR_INSS_IsTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(otherTax.getLBR_INSS_TaxAmt());
			}

			if (otherTax.getLBR_CSLL_TaxAmt() != null) {
				if (!otherTax.isLBR_CSLL_IsTaxIncluded())
					lineTaxAmt = lineTaxAmt.add(otherTax.getLBR_CSLL_TaxAmt());
			}
		}
		
		return lineTaxAmt;
	}

	/**
	 * 	Get adjusted IVA-ST based on transaction UF's 
	 * 
	 * 	@return adjusted or original iva-st
	 */
	protected BigDecimal getAdjustedIva(BigDecimal originalIVA){
		return originalIVA;
	}
	
	/**
	 * 	Create tax transaction (LBR_Tax_ID). If one exists, it is overwritten by a new one.
	 */
	public void createTaxTransaction(Object[] taxation) {
		//PO linePO = getParent();
		
		//if (linePO != null) {			
			//if (linePO.get_ValueAsInt("M_Product_ID") <= 0) {
			//	set_Value("LBR_Tax_ID", null);
			//	return;
			//}
			
			if (taxation == null) {
				set_Value("LBR_Tax_ID", null);
				return;
			}
			
			/**
			 * Content for taxation array slots:
			 * 	0 = Taxes
			 * 	1 = Legal Message
			 * 	2 = CFOP
			 * 	3 = CST
			 */
			@SuppressWarnings("unchecked")
			Map<Integer, MLBRTaxLine> taxes = (Map<Integer, MLBRTaxLine>) taxation[0];
			
			if (taxes.size() > 0)
			{
				MLBRTax tax = new MLBRTax (getCtx(), 0, get_TrxName());
				tax.setAD_Org_ID(getAD_Org_ID());
				tax.saveEx();

				for (Integer key : taxes.keySet()) {
					MLBRTaxLine tl = taxes.get(key);
					tl.setLBR_Tax_ID(tax.getLBR_Tax_ID());
					
					// Adjust IVA-ST
					//if (tl.getLBR_TaxName_ID() == 1000012)
					//	tl.setLBR_TaxRate(getAdjustedIva(tl.getLBR_TaxRate()));
					tl.saveEx();
				}
				
				// Check if it is necessary to adjust the IVA-ST 
				checkIVAST(tax);

				tax.setDescription();
				tax.saveEx();
				setLBR_Tax_ID(tax.get_ID());
			} else {
				set_Value("LBR_Tax_ID", null);
			}
			
			//if (((Integer) taxation[1]) > 0)
			//	mTab.setValue("LBR_LegalMessage_ID", ((Integer) taxation[1]));
			
			if (((Integer) taxation[2]) > 0) {
				setLBR_CFOP_ID((Integer) taxation[2]);
			} else {
				set_Value("LBR_CFOP_ID", null);
			}
			
			//if (((String) taxation[3]) != null && ((String) taxation[3]).length() > 0)
			//	mTab.setValue("lbr_TaxStatus", p.getlbr_ProductSource() + ((String) taxation[3]));
		//}

		return;
	}
	
	/**
	 * 	Check and adjust (if necessary) the IVA-ST percentage in the transaction
	 * 	@param tax MLBRTax
	 */
	private void checkIVAST(MLBRTax tax) {
		MLBRTaxLine[] lines = tax.getLines();
		
		BigDecimal aliqInterestadual = Env.ZERO;
		BigDecimal aliqInternaDestino = Env.ZERO;
		BigDecimal ivaOriginal = Env.ZERO;
		
		MLBRTaxLine ivaLine = null;
		
		// Get ICMS tax rate
		for (MLBRTaxLine line : lines) {
			if (line.getLBR_TaxName().getName().equals("ICMSPROD") ||
					line.getLBR_TaxName().getName().equals("ICMSSERV"))
				aliqInterestadual = line.getLBR_TaxRate();
			else if (line.getLBR_TaxName().getName().equals("ICMSST"))
				aliqInternaDestino = line.getLBR_TaxRate();
			else if (line.getLBR_TaxName().getName().equals("IVA")) {
				ivaOriginal = line.getLBR_TaxRate();
				ivaLine = line;
			}
		}
		
		if (ivaOriginal.compareTo(Env.ZERO) != 0) {
			ivaLine.setLBR_TaxRate(MLBRDocLineICMS.getAdjustedIva(ivaOriginal, aliqInterestadual, aliqInternaDestino));
			ivaLine.saveEx();
		}
		
		return;		
	}
	
	/**
	 * 	Get the IVA-ST percentage in a MLBRTax.	
	 * 	@param tax MLBRTax
	 *	@return IVA-ST percentage
	 */
	private BigDecimal getIVAST(MLBRTax tax) {
		BigDecimal iva = Env.ZERO;
		MLBRTaxLine[] lines = tax.getLines();
		
		// Get ICMS tax rate
		for (MLBRTaxLine line : lines) {
			if (line.getLBR_TaxName().getName().equals("IVA"))
				iva = line.getLBR_TaxRate();
		}
		
		return iva;
	}	
	
	/**
	 * 	Get FCP (fundo de combate a pobreza) Rate
	 * 	@param tax MLBRTax
	 *	@return IVA-ST percentage
	 */
	private BigDecimal getFCP(MLBRTax tax) {
		BigDecimal rate = Env.ZERO;
		MLBRTaxLine[] lines = tax.getLines();
		
		// Get FCP tax rate
		for (MLBRTaxLine line : lines) {
			if (line.getLBR_TaxName().getName().equals("FCP"))
				rate = line.getLBR_TaxRate();
		}
		
		return rate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 	Create new Doc Line Details record from a given PO.
	 * 	@param po line
	 *	@return true if it could be created successfully
	 */
	public static MLBRDocLineDetails createFromPO (PO po)
	{	
		MLBRDocLineDetails details;
		details = getOfPO(po);
		
		if (details != null)
			return details;		
		
		String columnName = po.get_TableName() + "_ID";
		
		details = new MLBRDocLineDetails(po.getCtx(), 0, po.get_TrxName());		
		details.setAD_Org_ID(po.getAD_Org_ID());
		details.set_ValueOfColumn(columnName, po.get_ID());
		
		return details;
	}
	
	/**
	 * 	Get Brazilian Doc Line Details of a given PO.
	 * 	@param po persistent object
	 *	@return details
	 */
	public static MLBRDocLineDetails getOfPO (PO po)
	{	
		String sql =  " SELECT LBR_DocLine_Details_ID"
				+ " FROM LBR_DocLine_Details"
				+ " WHERE " + po.get_TableName() + "_ID=?";
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try	{
			pstmt = DB.prepareStatement(sql, po.get_TrxName());
			pstmt.setInt(1, po.get_ID());
			rs = pstmt.executeQuery();
			while (rs.next()) {	
				MLBRDocLineDetails details = new MLBRDocLineDetails(po.getCtx(), rs.getInt("LBR_DocLine_Details_ID"), po.get_TrxName());
				return details;
			}
		}
		catch (SQLException e)
		{
			log.severe("Couldn't get LBR_DocLine_Details of PO " + po);
			e.printStackTrace();
		}
		finally
		{
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		
		return null;
	}
	
	public void populateFromPO(PO po) {
		if (po instanceof MOrderLine ||	po instanceof MInvoiceLine || po instanceof MRMALine || po instanceof MLBRNotaFiscalLine) {
			// Determine if discount is printed
			boolean isDiscountPrinted = isDiscountPrinted(po);
						
			// Common data from C_OrderLine, C_InvoiceLine and M_RMALine
			setAD_Org_ID(po.getAD_Org_ID());
			MProduct product = new MProduct(po.getCtx(), po.get_ValueAsInt("M_Product_ID"), po.get_TrxName());
			
			if (product.get_ID() > 0) {
				I_W_M_Product pW = POWrapper.create(product, I_W_M_Product.class);
				setProductValue(product.getValue());
				
				// use category name as product description
				if (MSysConfig.getBooleanValue("LBR_PRODUCT_FISCAL_NAME_SIMPLIFIED", false, po.getAD_Client_ID(), po.getAD_Org_ID()))
					setProductName(product.getM_Product_Category().getName());
				else
					setProductName(product.getName());
				
				setLBR_NCM_ID(pW.getLBR_NCM_ID());
				setLBR_UPCTax(product.getUPC());
				
				if (product.getProductType().equals(MProduct.PRODUCTTYPE_Service))
					setLBR_TaxationType(MLBRDocLineDetails.LBR_TAXATIONTYPE_ISSQN);
				else
					setLBR_TaxationType(MLBRDocLineDetails.LBR_TAXATIONTYPE_ICMS);
			}  else {
				setProductValue(null);
				setProductName(null);
				setLBR_NCM_ID(0);
				setLBR_UPCTax(null);
				setLBR_TaxationType(null);
			}
			
			// Common data from C_OrderLine and C_InvoiceLine
			if (po instanceof MOrderLine ||	po instanceof MInvoiceLine) {
				setLBR_QtyTax((BigDecimal)po.get_Value("QtyEntered"));
				setLBR_UOMTax_ID(po.get_ValueAsInt("C_UOM_ID"));
				setLBR_PriceTax((BigDecimal)po.get_Value("PriceEntered"));
				
				// Discount
				BigDecimal qty = Env.ZERO;
				
				if (po instanceof MOrderLine)
					qty = (BigDecimal)po.get_Value("QtyOrdered");
				else if (po instanceof MInvoiceLine)
					qty = (BigDecimal)po.get_Value("QtyInvoiced");
				
				if (isDiscountPrinted) {
					setDiscountAmt(
							calculateDiscountAmt(
									qty,
									(BigDecimal)po.get_Value("PriceList"),
									(BigDecimal)po.get_Value("LineNetAmt")
							)
					);
				} else {
					setDiscountAmt(Env.ZERO);
				}
			}
			
			// Data from C_OrderLine
			if (po instanceof MOrderLine) {
				MOrderLine line = (MOrderLine) po;
				setPOReference(line.getParent().getPOReference());
			}
			
			// Data from C_InvoiceLine
			if (po instanceof MInvoiceLine) {
				MInvoiceLine line = (MInvoiceLine) po;
				setPOReference(line.getParent().getPOReference());
			}
			
			// Data from M_RMALine
			if (po instanceof MRMALine) {
				setLBR_QtyTax((BigDecimal)po.get_Value("Qty"));
				setLBR_UOMTax_ID(product.get_ValueAsInt("C_UOM_ID"));
				setLBR_PriceTax((BigDecimal)po.get_Value("Amt"));
			}
			
			// Data from LBR_NotaFiscal
			if (po instanceof MLBRNotaFiscalLine) {
				setLBR_QtyTax((BigDecimal)po.get_Value("Qty"));
				setLBR_UOMTax_ID(product.get_ValueAsInt("C_UOM_ID"));
				setLBR_PriceTax((BigDecimal)po.get_Value("PriceActual"));
			}
			
			// Calculate gross amount
			setLBR_GrossAmt(((BigDecimal)po.get_Value("LineNetAmt")).add(getDiscountAmt() == null ? Env.ZERO : getDiscountAmt()));
		}  
		
		else if (po instanceof MLBRNFS) {
			setAD_Org_ID(po.getAD_Org_ID());
			MProduct product = new MProduct(po.getCtx(), po.get_ValueAsInt("M_Product_ID"), po.get_TrxName());
			
			if (product.get_ID() > 0) {
				setProductValue(product.getValue());
				setProductName(product.getName());
				setLBR_UOMTax_ID(product.get_ValueAsInt("C_UOM_ID"));
				
				if (product.getProductType().equals(MProduct.PRODUCTTYPE_Service))
					setLBR_TaxationType(MLBRDocLineDetails.LBR_TAXATIONTYPE_ISSQN);
				else
					setLBR_TaxationType(MLBRDocLineDetails.LBR_TAXATIONTYPE_ICMS);
			}  else {
				setProductValue(null);
				setProductName(null);
				setLBR_NCM_ID(0);
				setLBR_UPCTax(null);
				setLBR_TaxationType(null);
			}
			
			setLBR_QtyTax((BigDecimal)po.get_Value("Qty"));
			setLBR_PriceTax((BigDecimal)po.get_Value("Price"));
				
			// Calculate gross amount
			setLBR_GrossAmt(((BigDecimal)po.get_Value("TotalLines")).add(getDiscountAmt() == null ? Env.ZERO : getDiscountAmt()));
		}
		
		else if (po instanceof MOrder || po instanceof MInvoice || po instanceof MRMA) { // Data from C_Order, C_Invoice and M_RMA
			// Common data from C_Order and C_Invoice
			if (po instanceof MOrder ||	po instanceof MInvoice) {
				setPOReference(po.get_ValueAsString("POReference"));
				set_Value("LBR_POReferenceLine", null);
			}
		}
	}
	
	public boolean isDiscountPrinted(PO po) {
		if (po instanceof MOrderLine) {
			MOrder order = ((MOrderLine)po).getParent();
			return order.isDiscountPrinted();
		} else if (po instanceof MInvoiceLine) {
			MInvoice invoice = ((MInvoiceLine)po).getParent();
			return invoice.isDiscountPrinted();
		} else if (po instanceof MLBRNotaFiscal)
			return false;
		
		return false;
	}
	
	/**
	 * 	Calculate brazilian taxes
	 * 	@param original order/invoice
	 * 	@param line to be processed
	 * 	@param updateTaxes
	 * 	@return error message or null
	 */
	public String calculateTaxes (PO po, PO poLine) {
		if (MOrderLine.Table_Name.equals(poLine.get_TableName())) {
			MOrder order = null;
			MOrderLine orderLine = (MOrderLine) poLine;
			
			if (po != null) 
				order = (MOrder) po;
			else 
				order = orderLine.getParent();
			
			if (getLBR_Tax_ID() > 0) {
				Map<String, BigDecimal> params = new HashMap<String, BigDecimal>();
				params.put(MLBRTax.SISCOMEX, getLBR_SiscomexAmt());
				params.put(MLBRTax.INSURANCE, getInsuredAmount());
				params.put(MLBRTax.FREIGHT, getFreightAmt());
				params.put(MLBRTax.OTHERCHARGES, getSurcharges());
				params.put(MLBRTax.QTY, getLBR_QtyTax());
				params.put(MLBRTax.AMT, getLBR_GrossAmt().subtract(getDiscountAmt()));
				
				//if (getIVARateFromTaxTransaction() != null && getIVARateFromTaxTransaction().signum() == 1)
				//	params.put("IVA", getAdjustedIva().divide(Env.ONEHUNDRED, 4, BigDecimal.ROUND_HALF_UP));
			
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				tax.calculate (order.isTaxIncluded(), order.getDateOrdered(), params, order.get_ValueAsString("LBR_TransactionType"));
			}
		} else if (MInvoiceLine.Table_Name.equals(poLine.get_TableName())) {
			MInvoice invoice = null;
			MInvoiceLine invoiceLine = (MInvoiceLine) poLine;
			
			if (po != null) 
				invoice = (MInvoice) po;
			else 
				invoice = invoiceLine.getParent();
			
			if (getLBR_Tax_ID() > 0) {
				BigDecimal reversal = (getLBR_QtyTax().signum() < 0) ? Env.ONE.negate() : Env.ONE;
				
				Map<String, BigDecimal> params = new HashMap<String, BigDecimal>();
				params.put(MLBRTax.SISCOMEX, getLBR_SiscomexAmt().multiply(reversal));
				params.put(MLBRTax.INSURANCE, getInsuredAmount() == null ? Env.ZERO : getInsuredAmount().multiply(reversal));
				params.put(MLBRTax.FREIGHT, getFreightAmt() == null ? Env.ZERO : getFreightAmt().multiply(reversal));
				params.put(MLBRTax.OTHERCHARGES, getSurcharges() == null ? Env.ZERO : getSurcharges().multiply(reversal));
				params.put(MLBRTax.QTY, getLBR_QtyTax());
				params.put(MLBRTax.AMT, getLBR_GrossAmt().subtract(getDiscountAmt()));
				
				//if (getIVARateFromTaxTransaction() != null && getIVARateFromTaxTransaction().signum() == 1)
				//	params.put("IVA", getAdjustedIva().divide(Env.ONEHUNDRED, 4, BigDecimal.ROUND_HALF_UP));
				
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				tax.calculate (invoice.isTaxIncluded(), invoice.getDateInvoiced(), params, invoice.get_ValueAsString("LBR_TransactionType"));
			}
		} else if (MRMALine.Table_Name.equals(poLine.get_TableName())) {
			MRMA rma = null;
			MRMALine rmaline = (MRMALine) poLine;
			
			if (po != null) 
				rma = (MRMA) po;
			else 
				rma = rmaline.getParent();
			
			if (getLBR_Tax_ID() > 0) {
				
				BigDecimal reversal = (getLBR_QtyTax().signum() < 0) ? Env.ONE.negate() : Env.ONE;
				
				Map<String, BigDecimal> params = new HashMap<String, BigDecimal>();
				params.put(MLBRTax.SISCOMEX, getLBR_SiscomexAmt().multiply(reversal));
				params.put(MLBRTax.INSURANCE, getInsuredAmount() == null ? Env.ZERO : getInsuredAmount().multiply(reversal));
				params.put(MLBRTax.FREIGHT, getFreightAmt() == null ? Env.ZERO : getFreightAmt().multiply(reversal));
				params.put(MLBRTax.OTHERCHARGES, getSurcharges() == null ? Env.ZERO : getSurcharges().multiply(reversal));
				params.put(MLBRTax.QTY, getLBR_QtyTax());
				params.put(MLBRTax.AMT, getLBR_GrossAmt().subtract(getDiscountAmt()));
				
				//if (getIVARateFromTaxTransaction() != null && getIVARateFromTaxTransaction().signum() == 1)
				//	params.put("IVA", getAdjustedIva().divide(Env.ONEHUNDRED, 4, BigDecimal.ROUND_HALF_UP));
				
				// default re-sale
				String transactionType = "RES";
				
				// get from order
				MOrder m_order = null; 
				if (rma.getInOut() != null && rma.getInOut().getC_Order_ID() > 0) {
					m_order = new MOrder(getCtx(), rma.getInOut().getC_Order_ID(), get_TrxName());
					if (!m_order.get_ValueAsString("LBR_TransactionType").isEmpty())
						transactionType = m_order.get_ValueAsString("LBR_TransactionType");
				}
				
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				tax.calculate (rma.isTaxIncluded(), rma.getInOut().getMovementDate(), params, transactionType);
			}
		} else if (MLBRNotaFiscalLine.Table_Name.equals(poLine.get_TableName())) {
			MLBRNotaFiscal nf = null;
			MLBRNotaFiscalLine nfLine = (MLBRNotaFiscalLine) poLine;
			
			if (po != null) 
				nf = (MLBRNotaFiscal) po;
			else 
				nf = nfLine.getParent();
			
			if (getLBR_Tax_ID() > 0) {
				Map<String, BigDecimal> params = new HashMap<String, BigDecimal>();
				params.put(MLBRTax.SISCOMEX, getLBR_SiscomexAmt());
				params.put(MLBRTax.INSURANCE, getInsuredAmount());
				params.put(MLBRTax.FREIGHT, getFreightAmt());
				params.put(MLBRTax.OTHERCHARGES, getSurcharges());
				params.put(MLBRTax.QTY, getLBR_QtyTax());
				params.put(MLBRTax.AMT, getLBR_GrossAmt().subtract(getDiscountAmt() == null ? Env.ZERO : getDiscountAmt()));
				
				//if (getIVARateFromTaxTransaction() != null && getIVARateFromTaxTransaction().signum() == 1)
				//	params.put("IVA", getAdjustedIva().divide(Env.ONEHUNDRED, 4, BigDecimal.ROUND_HALF_UP));
			
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				tax.calculate (nf.isTaxIncluded(), nf.getDateDoc(), params, nf.get_ValueAsString("LBR_TransactionType"));
			}
		} else if (MLBRNFS.Table_Name.equals(po.get_TableName())) {
			MLBRNFS nfs = (MLBRNFS) po;
		
			//
			if (getLBR_Tax_ID() > 0) {
				Map<String, BigDecimal> params = new HashMap<String, BigDecimal>();
				params.put(MLBRTax.SISCOMEX, getLBR_SiscomexAmt());
				params.put(MLBRTax.INSURANCE, getInsuredAmount());
				params.put(MLBRTax.FREIGHT, getFreightAmt());
				params.put(MLBRTax.OTHERCHARGES, getSurcharges());
				params.put(MLBRTax.QTY, getLBR_QtyTax());
				params.put(MLBRTax.AMT, getLBR_GrossAmt().subtract(getDiscountAmt() == null ? Env.ZERO : getDiscountAmt()));
			
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				tax.calculate (nfs.isTaxIncluded(), nfs.getDateDoc(), params, nfs.getLBR_TransactionType());
			}
		}
		
		return null;
	}

	/**
	 * 	Get adjusted IVA-ST based on transaction UF's 
	 * 
	 * 	@return adjusted or original iva-st
	 */
	/*protected BigDecimal getAdjustedIva(BigDecimal originalIVA){
		boolean isSOTrx = true;
		Timestamp docDate = null;
		MProduct product = null;
		I_C_BPartner_Location bpLocation = null;
		int AD_Org_ID = 0;
		
		if (getC_OrderLine_ID() > 0) {
			MOrderLine line = new MOrderLine(getCtx(), getC_OrderLine_ID(), get_TrxName());
			MOrder order = line.getParent();
			docDate = order.getDateOrdered();
			isSOTrx = order.isSOTrx();
			bpLocation = order.getBill_Location();
			product = line.getProduct();
			AD_Org_ID = line.getAD_Org_ID();
		} else if (getC_InvoiceLine_ID() > 0) {
			MInvoiceLine line = new MInvoiceLine(getCtx(), getC_InvoiceLine_ID(), get_TrxName());
			MInvoice invoice = line.getParent();
			docDate = invoice.getDateInvoiced();
			isSOTrx = invoice.isSOTrx();
			bpLocation = invoice.getC_BPartner_Location();
			product = line.getProduct();
			AD_Org_ID = line.getAD_Org_ID();
		} else if (getLBR_NotaFiscalLine_ID() > 0) {
			MLBRNotaFiscalLine line = new MLBRNotaFiscalLine(getCtx(), getLBR_NotaFiscalLine_ID(), get_TrxName());
			MLBRNotaFiscal nf = line.getParent();
			docDate = nf.getDateDoc();
			isSOTrx = nf.isSOTrx();
			bpLocation = nf.getC_BPartner_Location();
			product = line.getProduct();
			AD_Org_ID = line.getAD_Org_ID();
		}
		
		return MLBRDocLineICMS.getInterstateAdjustedIva(originalIVA, AD_Org_ID, isSOTrx, docDate, product, bpLocation);
	}*/
	
	protected boolean afterSave(boolean newRecord, boolean success) {
		if (newRecord == false && getLBR_Tax_ID() == 0) {
			deleteChildren();
		}
		
		if (!success)
			return success;
		
		if (getC_OrderLine_ID() > 0 || getC_InvoiceLine_ID() > 0 || getM_RMALine_ID() > 0 ||
				getLBR_NotaFiscalLine_ID() > 0 || get_ValueAsInt("LBR_NFS_ID") > 0) {		
			if (m_DetailsFrom != null) {
				copyChildren(m_DetailsFrom);			
				m_DetailsFrom = null;
				return true;
			}
			
			// Calculate (or recalculate) taxes
			if (getLBR_Tax_ID() > 0 &&
					((!newRecord && (is_ValueChanged("LBR_Tax_ID") || is_ValueChanged("LBR_GrossAmt") || is_ValueChanged("DiscountAmt"))) ||
					(newRecord))
				) {
	
				deleteChildren();
				
				// Array para somar os impostos de todas as linhas
				Map<Integer, Object[]> taxes = new HashMap<Integer, Object[]>();
				MLBRTax tax = new MLBRTax (getCtx(), getLBR_Tax_ID(), get_TrxName());
				
				if (getC_OrderLine_ID() > 0) {
					MOrderLine orderLine = new MOrderLine(getCtx(), getC_OrderLine_ID(), get_TrxName());
					MOrder order = orderLine.getParent();
					calculateTaxes(order, orderLine);
					processTax(taxes, tax, orderLine.getC_Tax_ID());
					createChildren(taxes, tax, orderLine.getC_Tax_ID(),
							(MProduct) orderLine.getM_Product(),
							order.getC_BPartner_ID(),
							order.getC_BPartner_Location_ID(),
							order.get_ValueAsString("LBR_TransactionType"),
							order.getDateOrdered());
					orderLine.updateHeaderTax();
					
				} else if (getC_InvoiceLine_ID() > 0) {
					MInvoiceLine invoiceLine = new MInvoiceLine(getCtx(), getC_InvoiceLine_ID(), get_TrxName());
					MInvoice invoice = invoiceLine.getParent();
					calculateTaxes(invoice, invoiceLine);
					processTax(taxes, tax, invoiceLine.getC_Tax_ID());
					createChildren(taxes, tax, invoiceLine.getC_Tax_ID(),
							(MProduct) invoiceLine.getM_Product(),
							invoice.getC_BPartner_ID(),
							invoice.getC_BPartner_Location_ID(),
							invoice.get_ValueAsString("LBR_TransactionType"),
							invoice.getDateInvoiced());
					invoiceLine.updateHeaderTax();
					
				} else if (getM_RMALine_ID() > 0) {
					MRMALine rmaLine = new MRMALine(getCtx(), getM_RMALine_ID(), get_TrxName());
					MRMA rma = rmaLine.getParent();
					
					// get trxTypeBR from original order
					MOrder originalOrder = rma.getOriginalOrder();

					// 
					calculateTaxes(rma, rmaLine);
					processTax(taxes, tax, rmaLine.getC_Tax_ID());
					createChildren(taxes, tax, rmaLine.getC_Tax_ID(),
							(MProduct) rmaLine.getM_Product(),
							rma.getC_BPartner_ID(),
							originalOrder.getC_BPartner_Location_ID(),
							originalOrder
									.get_ValueAsString("LBR_TransactionType"),
							rma.getInOut().getMovementDate());
					rmaLine.updateHeaderAmt();
				} else if (getLBR_NotaFiscalLine_ID() > 0) {
					MLBRNotaFiscalLine nfLine = new MLBRNotaFiscalLine(getCtx(), getLBR_NotaFiscalLine_ID(), get_TrxName());
					MLBRNotaFiscal nf = nfLine.getParent();
					calculateTaxes(nf, nfLine);
					processTax(taxes, tax, nfLine.getC_Tax_ID());
					createChildren(taxes, tax, nfLine.getC_Tax_ID(),
							(MProduct) nfLine.getM_Product(),
							nf.getC_BPartner_ID(),
							nf.getC_BPartner_Location_ID(),
							nf.getLBR_TransactionType(), nf.getDateDoc());
					nfLine.updateHeaderTax();
				} else if (get_ValueAsInt("LBR_NFS_ID") > 0) {
					MLBRNFS m_nfs = new MLBRNFS(getCtx(), get_ValueAsInt("LBR_NFS_ID"), get_TrxName());
					calculateTaxes(m_nfs, m_nfs);
					processTax(taxes, tax, m_nfs.getC_Tax_ID());
					createChildren(taxes, tax, m_nfs.getC_Tax_ID(),
							(MProduct) m_nfs.getM_Product(),
							m_nfs.getC_BPartner_ID(),
							m_nfs.getC_BPartner_Location_ID(),
							m_nfs.getLBR_TransactionType(), m_nfs.getDateDoc());
					m_nfs.updateHeaderTax();
				}
			}
		}

		return true;
	}
}