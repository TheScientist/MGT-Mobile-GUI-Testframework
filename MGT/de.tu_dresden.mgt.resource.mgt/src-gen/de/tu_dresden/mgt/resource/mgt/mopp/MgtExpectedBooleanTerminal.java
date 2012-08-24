/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class MgtExpectedBooleanTerminal extends de.tu_dresden.mgt.resource.mgt.mopp.MgtAbstractExpectedElement {
	
	private de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal booleanTerminal;
	
	public MgtExpectedBooleanTerminal(de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MgtExpectedBooleanTerminal) {
			return getFeature().equals(((MgtExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
