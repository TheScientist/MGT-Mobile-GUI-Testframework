/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

public interface IMgtBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(de.tu_dresden.mgt.resource.mgt.mopp.MgtResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
