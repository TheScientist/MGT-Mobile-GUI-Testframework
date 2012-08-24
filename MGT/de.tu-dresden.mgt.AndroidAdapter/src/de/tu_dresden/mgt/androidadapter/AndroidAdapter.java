package de.tu_dresden.mgt.androidadapter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.adapter.IAdapter;
import de.tud.mgt.SoloId;


public class AndroidAdapter implements IAdapter{

	public String getAdapterName() {
		return "androidAdapter";
	}
	
	public Set<String> getAssertionProposals() {
		Set<String> assertions = new HashSet<String>();
		try {
			Class<?> jUnitAssert = this.getClass().getClassLoader().loadClass("junit.framework.Assert");
			Method[] methods = jUnitAssert.getDeclaredMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("assert"))
					assertions.add(m.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return assertions;
	}

	public Set<String> getElementIds(String aut) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(aut);
		if(project == null || !project.exists()) {
			return new HashSet<String>();
		}
		HashSet<String> proposals = new HashSet<String>();
		try {
			project.members();
			IFolder layoutDir = project.getFolder("res/layout");
			for(IResource layoutRes : layoutDir.members()) {
				if(!(layoutRes instanceof IFile)) 
					continue;
				IFile layout = (IFile) layoutRes;
				if(!layout.getFileExtension().equals("xml"))
					continue;
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db;
				try {
					db = dbf.newDocumentBuilder();
					Document dom = db.parse(layout.getContents());
					Element root = dom.getDocumentElement();
					root.normalize();
					proposals.addAll(parseXmlRecursive(root));
					
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return proposals;
		} catch (CoreException e) {
			e.printStackTrace();
			return proposals;
		}
	}
	
	/**
	 * Go through all elements recursive and get their ids.
	 * @param root Root element of xml.
	 * @return List of element's id's.
	 */
	private Collection<? extends String> parseXmlRecursive(Element root) {
		HashSet<String> proposals = new HashSet<String>();
		NodeList nodeLst = root.getChildNodes();
		for (int s = 0; s < nodeLst.getLength(); s++) {
		    Node node = nodeLst.item(s);
		    if (node.getNodeType() == Node.ELEMENT_NODE) {		  
		    	Element widget = (Element) node;
		    	//String widgetName = widget.getLocalName();
		    	//viewgroups ausschließen
		    	if(widget.hasAttribute("android:id")) {
			    	String idString = widget.getAttribute("android:id");
			    	proposals.add(idString.substring(5));
		    	}
		    	proposals.addAll(parseXmlRecursive(widget));
		    }
		}
		return proposals;
	}

	public TestSuite runTest(TestSuite suite, Properties props) {
		TestRunner runner = new TestRunner(suite, props);
		return runner.run();
	}

	public Collection<String> getKeywords() {
		Collection<String> keywords = new HashSet<String>();
		try {
//			Class<?> solo = this.getClass().getClassLoader().loadClass("com.jayway.android.robotium.solo.Solo");
			Class<?> soloID = this.getClass().getClassLoader().loadClass("de.tud.mgt.SoloId");
			Method[] methods = soloID.getMethods();
			List<Class<?>> allowedReturns = new LinkedList<Class<?>>();
			allowedReturns.add(String.class);
			allowedReturns.add(int.class);
			allowedReturns.add(boolean.class);
			allowedReturns.add(float.class);
			allowedReturns.add(void.class);
			for(Method m : methods) {
				if(m.getModifiers() == Modifier.PUBLIC && allowedReturns.contains(m.getReturnType())) {
					String kw = m.getName() + " ";
					Class<?>[] params = m.getParameterTypes();
					for(int i=0; i<params.length; i++) {
						Class<?> theParam = params[i];
						if(theParam.getSimpleName().equals("int") || theParam.getSimpleName().equals("long")) {
							if(i == 0 && !theParam.getSimpleName().equals("long") && m.getDeclaringClass() == SoloId.class)
								kw += ": id " + " ";
							else
								kw += ": " + 0 + " ";
						} else if(theParam.getSimpleName().equals("String")) {
							kw += ": \"\" ";
						} else if(theParam.getSimpleName().equals("float")) {
							kw += ": 0.0 ";
						} else if(theParam.getSimpleName().equals("boolean")) {
							kw += ": true ";
						} else {
							kw = "";
							continue;
						}	
					}
					keywords.add(kw.substring(0, kw.length()));
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		for(String key : keywords) {
//			System.out.println(key);
//		}
		return keywords;
	}
}
