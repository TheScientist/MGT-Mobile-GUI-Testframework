/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
