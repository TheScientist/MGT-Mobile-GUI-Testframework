/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tu_dresden.mgt.util;

import de.tu_dresden.mgt.MgtPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MgtXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MgtXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    MgtPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the MgtResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new MgtResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new MgtResourceFactoryImpl());
    }
    return registrations;
  }

} //MgtXMLProcessor
