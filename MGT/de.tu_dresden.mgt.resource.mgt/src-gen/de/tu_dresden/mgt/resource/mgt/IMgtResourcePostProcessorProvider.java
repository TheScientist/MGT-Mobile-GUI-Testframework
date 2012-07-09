/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IMgtResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public de.tu_dresden.mgt.resource.mgt.IMgtResourcePostProcessor getResourcePostProcessor();
	
}
