/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtUIMetaInformation extends de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation {
	
	public de.tu_dresden.mgt.resource.mgt.IMgtHoverTextProvider getHoverTextProvider() {
		return new de.tu_dresden.mgt.resource.mgt.ui.MgtHoverTextProvider();
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtImageProvider getImageProvider() {
		return de.tu_dresden.mgt.resource.mgt.ui.MgtImageProvider.INSTANCE;
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager createColorManager() {
		return new de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(de.tu_dresden.mgt.resource.mgt.IMgtTextResource,
	 * de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager) instead.
	 */
	public de.tu_dresden.mgt.resource.mgt.ui.MgtTokenScanner createTokenScanner(de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtTokenScanner createTokenScanner(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource, de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager colorManager) {
		return new de.tu_dresden.mgt.resource.mgt.ui.MgtTokenScanner(resource, colorManager);
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtCodeCompletionHelper createCodeCompletionHelper() {
		return new de.tu_dresden.mgt.resource.mgt.ui.MgtCodeCompletionHelper();
	}
	
}
