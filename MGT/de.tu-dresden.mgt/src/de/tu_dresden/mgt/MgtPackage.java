/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;

import java.lang.String;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.tu_dresden.mgt.MgtFactory
 * @model kind="package"
 * @generated
 */
public interface MgtPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mgt";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://mgt/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mgt";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MgtPackage eINSTANCE = de.tu_dresden.mgt.impl.MgtPackageImpl.init();

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.TestSuiteImpl <em>Test Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.TestSuiteImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestSuite()
   * @generated
   */
  int TEST_SUITE = 0;

  /**
   * The feature id for the '<em><b>System Under Test</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__SYSTEM_UNDER_TEST = 0;

  /**
   * The feature id for the '<em><b>Adapter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__ADAPTER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__NAME = 2;

  /**
   * The feature id for the '<em><b>Test Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__TEST_CASES = 3;

  /**
   * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE__SEQUENCES = 4;

  /**
   * The number of structural features of the '<em>Test Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_SUITE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.TestCaseImpl <em>Test Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.TestCaseImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestCase()
   * @generated
   */
  int TEST_CASE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__NAME = 0;

  /**
   * The feature id for the '<em><b>Test Steps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__TEST_STEPS = 1;

  /**
   * The feature id for the '<em><b>Verdict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE__VERDICT = 2;

  /**
   * The number of structural features of the '<em>Test Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_CASE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.AbstractTestStepImpl <em>Abstract Test Step</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.AbstractTestStepImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getAbstractTestStep()
   * @generated
   */
  int ABSTRACT_TEST_STEP = 2;

  /**
   * The number of structural features of the '<em>Abstract Test Step</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_TEST_STEP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.TestDateImpl <em>Test Date</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.TestDateImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestDate()
   * @generated
   */
  int TEST_DATE = 3;

  /**
   * The number of structural features of the '<em>Test Date</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_DATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.IntegerImpl <em>Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.IntegerImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getInteger()
   * @generated
   */
  int INTEGER = 4;

  /**
   * The feature id for the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER__DATA_VALUE = TEST_DATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_FEATURE_COUNT = TEST_DATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.BooleanImpl <em>Boolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.BooleanImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getBoolean()
   * @generated
   */
  int BOOLEAN = 5;

  /**
   * The feature id for the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN__DATA_VALUE = TEST_DATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_FEATURE_COUNT = TEST_DATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.StringImpl <em>String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.StringImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getString()
   * @generated
   */
  int STRING = 6;

  /**
   * The feature id for the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING__DATA_VALUE = TEST_DATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_FEATURE_COUNT = TEST_DATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.AssertionImpl <em>Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.AssertionImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getAssertion()
   * @generated
   */
  int ASSERTION = 7;

  /**
   * The feature id for the '<em><b>Assert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__ASSERT = ABSTRACT_TEST_STEP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Verdict</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__VERDICT = ABSTRACT_TEST_STEP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expected</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__EXPECTED = ABSTRACT_TEST_STEP_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Actual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__ACTUAL = ABSTRACT_TEST_STEP_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION_FEATURE_COUNT = ABSTRACT_TEST_STEP_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.KeywordImpl <em>Keyword</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.KeywordImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getKeyword()
   * @generated
   */
  int KEYWORD = 8;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__TARGET = ABSTRACT_TEST_STEP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Test Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__TEST_DATA = ABSTRACT_TEST_STEP_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD__NAME = ABSTRACT_TEST_STEP_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Keyword</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FEATURE_COUNT = ABSTRACT_TEST_STEP_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.UIElementLocatorImpl <em>UI Element Locator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.UIElementLocatorImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getUIElementLocator()
   * @generated
   */
  int UI_ELEMENT_LOCATOR = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_ELEMENT_LOCATOR__ID = 0;

  /**
   * The number of structural features of the '<em>UI Element Locator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UI_ELEMENT_LOCATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.SequenceImpl <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.SequenceImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Steps</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__STEPS = 1;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.SequentialStepImpl <em>Sequential Step</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.SequentialStepImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getSequentialStep()
   * @generated
   */
  int SEQUENTIAL_STEP = 11;

  /**
   * The feature id for the '<em><b>Sequence</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_STEP__SEQUENCE = ABSTRACT_TEST_STEP_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Sequential Step</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENTIAL_STEP_FEATURE_COUNT = ABSTRACT_TEST_STEP_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.impl.FloatImpl <em>Float</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.impl.FloatImpl
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getFloat()
   * @generated
   */
  int FLOAT = 12;

  /**
   * The feature id for the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT__DATA_VALUE = TEST_DATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Float</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FLOAT_FEATURE_COUNT = TEST_DATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.tu_dresden.mgt.Verdict <em>Verdict</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.tu_dresden.mgt.Verdict
   * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getVerdict()
   * @generated
   */
  int VERDICT = 13;


  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.TestSuite <em>Test Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Suite</em>'.
   * @see de.tu_dresden.mgt.TestSuite
   * @generated
   */
  EClass getTestSuite();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.TestSuite#getSystemUnderTest <em>System Under Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>System Under Test</em>'.
   * @see de.tu_dresden.mgt.TestSuite#getSystemUnderTest()
   * @see #getTestSuite()
   * @generated
   */
  EAttribute getTestSuite_SystemUnderTest();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.TestSuite#getAdapter <em>Adapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Adapter</em>'.
   * @see de.tu_dresden.mgt.TestSuite#getAdapter()
   * @see #getTestSuite()
   * @generated
   */
  EAttribute getTestSuite_Adapter();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.TestSuite#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.tu_dresden.mgt.TestSuite#getName()
   * @see #getTestSuite()
   * @generated
   */
  EAttribute getTestSuite_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.tu_dresden.mgt.TestSuite#getTestCases <em>Test Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Test Cases</em>'.
   * @see de.tu_dresden.mgt.TestSuite#getTestCases()
   * @see #getTestSuite()
   * @generated
   */
  EReference getTestSuite_TestCases();

  /**
   * Returns the meta object for the containment reference list '{@link de.tu_dresden.mgt.TestSuite#getSequences <em>Sequences</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sequences</em>'.
   * @see de.tu_dresden.mgt.TestSuite#getSequences()
   * @see #getTestSuite()
   * @generated
   */
  EReference getTestSuite_Sequences();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.TestCase <em>Test Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Case</em>'.
   * @see de.tu_dresden.mgt.TestCase
   * @generated
   */
  EClass getTestCase();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.TestCase#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.tu_dresden.mgt.TestCase#getName()
   * @see #getTestCase()
   * @generated
   */
  EAttribute getTestCase_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.tu_dresden.mgt.TestCase#getTestSteps <em>Test Steps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Test Steps</em>'.
   * @see de.tu_dresden.mgt.TestCase#getTestSteps()
   * @see #getTestCase()
   * @generated
   */
  EReference getTestCase_TestSteps();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.TestCase#getVerdict <em>Verdict</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Verdict</em>'.
   * @see de.tu_dresden.mgt.TestCase#getVerdict()
   * @see #getTestCase()
   * @generated
   */
  EAttribute getTestCase_Verdict();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.AbstractTestStep <em>Abstract Test Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Test Step</em>'.
   * @see de.tu_dresden.mgt.AbstractTestStep
   * @generated
   */
  EClass getAbstractTestStep();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.TestDate <em>Test Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Date</em>'.
   * @see de.tu_dresden.mgt.TestDate
   * @generated
   */
  EClass getTestDate();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Integer <em>Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer</em>'.
   * @see de.tu_dresden.mgt.Integer
   * @generated
   */
  EClass getInteger();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Integer#getDataValue <em>Data Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Value</em>'.
   * @see de.tu_dresden.mgt.Integer#getDataValue()
   * @see #getInteger()
   * @generated
   */
  EAttribute getInteger_DataValue();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Boolean <em>Boolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean</em>'.
   * @see de.tu_dresden.mgt.Boolean
   * @generated
   */
  EClass getBoolean();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Boolean#isDataValue <em>Data Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Value</em>'.
   * @see de.tu_dresden.mgt.Boolean#isDataValue()
   * @see #getBoolean()
   * @generated
   */
  EAttribute getBoolean_DataValue();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.String <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String</em>'.
   * @see de.tu_dresden.mgt.String
   * @generated
   */
  EClass getString();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.String#getDataValue <em>Data Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Value</em>'.
   * @see de.tu_dresden.mgt.String#getDataValue()
   * @see #getString()
   * @generated
   */
  EAttribute getString_DataValue();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assertion</em>'.
   * @see de.tu_dresden.mgt.Assertion
   * @generated
   */
  EClass getAssertion();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Assertion#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assert</em>'.
   * @see de.tu_dresden.mgt.Assertion#getAssert()
   * @see #getAssertion()
   * @generated
   */
  EAttribute getAssertion_Assert();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Assertion#getVerdict <em>Verdict</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Verdict</em>'.
   * @see de.tu_dresden.mgt.Assertion#getVerdict()
   * @see #getAssertion()
   * @generated
   */
  EAttribute getAssertion_Verdict();

  /**
   * Returns the meta object for the containment reference '{@link de.tu_dresden.mgt.Assertion#getExpected <em>Expected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expected</em>'.
   * @see de.tu_dresden.mgt.Assertion#getExpected()
   * @see #getAssertion()
   * @generated
   */
  EReference getAssertion_Expected();

  /**
   * Returns the meta object for the containment reference '{@link de.tu_dresden.mgt.Assertion#getActual <em>Actual</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Actual</em>'.
   * @see de.tu_dresden.mgt.Assertion#getActual()
   * @see #getAssertion()
   * @generated
   */
  EReference getAssertion_Actual();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword</em>'.
   * @see de.tu_dresden.mgt.Keyword
   * @generated
   */
  EClass getKeyword();

  /**
   * Returns the meta object for the containment reference '{@link de.tu_dresden.mgt.Keyword#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see de.tu_dresden.mgt.Keyword#getTarget()
   * @see #getKeyword()
   * @generated
   */
  EReference getKeyword_Target();

  /**
   * Returns the meta object for the containment reference list '{@link de.tu_dresden.mgt.Keyword#getTestData <em>Test Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Test Data</em>'.
   * @see de.tu_dresden.mgt.Keyword#getTestData()
   * @see #getKeyword()
   * @generated
   */
  EReference getKeyword_TestData();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Keyword#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.tu_dresden.mgt.Keyword#getName()
   * @see #getKeyword()
   * @generated
   */
  EAttribute getKeyword_Name();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.UIElementLocator <em>UI Element Locator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>UI Element Locator</em>'.
   * @see de.tu_dresden.mgt.UIElementLocator
   * @generated
   */
  EClass getUIElementLocator();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.UIElementLocator#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see de.tu_dresden.mgt.UIElementLocator#getId()
   * @see #getUIElementLocator()
   * @generated
   */
  EAttribute getUIElementLocator_Id();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see de.tu_dresden.mgt.Sequence
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Sequence#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.tu_dresden.mgt.Sequence#getName()
   * @see #getSequence()
   * @generated
   */
  EAttribute getSequence_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.tu_dresden.mgt.Sequence#getSteps <em>Steps</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Steps</em>'.
   * @see de.tu_dresden.mgt.Sequence#getSteps()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Steps();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.SequentialStep <em>Sequential Step</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequential Step</em>'.
   * @see de.tu_dresden.mgt.SequentialStep
   * @generated
   */
  EClass getSequentialStep();

  /**
   * Returns the meta object for the reference '{@link de.tu_dresden.mgt.SequentialStep#getSequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Sequence</em>'.
   * @see de.tu_dresden.mgt.SequentialStep#getSequence()
   * @see #getSequentialStep()
   * @generated
   */
  EReference getSequentialStep_Sequence();

  /**
   * Returns the meta object for class '{@link de.tu_dresden.mgt.Float <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Float</em>'.
   * @see de.tu_dresden.mgt.Float
   * @generated
   */
  EClass getFloat();

  /**
   * Returns the meta object for the attribute '{@link de.tu_dresden.mgt.Float#getDataValue <em>Data Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Data Value</em>'.
   * @see de.tu_dresden.mgt.Float#getDataValue()
   * @see #getFloat()
   * @generated
   */
  EAttribute getFloat_DataValue();

  /**
   * Returns the meta object for enum '{@link de.tu_dresden.mgt.Verdict <em>Verdict</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Verdict</em>'.
   * @see de.tu_dresden.mgt.Verdict
   * @generated
   */
  EEnum getVerdict();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MgtFactory getMgtFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.TestSuiteImpl <em>Test Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.TestSuiteImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestSuite()
     * @generated
     */
    EClass TEST_SUITE = eINSTANCE.getTestSuite();

    /**
     * The meta object literal for the '<em><b>System Under Test</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_SUITE__SYSTEM_UNDER_TEST = eINSTANCE.getTestSuite_SystemUnderTest();

    /**
     * The meta object literal for the '<em><b>Adapter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_SUITE__ADAPTER = eINSTANCE.getTestSuite_Adapter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_SUITE__NAME = eINSTANCE.getTestSuite_Name();

    /**
     * The meta object literal for the '<em><b>Test Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_SUITE__TEST_CASES = eINSTANCE.getTestSuite_TestCases();

    /**
     * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_SUITE__SEQUENCES = eINSTANCE.getTestSuite_Sequences();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.TestCaseImpl <em>Test Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.TestCaseImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestCase()
     * @generated
     */
    EClass TEST_CASE = eINSTANCE.getTestCase();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_CASE__NAME = eINSTANCE.getTestCase_Name();

    /**
     * The meta object literal for the '<em><b>Test Steps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_CASE__TEST_STEPS = eINSTANCE.getTestCase_TestSteps();

    /**
     * The meta object literal for the '<em><b>Verdict</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_CASE__VERDICT = eINSTANCE.getTestCase_Verdict();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.AbstractTestStepImpl <em>Abstract Test Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.AbstractTestStepImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getAbstractTestStep()
     * @generated
     */
    EClass ABSTRACT_TEST_STEP = eINSTANCE.getAbstractTestStep();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.TestDateImpl <em>Test Date</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.TestDateImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getTestDate()
     * @generated
     */
    EClass TEST_DATE = eINSTANCE.getTestDate();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.IntegerImpl <em>Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.IntegerImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getInteger()
     * @generated
     */
    EClass INTEGER = eINSTANCE.getInteger();

    /**
     * The meta object literal for the '<em><b>Data Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER__DATA_VALUE = eINSTANCE.getInteger_DataValue();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.BooleanImpl <em>Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.BooleanImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getBoolean()
     * @generated
     */
    EClass BOOLEAN = eINSTANCE.getBoolean();

    /**
     * The meta object literal for the '<em><b>Data Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN__DATA_VALUE = eINSTANCE.getBoolean_DataValue();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.StringImpl <em>String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.StringImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getString()
     * @generated
     */
    EClass STRING = eINSTANCE.getString();

    /**
     * The meta object literal for the '<em><b>Data Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING__DATA_VALUE = eINSTANCE.getString_DataValue();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.AssertionImpl <em>Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.AssertionImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getAssertion()
     * @generated
     */
    EClass ASSERTION = eINSTANCE.getAssertion();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSERTION__ASSERT = eINSTANCE.getAssertion_Assert();

    /**
     * The meta object literal for the '<em><b>Verdict</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSERTION__VERDICT = eINSTANCE.getAssertion_Verdict();

    /**
     * The meta object literal for the '<em><b>Expected</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSERTION__EXPECTED = eINSTANCE.getAssertion_Expected();

    /**
     * The meta object literal for the '<em><b>Actual</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSERTION__ACTUAL = eINSTANCE.getAssertion_Actual();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.KeywordImpl <em>Keyword</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.KeywordImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getKeyword()
     * @generated
     */
    EClass KEYWORD = eINSTANCE.getKeyword();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEYWORD__TARGET = eINSTANCE.getKeyword_Target();

    /**
     * The meta object literal for the '<em><b>Test Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEYWORD__TEST_DATA = eINSTANCE.getKeyword_TestData();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD__NAME = eINSTANCE.getKeyword_Name();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.UIElementLocatorImpl <em>UI Element Locator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.UIElementLocatorImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getUIElementLocator()
     * @generated
     */
    EClass UI_ELEMENT_LOCATOR = eINSTANCE.getUIElementLocator();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UI_ELEMENT_LOCATOR__ID = eINSTANCE.getUIElementLocator_Id();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.SequenceImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getSequence()
     * @generated
     */
    EClass SEQUENCE = eINSTANCE.getSequence();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEQUENCE__NAME = eINSTANCE.getSequence_Name();

    /**
     * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__STEPS = eINSTANCE.getSequence_Steps();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.SequentialStepImpl <em>Sequential Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.SequentialStepImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getSequentialStep()
     * @generated
     */
    EClass SEQUENTIAL_STEP = eINSTANCE.getSequentialStep();

    /**
     * The meta object literal for the '<em><b>Sequence</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENTIAL_STEP__SEQUENCE = eINSTANCE.getSequentialStep_Sequence();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.impl.FloatImpl <em>Float</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.impl.FloatImpl
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getFloat()
     * @generated
     */
    EClass FLOAT = eINSTANCE.getFloat();

    /**
     * The meta object literal for the '<em><b>Data Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FLOAT__DATA_VALUE = eINSTANCE.getFloat_DataValue();

    /**
     * The meta object literal for the '{@link de.tu_dresden.mgt.Verdict <em>Verdict</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.tu_dresden.mgt.Verdict
     * @see de.tu_dresden.mgt.impl.MgtPackageImpl#getVerdict()
     * @generated
     */
    EEnum VERDICT = eINSTANCE.getVerdict();

  }

} //MgtPackage
