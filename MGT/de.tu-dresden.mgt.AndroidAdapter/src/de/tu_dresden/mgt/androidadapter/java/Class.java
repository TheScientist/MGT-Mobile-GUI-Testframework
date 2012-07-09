package de.tu_dresden.mgt.androidadapter.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.tu_dresden.mgt.AbstractTestStep;

public class Class {
	private List<Method> methods;
	private List<Attribute> attributes;
	private String name;
	private String targetActvity;
	
	private HashMap<Integer, AbstractTestStep> mapping;
	
	public Class(String name) {
		this.name = name;
		methods = new LinkedList<Method>();
		attributes = new LinkedList<Attribute>();
		mapping = new HashMap<Integer, AbstractTestStep>();
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void addMethod(Method method) {
		this.methods.add(method);
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(Attribute attribute) {
		this.attributes.add(attribute);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTargetActivity() {
		return targetActvity;
	}
	
	public String getTargetActivityPure() {
		String pure = targetActvity.substring(targetActvity.lastIndexOf(".")+1); 
		return pure;
	}
	
	public String getTargetPackage() {
		return targetActvity.substring(0, targetActvity.lastIndexOf("."));
	}

	public void setTargetActivity(String implementStatement) {
		this.targetActvity = implementStatement;
	}

	public String printJUnitFile(String path) throws IOException {
		File folder = new File(path);
		folder.mkdirs();
		File file = new File(folder, name + ".java");
		if(file.exists()) file.delete();
		FileWriter outFile = new FileWriter(path + name + ".java");
		PrintWriter out = new PrintWriter(outFile);
		
		out.println(printHead());
		mapping.put(9, null);
		out.println("public class " + name +" extends ActivityInstrumentationTestCase2<"
				+ getTargetActivityPure() +"> {");
		mapping.put(10, null);
//		for(Attribute att : attributes) {
//			out.println("\t private " + att.getKey() + " = " + att.getValue() + ";\n");
//		}
		out.println(printExtras());
		mapping.put(25, null);
		int i = 26;
		for(Method meth : methods) {
			if(meth.getName().startsWith("test")) {
				out.println("\t@Smoke");
				i++;
			}
			out.println("\tpublic void " + meth.getName() + "() {");
			i++;
			for(Statement stat : meth.getStatements()) {
				out.println("\t\t" + stat.getStmt() + ";");
				mapping.put(i++, stat.getMatchingStep());
			}
			out.println("\t}");
			i++;
		}
		out.println("}\n");
		out.close();
		return file.getAbsolutePath();
	}

	private String printHead() {
		return "package " + getTargetPackage() + ".test;\n\n"
			+ "import junit.framework.Assert;\n"
			+ "import android.test.ActivityInstrumentationTestCase2;\n"
			+ "import android.test.suitebuilder.annotation.Smoke;\n"	
			+ "import " + targetActvity + ";\n"
			+ "import com.jayway.android.robotium.solo.Solo;\n"		
			+ "import de.tud.mgt.SoloId;\n";
	}

	private String printExtras() {
		String ret = "";
		ret += "private SoloId solo;\n";
		ret += "\tpublic " + name + "() {\n"
				+ "\t\t super(" + getTargetActivityPure() + ".class);\n"
				+ "\t}\n\n";

				ret += "\tpublic void setUp() throws Exception {\n"
			+ "\t\t solo = new SoloId(getInstrumentation(), getActivity());\n"
			+ "\t}\n\n";
		
			ret += "\t@Override\n"
				+ "\tpublic void tearDown() throws Exception {\n"
				+ "\t\t solo.finishOpenedActivities();\n"
				+ "\t}\n\n";
		return ret;
	}

	public HashMap<Integer, AbstractTestStep> getMapping() {
		return mapping;
	}
}
