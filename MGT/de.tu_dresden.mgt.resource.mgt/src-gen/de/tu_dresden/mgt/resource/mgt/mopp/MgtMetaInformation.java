/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtMetaInformation implements de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation {
	
	public String getSyntaxName() {
		return "mgt";
	}
	
	public String getURI() {
		return "http://mgt/1.0";
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextScanner createLexer() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtAntlrScanner(new de.tu_dresden.mgt.resource.mgt.mopp.MgtLexer());
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtParser().createInstance(inputStream, encoding);
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextPrinter createPrinter(java.io.OutputStream outputStream, de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolverSwitch getReferenceResolverSwitch() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtReferenceResolverSwitch();
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory getTokenResolverFactory() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "de.tu-dresden.mgt/metamodel/mgt.cs";
	}
	
	public String[] getTokenNames() {
		return de.tu_dresden.mgt.resource.mgt.mopp.MgtParser.tokenNames;
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTokenStyle getDefaultTokenStyle(String tokenName) {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtBracketPair> getBracketPairs() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtResourceFactory();
	}
	
	public de.tu_dresden.mgt.resource.mgt.mopp.MgtNewFileContentProvider getNewFileContentProvider() {
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new de.tu_dresden.mgt.resource.mgt.mopp.MgtResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "de.tu_dresden.mgt.resource.mgt.ui.launchConfigurationType";
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtNameProvider createNameProvider() {
		return new de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		de.tu_dresden.mgt.resource.mgt.mopp.MgtAntlrTokenHelper tokenHelper = new de.tu_dresden.mgt.resource.mgt.mopp.MgtAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
