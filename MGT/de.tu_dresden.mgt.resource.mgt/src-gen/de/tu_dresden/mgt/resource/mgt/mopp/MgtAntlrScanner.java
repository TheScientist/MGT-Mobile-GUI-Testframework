/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtAntlrScanner implements de.tu_dresden.mgt.resource.mgt.IMgtTextScanner {
	
	private org.antlr.runtime3_3_0.Lexer antlrLexer;
	
	public MgtAntlrScanner(org.antlr.runtime3_3_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_3_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		de.tu_dresden.mgt.resource.mgt.IMgtTextToken result = new de.tu_dresden.mgt.resource.mgt.mopp.MgtTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_3_0.ANTLRStringStream(text));
	}
	
}
