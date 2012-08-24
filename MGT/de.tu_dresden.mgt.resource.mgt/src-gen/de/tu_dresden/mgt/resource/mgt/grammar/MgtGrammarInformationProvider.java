/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

public class MgtGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static MgtGrammarInformationProvider INSTANCE = new MgtGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("TESTSUITE", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace MGT_0_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace(1, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("{", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_3 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_4 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("suiteName", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_5 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_0_0_0_6 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), "BIGNAME", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_7 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(",", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_8 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_9 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("systemUnderTest", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_10 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_0_0_0_11 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), "BIGNAME", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_12 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(",", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_13 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_14 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("adapter", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_15 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_0_0_0_16 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_17 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_0_0_0_18_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SEQUENCES), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_18_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_0_0_0_18_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0_18_0_0_0, MGT_0_0_0_18_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_0_0_0_18_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0_18_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_0_0_0_18 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_0_0_0_18_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.STAR);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_0_0_0_19_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__TEST_CASES), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_0_0_0_19_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_0_0_0_19_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0_19_0_0_0, MGT_0_0_0_19_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_0_0_0_19_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0_19_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_0_0_0_19 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_0_0_0_19_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.PLUS);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_0_0_0_20 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("}", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0_0, MGT_0_0_0_1, MGT_0_0_0_2, MGT_0_0_0_3, MGT_0_0_0_4, MGT_0_0_0_5, MGT_0_0_0_6, MGT_0_0_0_7, MGT_0_0_0_8, MGT_0_0_0_9, MGT_0_0_0_10, MGT_0_0_0_11, MGT_0_0_0_12, MGT_0_0_0_13, MGT_0_0_0_14, MGT_0_0_0_15, MGT_0_0_0_16, MGT_0_0_0_17, MGT_0_0_0_18, MGT_0_0_0_19, MGT_0_0_0_20);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_0_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), MGT_0_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("TESTCASE", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace MGT_1_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace(1, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("{", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_1_0_0_3 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_4 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("caseName", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_5 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_1_0_0_6 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_1_0_0_7 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_1_0_0_8_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__TEST_STEPS), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAbstractTestStep(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_8_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(";", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_1_0_0_8_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_1_0_0_8_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_1_0_0_8_0_0_0, MGT_1_0_0_8_0_0_1, MGT_1_0_0_8_0_0_2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_1_0_0_8_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_1_0_0_8_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_1_0_0_8 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_1_0_0_8_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.PLUS);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_1_0_0_9 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("}", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_1_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_1_0_0_0, MGT_1_0_0_1, MGT_1_0_0_2, MGT_1_0_0_3, MGT_1_0_0_4, MGT_1_0_0_5, MGT_1_0_0_6, MGT_1_0_0_7, MGT_1_0_0_8, MGT_1_0_0_9);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_1_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_1_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), MGT_1_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_2_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("ASSERT", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_2_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_2_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("(", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_2_0_0_3 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ACTUAL), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_2_0_0_4_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(",", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_2_0_0_4_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__EXPECTED), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestDate(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_2_0_0_4_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0_4_0_0_0, MGT_2_0_0_4_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_2_0_0_4_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0_4_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_2_0_0_4 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_2_0_0_4_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.QUESTIONMARK);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_2_0_0_5 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(")", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_2_0_0_6_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal MGT_2_0_0_6_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), new String[] {"fail", "FAIL", "error", "ERROR", "inconclusive", "INCONCL", "pass", "PASS", }, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_2_0_0_6_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0_6_0_0_0, MGT_2_0_0_6_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_2_0_0_6_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0_6_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_2_0_0_6 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_2_0_0_6_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.QUESTIONMARK);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_2_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0_0, MGT_2_0_0_1, MGT_2_0_0_2, MGT_2_0_0_3, MGT_2_0_0_4, MGT_2_0_0_5, MGT_2_0_0_6);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_2_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_2_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), MGT_2_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_3_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("id", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_3_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_3_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_3_0_0_0, MGT_3_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_3_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_3_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_3 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator(), MGT_3_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_4_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_4_0_0_1_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_4_0_0_1_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TARGET), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_4_0_0_1_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_1_0_0_0, MGT_4_0_0_1_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_4_0_0_1_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_1_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_4_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_4_0_0_1_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.QUESTIONMARK);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_4_0_0_2_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(":", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_4_0_0_2_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestDate(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_4_0_0_2_0_0_2_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(",", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_4_0_0_2_0_0_2_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestDate(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_4_0_0_2_0_0_2_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_2_0_0_2_0_0_0, MGT_4_0_0_2_0_0_2_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_4_0_0_2_0_0_2_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_2_0_0_2_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_4_0_0_2_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_4_0_0_2_0_0_2_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.STAR);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_4_0_0_2_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_2_0_0_0, MGT_4_0_0_2_0_0_1, MGT_4_0_0_2_0_0_2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_4_0_0_2_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_2_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_4_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_4_0_0_2_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.QUESTIONMARK);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_4_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0_0, MGT_4_0_0_1, MGT_4_0_0_2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_4_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_4_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_4 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), MGT_4_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_5_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("SEQUENCE", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace MGT_5_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace(1, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_5_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace MGT_5_0_0_3 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtWhiteSpace(1, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_5_0_0_4 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("{", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_5_0_0_5 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment MGT_5_0_0_6_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainment(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__STEPS), de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAbstractTestStep(), }, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_5_0_0_6_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword(";", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_5_0_0_6_0_0_2 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_5_0_0_6_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_5_0_0_6_0_0_0, MGT_5_0_0_6_0_0_1, MGT_5_0_0_6_0_0_2);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_5_0_0_6_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_5_0_0_6_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound MGT_5_0_0_6 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtCompound(MGT_5_0_0_6_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.PLUS);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak MGT_5_0_0_7 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtLineBreak(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_5_0_0_8 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("}", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_5_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_5_0_0_0, MGT_5_0_0_1, MGT_5_0_0_2, MGT_5_0_0_3, MGT_5_0_0_4, MGT_5_0_0_5, MGT_5_0_0_6, MGT_5_0_0_7, MGT_5_0_0_8);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_5_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_5_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_5 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), MGT_5_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword MGT_6_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword("seq:", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_6_0_0_1 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), "IDENTIFIER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_6_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_6_0_0_0, MGT_6_0_0_1);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_6_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_6_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_6 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), MGT_6_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_7_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), "INTEGER", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_7_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_7_0_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_7_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_7_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_7 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), MGT_7_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal MGT_8_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE), "true", "false", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_8_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_8_0_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_8_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_8_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_8 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), MGT_8_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_9_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), "QUOTED_34_34", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_9_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_9_0_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_9_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_9_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_9 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), MGT_9_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder MGT_10_0_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtPlaceholder(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), "FLOAT", de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, 0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence MGT_10_0_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtSequence(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_10_0_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice MGT_10_0 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtChoice(de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE, MGT_10_0_0);
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule MGT_10 = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), MGT_10_0, de.tu_dresden.mgt.resource.mgt.grammar.MgtCardinality.ONE);
	
	public static String getSyntaxElementID(de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement) de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static de.tu_dresden.mgt.resource.mgt.grammar.MgtRule[] RULES = new de.tu_dresden.mgt.resource.mgt.grammar.MgtRule[] {
		MGT_0,
		MGT_1,
		MGT_2,
		MGT_3,
		MGT_4,
		MGT_5,
		MGT_6,
		MGT_7,
		MGT_8,
		MGT_9,
		MGT_10,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (de.tu_dresden.mgt.resource.mgt.grammar.MgtRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword) {
			keywords.add(((de.tu_dresden.mgt.resource.mgt.grammar.MgtKeyword) element).getValue());
		} else if (element instanceof de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal) {
			keywords.add(((de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal) element).getTrueLiteral());
			keywords.add(((de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal) {
			de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal terminal = (de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (de.tu_dresden.mgt.resource.mgt.grammar.MgtSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
