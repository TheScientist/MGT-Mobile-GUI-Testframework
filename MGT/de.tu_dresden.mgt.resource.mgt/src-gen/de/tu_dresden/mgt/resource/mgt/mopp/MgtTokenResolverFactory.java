/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * The MgtTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class MgtTokenResolverFactory implements de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory {
	
	private java.util.Map<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver> featureName2CollectInTokenResolver;
	private static de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver defaultResolver = new de.tu_dresden.mgt.resource.mgt.analysis.MgtDefaultTokenResolver();
	
	public MgtTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver>();
		registerTokenResolver("IDENTIFIER", new de.tu_dresden.mgt.resource.mgt.analysis.MgtIDENTIFIERTokenResolver());
		registerTokenResolver("BIGNAME", new de.tu_dresden.mgt.resource.mgt.analysis.MgtBIGNAMETokenResolver());
		registerTokenResolver("INTEGER", new de.tu_dresden.mgt.resource.mgt.analysis.MgtINTEGERTokenResolver());
		registerTokenResolver("FLOAT", new de.tu_dresden.mgt.resource.mgt.analysis.MgtFLOATTokenResolver());
		registerTokenResolver("QUOTED_34_34", new de.tu_dresden.mgt.resource.mgt.analysis.MgtQUOTED_34_34TokenResolver());
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver internalCreateResolver(java.util.Map<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver> resolverMap, String key, de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
