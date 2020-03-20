package org.idempierelbr.cnab240.bradesco.process;

import org.idempierelbr.openitems.process.IBankCollection;
import org.idempierelbr.openitems.process.IBankCollectionFactory;

public class BankCollectionFactory implements IBankCollectionFactory {

	@Override
	public IBankCollection newBankCollectionInstance(String routingNo) {
		if (routingNo.equals("237"))
			return new BradescoBankCollection();
		
		return null;
	}

}
