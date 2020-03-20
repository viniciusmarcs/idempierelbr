package org.idempierelbr.cnab240.sicoob.process;

import org.idempierelbr.openitems.process.IBankCollection;
import org.idempierelbr.openitems.process.IBankCollectionFactory;

public class BankCollectionFactory implements IBankCollectionFactory {

	@Override
	public IBankCollection newBankCollectionInstance(String routingNo) {
		if (routingNo.equals("756"))
			return new SicoobBankCollection();
		
		return null;
	}

}
