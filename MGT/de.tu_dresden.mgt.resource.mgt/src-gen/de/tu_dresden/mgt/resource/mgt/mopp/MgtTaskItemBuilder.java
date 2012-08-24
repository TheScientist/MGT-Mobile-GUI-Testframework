/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * The MgtTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class MgtTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new de.tu_dresden.mgt.resource.mgt.mopp.MgtMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtTaskItem> taskItems = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.mopp.MgtTaskItem>();
		de.tu_dresden.mgt.resource.mgt.mopp.MgtTaskItemDetector taskItemDetector = new de.tu_dresden.mgt.resource.mgt.mopp.MgtTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = de.tu_dresden.mgt.resource.mgt.util.MgtStreamUtil.getContent(inputStream);
			de.tu_dresden.mgt.resource.mgt.IMgtTextScanner lexer = new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation().createLexer();
			lexer.setText(content);
			
			de.tu_dresden.mgt.resource.mgt.IMgtTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtPlugin.logError("Exception while searching for task items", e);
		}
		
		for (de.tu_dresden.mgt.resource.mgt.mopp.MgtTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new de.tu_dresden.mgt.resource.mgt.mopp.MgtMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
