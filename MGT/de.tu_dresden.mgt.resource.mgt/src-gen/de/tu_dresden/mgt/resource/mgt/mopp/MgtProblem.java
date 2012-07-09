/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtProblem implements de.tu_dresden.mgt.resource.mgt.IMgtProblem {
	
	private String message;
	private de.tu_dresden.mgt.resource.mgt.MgtEProblemType type;
	private de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity severity;
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> quickFixes;
	
	public MgtProblem(String message, de.tu_dresden.mgt.resource.mgt.MgtEProblemType type, de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix>emptySet());
	}
	
	public MgtProblem(String message, de.tu_dresden.mgt.resource.mgt.MgtEProblemType type, de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity severity, de.tu_dresden.mgt.resource.mgt.IMgtQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public MgtProblem(String message, de.tu_dresden.mgt.resource.mgt.MgtEProblemType type, de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity severity, java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public de.tu_dresden.mgt.resource.mgt.MgtEProblemType getType() {
		return type;
	}
	
	public de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
