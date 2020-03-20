package org.idempierelbr.cnab240.bb.process;

import org.idempierelbr.openitems.process.IBankCollection;
import org.idempierelbr.openitems.process.IBankCollectionFactory;

public class BankCollectionFactory implements IBankCollectionFactory {

	@Override
	public IBankCollection newBankCollectionInstance(String routingNo) {
		if (routingNo.equals("001"))
			return new BancoDoBrasilBankCollection();
		
		return null;
	}

}
