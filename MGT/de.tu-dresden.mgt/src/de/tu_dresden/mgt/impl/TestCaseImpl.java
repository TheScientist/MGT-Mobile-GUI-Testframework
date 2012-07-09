/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt.impl;

import de.tu_dresden.mgt.AbstractTestStep;
import de.tu_dresden.mgt.MgtPackage;
import de.tu_dresden.mgt.TestCase;
import de.tu_dresden.mgt.Verdict;

import java.lang.String;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.impl.TestCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestCaseImpl#getTestSteps <em>Test Steps</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestCaseImpl#getVerdict <em>Verdict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestCaseImpl extends EObjectImpl implements TestCase
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getTestSteps() <em>Test Steps</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestSteps()
   * @generated
   * @ordered
   */
  protected EList<AbstractTestStep> testSteps;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestCaseImpl()
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
    return MgtPackage.Literals.TEST_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.TEST_CASE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractTestStep> getTestSteps()
  {
    if (testSteps == null)
    {
      testSteps = new EObjectContainmentEList<AbstractTestStep>(AbstractTestStep.class, this, MgtPackage.TEST_CASE__TEST_STEPS);
    }
    return testSteps;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.TEST_CASE__VERDICT, oldVerdict, verdict));
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
      case MgtPackage.TEST_CASE__TEST_STEPS:
        return ((InternalEList<?>)getTestSteps()).basicRemove(otherEnd, msgs);
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
      case MgtPackage.TEST_CASE__NAME:
        return getName();
      case MgtPackage.TEST_CASE__TEST_STEPS:
        return getTestSteps();
      case MgtPackage.TEST_CASE__VERDICT:
        return getVerdict();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MgtPackage.TEST_CASE__NAME:
        setName((String)newValue);
        return;
      case MgtPackage.TEST_CASE__TEST_STEPS:
        getTestSteps().clear();
        getTestSteps().addAll((Collection<? extends AbstractTestStep>)newValue);
        return;
      case MgtPackage.TEST_CASE__VERDICT:
        setVerdict((Verdict)newValue);
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
      case MgtPackage.TEST_CASE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MgtPackage.TEST_CASE__TEST_STEPS:
        getTestSteps().clear();
        return;
      case MgtPackage.TEST_CASE__VERDICT:
        setVerdict(VERDICT_EDEFAULT);
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
      case MgtPackage.TEST_CASE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MgtPackage.TEST_CASE__TEST_STEPS:
        return testSteps != null && !testSteps.isEmpty();
      case MgtPackage.TEST_CASE__VERDICT:
        return verdict != VERDICT_EDEFAULT;
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
    result.append(" (name: ");
    result.append(name);
    result.append(", verdict: ");
    result.append(verdict);
    result.append(')');
    return result.toString();
  }

} //TestCaseImpl
