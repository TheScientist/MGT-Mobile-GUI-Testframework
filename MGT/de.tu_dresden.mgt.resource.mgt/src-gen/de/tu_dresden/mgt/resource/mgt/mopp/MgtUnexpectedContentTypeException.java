/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see de.tu_dresden.mgt.resource.mgt.IMgtOptions.RESOURCE_CONTENT_TYPE
 */
public class MgtUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  MgtUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
