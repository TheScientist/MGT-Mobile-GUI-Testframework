/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IMgtExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement follower, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>> getFollowers();
	
}
