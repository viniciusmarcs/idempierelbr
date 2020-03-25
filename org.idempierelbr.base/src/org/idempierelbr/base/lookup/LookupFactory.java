package org.idempierelbr.base.lookup;

import org.adempiere.base.ILookupFactory;
import org.compiere.model.GridFieldVO;
import org.compiere.model.Lookup;
import org.compiere.util.DisplayType;
import org.idempierelbr.base.model.MLBRTaxesLookup;
import org.idempierelbr.base.type.DisplayTypeFactory;

public class LookupFactory implements ILookupFactory {

	@Override
	public Lookup getLookup(GridFieldVO gridFieldVO) {
		Lookup lookup = null;
		
		if (gridFieldVO.lookupInfo == null && DisplayType.isLookup(gridFieldVO.displayType)) // IDEMPIERE-913
			gridFieldVO.loadLookupInfo();
		
		if (gridFieldVO.displayType == DisplayTypeFactory.BRAZILIAN_TAXES)   //  not cached
		{
			lookup = new MLBRTaxesLookup (gridFieldVO.ctx, gridFieldVO.WindowNo);
		}
		
		return lookup;
	}

	@Override
	public boolean isLookup(GridFieldVO gridFieldVO) {
		if (gridFieldVO.displayType == DisplayTypeFactory.BRAZILIAN_TAXES)
				return true;
		
		return false;
	}

}
