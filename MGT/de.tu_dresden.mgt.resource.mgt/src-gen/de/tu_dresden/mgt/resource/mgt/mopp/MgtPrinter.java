/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtPrinter implements de.tu_dresden.mgt.resource.mgt.IMgtTextPrinter {
	
	protected de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory tokenResolverFactory = new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public MgtPrinter(java.io.OutputStream outputStream, de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof de.tu_dresden.mgt.TestSuite) {
			print_de_tu_005fdresden_mgt_TestSuite((de.tu_dresden.mgt.TestSuite) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.TestCase) {
			print_de_tu_005fdresden_mgt_TestCase((de.tu_dresden.mgt.TestCase) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Assertion) {
			print_de_tu_005fdresden_mgt_Assertion((de.tu_dresden.mgt.Assertion) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.UIElementLocator) {
			print_de_tu_005fdresden_mgt_UIElementLocator((de.tu_dresden.mgt.UIElementLocator) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Keyword) {
			print_de_tu_005fdresden_mgt_Keyword((de.tu_dresden.mgt.Keyword) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Sequence) {
			print_de_tu_005fdresden_mgt_Sequence((de.tu_dresden.mgt.Sequence) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.SequentialStep) {
			print_de_tu_005fdresden_mgt_SequentialStep((de.tu_dresden.mgt.SequentialStep) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Integer) {
			print_de_tu_005fdresden_mgt_Integer((de.tu_dresden.mgt.Integer) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Boolean) {
			print_de_tu_005fdresden_mgt_Boolean((de.tu_dresden.mgt.Boolean) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.String) {
			print_de_tu_005fdresden_mgt_String((de.tu_dresden.mgt.String) element, globaltab, out);
			return;
		}
		if (element instanceof de.tu_dresden.mgt.Float) {
			print_de_tu_005fdresden_mgt_Float((de.tu_dresden.mgt.Float) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected de.tu_dresden.mgt.resource.mgt.mopp.MgtReferenceResolverSwitch getReferenceResolverSwitch() {
		return (de.tu_dresden.mgt.resource.mgt.mopp.MgtReferenceResolverSwitch) new de.tu_dresden.mgt.resource.mgt.mopp.MgtMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new de.tu_dresden.mgt.resource.mgt.mopp.MgtProblem(errorMessage, de.tu_dresden.mgt.resource.mgt.MgtEProblemType.PRINT_PROBLEM, de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_de_tu_005fdresden_mgt_TestSuite(de.tu_dresden.mgt.TestSuite element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST));
		printCountingMap.put("systemUnderTest", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER));
		printCountingMap.put("adapter", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__TEST_CASES));
		printCountingMap.put("testCases", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SEQUENCES));
		printCountingMap.put("sequences", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("TESTSUITE");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("suiteName");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("BIGNAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("systemUnderTest");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("systemUnderTest");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("BIGNAME");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), element));
				out.print(" ");
			}
			printCountingMap.put("systemUnderTest", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("adapter");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("adapter");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), element));
				out.print(" ");
			}
			printCountingMap.put("adapter", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_de_tu_005fdresden_mgt_TestSuite_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_de_tu_005fdresden_mgt_TestSuite_1(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_de_tu_005fdresden_mgt_TestSuite_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_de_tu_005fdresden_mgt_TestSuite_0(de.tu_dresden.mgt.TestSuite element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("sequences");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SEQUENCES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("sequences", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
	}
	
	public void print_de_tu_005fdresden_mgt_TestSuite_1(de.tu_dresden.mgt.TestSuite element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("testCases");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__TEST_CASES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("testCases", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	
	public void print_de_tu_005fdresden_mgt_TestCase(de.tu_dresden.mgt.TestCase element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__TEST_STEPS));
		printCountingMap.put("testSteps", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__VERDICT));
		printCountingMap.put("verdict", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("TESTCASE");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "		";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("caseName");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "		";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_de_tu_005fdresden_mgt_TestCase_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_de_tu_005fdresden_mgt_TestCase_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_de_tu_005fdresden_mgt_TestCase_0(de.tu_dresden.mgt.TestCase element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("testSteps");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__TEST_STEPS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("testSteps", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
	}
	
	
	public void print_de_tu_005fdresden_mgt_Assertion(de.tu_dresden.mgt.Assertion element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT));
		printCountingMap.put("assert", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT));
		printCountingMap.put("verdict", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__EXPECTED));
		printCountingMap.put("expected", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ACTUAL));
		printCountingMap.put("actual", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("ASSERT");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("assert");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), element));
				out.print(" ");
			}
			printCountingMap.put("assert", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("actual");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ACTUAL));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("actual", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_de_tu_005fdresden_mgt_Assertion_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_de_tu_005fdresden_mgt_Assertion_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_de_tu_005fdresden_mgt_Assertion_0(de.tu_dresden.mgt.Assertion element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expected");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__EXPECTED));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expected", count - 1);
		}
	}
	
	public void print_de_tu_005fdresden_mgt_Assertion_1(de.tu_dresden.mgt.Assertion element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("verdict");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT));
			if (o != null) {
			}
			printCountingMap.put("verdict", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_UIElementLocator(de.tu_dresden.mgt.UIElementLocator element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("id");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_Keyword(de.tu_dresden.mgt.Keyword element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA));
		printCountingMap.put("testData", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_de_tu_005fdresden_mgt_Keyword_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_de_tu_005fdresden_mgt_Keyword_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
	}
	
	public void print_de_tu_005fdresden_mgt_Keyword_0(de.tu_dresden.mgt.Keyword element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
	}
	
	public void print_de_tu_005fdresden_mgt_Keyword_1(de.tu_dresden.mgt.Keyword element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("testData");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("testData", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_de_tu_005fdresden_mgt_Keyword_1_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_de_tu_005fdresden_mgt_Keyword_1_0(de.tu_dresden.mgt.Keyword element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("testData");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("testData", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_Sequence(de.tu_dresden.mgt.Sequence element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__STEPS));
		printCountingMap.put("steps", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("SEQUENCE");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_de_tu_005fdresden_mgt_Sequence_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_de_tu_005fdresden_mgt_Sequence_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_de_tu_005fdresden_mgt_Sequence_0(de.tu_dresden.mgt.Sequence element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("steps");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__STEPS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("steps", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(";");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
	}
	
	
	public void print_de_tu_005fdresden_mgt_SequentialStep(de.tu_dresden.mgt.SequentialStep element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE));
		printCountingMap.put("sequence", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("seq:");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("sequence");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSequentialStepSequenceReferenceResolver().deResolve((de.tu_dresden.mgt.Sequence) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE)), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), element));
				out.print(" ");
			}
			printCountingMap.put("sequence", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_Integer(de.tu_dresden.mgt.Integer element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE));
		printCountingMap.put("dataValue", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("dataValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("dataValue", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_Boolean(de.tu_dresden.mgt.Boolean element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (BooleanTerminal)
		count = printCountingMap.get("dataValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE));
			if (o != null) {
			}
			printCountingMap.put("dataValue", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_String(de.tu_dresden.mgt.String element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("dataValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("dataValue", count - 1);
		}
	}
	
	
	public void print_de_tu_005fdresden_mgt_Float(de.tu_dresden.mgt.Float element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE));
		printCountingMap.put("dataValue", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("dataValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE));
			if (o != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver resolver = tokenResolverFactory.createTokenResolver("FLOAT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), element));
				out.print(" ");
			}
			printCountingMap.put("dataValue", count - 1);
		}
	}
	
	
}
