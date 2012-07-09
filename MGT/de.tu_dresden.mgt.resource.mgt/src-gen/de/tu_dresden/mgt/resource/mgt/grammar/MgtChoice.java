/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtChoice extends de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement {
	
	public MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.explode(getChildren(), "|");
	}
	
}
