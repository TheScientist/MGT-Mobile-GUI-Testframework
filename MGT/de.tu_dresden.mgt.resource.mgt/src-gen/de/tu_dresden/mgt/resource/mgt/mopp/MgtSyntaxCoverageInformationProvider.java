/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.mopp;

public class MgtSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getUIElementLocator(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequentialStep(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getInteger(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getBoolean(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getString(),
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getFloat(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(),
		};
	}
	
}
