/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class MgtExpectedStructuralFeature extends de.tu_dresden.mgt.resource.mgt.mopp.MgtAbstractExpectedElement {
	
	private de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder placeholder;
	
	public MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MgtExpectedStructuralFeature) {
			return getFeature().equals(((MgtExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
