/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.debug;

public interface IMgtDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage message);
}
