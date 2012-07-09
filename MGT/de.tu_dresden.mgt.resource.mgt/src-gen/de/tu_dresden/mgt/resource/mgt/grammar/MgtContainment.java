/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtContainment extends de.tu_dresden.mgt.resource.mgt.grammar.MgtTerminal {
	
	public MgtContainment(org.eclipse.emf.ecore.EStructuralFeature feature, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
