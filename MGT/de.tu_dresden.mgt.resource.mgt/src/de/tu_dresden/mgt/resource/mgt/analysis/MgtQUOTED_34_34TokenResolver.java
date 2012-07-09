/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.analysis;

public class MgtQUOTED_34_34TokenResolver implements de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver {
	
	private de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultTokenResolver defaultTokenResolver = new de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
