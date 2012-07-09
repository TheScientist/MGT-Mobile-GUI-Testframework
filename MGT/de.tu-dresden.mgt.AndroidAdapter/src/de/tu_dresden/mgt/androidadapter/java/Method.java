package de.tu_dresden.mgt.androidadapter.java;

import java.util.LinkedList;

public class Method {
	private LinkedList<Statement> statements;
	private String name;
	//Argumente?
	
	public Method(String name) {
		this.name = name;
		statements = new LinkedList<Statement>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Statement> getStatements() {
		return statements;
	}

	public void addStatement(Statement statement) {
		statements.add(statement);
	}
}
