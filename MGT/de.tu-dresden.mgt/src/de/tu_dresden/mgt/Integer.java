/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.Integer#getDataValue <em>Data Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tu_dresden.mgt.MgtPackage#getInteger()
 * @model
 * @generated
 */
public interface Integer extends TestDate
{
  /**
   * Returns the value of the '<em><b>Data Value</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Value</em>' attribute.
   * @see #setDataValue(int)
   * @see de.tu_dresden.mgt.MgtPackage#getInteger_DataValue()
   * @model default="0" required="true"
   * @generated
   */
  int getDataValue();

  /**
   * Sets the value of the '{@link de.tu_dresden.mgt.Integer#getDataValue <em>Data Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Value</em>' attribute.
   * @see #getDataValue()
   * @generated
   */
  void setDataValue(int value);

} // Integer
