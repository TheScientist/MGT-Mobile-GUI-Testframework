/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequential Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.SequentialStep#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getSequentialStep()
 * @model
 * @generated
 */
public interface SequentialStep extends AbstractTestStep
{
  /**
   * Returns the value of the '<em><b>Sequence</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence</em>' reference.
   * @see #setSequence(Sequence)
   * @see de.tu_dresden.mgt.MgtPackage#getSequentialStep_Sequence()
   * @model required="true"
   * @generated
   */
  Sequence getSequence();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.SequentialStep#getSequence <em>Sequence</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence</em>' reference.
   * @see #getSequence()
   * @generated
   */
  void setSequence(Sequence value);

} // SequentialStep
