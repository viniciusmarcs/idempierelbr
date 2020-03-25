package org.idempierelbr.base.provider;

import org.adempiere.model.ITaxProvider;
import org.compiere.model.MTaxProvider;
import org.idempierelbr.base.model.MLBRNFS;
import org.idempierelbr.base.model.MLBRNotaFiscal;
import org.idempierelbr.base.model.MLBRNotaFiscalLine;

/**
 * NF Tax provider interface
 * @author Alan
 */
public interface ITaxProviderLBR extends ITaxProvider {		
	public boolean calculateNFTaxTotal(MTaxProvider provider, MLBRNotaFiscal nf);	
	public boolean updateNFTax(MTaxProvider provider, MLBRNotaFiscalLine line);
	public boolean recalculateTax(MTaxProvider provider, MLBRNotaFiscalLine line, boolean newRecord);
	public boolean updateHeaderTax(MTaxProvider provider, MLBRNotaFiscalLine line);
	
	public boolean calculateNFSTaxTotal(MTaxProvider provider, MLBRNFS nfs);	
	public boolean updateNFSTax(MTaxProvider provider, MLBRNFS nfs);
	public boolean recalculateTax(MTaxProvider provider, MLBRNFS nfs, boolean newRecord);
	public boolean updateHeaderTax(MTaxProvider provider, MLBRNFS nfs);
}