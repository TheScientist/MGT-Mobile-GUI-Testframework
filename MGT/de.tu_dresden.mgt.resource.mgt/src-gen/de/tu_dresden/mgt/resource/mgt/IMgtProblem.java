/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt;

public interface IMgtProblem {
	public String getMessage();
	public de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity getSeverity();
	public de.tu_dresden.mgt.resource.mgt.MgtEProblemType getType();
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> getQuickFixes();
}
