/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtOutlinePageExpandAllAction extends de.tu_dresden.mgt.resource.mgt.ui.AbstractMgtOutlinePageAction {
	
	public MgtOutlinePageExpandAllAction(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
