/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class MgtFollowSetProvider {
	
	public final static de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement TERMINALS[] = new de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement[45];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[8];
	
	public final static de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] LINKS = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[43];
	
	public final static de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] EMPTY_LINK_ARRAY = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_0);
		TERMINALS[1] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_2);
		TERMINALS[2] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_4);
		TERMINALS[3] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_5);
		TERMINALS[4] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_6);
		TERMINALS[5] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_7);
		TERMINALS[6] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_9);
		TERMINALS[7] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_10);
		TERMINALS[8] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_11);
		TERMINALS[9] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_12);
		TERMINALS[10] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_14);
		TERMINALS[11] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_15);
		TERMINALS[12] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_16);
		TERMINALS[13] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_0);
		TERMINALS[14] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_0);
		TERMINALS[15] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_20);
		TERMINALS[16] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_2);
		TERMINALS[17] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_4);
		TERMINALS[18] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_5);
		TERMINALS[19] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_6);
		TERMINALS[20] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_0);
		TERMINALS[21] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_0);
		TERMINALS[22] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_0);
		TERMINALS[23] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_8_0_0_1);
		TERMINALS[24] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_9);
		TERMINALS[25] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_1);
		TERMINALS[26] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_2);
		TERMINALS[27] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_4_0_0_0);
		TERMINALS[28] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_5);
		TERMINALS[29] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_7_0_0_0);
		TERMINALS[30] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedBooleanTerminal(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_8_0_0_0);
		TERMINALS[31] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_9_0_0_0);
		TERMINALS[32] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_10_0_0_0);
		TERMINALS[33] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_0);
		TERMINALS[34] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_6_0_0_1);
		TERMINALS[35] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedEnumerationTerminal(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1);
		TERMINALS[36] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_0);
		TERMINALS[37] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_1);
		TERMINALS[38] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_0);
		TERMINALS[39] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_1_0_0_0);
		TERMINALS[40] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_2_0_0_0);
		TERMINALS[41] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_2);
		TERMINALS[42] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_4);
		TERMINALS[43] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_8);
		TERMINALS[44] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature(de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SEQUENCES);
		FEATURES[1] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__TEST_CASES);
		FEATURES[2] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__TEST_STEPS);
		FEATURES[3] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ACTUAL);
		FEATURES[4] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__EXPECTED);
		FEATURES[5] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TARGET);
		FEATURES[6] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA);
		FEATURES[7] = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__STEPS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]);
		LINKS[1] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[2] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]);
		LINKS[3] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[4] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]);
		LINKS[5] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[6] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[7] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[8] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[2]);
		LINKS[9] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[2]);
		LINKS[10] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[2]);
		LINKS[11] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[2]);
		LINKS[12] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[2]);
		LINKS[13] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[2]);
		LINKS[14] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[2]);
		LINKS[15] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[2]);
		LINKS[16] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[2]);
		LINKS[17] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
		LINKS[18] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[3]);
		LINKS[19] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[4]);
		LINKS[20] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[4]);
		LINKS[21] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[4]);
		LINKS[22] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[4]);
		LINKS[23] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator(), FEATURES[5]);
		LINKS[24] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[6]);
		LINKS[25] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[6]);
		LINKS[26] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[6]);
		LINKS[27] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[6]);
		LINKS[28] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[6]);
		LINKS[29] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[6]);
		LINKS[30] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[6]);
		LINKS[31] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[6]);
		LINKS[32] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[7]);
		LINKS[33] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[7]);
		LINKS[34] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[7]);
		LINKS[35] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[7]);
		LINKS[36] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[7]);
		LINKS[37] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[7]);
		LINKS[38] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[7]);
		LINKS[39] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[7]);
		LINKS[40] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[7]);
		LINKS[41] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]);
		LINKS[42] = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]), });
		TERMINALS[12].addFollower(TERMINALS[14], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]), });
		TERMINALS[14].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[20], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[2]), });
		TERMINALS[19].addFollower(TERMINALS[21], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[2]), });
		TERMINALS[19].addFollower(TERMINALS[22], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[2]), });
		TERMINALS[23].addFollower(TERMINALS[20], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[2]), });
		TERMINALS[23].addFollower(TERMINALS[21], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[2]), });
		TERMINALS[23].addFollower(TERMINALS[22], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[2]), });
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[14], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]), });
		TERMINALS[24].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[26], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[21], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[3]), });
		TERMINALS[27].addFollower(TERMINALS[29], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[4]), });
		TERMINALS[27].addFollower(TERMINALS[30], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[4]), });
		TERMINALS[27].addFollower(TERMINALS[31], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[4]), });
		TERMINALS[27].addFollower(TERMINALS[32], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[4]), });
		TERMINALS[28].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[37], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[39], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[39].addFollower(TERMINALS[36], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator(), FEATURES[5]), });
		TERMINALS[38].addFollower(TERMINALS[29], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[6]), });
		TERMINALS[38].addFollower(TERMINALS[30], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[6]), });
		TERMINALS[38].addFollower(TERMINALS[31], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[6]), });
		TERMINALS[38].addFollower(TERMINALS[32], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[6]), });
		TERMINALS[40].addFollower(TERMINALS[29], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(), FEATURES[6]), });
		TERMINALS[40].addFollower(TERMINALS[30], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(), FEATURES[6]), });
		TERMINALS[40].addFollower(TERMINALS[31], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(), FEATURES[6]), });
		TERMINALS[40].addFollower(TERMINALS[32], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(), FEATURES[6]), });
		TERMINALS[13].addFollower(TERMINALS[41], EMPTY_LINK_ARRAY);
		TERMINALS[41].addFollower(TERMINALS[42], EMPTY_LINK_ARRAY);
		TERMINALS[42].addFollower(TERMINALS[20], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[7]), });
		TERMINALS[42].addFollower(TERMINALS[21], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[7]), });
		TERMINALS[42].addFollower(TERMINALS[22], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[7]), });
		TERMINALS[34].addFollower(TERMINALS[20], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), FEATURES[7]), });
		TERMINALS[34].addFollower(TERMINALS[21], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), FEATURES[7]), });
		TERMINALS[34].addFollower(TERMINALS[22], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(), FEATURES[7]), });
		TERMINALS[34].addFollower(TERMINALS[43], EMPTY_LINK_ARRAY);
		TERMINALS[43].addFollower(TERMINALS[13], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), FEATURES[0]), });
		TERMINALS[43].addFollower(TERMINALS[14], new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] {new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), FEATURES[1]), });
		TERMINALS[22].addFollower(TERMINALS[44], EMPTY_LINK_ARRAY);
		TERMINALS[44].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[44].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
