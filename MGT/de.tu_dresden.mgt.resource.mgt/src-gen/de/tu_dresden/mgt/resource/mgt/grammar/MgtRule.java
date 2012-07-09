/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class MgtRule extends de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public MgtRule(org.eclipse.emf.ecore.EClass metaclass, de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice choice, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality) {
		super(cardinality, new de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice getDefinition() {
		return (de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice) getChildren()[0];
	}
	
}

