/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class MgtContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements de.tu_dresden.mgt.resource.mgt.IMgtContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public MgtContextDependentURIFragmentFactory(de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new de.tu_dresden.mgt.resource.mgt.mopp.MgtContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
