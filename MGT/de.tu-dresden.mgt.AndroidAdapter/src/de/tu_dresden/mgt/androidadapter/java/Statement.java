package de.tu_dresden.mgt.androidadapter.java;

import de.tu_dresden.mgt.AbstractTestStep;

public class Statement {

	private String stmt;
	private AbstractTestStep matchingStep;
	
	public Statement(String stmt, AbstractTestStep step) {
		this.stmt = stmt;
		this.matchingStep = step;
	}

	public String getStmt() {
		return stmt;
	}

	public void setStmt(String stmt) {
		this.stmt = stmt;
	}

	public AbstractTestStep getMatchingStep() {
		return matchingStep;
	}

	public void setMatchingStep(AbstractTestStep matchingStep) {
		this.matchingStep = matchingStep;
	}
}
