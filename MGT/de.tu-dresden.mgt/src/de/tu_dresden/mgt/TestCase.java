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
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.TestCase#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestCase#getTestSteps <em>Test Steps</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.TestCase#getVerdict <em>Verdict</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends EObject
{
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
   * @see de.tu_dresden.mgt.MgtPackage#getTestCase_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.TestCase#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Test Steps</b></em>' containment reference list.
   * The list contents are of type {@link de.tu_dresden.mgt.AbstractTestStep}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Steps</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Steps</em>' containment reference list.
   * @see de.tu_dresden.mgt.MgtPackage#getTestCase_TestSteps()
   * @model containment="true" required="true"
   * @generated
   */
  EList<AbstractTestStep> getTestSteps();

  /**
   * Returns the value of the '<em><b>Verdict</b></em>' attribute.
   * The literals are from the enumeration {@link de.tu_dresden.mgt.Verdict}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verdict</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verdict</em>' attribute.
   * @see de.tu_dresden.mgt.Verdict
   * @see #setVerdict(Verdict)
   * @see de.tu_dresden.mgt.MgtPackage#getTestCase_Verdict()
   * @model required="true"
   * @generated
   */
  Verdict getVerdict();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.TestCase#getVerdict <em>Verdict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verdict</em>' attribute.
   * @see de.tu_dresden.mgt.Verdict
   * @see #getVerdict()
   * @generated
   */
  void setVerdict(Verdict value);

} // TestCase
