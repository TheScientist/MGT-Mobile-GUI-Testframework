/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.util;

/**
 * Class MgtTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.
 */
public class MgtTextResourceUtil {
	
	/**
	 * Use de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static de.tu_dresden.mgt.resource.mgt.mopp.MgtResource getResource(org.eclipse.core.resources.IFile file) {
		return new de.tu_dresden.mgt.resource.mgt.util.MgtEclipseProxy().getResource(file);
	}
	
	/**
	 * Use de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static de.tu_dresden.mgt.resource.mgt.mopp.MgtResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static de.tu_dresden.mgt.resource.mgt.mopp.MgtResource getResource(org.eclipse.emf.common.util.URI uri) {
		return de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource(uri);
	}
	
	/**
	 * Use de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource() instead.
	 */
	@Deprecated	
	public static de.tu_dresden.mgt.resource.mgt.mopp.MgtResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return de.tu_dresden.mgt.resource.mgt.util.MgtResourceUtil.getResource(uri, options);
	}
	
}
