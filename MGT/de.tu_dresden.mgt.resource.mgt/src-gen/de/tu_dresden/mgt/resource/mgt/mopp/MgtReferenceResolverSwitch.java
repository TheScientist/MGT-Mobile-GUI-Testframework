/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtReferenceResolverSwitch implements de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolverSwitch {
	
	protected de.tu_dresden.mgt.resource.mgt.analysis.SequentialStepSequenceReferenceResolver sequentialStepSequenceReferenceResolver = new de.tu_dresden.mgt.resource.mgt.analysis.SequentialStepSequenceReferenceResolver();
	
	public de.tu_dresden.mgt.resource.mgt.analysis.SequentialStepSequenceReferenceResolver getSequentialStepSequenceReferenceResolver() {
		return sequentialStepSequenceReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		sequentialStepSequenceReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep().isInstance(container)) {
			MgtFuzzyResolveResult<de.tu_dresden.mgt.Sequence> frr = new MgtFuzzyResolveResult<de.tu_dresden.mgt.Sequence>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sequence")) {
				sequentialStepSequenceReferenceResolver.resolve(identifier, (de.tu_dresden.mgt.SequentialStep) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep_Sequence()) {
			return sequentialStepSequenceReferenceResolver;
		}
		return null;
	}
	
}
