package org.idempierelbr.cnab240.sicoob.annotated;

import org.idempierelbr.cnab240.annotated.CNABSegmentTRecord;

import com.ancientprogramming.fixedformat4j.annotation.Align;
import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record
public class SicoobCNABSegmentT extends CNABSegmentTRecord {

	@Override
	@Field( offset=58 , length=1, paddingChar='0' , align = Align.RIGHT)
	public String getCodigoCarteira() {
		// TODO Auto-generated method stub
		String codigoCarteira = super.getCodigoCarteira();
		if (codigoCarteira.equals("7")) {
			return "1";
		}
		return codigoCarteira;
	}

}
