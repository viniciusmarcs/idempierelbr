package org.idempierelbr.base.process;

import java.util.logging.Level;

import org.compiere.model.MOrder;
import org.compiere.model.MOrderLine;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.Msg;
import org.idempierelbr.base.model.MLBRDocLineCOFINS;
import org.idempierelbr.base.model.MLBRDocLineDetails;
import org.idempierelbr.base.model.MLBRDocLineICMS;
import org.idempierelbr.base.model.MLBRDocLineIPI;
import org.idempierelbr.base.model.MLBRDocLineISSQN;
import org.idempierelbr.base.model.MLBRDocLineImportTax;
import org.idempierelbr.base.model.MLBRDocLinePIS;
import org.idempierelbr.base.model.MLBRNotaFiscal;
import org.idempierelbr.base.model.MLBRNotaFiscalLine;

public class NotaFiscalCreatePO extends SvrProcess
{
	private int 	p_LBR_NotaFiscal_ID = 0;
	private int 	p_C_DocType_ID = 0;
	private int 	p_M_Warehouse_ID = 0;
	private int		p_M_PriceList_ID = 0;
	private int		p_SalesRep_ID = 0;
	private int		p_C_PaymentTerm_ID = 0;
	private String	p_docAction = DocAction.ACTION_None;
	
	private MLBRNotaFiscal nf;
	
	@Override
	protected void prepare() 
	{
		ProcessInfoParameter[] para = getParameter();
		
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			
			if (para[i].getParameter() == null)
				;
			else if (name.equals("LBR_NotaFiscal_ID")) {
				p_LBR_NotaFiscal_ID = para[i].getParameterAsInt();
			} else if (name.equals("C_DocType_ID")) {
				p_C_DocType_ID = para[i].getParameterAsInt();
			} else if (name.equals("M_Warehouse_ID")) {
				p_M_Warehouse_ID = para[i].getParameterAsInt();
			} else if (name.equals("M_PriceList_ID")) {
				p_M_PriceList_ID = para[i].getParameterAsInt();
			} else if (name.equals("SalesRep_ID")) {
				p_SalesRep_ID = para[i].getParameterAsInt();
			} else if (name.equals("C_PaymentTerm_ID")) {
				p_C_PaymentTerm_ID = para[i].getParameterAsInt();
			} else if (name.equals("DocAction")) {
				p_docAction = (String)para[i].getParameter();
			} else {
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
			}
		}
	}
	
	@Override
	protected String doIt() throws Exception {
		// If this process is called from window (not from menu), set source document
		if (getTable_ID() == MLBRNotaFiscal.Table_ID)
			p_LBR_NotaFiscal_ID = getRecord_ID();
		
		// NF
		if (p_LBR_NotaFiscal_ID > 0) {
			nf = new MLBRNotaFiscal(getCtx(), p_LBR_NotaFiscal_ID, get_TrxName());
		}
		
		// Check Doc Status (allows only CO or CL)
		if (!nf.get_ValueAsString("DocStatus").equals(DocAction.STATUS_Completed) &&
				!nf.get_ValueAsString("DocStatus").equals(DocAction.STATUS_Closed))
			throw new Exception("The document should be completed or closed");
		
		// Order
		MOrder order = createOrder();
		
		// Link Order to Nota Fiscal
		nf.setC_Order_ID(order.get_ID());
		nf.saveEx();
		
		// Create lines
		createOrderLines(order);
		
		// Process it
		if (!DocAction.ACTION_None.equals(p_docAction))	{
			order.setDocAction(p_docAction);
			
			if (!order.processIt(p_docAction)) {
				log.warning("Failed: " + order);
				throw new IllegalStateException("PO Generate Process Failed: " +
						order + " - " + order.getProcessMsg());
			} 
			
			order.saveEx();
		}
		
		String message = Msg.parseTranslation(getCtx(), "@GeneratedPO@ " + order.getDocumentNo());
		addBufferLog(0, null, order.getGrandTotal(), message, order.get_Table_ID(), order.getC_Order_ID());
		
		return "Ok";
	}

	private void createOrderLines(MOrder order) {
		MLBRNotaFiscalLine[] nfLines = nf.getLines();
		
		for (MLBRNotaFiscalLine nfLine : nfLines) {
			MOrderLine orderLine = new MOrderLine(order);
			
			orderLine.setLine(nfLine.getLine());
			
			if (nfLine.getM_Product() != null) {
				orderLine.setM_Product_ID(nfLine.getM_Product_ID());
			} else {
				orderLine.setC_Charge_ID(nfLine.getC_Charge_ID());
			}
			
			orderLine.setQty(nfLine.getQty());
			orderLine.setC_UOM_ID(nfLine.getC_UOM_ID());
			orderLine.setC_Tax_ID(nfLine.getC_Tax_ID());
			orderLine.setPriceActual(nfLine.getPriceActual());
			
			orderLine.saveEx();
			
			// Generate details and taxes
			MLBRDocLineDetails nflDetails = MLBRDocLineDetails.getOfPO(nfLine);
			
			if (nflDetails != null) {
				MLBRDocLineDetails olDetails = MLBRDocLineDetails.createFromPO(orderLine);
			
				if (olDetails != null) {
					// Delete
					MLBRDocLineCOFINS[] cofins = MLBRDocLineCOFINS.getOfDetails(olDetails);
					for (MLBRDocLineCOFINS cofinsEntry : cofins) {
						cofinsEntry.deleteEx(true);
					}
					
					MLBRDocLineICMS[] icms = MLBRDocLineICMS.getOfDetails(olDetails);
					for (MLBRDocLineICMS icmsEntry : icms) {
						icmsEntry.deleteEx(true);
					}
					
					MLBRDocLineImportTax[] ii = MLBRDocLineImportTax.getOfDetails(olDetails);
					for (MLBRDocLineImportTax iiEntry : ii) {
						iiEntry.deleteEx(true);
					}
					
					MLBRDocLineIPI[] ipi = MLBRDocLineIPI.getOfDetails(olDetails);
					for (MLBRDocLineIPI ipiEntry : ipi) {
						ipiEntry.deleteEx(true);
					}
					
					MLBRDocLineISSQN[] issqn = MLBRDocLineISSQN.getOfDetails(olDetails);
					for (MLBRDocLineISSQN issqnEntry : issqn) {
						issqnEntry.deleteEx(true);
					}
					
					MLBRDocLinePIS[] pis = MLBRDocLinePIS.getOfDetails(olDetails);
					for (MLBRDocLinePIS pisEntry : pis) {
						pisEntry.deleteEx(true);
					}
					
					olDetails.copyFrom(nflDetails);
					olDetails.saveEx();
					olDetails.copyChildren(MLBRDocLineDetails.getOfPO(nfLine));
				}
			}
		}
	}

	private MOrder createOrder() {
		MOrder order = new MOrder(getCtx(), 0, get_TrxName());
		order.setAD_Org_ID(nf.getAD_Org_ID());
		order.setC_DocTypeTarget_ID(p_C_DocType_ID);
		order.setC_BPartner_ID(nf.getC_BPartner_ID());
		order.setC_BPartner_Location_ID(nf.getC_BPartner_Location_ID());
		order.set_ValueOfColumn("LBR_TransactionType", nf.getLBR_TransactionType());
		order.setM_Warehouse_ID(p_M_Warehouse_ID);
		order.setM_PriceList_ID(p_M_PriceList_ID);
		order.setSalesRep_ID(p_SalesRep_ID);
		order.setPaymentRule("P");
		order.setC_PaymentTerm_ID(p_C_PaymentTerm_ID);
		order.setIsSOTrx(false);
		order.saveEx();
		
		return order;
	}

}
