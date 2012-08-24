/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtOutlinePageLinkWithEditorAction extends de.tu_dresden.mgt.resource.mgt.ui.AbstractMgtOutlinePageAction {
	
	public MgtOutlinePageLinkWithEditorAction(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
