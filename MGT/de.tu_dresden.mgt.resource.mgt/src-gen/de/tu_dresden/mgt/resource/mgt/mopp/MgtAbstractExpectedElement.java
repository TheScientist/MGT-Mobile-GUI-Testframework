/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class MgtAbstractExpectedElement implements de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>> followers = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>>();
	
	public MgtAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement follower, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] path) {
		followers.add(new de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
