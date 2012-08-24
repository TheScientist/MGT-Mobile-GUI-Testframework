/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

/**
 * A class used to initialize default preference values.
 */
public class MgtPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = de.tu_dresden.mgt.resource.mgt.ui.MgtUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		de.tu_dresden.mgt.resource.mgt.ui.MgtBracketSet bracketSet = new de.tu_dresden.mgt.resource.mgt.ui.MgtBracketSet(null, null);
		final java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (de.tu_dresden.mgt.resource.mgt.IMgtBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + de.tu_dresden.mgt.resource.mgt.ui.MgtPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			de.tu_dresden.mgt.resource.mgt.IMgtTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, de.tu_dresden.mgt.resource.mgt.ui.MgtSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
