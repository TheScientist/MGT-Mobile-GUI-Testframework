/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public MgtResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtResource(uri);
	}
	
}
