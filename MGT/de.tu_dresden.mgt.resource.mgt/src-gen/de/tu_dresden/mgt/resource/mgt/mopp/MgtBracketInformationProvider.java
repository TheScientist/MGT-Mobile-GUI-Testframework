/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtBracketInformationProvider {
	
	public class BracketPair implements de.tu_dresden.mgt.resource.mgt.IMgtBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtBracketPair> getBracketPairs() {
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtBracketPair> result = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.IMgtBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
