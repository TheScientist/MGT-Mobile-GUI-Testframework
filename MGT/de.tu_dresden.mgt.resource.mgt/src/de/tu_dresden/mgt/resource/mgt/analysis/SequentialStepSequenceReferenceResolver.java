/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.analysis;

public class SequentialStepSequenceReferenceResolver implements de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<de.tu_dresden.mgt.SequentialStep, de.tu_dresden.mgt.Sequence> {
	
	private de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultResolverDelegate<de.tu_dresden.mgt.SequentialStep, de.tu_dresden.mgt.Sequence> delegate = new de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultResolverDelegate<de.tu_dresden.mgt.SequentialStep, de.tu_dresden.mgt.Sequence>();
	
	public void resolve(String identifier, de.tu_dresden.mgt.SequentialStep container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<de.tu_dresden.mgt.Sequence> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(de.tu_dresden.mgt.Sequence element, de.tu_dresden.mgt.SequentialStep container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
