/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class MgtTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private de.tu_dresden.mgt.resource.mgt.IMgtTextScanner lexer;
	private de.tu_dresden.mgt.resource.mgt.IMgtTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager colorManager;
	private de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public MgtTokenScanner(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource, de.tu_dresden.mgt.resource.mgt.ui.MgtColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation().createLexer();
		this.languageId = new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation().getSyntaxName();
		this.store = de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		de.tu_dresden.mgt.resource.mgt.mopp.MgtDynamicTokenStyler dynamicTokenStyler = new de.tu_dresden.mgt.resource.mgt.mopp.MgtDynamicTokenStyler();
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.ENABLE);
			boolean enabled = store.getBoolean(enableKey);
			de.tu_dresden.mgt.resource.mgt.IMgtTokenStyle staticStyle = null;
			if (enabled) {
				String colorKey = de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
				org.eclipse.swt.graphics.RGB backgroundRGB = null;
				boolean bold = store.getBoolean(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.BOLD));
				boolean italic = store.getBoolean(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.ITALIC));
				boolean strikethrough = store.getBoolean(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
				boolean underline = store.getBoolean(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.UNDERLINE));
				// now call dynamic token styler to allow to apply modifications to the static
				// style
				staticStyle = new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
			}
			de.tu_dresden.mgt.resource.mgt.IMgtTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
			if (dynamicStyle != null) {
				int[] foregroundColorArray = dynamicStyle.getColorAsRGB();
				org.eclipse.swt.graphics.Color foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
				int[] backgroundColorArray = dynamicStyle.getBackgroundColorAsRGB();
				org.eclipse.swt.graphics.Color backgroundColor = null;
				if (backgroundColorArray != null) {
					org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
					backgroundColor = colorManager.getColor(backgroundRGB);
				}
				int style = org.eclipse.swt.SWT.NORMAL;
				if (dynamicStyle.isBold()) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (dynamicStyle.isItalic()) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (dynamicStyle.isStrikethrough()) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (dynamicStyle.isUnderline()) {
					style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
				}
				ta = new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
			}
		}
		return new org.eclipse.jface.text.rules.Token(ta);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
}
