/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class MgtPlaceholder extends de.tu_dresden.mgt.resource.mgt.grammar.MgtTerminal {
	
	private final String tokenName;
	
	public MgtPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
