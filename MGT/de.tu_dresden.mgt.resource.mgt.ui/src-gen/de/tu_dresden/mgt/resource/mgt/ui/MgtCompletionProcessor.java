/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

public class MgtCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private de.tu_dresden.mgt.resource.mgt.IMgtResourceProvider resourceProvider;
	private de.tu_dresden.mgt.resource.mgt.ui.IMgtBracketHandlerProvider bracketHandlerProvider;
	
	public MgtCompletionProcessor(de.tu_dresden.mgt.resource.mgt.IMgtResourceProvider resourceProvider, de.tu_dresden.mgt.resource.mgt.ui.IMgtBracketHandlerProvider bracketHandlerProvider) {
		this.resourceProvider = resourceProvider;
		this.bracketHandlerProvider = bracketHandlerProvider;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		de.tu_dresden.mgt.resource.mgt.IMgtTextResource textResource = resourceProvider.getResource();
		String content = viewer.getDocument().get();
		de.tu_dresden.mgt.resource.mgt.ui.MgtCodeCompletionHelper helper = new de.tu_dresden.mgt.resource.mgt.ui.MgtCodeCompletionHelper();
		de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		de.tu_dresden.mgt.resource.mgt.ui.MgtProposalPostProcessor proposalPostProcessor = new de.tu_dresden.mgt.resource.mgt.ui.MgtProposalPostProcessor();
		java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> finalProposalList = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>();
		for (de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			de.tu_dresden.mgt.resource.mgt.ui.IMgtBracketHandler bracketHandler = bracketHandlerProvider.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
