/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class MgtProposalPostProcessor {
	
	public java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> process(java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
