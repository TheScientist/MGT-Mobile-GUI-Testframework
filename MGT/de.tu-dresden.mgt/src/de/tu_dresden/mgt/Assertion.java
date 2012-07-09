/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;

import java.lang.String;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.Assertion#getAssert <em>Assert</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.Assertion#getVerdict <em>Verdict</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.Assertion#getExpected <em>Expected</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.Assertion#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getAssertion()
 * @model
 * @generated
 */
public interface Assertion extends AbstractTestStep
{
  /**
   * Returns the value of the '<em><b>Assert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assert</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assert</em>' attribute.
   * @see #setAssert(String)
   * @see de.tu_dresden.mgt.MgtPackage#getAssertion_Assert()
   * @model required="true"
   * @generated
   */
  String getAssert();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Assertion#getAssert <em>Assert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assert</em>' attribute.
   * @see #getAssert()
   * @generated
   */
  void setAssert(String value);

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
   * @see de.tu_dresden.mgt.MgtPackage#getAssertion_Verdict()
   * @model
   * @generated
   */
  Verdict getVerdict();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Assertion#getVerdict <em>Verdict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verdict</em>' attribute.
   * @see de.tu_dresden.mgt.Verdict
   * @see #getVerdict()
   * @generated
   */
  void setVerdict(Verdict value);

  /**
   * Returns the value of the '<em><b>Expected</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expected</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expected</em>' containment reference.
   * @see #setExpected(TestDate)
   * @see de.tu_dresden.mgt.MgtPackage#getAssertion_Expected()
   * @model containment="true"
   * @generated
   */
  TestDate getExpected();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Assertion#getExpected <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expected</em>' containment reference.
   * @see #getExpected()
   * @generated
   */
  void setExpected(TestDate value);

  /**
   * Returns the value of the '<em><b>Actual</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual</em>' containment reference.
   * @see #setActual(Keyword)
   * @see de.tu_dresden.mgt.MgtPackage#getAssertion_Actual()
   * @model containment="true" required="true"
   * @generated
   */
  Keyword getActual();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Assertion#getActual <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual</em>' containment reference.
   * @see #getActual()
   * @generated
   */
  void setActual(Keyword value);

} // Assertion
