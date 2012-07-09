/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class MgtKeyword extends de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement {
	
	private final String value;
	
	public MgtKeyword(String value, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
