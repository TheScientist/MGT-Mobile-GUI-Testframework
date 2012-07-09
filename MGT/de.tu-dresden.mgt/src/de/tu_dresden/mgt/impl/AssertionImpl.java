/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt.impl;

import de.tu_dresden.mgt.Assertion;
import de.tu_dresden.mgt.Keyword;
import de.tu_dresden.mgt.MgtPackage;
import de.tu_dresden.mgt.TestDate;
import de.tu_dresden.mgt.Verdict;

import java.lang.String;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assertion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.impl.AssertionImpl#getAssert <em>Assert</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.AssertionImpl#getVerdict <em>Verdict</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.AssertionImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.AssertionImpl#getActual <em>Actual</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssertionImpl extends AbstractTestStepImpl implements Assertion
{
  /**
   * The default value of the '{@link #getAssert() <em>Assert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssert()
   * @generated
   * @ordered
   */
  protected static final String ASSERT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAssert() <em>Assert</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssert()
   * @generated
   * @ordered
   */
  protected String assert_ = ASSERT_EDEFAULT;

  /**
   * The default value of the '{@link #getVerdict() <em>Verdict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerdict()
   * @generated
   * @ordered
   */
  protected static final Verdict VERDICT_EDEFAULT = Verdict.FAIL;

  /**
   * The cached value of the '{@link #getVerdict() <em>Verdict</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVerdict()
   * @generated
   * @ordered
   */
  protected Verdict verdict = VERDICT_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpected() <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected TestDate expected;

  /**
   * The cached value of the '{@link #getActual() <em>Actual</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getActual()
   * @generated
   * @ordered
   */
  protected Keyword actual;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssertionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MgtPackage.Literals.ASSERTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAssert()
  {
    return assert_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssert(String newAssert)
  {
    String oldAssert = assert_;
    assert_ = newAssert;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__ASSERT, oldAssert, assert_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Verdict getVerdict()
  {
    return verdict;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVerdict(Verdict newVerdict)
  {
    Verdict oldVerdict = verdict;
    verdict = newVerdict == null ? VERDICT_EDEFAULT : newVerdict;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__VERDICT, oldVerdict, verdict));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestDate getExpected()
  {
    return expected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpected(TestDate newExpected, NotificationChain msgs)
  {
    TestDate oldExpected = expected;
    expected = newExpected;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__EXPECTED, oldExpected, newExpected);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpected(TestDate newExpected)
  {
    if (newExpected != expected)
    {
      NotificationChain msgs = null;
      if (expected != null)
        msgs = ((InternalEObject)expected).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MgtPackage.ASSERTION__EXPECTED, null, msgs);
      if (newExpected != null)
        msgs = ((InternalEObject)newExpected).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MgtPackage.ASSERTION__EXPECTED, null, msgs);
      msgs = basicSetExpected(newExpected, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__EXPECTED, newExpected, newExpected));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Keyword getActual()
  {
    return actual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetActual(Keyword newActual, NotificationChain msgs)
  {
    Keyword oldActual = actual;
    actual = newActual;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__ACTUAL, oldActual, newActual);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActual(Keyword newActual)
  {
    if (newActual != actual)
    {
      NotificationChain msgs = null;
      if (actual != null)
        msgs = ((InternalEObject)actual).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MgtPackage.ASSERTION__ACTUAL, null, msgs);
      if (newActual != null)
        msgs = ((InternalEObject)newActual).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MgtPackage.ASSERTION__ACTUAL, null, msgs);
      msgs = basicSetActual(newActual, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.ASSERTION__ACTUAL, newActual, newActual));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MgtPackage.ASSERTION__EXPECTED:
        return basicSetExpected(null, msgs);
      case MgtPackage.ASSERTION__ACTUAL:
        return basicSetActual(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MgtPackage.ASSERTION__ASSERT:
        return getAssert();
      case MgtPackage.ASSERTION__VERDICT:
        return getVerdict();
      case MgtPackage.ASSERTION__EXPECTED:
        return getExpected();
      case MgtPackage.ASSERTION__ACTUAL:
        return getActual();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MgtPackage.ASSERTION__ASSERT:
        setAssert((String)newValue);
        return;
      case MgtPackage.ASSERTION__VERDICT:
        setVerdict((Verdict)newValue);
        return;
      case MgtPackage.ASSERTION__EXPECTED:
        setExpected((TestDate)newValue);
        return;
      case MgtPackage.ASSERTION__ACTUAL:
        setActual((Keyword)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MgtPackage.ASSERTION__ASSERT:
        setAssert(ASSERT_EDEFAULT);
        return;
      case MgtPackage.ASSERTION__VERDICT:
        setVerdict(VERDICT_EDEFAULT);
        return;
      case MgtPackage.ASSERTION__EXPECTED:
        setExpected((TestDate)null);
        return;
      case MgtPackage.ASSERTION__ACTUAL:
        setActual((Keyword)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MgtPackage.ASSERTION__ASSERT:
        return ASSERT_EDEFAULT == null ? assert_ != null : !ASSERT_EDEFAULT.equals(assert_);
      case MgtPackage.ASSERTION__VERDICT:
        return verdict != VERDICT_EDEFAULT;
      case MgtPackage.ASSERTION__EXPECTED:
        return expected != null;
      case MgtPackage.ASSERTION__ACTUAL:
        return actual != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (assert: ");
    result.append(assert_);
    result.append(", verdict: ");
    result.append(verdict);
    result.append(')');
    return result.toString();
  }

} //AssertionImpl
