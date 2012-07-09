/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtCompound extends de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement {
	
	public MgtCompound(de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice choice, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality) {
		super(cardinality, new de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
