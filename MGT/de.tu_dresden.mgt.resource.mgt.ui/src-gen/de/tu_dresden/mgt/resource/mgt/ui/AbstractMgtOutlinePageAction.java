/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public abstract class AbstractMgtOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer;
	
	public AbstractMgtOutlinePageAction(de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = de.tu_dresden.mgt.resource.mgt.ui.MgtImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (de.tu_dresden.mgt.resource.mgt.ui.MgtOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
