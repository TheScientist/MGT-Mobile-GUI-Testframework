/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class MgtExpectedCsString extends de.tu_dresden.mgt.resource.mgt.mopp.MgtAbstractExpectedElement {
	
	private de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword keyword;
	
	public MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof MgtExpectedCsString) {
			return getValue().equals(((MgtExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
