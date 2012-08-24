/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtOutlinePageTypeSortingAction extends de.tu_dresden.mgt.resource.mgt.ui.AbstractMgtOutlinePageAction {
	
	public MgtOutlinePageTypeSortingAction(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
