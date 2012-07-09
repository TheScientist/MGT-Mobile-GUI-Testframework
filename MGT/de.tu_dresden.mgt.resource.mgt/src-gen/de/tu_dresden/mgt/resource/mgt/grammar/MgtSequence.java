/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtSequence extends de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement {
	
	public MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.explode(getChildren(), " ");
	}
	
}
