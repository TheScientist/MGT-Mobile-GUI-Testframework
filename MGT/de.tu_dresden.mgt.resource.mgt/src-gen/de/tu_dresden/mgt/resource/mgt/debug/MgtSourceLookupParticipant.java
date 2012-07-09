/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.debug;

public class MgtSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof de.tu_dresden.mgt.resource.mgt.debug.MgtStackFrame) {
			de.tu_dresden.mgt.resource.mgt.debug.MgtStackFrame frame = (de.tu_dresden.mgt.resource.mgt.debug.MgtStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
