package de.tu_dresden.mgt.adapter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.tu_dresden.mgt.AbstractTestStep;
import de.tu_dresden.mgt.Assertion;
import de.tu_dresden.mgt.Keyword;
import de.tu_dresden.mgt.Sequence;
import de.tu_dresden.mgt.TestCase;
import de.tu_dresden.mgt.TestSuite;
import de.tu_dresden.mgt.resource.mgt.IMgtOptionProvider;
import de.tu_dresden.mgt.resource.mgt.IMgtOptions;
import de.tu_dresden.mgt.resource.mgt.IMgtResourcePostProcessor;
import de.tu_dresden.mgt.resource.mgt.IMgtResourcePostProcessorProvider;
import de.tu_dresden.mgt.resource.mgt.MgtEProblemType;
import de.tu_dresden.mgt.resource.mgt.mopp.MgtResource;

public class ValidateModel implements IMgtOptionProvider,
		IMgtResourcePostProcessorProvider, IMgtResourcePostProcessor {

	IAdapter adapter;
	String sut;
	Set<String> knownAssertions;		
	Set<String> knownIds;
	Collection<String> knownKeywords;
	
	public Map<?, ?> getOptions() {
		return Collections.singletonMap( 
			      IMgtOptions.RESOURCE_POSTPROCESSOR_PROVIDER, 
			      this 
			    ); 
	}

	public void process(MgtResource resource) {
		EList<EObject> objects = resource.getContents();
		for(EObject object : objects) {
			if (object instanceof TestSuite) {
				TestSuite suite = (TestSuite) object;
				validate(suite, resource);
			}
		}
	}

	/**
	 * Validate the suite
	 * @param suite
	 * @param resource 
	 */
	private void validate(TestSuite suite, MgtResource resource) {
		IAdapter suiteAdapter = AdapterUtils.getCurrentAdapterFromModel(suite);
		if(suiteAdapter == null) {
			resource.addWarning("Adapter not found", MgtEProblemType.ANALYSIS_PROBLEM, suite);
			return;
		} 
		boolean adapterChanged = false;
		if(adapter == null || !suiteAdapter.getAdapterName().equals(adapter.getAdapterName())) {
			adapter = suiteAdapter;
			knownAssertions = adapter.getAssertionProposals();		
			Collection<String> keys = adapter.getKeywords(); 
			knownKeywords = new HashSet<String>();
			for(String key : keys) {
				if(key.contains(":")) {
					knownKeywords.add(key.substring(0, key.indexOf(":")).trim());
				} else {
					knownKeywords.add(key.trim());
				}
			}
			adapterChanged = true;
		}
		String suiteSut = suite.getSystemUnderTest();
		if(sut == null || !sut.equals(suiteSut) || adapterChanged) {
			sut = suiteSut;
			knownIds = adapter.getElementIds(sut);
		}
		Set<Keyword> usedKeywords = new HashSet<Keyword>();
		HashMap<Keyword, String> usedIds = new HashMap<Keyword, String>();
				
		EList<Sequence> sequences = suite.getSequences();
		Set<String> knownSequences = new HashSet<String>();
		List<AbstractTestStep> allSteps = new LinkedList<AbstractTestStep>();
		for(Sequence s : sequences) {
			if(s.getName() != null) {
				knownSequences.add(s.getName());
			}
			allSteps.addAll(s.getSteps());
		}
		for(TestCase tCase : suite.getTestCases()) {
			allSteps.addAll(tCase.getTestSteps());
		}
		
		for(AbstractTestStep step : allSteps) {
			if(step instanceof Assertion) {
				Assertion ass = (Assertion) step;
				if(!knownAssertions.contains(ass.getAssert())) {
					resource.addWarning("Assertion '" + ass.getAssert() +"' not known by Adapter. Use Strg+Space for proposals.",
							MgtEProblemType.UNKNOWN, step);
				}
				if(ass.getActual() != null) 
					usedKeywords.add(ass.getActual());
//			} else if(step instanceof SequentialStep) {
//				SequentialStep seq = (SequentialStep) step;
//				if(knownSequences.contains(seq.getSequence().getName())) {
//					resource.addWarning("Assertion not known by Adapter. Use Strg+Space for proposals.",
//							MgtEProblemType.UNKNOWN, step);
//				}
			} else if(step instanceof Keyword) {
				Keyword key = (Keyword) step;
				usedKeywords.add(key);
				if(key.getTarget() != null && key.getTarget().getId() != null) {
					usedIds.put(key, key.getTarget().getId());
				}
			}
		}
		for (Keyword key : usedKeywords) {
			if(key.getTarget() != null && key.getTarget().getId() != null) {
				usedIds.put(key, key.getTarget().getId());
			}
			if(!knownKeywords.contains(key.getName())) {
				resource.addWarning("Keyword '" + key.getName() +"' not known by Adapter. Use Strg+Space for proposals.",
						MgtEProblemType.UNKNOWN, key);
			}
		}
		for (Keyword key : usedIds.keySet()) {
			String id = usedIds.get(key);
			if(!knownIds.contains(id)) {
				resource.addWarning("Id '" + id +"' not known by Adapter. Use Strg+Space for proposals.",
						MgtEProblemType.UNKNOWN, key);
			}
		}
	}

	public void terminate() {
		// TODO Auto-generated method stub		
	}

	public IMgtResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
