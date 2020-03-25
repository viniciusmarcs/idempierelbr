package org.idempierelbr.base.model;

import java.math.BigDecimal;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventManager;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.POWrapper;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MInOut;
import org.compiere.model.MInOutLine;
import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.model.MOrgInfo;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTax;
import org.compiere.model.MTaxProvider;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.idempierelbr.base.provider.TaxProviderFactory;
import org.idempierelbr.base.wrapper.I_W_C_BPartner;
import org.idempierelbr.base.wrapper.I_W_C_BPartner_Location;
import org.osgi.service.event.Event;

public class EventHandler extends AbstractEventHandler {
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(EventHandler.class);

	@Override
	protected void initialize() {
		registerEvent(IEventTopics.AFTER_LOGIN);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBPartner.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MBPartner.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBPartnerLocation.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MBPartnerLocation.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MOrgInfo.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MOrgInfo.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrgInfo.Table_Name);

		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrder.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MOrderLine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MOrderLine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MOrderLine.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MInvoice.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MInvoice.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MInvoiceLine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MInvoiceLine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MInvoiceLine.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MRMA.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MRMALine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MRMALine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MRMALine.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MLBRNotaFiscal.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MLBRNotaFiscal.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MLBRNotaFiscal.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MLBRNotaFiscal.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MLBRNotaFiscalLine.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MLBRNotaFiscalLine.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MLBRNotaFiscalLine.Table_Name);
		
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MLBRNotaFiscalTransp.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, X_LBR_NotaFiscalTrailer.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MLBRNotaFiscalPay.Table_Name);
		
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MLBRNFS.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MLBRNFS.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_NEW, MLBRNFS.Table_Name);
		registerTableEvent(IEventTopics.PO_AFTER_CHANGE, MLBRNFS.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_DELETE, MLBRNFS.Table_Name);
	}

	@Override
	protected void doHandleEvent(Event event) {
		if (event.getTopic().equals(IEventTopics.AFTER_LOGIN)) {
			LoginEventData loginData = (LoginEventData)event.getProperty(IEventManager.EVENT_DATA);
			boolean useUnifiedBP = MSysConfig.getBooleanValue("LBR_USE_UNIFIED_BP", false, loginData.getAD_Client_ID());
			
			if(useUnifiedBP)
				log.info("LBR: Usando PN unificados.");
			else
				log.info("LBR: Usando um PN por Filial (Normal).");
			
			Env.setContext(Env.getCtx(), "#LBR_USE_UNIFIED_BP", useUnifiedBP);
			return;
		}
		
		PO po = getPO(event);
		log.info(po + " Type: " + event.getTopic());
		String msg = null;
		
		if (po.get_TableName().equals(MBPartner.Table_Name) && (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)
				|| event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)))
		{
			MBPartner bp = (MBPartner)po;
			msg = validateBPTypeBR(bp);
			if (msg != null) {
				addErrorMessage(event, msg);
			}
		} else if (po.get_TableName().equals(MBPartnerLocation.Table_Name) && (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)
				|| event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE)))
		{
			MBPartnerLocation bpl = (MBPartnerLocation)po;
			msg = validateBPTypeBR(bpl);
			if (msg != null)
				addErrorMessage(event, msg);
		}
		
		// Copy LBR fields from Order to Invoice
		if (po instanceof MInvoice && event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			MInvoice invoice = (MInvoice) po;
			
			if (invoice.getC_Order_ID() > 0) {
				MOrder order = new MOrder(po.getCtx(), invoice.getC_Order_ID(), po.get_TrxName());
				String transactionType = order.get_ValueAsString("LBR_TransactionType");
				if (transactionType != null && transactionType.trim().length() > 0)
					invoice.set_ValueOfColumn("LBR_TransactionType", transactionType);
				
				String taxPayerInfo = order.get_ValueAsString("LBR_TaxPayerInfo");
				if (taxPayerInfo != null && taxPayerInfo.trim().length() > 0)
					invoice.set_ValueOfColumn("LBR_TaxPayerInfo", taxPayerInfo);
				
				String LBR_CPF = order.get_ValueAsString("LBR_UnidentifiedCustomerCPF");
				if(LBR_CPF != null){
					invoice.set_ValueOfColumn("LBR_UnidentifiedCustomerCPF", LBR_CPF);
				}
			} else if (invoice.getM_RMA_ID() > 0) {
				MRMA rma = new MRMA(po.getCtx(), invoice.getM_RMA_ID(), po.get_TrxName());
				MInOut inOut = new MInOut(po.getCtx(), rma.getInOut_ID(), po.get_TrxName());
				MOrder order = new MOrder(po.getCtx(), inOut.getC_Order_ID(), po.get_TrxName());
				String transactionType = order.get_ValueAsString("LBR_TransactionType");
				if (transactionType != null && transactionType.trim().length() > 0)
					invoice.set_ValueOfColumn("LBR_TransactionType", transactionType);
			}
		}
		
		// Set a default TaxRate for InvoiceLine if it is null (when generated by process)
		if (po instanceof MInvoiceLine && event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			MInvoiceLine iLine = (MInvoiceLine) po;
			
			if (iLine.getC_Tax_ID() <= 0) {
				iLine.setC_Tax_ID(getDefaultC_Tax_ID(iLine));
				iLine.save();
			}			
		}		
		
		// Create/update/delete Doc Line Details
		if (po instanceof MOrderLine ||	po instanceof MInvoiceLine || po instanceof MRMALine || po instanceof MLBRNotaFiscalLine ||
				po instanceof MOrder || po instanceof MInvoice || po instanceof MRMA || po instanceof MLBRNotaFiscal ||
				po instanceof MLBRNFS) {
			
			if (event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE)) {  // Update
				boolean requery = false;
			
				if (po.get_ColumnIndex("C_Tax_ID") == -1)
					checkNeedForUpdateLBRDocLineDetails(po);
				else {
					if (po.is_ValueChanged("C_Tax_ID"))
						requery = true;

					if (isLBRDefaultTaxProvider(po, requery)) {	
						MLBRDocLineDetails details = MLBRDocLineDetails.getOfPO(po);
			
						if (details == null) {
							msg = createLBRDocLineDetails(po);
							
							if (msg != null)
								addErrorMessage(event, msg);
						}
						
						if (msg == null)
							checkNeedForUpdateLBRDocLineDetails(po);
					} else {
						deleteLBRDocLineDetails(po);
					}
				}
			}
			
			if (po instanceof MOrderLine ||	po instanceof MInvoiceLine || po instanceof MRMALine ||
					po instanceof MLBRNotaFiscalLine || po instanceof MLBRNFS) {
				if (event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) { // Create
					if (isLBRDefaultTaxProvider(po, true)) {
						msg = createLBRDocLineDetails(po);
						
						if (msg != null)
							addErrorMessage(event, msg);
					}
				} else if (event.getTopic().equals(IEventTopics.PO_BEFORE_DELETE)) // Delete
					deleteLBRDocLineDetails(po);
			}
		}
		
		// Copy DateDoc to DateAcct
		if (po instanceof MLBRNotaFiscal && (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)
				|| event.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE))) {
			po.set_ValueOfColumn("DateAcct", po.get_Value("DateDoc"));
		}
		
		// Auto-Create child records when creating header record
		if (po instanceof MLBRNotaFiscal && event.getTopic().equals(IEventTopics.PO_AFTER_NEW)) {
			// Transportation
			X_LBR_NotaFiscalTransp transp = new X_LBR_NotaFiscalTransp(po.getCtx(), 0, po.get_TrxName());
			transp.setAD_Org_ID(po.getAD_Org_ID());
			transp.setLBR_NotaFiscal_ID(po.get_ID());
			transp.setLBR_NFeModShipping("0"); // Issuer
			transp.saveEx();
		}
		
		// Delete records from Trailer Tab when changing field in NF Transportation Tab
		if (po instanceof MLBRNotaFiscalTransp && event.getTopic().equals(IEventTopics.PO_AFTER_CHANGE) &&
				po.is_ValueChanged("LBR_NFeTranspVehicleType")) {

			X_LBR_NotaFiscalTrailer[] trailers = ((MLBRNotaFiscalTransp)po).getTrailers();
			
			for (X_LBR_NotaFiscalTrailer trailer : trailers) {
				trailer.deleteEx(true);
			}
		}
		
		// Check if there are maximum of 5 entries on NF Trailer Tab
		if (po instanceof X_LBR_NotaFiscalTrailer && event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			int LBR_NotaFiscalTransp_ID = ((X_LBR_NotaFiscalTrailer)po).getLBR_NotaFiscalTransp_ID();
			MLBRNotaFiscalTransp transp = new MLBRNotaFiscalTransp(po.getCtx(), LBR_NotaFiscalTransp_ID, po.get_TrxName());
			
			X_LBR_NotaFiscalTrailer[] trailers = transp.getTrailers();
			if (trailers.length >= 5)
				addErrorMessage(event, "Limite de 5 registros por Nota Fiscal");
		}
		
		// Check if there are maximum of 1 entries on NF Pay Tab
		if (po instanceof MLBRNotaFiscalPay && event.getTopic().equals(IEventTopics.PO_BEFORE_NEW)) {
			int LBR_NotaFiscal_ID = ((MLBRNotaFiscalPay)po).getLBR_NotaFiscal_ID();
			MLBRNotaFiscal nf = new MLBRNotaFiscal(po.getCtx(), LBR_NotaFiscal_ID, po.get_TrxName());
			
			MLBRNotaFiscalPay[] pays = nf.getPay();
			if (pays.length >= 1)
				addErrorMessage(event, "Limite de 1 registro por Nota Fiscal");
		}
		
		// Copy DateDoc to DateAcct
		if (po instanceof MLBRNFS
				&& (event.getTopic().equals(IEventTopics.PO_BEFORE_NEW) || event
						.getTopic().equals(IEventTopics.PO_BEFORE_CHANGE))) {
			po.set_ValueOfColumn("DateAcct", po.get_Value("DateDoc"));
		}
	}
	
	/**
	 *	Verifica se o campo CNPJ é válido
	 *	@return mensagem de erro ou null
	 */
	private String validateBPTypeBR(MBPartnerLocation bpl) {
		// BF [ 2808639 ] - Erro notado pelo usuario gmichels
		if (!MSysConfig.getBooleanValue("LBR_USE_UNIFIED_BP", false, bpl.getAD_Client_ID()))
			return null;
		
		MBPartner bp = new MBPartner(Env.getCtx(), bpl.getC_BPartner_ID(), bpl.get_TrxName());
		I_W_C_BPartner_Location bplW = POWrapper.create(bpl, I_W_C_BPartner_Location.class);
		I_W_C_BPartner bpW = POWrapper.create(bp, I_W_C_BPartner.class);
		boolean isValid = bpW.isLBR_BPTypeBRIsValid();

		// tentando desativar um registro
		if (bpl.is_ValueChanged("IsActive") && !bpl.isActive())
			return null;

		if (!isValid || bpW.getLBR_BPTypeBR() == null ||
				!bpW.getLBR_BPTypeBR().equalsIgnoreCase(I_W_C_BPartner.LBR_BPTYPEBR_PJ_LegalEntity))
			return null;

		String CNPJMatriz = bpW.getLBR_CNPJ();
		String CNPJFilial = bplW.getLBR_CNPJ();

		if (CNPJMatriz.substring(0, 8).equalsIgnoreCase(CNPJFilial.substring(0, 8)))	{
			if (!isValidCNPJ(bplW.getLBR_CNPJ()))
				return "CNPJ Inválido, por favor verifique";

			MCNPJ cnpj = new MCNPJ(CNPJFilial);
			
			if (!cnpj.isUniqueOnBP(bpl.getAD_Client_ID(), bpl.get_ID(), bpl.get_TableName(), bpl.get_TrxName()))
				return "CNPJ Duplicado. Existe outro Parceiro de Negócios com este CNPJ";
		} else
			return "CNPJ Inválido. Raiz do CNPJ não corresponde com o informado na aba Parceiro de Negócios";

		bplW.setLBR_BPTypeBRIsValid(true);
		return null;
	}

	/**
	 *	Verifica se os campos CPF, CNPJ e IE são válidos
	 *	@return mensagem de erro ou null
	 */
	private String validateBPTypeBR(MBPartner bp) {
		log.info(bp.toString());
		int AD_Client_ID = bp.getAD_Client_ID();
		I_W_C_BPartner bpW = POWrapper.create(bp, I_W_C_BPartner.class);

		if (bpW.getLBR_BPTypeBR() == null || bpW.getLBR_BPTypeBR().equals(""))
			return null;

		// se não estiver validado ou tentando ativar um registro desativado
		if (!bpW.isLBR_BPTypeBRIsValid() || (bp.is_ValueChanged("IsActive") && bp.isActive())) {
			// se PF, valida Pessoa Física
			if (bpW.getLBR_BPTypeBR().equalsIgnoreCase(I_W_C_BPartner.LBR_BPTYPEBR_PF_Individual)){
				if (bpW.getLBR_CPF() == null){
					return "Por favor, informe o CPF";
				}

				if (bpW.getLBR_CPF().length() < 11 || !isValidCPF(bpW.getLBR_CPF())){
					return "CPF Inválido, por favor verifique";
				}
				
				MCPF cpf = new MCPF(bpW.getLBR_CPF());

				if (!cpf.isUniqueOnBP(AD_Client_ID, bp.get_ID(), bp.get_TrxName())){
					return "CPF Duplicado. Existe outro Parceiro de Negócios com este CPF";
				}

			}
			// se PJ, valida Pessoa Jurídica
			else if (bpW.getLBR_BPTypeBR().equalsIgnoreCase(I_W_C_BPartner.LBR_BPTYPEBR_PJ_LegalEntity)) {
				if (bpW.getLBR_CNPJ() == null){
					return "Por favor, informe o CNPJ";
				}

				if (bpW.getLBR_CNPJ().length() < 14 || !isValidCNPJ(bpW.getLBR_CNPJ())){
					return "CNPJ Inválido, por favor verifique";
				}
				
				MCNPJ cnpj = new MCNPJ(bpW.getLBR_CNPJ());
				
				if (!cnpj.isUniqueOnBP(AD_Client_ID, bp.get_ID(), bp.get_TableName(), bp.get_TrxName())){
					return "CNPJ Duplicado. Existe outro Parceiro de Negócios com este CNPJ (ou raiz, caso PN Unificado)";
				}

				if(MSysConfig.getBooleanValue("LBR_USE_UNIFIED_BP", false, AD_Client_ID)) {
					// salva apenas a raiz do CNPJ
					bpW.setLBR_CNPJ(bpW.getLBR_CNPJ().substring(0, 8) + "000000");
					
					// Marca como ISENTO, para manter consistência do DB
					bpW.setLBR_TypeIE(I_W_C_BPartner.LBR_TYPEIE_Isento);
				}
			}
			
			// formata IE
			if (bpW.getLBR_IE() != null && bpW.getLBR_IE().length() > 0) {
				MIE ie = new MIE(bpW.getLBR_IE());
				String ieFormated = ie.getFormated();
				
				if (!ieFormated.equals(bpW.getLBR_IE()))
					bpW.setLBR_IE(ieFormated);
			}

			bpW.setLBR_BPTypeBRIsValid(true);
		}
		
		

		return null;
	}
	
	/**
	 *	Verifica se o CPF possui a sequência de caracteres e os dígitos verificadores válidos 
	 * @param bpW 
	 *	@return boolean true or false
	 */
	private boolean isValidCPF(String cpf)
	{
		MCPF c = new MCPF(cpf);
		return c.isValid();
	}
	
	/**
	 *	Verifica se o CNPJ possui a sequência de caracteres e os dígitos verificadores válidos 
	 *	@return boolean true or false
	 */
	private boolean isValidCNPJ(String cnpj) {
		MCNPJ c = new MCNPJ(cnpj);
		return c.isValid();
	}
	
	/**
	 * 	Delete Doc Line Details record
	 * 	@param po persistent object
	 */
	private void deleteLBRDocLineDetails(PO po) {
		MLBRDocLineDetails details = MLBRDocLineDetails.getOfPO(po);
		
		if (details != null) {
			try {
				details.deleteEx(true);
			} catch (AdempiereException e) {
				e.printStackTrace();
				log.warning(MLBRDocLineDetails.Table_Name + " for " + po + " was not deleted.");
				
				details.setC_OrderLine_ID(0);
				details.setC_InvoiceLine_ID(0);
				details.setM_RMALine_ID(0);
				details.setLBR_NotaFiscalLine_ID(0);
				details.saveEx();
			}
		}
	}

	/**
	 * 	Create new Brazilian Doc Line Details record
	 * 	@param po persistent object
	 *	@return error message or null
	 */
	private String createLBRDocLineDetails(PO po) {
		MLBRDocLineDetails details = MLBRDocLineDetails.createFromPO(po);
		
		if (details != null) {
			PO lineFrom = null;
			boolean copyDetails = false;
			BigDecimal qtyFrom = null;
			BigDecimal qtyTo = null;
			
			if (po instanceof MInvoiceLine || po instanceof MRMALine || po instanceof MLBRNotaFiscalLine || po instanceof MLBRNFS) {
				if (po instanceof MInvoiceLine) {
					MInvoiceLine iLine = (MInvoiceLine) po;
					
					if (iLine.getC_OrderLine_ID() > 0) { // Invoice generated to an order
						lineFrom = new MOrderLine(details.getCtx(), iLine.getC_OrderLine_ID(), details.get_TrxName());
						qtyFrom = ((MOrderLine) lineFrom).getQtyOrdered();
					} else if (iLine.getM_InOutLine_ID() > 0) { // Invoice generated to an RMA
						MInOutLine inOutLine = new MInOutLine(details.getCtx(), iLine.getM_InOutLine_ID(), details.get_TrxName());
						lineFrom = new MRMALine(details.getCtx(), inOutLine.getM_RMALine_ID(), details.get_TrxName());
						qtyFrom = ((MRMALine) lineFrom).getQty();
					}
					
					qtyTo = iLine.getQtyInvoiced();
				} else if (po instanceof MRMALine) {
					MRMALine rmaLine = (MRMALine) po;
					MInOutLine inOutLine = new MInOutLine(details.getCtx(), rmaLine.getM_InOutLine_ID(), details.get_TrxName());
					lineFrom = new MOrderLine(details.getCtx(), inOutLine.getC_OrderLine_ID(), details.get_TrxName());
					qtyFrom = ((MOrderLine) lineFrom).getQtyOrdered();
					qtyTo = rmaLine.getQty();
				} else if (po instanceof MLBRNotaFiscalLine) {
					MLBRNotaFiscalLine nfLine = (MLBRNotaFiscalLine)po;

					if (nfLine.getC_OrderLine_ID() > 0) {
						copyDetails = true;
						lineFrom = new MOrderLine(details.getCtx(), nfLine.getC_OrderLine_ID(), details.get_TrxName());
					} else if (nfLine.getC_InvoiceLine_ID() > 0) {
						copyDetails = true;
						lineFrom = new MInvoiceLine(details.getCtx(), nfLine.getC_InvoiceLine_ID(), details.get_TrxName());
					} else if (nfLine.getM_RMALine_ID() > 0) {
						copyDetails = true;
						lineFrom = new MRMALine(details.getCtx(), nfLine.getM_RMALine_ID(), details.get_TrxName());
					}
				}
				
				if (qtyFrom != null && qtyTo != null && qtyFrom.compareTo(qtyTo) == 0)
					copyDetails = true;
				
				if (po instanceof MLBRNFS) {
					copyDetails = false;
					MLBRNFS nfLine = (MLBRNFS) po;

					if (nfLine.getC_OrderLine_ID() > 0) {
						copyDetails = true;
						lineFrom = new MOrderLine(details.getCtx(),
								nfLine.getC_OrderLine_ID(), details.get_TrxName());
					} else if (nfLine.getC_InvoiceLine_ID() > 0) {
						copyDetails = true;
						lineFrom = new MInvoiceLine(details.getCtx(),
								nfLine.getC_InvoiceLine_ID(), details.get_TrxName());
					}
				}
			}
			
			if (copyDetails)
				details.copyFrom(MLBRDocLineDetails.getOfPO(lineFrom));
			else {
				details.populateFromPO(po);
				
				if (lineFrom != null)				
					details.copyTaxTransactionFrom(MLBRDocLineDetails.getOfPO(lineFrom));
				else {
					Object[] taxation = null;
					if (details.getC_OrderLine_ID() > 0) {
						MOrderLine oLine = new MOrderLine(details.getCtx(), details.getC_OrderLine_ID(), details.get_TrxName());
						taxation = MLBRTax.getTaxes(details.getCtx(), oLine, details.get_TrxName());
					} else if (details.getC_InvoiceLine_ID() > 0) {
						MInvoiceLine iLine = new MInvoiceLine(details.getCtx(), details.getC_InvoiceLine_ID(), details.get_TrxName());
						taxation = MLBRTax.getTaxes(details.getCtx(), iLine, details.get_TrxName());
					} else if (details.getLBR_NotaFiscalLine_ID() > 0) {
						MLBRNotaFiscalLine nfLine = new MLBRNotaFiscalLine(details.getCtx(), details.getLBR_NotaFiscalLine_ID(), details.get_TrxName());
						taxation = MLBRTax.getTaxes(details.getCtx(), nfLine, details.get_TrxName());
					} else if (details.get_ValueAsInt("LBR_NFS_ID") > 0) {
						MLBRNFS nfLine = new MLBRNFS(details.getCtx(),
								details.get_ValueAsInt("LBR_NFS_ID"),
								details.get_TrxName());
						taxation = MLBRTax.getTaxes(details.getCtx(), nfLine,
								details.get_TrxName());
					}
					details.createTaxTransaction(taxation);
				}
			}
			
			details.saveEx();
		} else {
			log.severe(MLBRDocLineDetails.Table_Name + " for " + po + " was not created.");
			return "Could not create Doc Line Details record";
		}
		
		return null;
	}
	
	/**
	 * 	Requery to define if tax line is calculated by LBR Default Tax Provider
	 * 	@param po persistent object
	 */
	private void requeryLBRDefaultTaxProvider(PO po) {
		boolean isLBRDefaultTaxProvider = false;
		
		if (po.get_ValueAsInt("C_Tax_ID") != 0) {
			MTax tax = new MTax(po.getCtx(), po.get_ValueAsInt("C_Tax_ID"), po.get_TrxName());
			int C_Tax_Provider_ID = tax.getC_TaxProvider_ID();
			
			if (C_Tax_Provider_ID > 0) {
				MTaxProvider provider = new MTaxProvider(Env.getCtx(), C_Tax_Provider_ID, po.get_TrxName());
				
				if (provider.getTaxProviderClass().equals(TaxProviderFactory.DEFAULT_TAX_PROVIDER))
					isLBRDefaultTaxProvider = true;
			}
		}
		
		if (isLBRDefaultTaxProvider)
			po.set_Attribute("IsLBRDefaultTaxProvider", "Y");
		else
			po.set_Attribute("IsLBRDefaultTaxProvider", "N");
		
		return;
	}
	
	/**
	 * 	Is tax line calculated by LBR Default Tax Provider?
	 * 	@param po persistent object
	 * 	@param requery true if C_Tax_ID should be revaluated
	 * 	@return true if is LBR Default Provider
	 */
	private boolean isLBRDefaultTaxProvider(PO po, boolean requery) {
		if (po.get_ColumnIndex("C_Tax_ID") == -1)
			return false;
		
		if (po.get_Attribute("IsLBRDefaultTaxProvider") == null)
			requery = true;
		
		if (!requery) {
			String isLBRDefaultTaxProvider = (String) po.get_Attribute("IsLBRDefaultTaxProvider");
			
			if (isLBRDefaultTaxProvider != null && isLBRDefaultTaxProvider.equals("Y"))
				return true;
		}
		
		requeryLBRDefaultTaxProvider(po);
		
		if (po.get_Attribute("IsLBRDefaultTaxProvider").equals("Y"))
			return true;
		
		return false;
	}
	
	/**
	 * 	Check the need for update Brazilian Doc Line Details record when PO change
	 * 	@param po persistent object
	 */
	private void checkNeedForUpdateLBRDocLineDetails(PO po) {
		if (!(isChangeAffectDocLineDetails(po) || isChangeAffectTaxTransaction(po)))
			return;
		
		if (po instanceof MOrderLine ||	po instanceof MInvoiceLine || po instanceof MRMALine || po instanceof MLBRNotaFiscalLine) {			
			updateLBRDocLineDetails(po, null);
		} else if (po instanceof MOrder) {
			MOrderLine[] lines = ((MOrder)po).getLines();
			
			for (MOrderLine line : lines) {
				updateLBRDocLineDetails(po, line);
			}
		} else if (po instanceof MInvoice) {
			MInvoiceLine[] lines = ((MInvoice)po).getLines();
			
			for (MInvoiceLine line : lines) {
				updateLBRDocLineDetails(po, line);
			}
		} else if (po instanceof MRMA) {
			MRMALine[] lines = ((MRMA)po).getLines(true);
			
			for (MRMALine line : lines) {
				updateLBRDocLineDetails(po, line);
			}
		} else if (po instanceof MLBRNotaFiscal) {
			MLBRNotaFiscalLine[] lines = ((MLBRNotaFiscal)po).getLines();
			
			for (MLBRNotaFiscalLine line : lines) {
				updateLBRDocLineDetails(po, line);
			}
		} else if (po instanceof MLBRNFS)
			updateLBRDocLineDetails(po, null);
		
		return;
	}
	
	/**
	 * 	Update Brazilian Doc Line Details
	 * 	@param poChanged doc changed
	 * 	@param poLine doc line
	 */
	private void updateLBRDocLineDetails(PO poChanged, PO poLine) {
		if (poLine == null)
			poLine = poChanged;
		
		MLBRDocLineDetails details = MLBRDocLineDetails.getOfPO(poLine);
		
		if (details != null) {
			if (isChangeAffectDocLineDetails(poChanged))
				details.populateFromPO(poLine);
			
			if (isChangeAffectTaxTransaction(poChanged)) {
				Object[] taxation = null;
				if (details.getC_OrderLine_ID() > 0) {
					MOrderLine oLine = new MOrderLine(details.getCtx(), details.getC_OrderLine_ID(), details.get_TrxName());
					taxation = MLBRTax.getTaxes(details.getCtx(), oLine, details.get_TrxName());
				} else if (details.getC_InvoiceLine_ID() > 0) {
					MInvoiceLine iLine = new MInvoiceLine(details.getCtx(), details.getC_InvoiceLine_ID(), details.get_TrxName());
					taxation = MLBRTax.getTaxes(details.getCtx(), iLine, details.get_TrxName());
				} else if (details.getLBR_NotaFiscalLine_ID() > 0) {
					MLBRNotaFiscalLine nfLine =
							new MLBRNotaFiscalLine(details.getCtx(), details.getLBR_NotaFiscalLine_ID(), details.get_TrxName());
					taxation = MLBRTax.getTaxes(details.getCtx(), nfLine, details.get_TrxName());
				} else if (details.get_ValueAsInt("LBR_NFS_ID") > 0) {
					MLBRNFS nfLine = new MLBRNFS(details.getCtx(),
							details.get_ValueAsInt("LBR_NFS_ID"),
							details.get_TrxName());
					taxation = MLBRTax.getTaxes(details.getCtx(), nfLine,
							details.get_TrxName());
				}
				details.createTaxTransaction(taxation);
			}
			
			details.saveEx();
		}
	}

	/**
	 * 	Verify if Doc Line Details must be updated
	 * 	@param po persistent object
	 * 	@return true if must updated
	 */
	private boolean isChangeAffectDocLineDetails(PO po)
	{
		if (po instanceof MOrder || po instanceof MInvoice || po instanceof MRMA) {
			// Commom changes in C_Order and C_Invoice
			if (po instanceof MOrder || po instanceof MInvoice) {
				if (po.is_ValueChanged("POReference") ||
						po.is_ValueChanged("IsDiscountPrinted"))
					return true;
			}
		} else if  (po instanceof MOrderLine || po instanceof MInvoiceLine || po instanceof MRMALine ||
				po instanceof MLBRNotaFiscalLine || po instanceof MLBRNFS) {
			// Commom changes in C_OrderLine, C_InvoiceLine and M_RMALine
			if (po.is_ValueChanged("AD_Org_ID") ||
					po.is_ValueChanged("M_Product_ID") ||
					po.is_ValueChanged ("C_Tax_ID"))
				return true;
			
			// Commom changes in C_OrderLine and C_InvoiceLine
			if  (po instanceof MOrderLine || po instanceof MInvoiceLine) {
				if (po.is_ValueChanged("QtyEntered") ||
						po.is_ValueChanged("C_UOM_ID") ||
						po.is_ValueChanged("PriceEntered") ||
						po.is_ValueChanged("PriceList") ||
						po.is_ValueChanged ("LineNetAmt"))
					return true;
			}
			
			// Changes in C_OrderLine
			if  (po instanceof MOrderLine) {
				if (po.is_ValueChanged("QtyOrdered"))
					return true;
			}
			
			// Changes in C_InvoiceLine
			if  (po instanceof MInvoiceLine) {
				if (po.is_ValueChanged("QtyInvoiced"))
					return true;
			}
			
			// Changes in M_RMALine
			if  (po instanceof MRMALine) {
				if (po.is_ValueChanged("Qty") ||
						po.is_ValueChanged ("Amt"))
					return true;
			}
			
			// Changes in LBR_NotaFiscalLine
			if  (po instanceof MLBRNotaFiscalLine) {
				if (po.is_ValueChanged("AD_Org_ID") ||
						po.is_ValueChanged("M_Product_ID") ||
						po.is_ValueChanged ("C_Tax_ID") ||
						po.is_ValueChanged("Qty") ||
						po.is_ValueChanged ("PriceActual"))
					return true;
			}
			
			// Changes in LBR_NFS
			if (po instanceof MLBRNFS) {
				if (po.is_ValueChanged("AD_Org_ID")
						|| po.is_ValueChanged("M_Product_ID")
						|| po.is_ValueChanged("C_Tax_ID")
						|| po.is_ValueChanged("Qty") 
						|| po.is_ValueChanged("Price"))
					return true;
			}
		}

		return false;
	}
	
	/**
	 * 	Verify if Tax Transaction must be updated
	 * 	@param po persistent object
	 * 	@return true if must updated
	 */
	private boolean isChangeAffectTaxTransaction(PO po)
	{
		if (po instanceof MOrder || po instanceof MInvoice || po instanceof MRMA ||
				po instanceof MLBRNotaFiscal || po instanceof MLBRNFS) {
			// Commom changes in C_Order, C_Invoice and M_RMA
			if (po.is_ValueChanged("AD_Org_ID") ||
					po.is_ValueChanged("C_BPartner_ID"))
				return true;
					
			// Commom changes in C_Order and C_Invoice
			if (po instanceof MOrder || po instanceof MInvoice) {
				if (po.is_ValueChanged("C_BPartner_Location_ID") ||
						po.is_ValueChanged("C_DocTypeTarget_ID") ||
						po.is_ValueChanged("LBR_TransactionType"))
					return true;
			}
			
			// Changes in C_Order
			if (po instanceof MOrder) {
				if (po.is_ValueChanged("Bill_BPartner_ID") ||
						po.is_ValueChanged("Bill_Location_ID") ||
						po.is_ValueChanged("DateOrdered"))
					return true;
			}
			
			// Changes in C_Invoice
			if (po instanceof MInvoice) {
				if (po.is_ValueChanged("DateInvoiced"))
					return true;
			}
			
			// Changes in M_RMA
			if (po instanceof MRMA) {
				if (po.is_ValueChanged("C_BPartner_ID") ||
						po.is_ValueChanged("C_DocType_ID"))
					return true;
			}
			
			// Changes in LBR_NotaFiscal
			if (po instanceof MLBRNotaFiscal) {
				if (po.is_ValueChanged("AD_Org_ID") ||
						po.is_ValueChanged("C_BPartner_ID") ||
						po.is_ValueChanged("C_BPartner_Location_ID") ||
						po.is_ValueChanged("DateDoc"))
					return true;
			}
			
			// Changes in LBR_NFS
			if (po instanceof MLBRNFS) {
				if (po.is_ValueChanged("AD_Org_ID")
						|| po.is_ValueChanged("C_BPartner_ID")
						|| po.is_ValueChanged("C_DocTypeTarget_ID")
						|| po.is_ValueChanged("C_BPartner_Location_ID")
						|| po.is_ValueChanged("DateDoc")
						|| po.is_ValueChanged("M_Product_ID")
						|| po.is_ValueChanged("C_Tax_ID"))
					return true;
			}
		} else if (po instanceof MOrderLine || po instanceof MInvoiceLine || po instanceof MRMALine || po instanceof MLBRNotaFiscalLine) {
			// Commom changes in C_OrderLine, C_InvoiceLine and M_RMALine
			if (po.is_ValueChanged("M_Product_ID") ||
					po.is_ValueChanged ("C_Tax_ID"))
				return true;
		}
		
		return false;
	}
	
	private int getDefaultC_Tax_ID(MInvoiceLine iLine) {
		final String sql = "SELECT t.C_Tax_ID "
				+ "FROM C_Tax t"
				+ " INNER JOIN AD_Org o ON (t.AD_Client_ID=o.AD_Client_ID) "
				+ "WHERE t.IsDefault='Y' AND t.AD_Org_ID IN (0,?) "
				+ "ORDER BY t.AD_Org_ID DESC";
		int C_Tax_ID = DB.getSQLValueEx(iLine.get_TrxName(), sql, iLine.getAD_Org_ID());
		return C_Tax_ID;
	}
}
