package de.tu_dresden.mgt.dummyAdapter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.adapter.IAdapter;


public class DummyAdapter implements IAdapter{

	@Override
	public String getAdapterName() {
		return "dummyAdapter";
	}
	
	/*@Override
	public String[] getEventProposals(String target) {
		return new String[]{"writeText()", "getText()"};
	}

	@Override
	public String[] getTargetProposals() {
		return new String[]{"Button(name: ok)", "TextField"};
	}*/
	
	@Override
	public Set<String> getAssertionProposals() {
		HashSet<String> proposals = new HashSet<String>();
		proposals.add("Assert.asserTrue(message condition)");
		proposals.add("Assert.assertEquals(actual expected)");
		return proposals;
	}

	@Override
	public Set<String> getElementIds(String sut) {
		HashSet<String> proposals = new HashSet<String>();
		proposals.add("id:button0");
		proposals.add("id:button1");
		return proposals;
	}

	@Override
	public TestSuite runTest(TestSuite suite, Properties properties) {
		return suite;
	}

	@Override
	public Collection<String> getKeywords() {
		Collection<String> keywords = new HashSet<String>();
		keywords.add("keyword1");
		keywords.add("keyword2");
		return keywords;
	}
}
