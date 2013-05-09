package de.tu_dresden.mgt.androidadapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.tu_dresden.mgt.AbstractTestStep;
import de.tu_dresden.mgt.Assertion;
import de.tu_dresden.mgt.Keyword;
import de.tu_dresden.mgt.Sequence;
import de.tu_dresden.mgt.SequentialStep;
import de.tu_dresden.mgt.TestCase;
import de.tu_dresden.mgt.TestDate;
import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.androidadapter.java.Class;
import de.tu_dresden.mgt.androidadapter.java.Method;
import de.tu_dresden.mgt.androidadapter.java.Statement;

public class TestRunner {

	public static final Logger logger = Logger.getLogger(TestRunner.class);
	private static final String CLEANDEBUG = "ant clean debug";
	private static final String INSTALL = "ant installd";
	private static String TEST = "adb shell am instrument -w -e " + "class %s "
			+ "%s.tests/android.test.InstrumentationTestRunner";

	private Class testClass;
	private TestSuite suite;
	private Properties properties;

	public TestRunner(TestSuite suite, Properties properties) {
		initLogger();
		this.properties = properties;
		this.suite = suite;
		// Build Testclass
		testClass = new Class(suite.getName());
		testClass
				.setTargetActivity(getStartActivity(suite.getSystemUnderTest()));
		for (Sequence seq : suite.getSequences()) {
			Method method = new Method(seq.getName());
			for (AbstractTestStep step : seq.getSteps()) {
				method.addStatement(new Statement(handleStep(step, method,
						testClass), step));
			}
			testClass.addMethod(method);
		}
		for (TestCase testMethod : suite.getTestCases()) {
			Method method = new Method("test" + testMethod.getName());
			for (AbstractTestStep step : testMethod.getTestSteps()) {
				method.addStatement(new Statement(handleStep(step, method,
						testClass), step));
			}
			testClass.addMethod(method);
		}
	}

	public TestSuite run() {
		MessageConsole myConsole = findConsole("MGT Runner");
		MessageConsoleStream console = myConsole.newMessageStream();

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(suite.getSystemUnderTest());
		String autPath = project.getLocation().toString();
		String workspace = autPath.substring(0, autPath.lastIndexOf("/"));
		String testProject = "/" + suite.getSystemUnderTest() + "Test";
		File exisingProject = new File(workspace + testProject);
		try {
			String buildAut = properties.getProperty("buildAut");

			if (buildAut != null && buildAut.equals("true")) {
				// update project under test
				String cmd = "android update project --path .";
				console.println("Update app under test...");
				if (!runCommand(cmd, autPath, null))
					console.println("Update failed! See log for more informations.");
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
			// create test project
			if (!exisingProject.exists() && !exisingProject.isDirectory()) {
				String args0 = "android create test-project -m ../"
						+ suite.getSystemUnderTest() + " -n "
						+ testProject.substring(1) + " -p "
						+ testProject.substring(1);
				console.println("Creating test project...");
				if (!runCommand(args0, workspace, null))
					console.println("Creation failed! See log for more informations.");
			} // else update project?
			else {
				String cmd2 = "android update test-project -m ../"
						+ suite.getSystemUnderTest() + " -p .";
				console.println("Update test project...");
				if (!runCommand(cmd2, workspace + testProject, null)) {
					console.println("Update failed! See log for more informations.");
				}
			}
			// move Testclass, add robotium Libs
			String jUnitFilePath = testClass
					.printJUnitFile(workspace + testProject + "/src/"
							+ testClass.getTargetPackage().replace(".", "/")
							+ "/test/");
			moveRobotiumLibsIntoProject(workspace + testProject);

			if (buildAut.equalsIgnoreCase("true")) {
				console.println("Build app under test...");
				if (runCommand(CLEANDEBUG, autPath, null)) {
					console.println("Install app under test...");
					if (!runCommand(INSTALL, autPath, null))
						console.println("Installation failed! See log for more informations.");
				} else {
					console.println("Build failed! See log for more informations.");
				}
			}
			console.println("Build test project...");
			if (runCommand(CLEANDEBUG, workspace + testProject, null)) {
				console.println("Install test project...");
				if (!runCommand(INSTALL, workspace + testProject, null)) {
					console.println("Installation failed! See log for more informations.");
					console.println("Test execution stopped.");
				} else {
					console.println("________________");
					console.println("Running tests...");
					runCommand(TEST, workspace + testProject, jUnitFilePath);
				}
			} else {
				console.println("Build failed! See log for more informations.");
			}
		} catch (Exception e) {
			logger.error(e.toString());
			for (StackTraceElement elem : e.getStackTrace()) {
				logger.error("\t" + elem.toString());
			}
			console.println("An error occured. See log file for infomation.");
		}
		return null;
	}

	private void initLogger() {
		MessageConsole myConsole = findConsole("MGT Runner");
		myConsole.clearConsole();
		MessageConsoleStream console = myConsole.newMessageStream();
		final String logLocation = System.getProperty("user.home")
				+ File.separator + "MGT" + File.separator + "mgtLog.log";
		Logger.getRootLogger().setLevel(Level.ERROR);
		logger.setLevel(Level.ALL);
		try {
			BasicConfigurator.configure(new FileAppender(new PatternLayout(
					"[%-5p] %c{1} : %m%n"), logLocation, false));
			console.println("Using Logfile " + logLocation);
		} catch (IOException e) {
			logger.error(e.toString());
		}
	}

	private void moveRobotiumLibsIntoProject(String path) {
		String target = path + "/libs/robotium-solo-4-1.jar";
		File exists = new File(target);
		if (!exists.exists()) {
			new File(target).getParentFile().mkdirs();
			try {
				URL url = new URL(
						"platform:/plugin/de.tu-dresden.mgt.AndroidAdapter/lib/robotium-solo-4.1.jar");
				InputStream inputStream = url.openConnection().getInputStream();

				// InputStream inputStream =
				// this.getClass().getResourceAsStream("robotium-solo-4.1.jar");
				if (inputStream != null) {
					File f = new File(target);
					OutputStream out = new FileOutputStream(f);
					byte buf[] = new byte[1024];
					int len;
					while ((len = inputStream.read(buf)) > 0)
						out.write(buf, 0, len);
					out.close();
					inputStream.close();
				} else {
					throw new MissingResourceException("Resource not found",
							"TestRunner", "robotium-solo-4.1.jar");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String soloPath = path + "/src/de/tud/mgt/SoloId.java";
		new File(soloPath).getParentFile().mkdirs();
		try {
			URL url = new URL(
					"platform:/plugin/de.tu-dresden.mgt.AndroidAdapter/lib/SoloId.java");
			InputStream inputStream = url.openConnection().getInputStream();

			// InputStream inputStream =
			// this.getClass().getResourceAsStream("robotium-solo-4.1.jar");
			if (inputStream != null) {
				File f = new File(soloPath);
				f.createNewFile();
				OutputStream out = new FileOutputStream(f);
				byte buf[] = new byte[1024];
				int len;
				while ((len = inputStream.read(buf)) > 0)
					out.write(buf, 0, len);
				out.close();
				inputStream.close();
			} else {
				throw new MissingResourceException("Resource not found",
						"SoloId", "SoloId.java");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean runCommand(String command, String directory,
			String jUnitFile) throws IOException {
		if (command == null || command.isEmpty()) {
			return false;
		}
		boolean test = false;
		if (command.equals(TEST)) {
			command = String.format(TEST, this.testClass.getTargetPackage()
					+ ".test." + suite.getName(),
					this.testClass.getTargetPackage());
			test = true;
		}
		ProcessBuilder pb;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			pb = new ProcessBuilder("cmd", "/c", command);
		} else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
			pb = new ProcessBuilder("bash", "-c", command);
		} else {
			logger.error("Your OS is not supported! Contact Developer.");
			return false;
		}

		pb.redirectErrorStream(true);
		if (directory != null)
			pb.directory(new File(directory));
		Process process = pb.start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		logger.info("Executing: " + command);
		boolean ret = true;
		if (test) {
			CmdRunner run = new CmdRunner(suite, testClass);
			run.readTestExec(br, jUnitFile);
		} else {
			while ((line = br.readLine()) != null) {
				logger.trace(line);
				// out.println(line);
				if (line.contains("BUILD FAILED"))
					ret = false;
			}
		}
		return ret;
	}

	private String handleStep(AbstractTestStep step, Method method,
			Class testClass) {
		if (step instanceof Keyword) {
			return handleKeyword((Keyword) step, testClass);
		} else if (step instanceof Assertion) {
			return handleAssertion((Assertion) step, testClass);
		} else if (step instanceof SequentialStep) {
			return handleSequentialStep((SequentialStep) step);
		} else {
			return "";
		}
	}

	private String handleSequentialStep(SequentialStep step) {
		String statement = step.getSequence().getName() + "()";
		return statement;
	}

	private String handleAssertion(Assertion step, Class testClass) {
		String statement = step.getAssert() + "(";
		if (step.getExpected() != null) {
			statement += handleDate(step.getExpected()) + ", ";
		}
		statement += handleKeyword(step.getActual(), testClass);

		return statement + ")";
	}

	private String handleKeyword(Keyword step, Class testClass) {
		String statement = "solo.";
		statement += step.getName() + "(";
		if (step.getTarget() != null) {
			String locator = step.getTarget().getId();
			if (locator != null && locator.length() > 0) {
				String autPackage = testClass.getTargetPackage();
				statement = statement + autPackage + ".R.id."
						+ step.getTarget().getId();
			}

		}
		EList<TestDate> data = step.getTestData();
		if (data != null && data.size() > 0) {
			for (TestDate date : data) {
				if (!statement.endsWith("(") && !statement.endsWith(", ")) {
					statement += ", ";
				}
				statement += handleDate(date);
			}
		}
		return statement += ")";
	}

	private String handleDate(TestDate date) {
		if (date instanceof de.tu_dresden.mgt.String) {
			return "\"" + ((de.tu_dresden.mgt.String) date).getDataValue()
					+ "\"";
		} else if (date instanceof de.tu_dresden.mgt.Integer) {
			return ((de.tu_dresden.mgt.Integer) date).getDataValue() + "";
		} else if (date instanceof de.tu_dresden.mgt.Boolean) {
			return (((de.tu_dresden.mgt.Boolean) date).isDataValue()) ? "true"
					: "false";
		} else {
			return "";
		}
	}

	private String getStartActivity(String aut) {
		String ret = null;

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(aut);

		if (project == null || !project.exists()) {
			return null;
		}
		IFile manifest = project.getFile("AndroidManifest.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document dom = db.parse(manifest.getContents());
			Element root = dom.getDocumentElement();
			root.normalize();
			String autPackage = root.getAttribute("package");
			Node application = root.getElementsByTagName("application").item(0);
			NodeList activities = application.getChildNodes();
			// Activities
			for (int s = 0; s < activities.getLength(); s++) {
				Node node = activities.item(s);
				if (node.getNodeType() == Node.ELEMENT_NODE
						&& node.getNodeName().equals("activity")) {
					Element activity = (Element) node;
					if (activity.hasChildNodes()) {
						// Intent-filter
						NodeList intentFilters = activity.getChildNodes();
						for (int i = 0; i < intentFilters.getLength(); i++) {
							Node intent = intentFilters.item(i);
							if (intent.getNodeType() == Node.ELEMENT_NODE
									&& intent.getNodeName().equals(
											"intent-filter")) {
								Element intentFilter = (Element) intent;
								if (intentFilter.hasChildNodes()) {
									NodeList actions = intentFilter
											.getChildNodes();
									for (int j = 0; j < actions.getLength(); j++) {
										Node node2 = actions.item(j);
										if (node2.getNodeType() == Node.ELEMENT_NODE
												&& node2.getNodeName().equals(
														"action")) {
											Element action = (Element) node2;
											if (action
													.getAttribute(
															"android:name")
													.equals("android.intent.action.MAIN")) {
												String mainActivity = activity
														.getAttribute("android:name");
												if (mainActivity
														.startsWith("."))
													return autPackage
															+ mainActivity;
												else
													return mainActivity;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return ret;
	}

	public static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
}
