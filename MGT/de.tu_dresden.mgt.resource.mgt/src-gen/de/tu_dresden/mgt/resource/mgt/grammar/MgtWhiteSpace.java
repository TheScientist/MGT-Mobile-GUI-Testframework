/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtWhiteSpace extends de.tu_dresden.mgt.resource.mgt.grammar.MgtFormattingElement {
	
	private final int amount;
	
	public MgtWhiteSpace(int amount, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
