/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;

import java.lang.String;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keyword</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.Keyword#getTarget <em>Target</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.Keyword#getTestData <em>Test Data</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.Keyword#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getKeyword()
 * @model
 * @generated
 */
public interface Keyword extends AbstractTestStep
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(UIElementLocator)
   * @see de.tu_dresden.mgt.MgtPackage#getKeyword_Target()
   * @model containment="true"
   * @generated
   */
  UIElementLocator getTarget();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Keyword#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(UIElementLocator value);

  /**
   * Returns the value of the '<em><b>Test Data</b></em>' containment reference list.
   * The list contents are of type {@link de.tu_dresden.mgt.TestDate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Data</em>' containment reference list.
   * @see de.tu_dresden.mgt.MgtPackage#getKeyword_TestData()
   * @model containment="true"
   * @generated
   */
  EList<TestDate> getTestData();

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
   * @see de.tu_dresden.mgt.MgtPackage#getKeyword_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Keyword#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Keyword
