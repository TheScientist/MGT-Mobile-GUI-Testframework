package de.tu_dresden.mgt.adapter;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;

import de.tu_dresden.mgt.impl.TestSuiteImpl;

/**
 * Class that provides some utility funtions for adapter handling
 * @author scientist *
 */
public class AdapterUtils {
	
	/**
	 * Hide construcor of Utility class. Not needed.
	 */
	private AdapterUtils() {};
	
	public static IAdapter getCurrentAdapterFromModel(EObject container) {
		IAdapter adapter = null;
		EObject tempContainer = container;
		String contClass = container.getClass().getSimpleName();
		while(!contClass.equals("TestSuiteImpl")) {
			tempContainer = tempContainer.eContainer();
			contClass = tempContainer.getClass().getSimpleName();
		}
		TestSuiteImpl suite = (TestSuiteImpl) tempContainer;
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("de.tu_dresden.mgt.adapter");
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof IAdapter) {
					IAdapter tempAdapter = (IAdapter) o;
					if(tempAdapter.getAdapterName().equals(suite.getAdapter())) {
						adapter = tempAdapter;
						return adapter;
					}
				}
			}
		} catch (CoreException ex) {
			//System.out.println(ex.getMessage());
		}
		return adapter;
	}
	
	/**
	 * Get possible Adapters plugged into Eclipse.
	 * @return
	 */
	public static Set<String> getAdapterProposals() {
		Set<String> ret = new HashSet<String>();
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("de.tu_dresden.mgt.adapter");
		try {
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof IAdapter) {
					IAdapter tempAdapter = (IAdapter) o;
					ret.add(tempAdapter.getAdapterName());
				}
			}
		} catch (CoreException ex) {
			//System.out.println(ex.getMessage());
		}
		return ret;
	}

	public static String getAppUnderTest(EObject container) {
		EObject tempContainer = container;
		String contClass = container.getClass().getSimpleName();
		while(!contClass.equals("TestSuiteImpl")) {
			tempContainer = tempContainer.eContainer();
			contClass = tempContainer.getClass().getSimpleName();
		}
		TestSuiteImpl suite = (TestSuiteImpl) tempContainer;
		return suite.getSystemUnderTest();
	}
}
