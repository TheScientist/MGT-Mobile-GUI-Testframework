/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IMgtResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public de.tu_dresden.mgt.resource.mgt.IMgtTextResource getResource();
	
}
