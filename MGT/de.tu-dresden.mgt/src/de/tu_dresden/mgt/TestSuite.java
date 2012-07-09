/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;

import java.lang.String;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.TestSuite#getSystemUnderTest <em>System Under Test</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestSuite#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestSuite#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestSuite#getTestCases <em>Test Cases</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestSuite#getSequences <em>Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getTestSuite()
 * @model
 * @generated
 */
public interface TestSuite extends EObject
{
  /**
   * Returns the value of the '<em><b>System Under Test</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Under Test</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Under Test</em>' attribute.
   * @see #setSystemUnderTest(String)
   * @see de.tu_dresden.mgt.MgtPackage#getTestSuite_SystemUnderTest()
   * @model required="true"
   * @generated
   */
  String getSystemUnderTest();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.TestSuite#getSystemUnderTest <em>System Under Test</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System Under Test</em>' attribute.
   * @see #getSystemUnderTest()
   * @generated
   */
  void setSystemUnderTest(String value);

  /**
   * Returns the value of the '<em><b>Adapter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adapter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adapter</em>' attribute.
   * @see #setAdapter(String)
   * @see de.tu_dresden.mgt.MgtPackage#getTestSuite_Adapter()
   * @model required="true"
   * @generated
   */
  String getAdapter();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.TestSuite#getAdapter <em>Adapter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adapter</em>' attribute.
   * @see #getAdapter()
   * @generated
   */
  void setAdapter(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.tu_dresden.mgt.MgtPackage#getTestSuite_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.TestSuite#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Test Cases</b></em>' containment reference list.
   * The list contents are of type {@link de.tu_dresden.mgt.TestCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Cases</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Cases</em>' containment reference list.
   * @see de.tu_dresden.mgt.MgtPackage#getTestSuite_TestCases()
   * @model containment="true" required="true"
   * @generated
   */
  EList<TestCase> getTestCases();

  /**
   * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
   * The list contents are of type {@link de.tu_dresden.mgt.Sequence}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequences</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequences</em>' containment reference list.
   * @see de.tu_dresden.mgt.MgtPackage#getTestSuite_Sequences()
   * @model containment="true"
   * @generated
   */
  EList<Sequence> getSequences();

} // TestSuite
