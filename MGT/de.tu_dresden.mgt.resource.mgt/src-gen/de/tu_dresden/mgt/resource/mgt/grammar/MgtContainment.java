/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtContainment extends de.tu_dresden.mgt.resource.mgt.grammar.MgtTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public MgtContainment(org.eclipse.emf.ecore.EStructuralFeature feature, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.explode(allowedTypes, ", ", new de.tu_dresden.mgt.resource.mgt.IMgtFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
