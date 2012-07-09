/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.String#getDataValue <em>Data Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getString()
 * @model
 * @generated
 */
public interface String extends TestDate
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
   * @see #setDataValue(java.lang.String)
   * @see de.tu_dresden.mgt.MgtPackage#getString_DataValue()
   * @model required="true" derived="true"
   * @generated
   */
  java.lang.String getDataValue();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.String#getDataValue <em>Data Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Value</em>' attribute.
   * @see #getDataValue()
   * @generated
   */
  void setDataValue(java.lang.String value);

} // String
