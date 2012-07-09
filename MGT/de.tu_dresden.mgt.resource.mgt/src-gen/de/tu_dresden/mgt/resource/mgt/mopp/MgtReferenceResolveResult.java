/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * A basic implementation of the
 * de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class MgtReferenceResolveResult<ReferenceType> implements de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> quickFixes;
	
	public MgtReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(de.tu_dresden.mgt.resource.mgt.IMgtQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new de.tu_dresden.mgt.resource.mgt.mopp.MgtElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new de.tu_dresden.mgt.resource.mgt.mopp.MgtURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
