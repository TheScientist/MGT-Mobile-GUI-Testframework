package de.tu_dresden.mgt.adapter;

import java.util.Collection;
import java.util.Properties;
import java.util.Set;

import de.tu_dresden.mgt.TestSuite;

/**
 * This interface defines all necessary functions needed by the extensionpoint 'de.tu_dresden.mgt.adapter'.
 * Extensions filling this ext. point need to implement this interface.
 * @author sprasse
 *
 */
public interface IAdapter {
	/**
	 * Returns the name of this adapter.
	 * @return Name of this adapter.
	 */
	String getAdapterName();
	
	/**
	 * Get all names of assertions that can be used in a TestCase.
	 * @return Set containing assertion method-skeletons.
	 */
	Set<String> getAssertionProposals();
	
	/**
	 * Computes a number of strings that can be used as ids for Widgets in a TestCase.
	 * @return Set containing id's of the AUT widgets.
	 */
	Set<String> getElementIds(String aut);
	
	/**
	 * Runs a mgt test and returns the result as a verdict.
	 * @param suite Test Suite to run.
	 * @param props 
	 * @return TestSuite with results of test run.
	 */
	TestSuite runTest(TestSuite suite, Properties props);

	/**
	 * Gets keywords of Adapter.
	 * @return Collecion of keywords.
	 */
	Collection<String> getKeywords();
}
