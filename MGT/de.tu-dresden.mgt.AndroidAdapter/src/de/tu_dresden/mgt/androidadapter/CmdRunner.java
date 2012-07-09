package de.tu_dresden.mgt.androidadapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.tu_dresden.mgt.AbstractTestStep;
import de.tu_dresden.mgt.Assertion;
import de.tu_dresden.mgt.Keyword;
import de.tu_dresden.mgt.SequentialStep;
import de.tu_dresden.mgt.TestDate;
import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.Verdict;

public class CmdRunner {

	private TestSuite suite;
	private de.tu_dresden.mgt.androidadapter.java.Class testClass;
	private Logger logger;
	
	public CmdRunner(TestSuite suite, de.tu_dresden.mgt.androidadapter.java.Class testClass) {
		logger = Logger.getLogger(TestRunner.class);
		this.suite = suite;
		this.testClass = testClass;
	}
	
	private String generateCsvFile(HashMap<Verdict, Integer> stats) {
		try {
			String filename = System.getProperty("user.dir") + File.separator + "testResults.csv";
			File file = new File(filename);
			FileWriter writer = new FileWriter(filename);
			if(file.exists()) {
				writer.append("Date");
				writer.append(',');
				writer.append("PASS");
				writer.append(',');
				writer.append("ERROR");
				writer.append(',');
				writer.append("FAIL");
				writer.append(',');
				writer.append("INCONCLUSIVE");
				writer.append('\n');
			}			

			writer.append(new Date().toString());
			writer.append(',');
			writer.append(stats.get(Verdict.PASS)+"");
			writer.append(',');
			writer.append(stats.get(Verdict.ERROR)+"");
			writer.append(',');
			writer.append(stats.get(Verdict.FAIL)+"");
			writer.append(',');
			writer.append(stats.get(Verdict.INCONCLUSIVE)+"");
			writer.append('\n');

			writer.flush();
			writer.close();
			
			return filename;
		} catch (IOException e) {
			Logger.getLogger(this.getClass()).error("Error writing results to file.");
		}
		return "";
	}
	
	public void readTestExec(BufferedReader br, String filename) throws IOException {
		String line;
		MessageConsole myConsole = TestRunner.findConsole("MGT Runner");
		MessageConsoleStream console = myConsole.newMessageStream();
		HashMap<Integer, AbstractTestStep> mapping = testClass.getMapping();
		if(mapping == null) {
			console.println("Errors can not be mapped. See logFile");
		}
		HashMap<Verdict, Integer> stats = new HashMap<Verdict, Integer>();
		stats.put(Verdict.ERROR, 0);
		stats.put(Verdict.FAIL, 0);
		stats.put(Verdict.INCONCLUSIVE, 0);
		stats.put(Verdict.PASS, 0);
		
		boolean error = false;
		String failedMethod = "";
		while ((line = br.readLine()) != null) {
			logger.trace(line);
			if(line.contains("Failure in")) {
				error = true;
				failedMethod = line.substring(line.indexOf("Failure in ") + 11, line.length()-1);
				logger.warn("Found error in " + failedMethod);
			} 
			if(error && line.contains("at " + testClass.getTargetPackage() + ".test." + suite.getName())) {
				int theBadLine = Integer.parseInt(line.substring(
									line.lastIndexOf(":") + 1, line.length()-1));
				AbstractTestStep badStep = mapping.get(theBadLine);
				String verdict;
				if(badStep != null && badStep instanceof Assertion) {
					Assertion assertion = (Assertion) badStep;
					if(assertion.getVerdict() != null) {
						stats.put(assertion.getVerdict(), stats.get(assertion.getVerdict())+1);
						verdict = "[" + assertion.getVerdict().getName().toUpperCase() + "]";
					} else {
						stats.put(Verdict.FAIL, stats.get(Verdict.FAIL)+1);
						verdict = "[FAIL]";
					}
				} else {
					stats.put(Verdict.ERROR, stats.get(Verdict.ERROR)+1);
					verdict = "[ERROR]";
				}
				console.println(verdict + " Failure in Testcase " + failedMethod.substring(4) + " at Teststep "); 
				console.println("\t" + interpreteFailedStep(badStep));
				error = false;
			}
		}
		int sum = 0;
		for(Integer i : stats.values()) {
		  sum += i;
		}
		stats.put(Verdict.PASS, stats.get(Verdict.PASS) + suite.getTestCases().size()-sum);
		console.println();
		console.println("Testrun completed:");
		console.println("PASS: " + stats.get(Verdict.PASS));
		console.println("FAIL: " + stats.get(Verdict.FAIL));
		console.println("ERROR: " + stats.get(Verdict.ERROR));
		console.println("INCONCLUSIVE: " + stats.get(Verdict.INCONCLUSIVE));
		generateCsvFile(stats);
	}

	private String interpreteFailedStep(AbstractTestStep badStep) {
		String out;
		if(badStep instanceof Keyword) {
			Keyword key = (Keyword) badStep;
			out = key.getName();
			if(key.getTarget()!=null) 
				out += " : id " + key.getTarget().getId();
			if(key.getTestData() != null && key.getTestData().size() > 0) {
				out += " : ";
				for(TestDate date : key.getTestData()) {
					out += testDateToString(date) + ", ";
				}
				out = out.substring(0, out.length()-2);
			}
			return out;
		} else if(badStep instanceof SequentialStep) {
			SequentialStep seq = (SequentialStep) badStep;
			return seq.getSequence().getName();			
		} else if(badStep instanceof Assertion) {
			Assertion ass = (Assertion) badStep;
			out = "ASSERT " + ass.getAssert() + "(";
			Keyword key = ass.getActual();
			out += key.getName();
			if(key.getTarget()!=null) 
				out += " : id " + key.getTarget().getId();
			if(key.getTestData() != null && key.getTestData().size() > 0) {
				out += " : ";
				for(TestDate date : key.getTestData()) {
					out += testDateToString(date) + ", ";
				}
				out = out.substring(0, out.length()-2);
			}
			if(ass.getExpected() != null) {
				out += ", " + ass.getExpected().toString();
			}
			out += ")";
			if(ass.getVerdict() != null) {
				out+= " : " + ass.getVerdict().getName();
			}
			return out;
		} else
			return "impossible";
	}
	
	private String testDateToString(TestDate date) {
		if(date instanceof de.tu_dresden.mgt.String) {
			return ((de.tu_dresden.mgt.String) date).getDataValue();
		} else if(date instanceof de.tu_dresden.mgt.Integer) {
			return ((de.tu_dresden.mgt.Integer) date).getDataValue() + "";
		} else if(date instanceof de.tu_dresden.mgt.Float) {
			return ((de.tu_dresden.mgt.Float) date).getDataValue() + "";
		} else {
			if(((de.tu_dresden.mgt.Boolean) date).isDataValue()) {
				return "true";
			} else {
				return "false";
			}
		}
	}
}
