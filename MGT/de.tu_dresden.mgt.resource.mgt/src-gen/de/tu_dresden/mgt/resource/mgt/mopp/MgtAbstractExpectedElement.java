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
	private java.util.Set<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public MgtAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
