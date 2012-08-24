/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtOutlinePageLexicalSortingAction extends de.tu_dresden.mgt.resource.mgt.ui.AbstractMgtOutlinePageAction {
	
	public MgtOutlinePageLexicalSortingAction(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
