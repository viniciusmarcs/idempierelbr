package org.idempierelbr.base.editor;

import org.adempiere.webui.editor.WEditor;
import org.adempiere.webui.factory.IEditorFactory;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.util.DisplayType;
import org.idempierelbr.base.type.DisplayTypeFactory;
import org.idempierelbr.base.webui.editor.WLocationEditorLBR;
import org.idempierelbr.base.webui.editor.WTaxesEditor;

public class EditorFactory implements IEditorFactory {

	@Override
	public WEditor getEditor(GridTab gridTab, GridField gridField,
			boolean tableEditor) {
		if (gridField == null) {
            return null;
        }

        WEditor editor = null;
        int displayType = gridField.getDisplayType();

        /** Not a Field */
        if (gridField.isHeading()) {
            return null;
        }
        
		if (displayType == DisplayType.Location) {
            editor = new WLocationEditorLBR(gridField);
        }
		else if (displayType == DisplayTypeFactory.BRAZILIAN_TAXES) {
            editor = new WTaxesEditor(gridTab, gridField);
        }

        return editor;
	}

}
