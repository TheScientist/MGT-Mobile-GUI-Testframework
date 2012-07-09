/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A FuzzyResolveResult is an implementation of the IMgtReferenceResolveResult
 * interface that delegates all method calls to a given IMgtReferenceResolveResult
 * with ReferenceType EObject. It is used by reference resolver switches to
 * collect results from different reference resolvers in a type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class MgtFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<ReferenceType> {
	
	private de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public MgtFuzzyResolveResult(de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(de.tu_dresden.mgt.resource.mgt.IMgtQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
