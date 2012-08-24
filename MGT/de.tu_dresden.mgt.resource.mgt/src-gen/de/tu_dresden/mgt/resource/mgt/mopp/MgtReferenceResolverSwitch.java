/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtReferenceResolverSwitch implements de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected de.tu_dresden.mgt.resource.mgt.analysis.SequentialStepSequenceReferenceResolver sequentialStepSequenceReferenceResolver = new de.tu_dresden.mgt.resource.mgt.analysis.SequentialStepSequenceReferenceResolver();
	
	public de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<de.tu_dresden.mgt.SequentialStep, de.tu_dresden.mgt.Sequence> getSequentialStepSequenceReferenceResolver() {
		return getResolverChain(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep_Sequence(), sequentialStepSequenceReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
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
			return getResolverChain(reference, sequentialStepSequenceReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(de.tu_dresden.mgt.resource.mgt.IMgtOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new de.tu_dresden.mgt.resource.mgt.util.MgtRuntimeUtil().logWarning("Found value with invalid type for option " + de.tu_dresden.mgt.resource.mgt.IMgtOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver) {
			de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver replacingResolver = (de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver) resolverValue;
			if (replacingResolver instanceof de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof de.tu_dresden.mgt.resource.mgt.IMgtReferenceCache) {
					de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver nextResolver = (de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver) next;
					if (nextResolver instanceof de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new de.tu_dresden.mgt.resource.mgt.util.MgtRuntimeUtil().logWarning("Found value with invalid type in value map for option " + de.tu_dresden.mgt.resource.mgt.IMgtOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new de.tu_dresden.mgt.resource.mgt.util.MgtRuntimeUtil().logWarning("Found value with invalid type in value map for option " + de.tu_dresden.mgt.resource.mgt.IMgtOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + de.tu_dresden.mgt.resource.mgt.IMgtDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
