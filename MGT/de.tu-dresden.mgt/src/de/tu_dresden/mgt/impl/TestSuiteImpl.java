/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt.impl;

import de.tu_dresden.mgt.MgtPackage;
import de.tu_dresden.mgt.Sequence;
import de.tu_dresden.mgt.TestCase;
import de.tu_dresden.mgt.TestSuite;

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
 * An implementation of the model object '<em><b>Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.tu_dresden.mgt.impl.TestSuiteImpl#getSystemUnderTest <em>System Under Test</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestSuiteImpl#getAdapter <em>Adapter</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestSuiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestSuiteImpl#getTestCases <em>Test Cases</em>}</li>
 *   <li>{@link de.tu_dresden.mgt.impl.TestSuiteImpl#getSequences <em>Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestSuiteImpl extends EObjectImpl implements TestSuite
{
  /**
   * The default value of the '{@link #getSystemUnderTest() <em>System Under Test</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemUnderTest()
   * @generated
   * @ordered
   */
  protected static final String SYSTEM_UNDER_TEST_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSystemUnderTest() <em>System Under Test</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSystemUnderTest()
   * @generated
   * @ordered
   */
  protected String systemUnderTest = SYSTEM_UNDER_TEST_EDEFAULT;

  /**
   * The default value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdapter()
   * @generated
   * @ordered
   */
  protected static final String ADAPTER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdapter() <em>Adapter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdapter()
   * @generated
   * @ordered
   */
  protected String adapter = ADAPTER_EDEFAULT;

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
   * The cached value of the '{@link #getTestCases() <em>Test Cases</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestCases()
   * @generated
   * @ordered
   */
  protected EList<TestCase> testCases;

  /**
   * The cached value of the '{@link #getSequences() <em>Sequences</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequences()
   * @generated
   * @ordered
   */
  protected EList<Sequence> sequences;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestSuiteImpl()
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
    return MgtPackage.Literals.TEST_SUITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSystemUnderTest()
  {
    return systemUnderTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSystemUnderTest(String newSystemUnderTest)
  {
    String oldSystemUnderTest = systemUnderTest;
    systemUnderTest = newSystemUnderTest;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST, oldSystemUnderTest, systemUnderTest));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdapter()
  {
    return adapter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdapter(String newAdapter)
  {
    String oldAdapter = adapter;
    adapter = newAdapter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.TEST_SUITE__ADAPTER, oldAdapter, adapter));
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
      eNotify(new ENotificationImpl(this, Notification.SET, MgtPackage.TEST_SUITE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TestCase> getTestCases()
  {
    if (testCases == null)
    {
      testCases = new EObjectContainmentEList<TestCase>(TestCase.class, this, MgtPackage.TEST_SUITE__TEST_CASES);
    }
    return testCases;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Sequence> getSequences()
  {
    if (sequences == null)
    {
      sequences = new EObjectContainmentEList<Sequence>(Sequence.class, this, MgtPackage.TEST_SUITE__SEQUENCES);
    }
    return sequences;
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
      case MgtPackage.TEST_SUITE__TEST_CASES:
        return ((InternalEList<?>)getTestCases()).basicRemove(otherEnd, msgs);
      case MgtPackage.TEST_SUITE__SEQUENCES:
        return ((InternalEList<?>)getSequences()).basicRemove(otherEnd, msgs);
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
      case MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST:
        return getSystemUnderTest();
      case MgtPackage.TEST_SUITE__ADAPTER:
        return getAdapter();
      case MgtPackage.TEST_SUITE__NAME:
        return getName();
      case MgtPackage.TEST_SUITE__TEST_CASES:
        return getTestCases();
      case MgtPackage.TEST_SUITE__SEQUENCES:
        return getSequences();
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
      case MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST:
        setSystemUnderTest((String)newValue);
        return;
      case MgtPackage.TEST_SUITE__ADAPTER:
        setAdapter((String)newValue);
        return;
      case MgtPackage.TEST_SUITE__NAME:
        setName((String)newValue);
        return;
      case MgtPackage.TEST_SUITE__TEST_CASES:
        getTestCases().clear();
        getTestCases().addAll((Collection<? extends TestCase>)newValue);
        return;
      case MgtPackage.TEST_SUITE__SEQUENCES:
        getSequences().clear();
        getSequences().addAll((Collection<? extends Sequence>)newValue);
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
      case MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST:
        setSystemUnderTest(SYSTEM_UNDER_TEST_EDEFAULT);
        return;
      case MgtPackage.TEST_SUITE__ADAPTER:
        setAdapter(ADAPTER_EDEFAULT);
        return;
      case MgtPackage.TEST_SUITE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case MgtPackage.TEST_SUITE__TEST_CASES:
        getTestCases().clear();
        return;
      case MgtPackage.TEST_SUITE__SEQUENCES:
        getSequences().clear();
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
      case MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST:
        return SYSTEM_UNDER_TEST_EDEFAULT == null ? systemUnderTest != null : !SYSTEM_UNDER_TEST_EDEFAULT.equals(systemUnderTest);
      case MgtPackage.TEST_SUITE__ADAPTER:
        return ADAPTER_EDEFAULT == null ? adapter != null : !ADAPTER_EDEFAULT.equals(adapter);
      case MgtPackage.TEST_SUITE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case MgtPackage.TEST_SUITE__TEST_CASES:
        return testCases != null && !testCases.isEmpty();
      case MgtPackage.TEST_SUITE__SEQUENCES:
        return sequences != null && !sequences.isEmpty();
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
    result.append(" (systemUnderTest: ");
    result.append(systemUnderTest);
    result.append(", adapter: ");
    result.append(adapter);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TestSuiteImpl
