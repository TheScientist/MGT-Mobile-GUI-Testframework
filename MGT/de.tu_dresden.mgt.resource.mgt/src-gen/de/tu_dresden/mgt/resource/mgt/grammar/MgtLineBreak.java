/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtLineBreak extends de.tu_dresden.mgt.resource.mgt.grammar.MgtFormattingElement {
	
	private final int tabs;
	
	public MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
