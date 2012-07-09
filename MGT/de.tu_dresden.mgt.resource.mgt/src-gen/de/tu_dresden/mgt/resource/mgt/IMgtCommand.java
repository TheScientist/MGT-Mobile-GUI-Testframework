/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IMgtCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
