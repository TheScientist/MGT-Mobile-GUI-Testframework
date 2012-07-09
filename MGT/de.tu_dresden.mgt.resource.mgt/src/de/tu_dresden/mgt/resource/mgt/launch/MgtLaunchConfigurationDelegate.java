/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.launch;

import java.util.Properties;

import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.adapter.AdapterUtils;
import de.tu_dresden.mgt.adapter.IAdapter;

/**
 * A class that handles launch configurations.
 */
public class MgtLaunchConfigurationDelegate extends org.eclipse.debug.core.model.LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	public final static String ATTR_RESOURCE_PROPS = "props";
	
	
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		MgtLaunchConfigurationHelper helper = new MgtLaunchConfigurationHelper(); 
		
		Properties props = new Properties();
		String text = configuration.getAttribute(ATTR_RESOURCE_PROPS, "");
		String[] splitted = text.split(System.getProperty("line.separator"));
		for(String prop : splitted) {
			String[] keyValue = prop.split("=");
			if(keyValue.length == 2)
				props.put(keyValue[0].trim(), keyValue[1].trim());
		}
		
		TestSuite root = (TestSuite) helper.getModelRoot(configuration);
		// replace this delegate with your actual interpreter
		//SystemOutInterpreter delegate = new SystemOutInterpreter();
		IAdapter currAdapter = AdapterUtils.getCurrentAdapterFromModel(root);
		@SuppressWarnings("unused")
		TestSuite result = currAdapter.runTest((TestSuite) root, props);
		//TODO write results to model.		
	}
	
}
