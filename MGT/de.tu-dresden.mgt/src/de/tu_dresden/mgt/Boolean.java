/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.Boolean#isDataValue <em>Data Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getBoolean()
 * @model
 * @generated
 */
public interface Boolean extends TestDate
{
  /**
   * Returns the value of the '<em><b>Data Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Value</em>' attribute.
   * @see #setDataValue(boolean)
   * @see de.tu_dresden.mgt.MgtPackage#getBoolean_DataValue()
   * @model required="true" derived="true"
   * @generated
   */
  boolean isDataValue();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Boolean#isDataValue <em>Data Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Value</em>' attribute.
   * @see #isDataValue()
   * @generated
   */
  void setDataValue(boolean value);

} // Boolean
