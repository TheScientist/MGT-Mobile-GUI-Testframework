/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.ui;

import java.util.HashSet;
import java.util.Set;

import de.tu_dresden.mgt.adapter.AdapterUtils;
import de.tu_dresden.mgt.adapter.IAdapter;
import de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver;
import de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory;

/**
 * A CodeCompletionHelper can be used to derive completion proposals for partial
 * documents. It runs the parser generated by EMFText in a special mode (i.e., the
 * rememberExpectedElements mode). Based on the elements that are expected by the
 * parser for different regions in the document, valid proposals are computed.
 */
public class MgtCodeCompletionHelper {
	
	private de.tu_dresden.mgt.resource.mgt.mopp.MgtAttributeValueProvider attributeValueProvider = new de.tu_dresden.mgt.resource.mgt.mopp.MgtAttributeValueProvider();
	
	/**
	 * Computes a set of proposals for the given document assuming the cursor is at
	 * 'cursorOffset'. The proposals are derived using the meta information, i.e., the
	 * generated language plug-in.
	 * 
	 * @param originalResource
	 * @param content the documents content
	 * @param cursorOffset
	 * 
	 * @return
	 */
	public de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal[] computeCompletionProposals(de.tu_dresden.mgt.resource.mgt.IMgtTextResource originalResource, String content, int cursorOffset) {
		org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// the shadow resource needs the same URI because reference resolvers may use the
		// URI to resolve external references
		de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource = (de.tu_dresden.mgt.resource.mgt.IMgtTextResource) resourceSet.createResource(originalResource.getURI());
		java.io.ByteArrayInputStream inputStream = new java.io.ByteArrayInputStream(content.getBytes());
		de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation = resource.getMetaInformation();
		de.tu_dresden.mgt.resource.mgt.IMgtTextParser parser = metaInformation.createParser(inputStream, null);
		de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[] expectedElements = parseToExpectedElements(parser, resource, cursorOffset);
		if (expectedElements == null) {
			return new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal[0];
		}
		if (expectedElements.length == 0) {
			return new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal[0];
		}
		java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedAfterCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset));
		java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedBeforeCursor = java.util.Arrays.asList(getElementsExpectedAt(expectedElements, cursorOffset - 1));
		setPrefixes(expectedAfterCursor, content, cursorOffset);
		setPrefixes(expectedBeforeCursor, content, cursorOffset);
		// First, we derive all possible proposals from the set of elements that are
		// expected at the cursor position.
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> allProposals = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>();
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> rightProposals = deriveProposals(expectedAfterCursor, content, resource, cursorOffset);
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> leftProposals = deriveProposals(expectedBeforeCursor, content, resource, cursorOffset - 1);
		// Second, the set of left proposals (i.e., the ones before the cursor) is checked
		// for emptiness. If the set is empty, the right proposals (i.e., the ones after
		// the cursor) are also considered. If the set is not empty, the right proposal
		// are discarded, because it does not make sense to propose them until the element
		// before the cursor was completed.
		allProposals.addAll(leftProposals);
		if (leftProposals.isEmpty()) {
			allProposals.addAll(rightProposals);
		}
		// Third, the proposals are sorted according to their relevance. Proposals that
		// matched the prefix are preferred over ones that did not. Finally, proposals are
		// sorted alphabetically.
		final java.util.List<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> sortedProposals = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>(allProposals);
		java.util.Collections.sort(sortedProposals);
		return sortedProposals.toArray(new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal[sortedProposals.size()]);
	}
	
	public de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[] parseToExpectedElements(de.tu_dresden.mgt.resource.mgt.IMgtTextParser parser, de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource, int cursorOffset) {
		final java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements = parser.parseToExpectedElements(null, resource, cursorOffset);
		if (expectedElements == null) {
			return new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[0];
		}
		removeDuplicateEntries(expectedElements);
		removeInvalidEntriesAtEnd(expectedElements);
		return expectedElements.toArray(new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[expectedElements.size()]);
	}
	
	private void removeDuplicateEntries(java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1; i++) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtIndex = expectedElements.get(i);
			for (int j = i + 1; j < expectedElements.size();) {
				de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtNext = expectedElements.get(j);
				if (elementAtIndex.equals(elementAtNext) && elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens()) {
					expectedElements.remove(j);
				} else {
					j++;
				}
			}
		}
	}
	
	private void removeInvalidEntriesAtEnd(java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements) {
		for (int i = 0; i < expectedElements.size() - 1;) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtIndex = expectedElements.get(i);
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtNext = expectedElements.get(i + 1);
			if (elementAtIndex.getStartExcludingHiddenTokens() == elementAtNext.getStartExcludingHiddenTokens() && shouldRemove(elementAtIndex.getFollowSetID(), elementAtNext.getFollowSetID())) {
				expectedElements.remove(i + 1);
			} else {
				i++;
			}
		}
	}
	
	public boolean shouldRemove(int followSetID1, int followSetID2) {
		return followSetID1 != followSetID2;
	}
	
	private String findPrefix(java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedAtCursor, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return "";
		}
		int end = 0;
		for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement : expectedElements) {
			if (expectedElement == expectedAtCursor) {
				final int start = expectedElement.getStartExcludingHiddenTokens();
				if (start >= 0  && start < Integer.MAX_VALUE) {
					end = start;
				}
				break;
			}
		}
		end = Math.min(end, cursorOffset);
		final String prefix = content.substring(end, Math.min(content.length(), cursorOffset));
		return prefix;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> deriveProposals(java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements, String content, de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource, int cursorOffset) {
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> resultSet = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>();
		for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement : expectedElements) {
			resultSet.addAll(deriveProposals(expectedElement, content, resource, cursorOffset));
		}
		return resultSet;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> deriveProposals(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedTerminal, String content, de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource, int cursorOffset) {
		de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation = resource.getMetaInformation();
		de.tu_dresden.mgt.resource.mgt.IMgtLocationMap locationMap = resource.getLocationMap();
		de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement expectedElement = (de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement) expectedTerminal.getTerminal();
		if (expectedElement instanceof de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString csString = (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString) expectedElement;
			return handleKeyword(csString, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedBooleanTerminal) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedBooleanTerminal expectedBooleanTerminal = (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedBooleanTerminal) expectedElement;
			return handleBooleanTerminal(expectedBooleanTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedEnumerationTerminal) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedEnumerationTerminal expectedEnumerationTerminal = (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedEnumerationTerminal) expectedElement;
			return handleEnumerationTerminal(expectedEnumerationTerminal, expectedTerminal.getPrefix());
		} else if (expectedElement instanceof de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature expectedFeature = (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature) expectedElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = expectedFeature.getFeature();
			org.eclipse.emf.ecore.EClassifier featureType = feature.getEType();
			java.util.List<org.eclipse.emf.ecore.EObject> elementsAtCursor = locationMap.getElementsAt(cursorOffset);
			org.eclipse.emf.ecore.EObject container = null;
			// we need to skip the proxy elements at the cursor, because they are not the
			// container for the reference we try to complete
			for (int i = 0; i < elementsAtCursor.size(); i++) {
				container = elementsAtCursor.get(i);
				if (!container.eIsProxy()) {
					break;
				}
			}
			// if no container can be found, the cursor is probably at the end of the
			// document. we need to create artificial containers.
			if (container == null) {
				boolean attachedArtificialContainer = false;
				org.eclipse.emf.ecore.EClass containerClass = expectedTerminal.getTerminal().getRuleMetaclass();
				org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace = expectedTerminal.getContainmentTrace();
				java.util.List<org.eclipse.emf.ecore.EObject> contentList = null;
				for (org.eclipse.emf.ecore.EStructuralFeature eStructuralFeature : containmentTrace) {
					if (attachedArtificialContainer) {
						break;
					}
					org.eclipse.emf.ecore.EClass neededClass = eStructuralFeature.getEContainingClass();
					// fill the content list during the first iteration of the loop
					if (contentList == null) {
						contentList = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
						java.util.Iterator<org.eclipse.emf.ecore.EObject> allContents = resource.getAllContents();
						while (allContents.hasNext()) {
							org.eclipse.emf.ecore.EObject next = allContents.next();
							contentList.add(next);
						}
					}
					// find object to attach artificial container to
					for (int i = contentList.size() - 1; i >= 0; i--) {
						org.eclipse.emf.ecore.EObject object = contentList.get(i);
						if (neededClass.isInstance(object)) {
							org.eclipse.emf.ecore.EObject newContainer = containerClass.getEPackage().getEFactoryInstance().create(containerClass);
							if (eStructuralFeature.getEType().isInstance(newContainer)) {
								de.tu_dresden.mgt.resource.mgt.util.MgtEObjectUtil.setFeature(object, eStructuralFeature, newContainer, false);
								container = newContainer;
								attachedArtificialContainer = true;
							}
						}
					}
				}
			}
			
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				org.eclipse.emf.ecore.EReference reference = (org.eclipse.emf.ecore.EReference) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EClass) {
					if (reference.isContainment()) {
						// the FOLLOW set should contain only non-containment references
						assert false;
					} else {
						return handleNCReference(metaInformation, container, reference, expectedTerminal.getPrefix(), expectedFeature.getTokenName());
					}
				}
			} else if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				org.eclipse.emf.ecore.EAttribute attribute = (org.eclipse.emf.ecore.EAttribute) feature;
				if (featureType instanceof org.eclipse.emf.ecore.EEnum) {
					org.eclipse.emf.ecore.EEnum enumType = (org.eclipse.emf.ecore.EEnum) featureType;
					return handleEnumAttribute(metaInformation, expectedFeature, enumType, expectedTerminal.getPrefix(), container);
				} else {
					// handle EAttributes (derive default value depending on the type of the
					// attribute, figure out token resolver, and call deResolve())
					return handleAttribute(metaInformation, expectedFeature, container, attribute, expectedTerminal.getPrefix());
				}
			} else {
				// there should be no other subclass of EStructuralFeature
				assert false;
			}
		} else {
			// there should be no other class implementing IExpectedElement
			assert false;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleEnumAttribute(de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EEnum enumType, String prefix, org.eclipse.emf.ecore.EObject container) {
		java.util.Collection<org.eclipse.emf.ecore.EEnumLiteral> enumLiterals = enumType.getELiterals();
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> result = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>();
		for (org.eclipse.emf.ecore.EEnumLiteral literal : enumLiterals) {
			String unResolvedLiteral = literal.getLiteral();
			// use token resolver to get de-resolved value of the literal
			de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
			de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(expectedFeature.getTokenName());
			String resolvedLiteral = tokenResolver.deResolve(unResolvedLiteral, expectedFeature.getFeature(), container);
			boolean matchesPrefix = matches(resolvedLiteral, prefix);
			result.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal(resolvedLiteral, prefix, matchesPrefix, expectedFeature.getFeature(), container));
		}
		return result;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleNCReference(de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, String prefix, String tokenName) {
		// proposals for non-containment references are derived by calling the reference
		// resolver switch in fuzzy mode.
		de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolverSwitch resolverSwitch = metaInformation.getReferenceResolverSwitch();
		de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
		de.tu_dresden.mgt.resource.mgt.IMgtReferenceResolveResult<org.eclipse.emf.ecore.EObject> result = new de.tu_dresden.mgt.resource.mgt.mopp.MgtReferenceResolveResult<org.eclipse.emf.ecore.EObject>(true);
		resolverSwitch.resolveFuzzy(prefix, container, reference, 0, result);
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<org.eclipse.emf.ecore.EObject>> mappings = result.getMappings();
		if (mappings != null) {
			java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> resultSet = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>();
			for (de.tu_dresden.mgt.resource.mgt.IMgtReferenceMapping<org.eclipse.emf.ecore.EObject> mapping : mappings) {
				org.eclipse.swt.graphics.Image image = null;
				if (mapping instanceof de.tu_dresden.mgt.resource.mgt.mopp.MgtElementMapping<?>) {
					de.tu_dresden.mgt.resource.mgt.mopp.MgtElementMapping<?> elementMapping = (de.tu_dresden.mgt.resource.mgt.mopp.MgtElementMapping<?>) mapping;
					Object target = elementMapping.getTargetElement();
					// de-resolve reference to obtain correct identifier
					de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
					final String identifier = tokenResolver.deResolve(elementMapping.getIdentifier(), reference, container);
					if (target instanceof org.eclipse.emf.ecore.EObject) {
						image = getImage((org.eclipse.emf.ecore.EObject) target);
					}
					boolean matchesPrefix = matches(identifier, prefix);
					resultSet.add(new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal(identifier, prefix, matchesPrefix, reference, container, image));
				}
			}
			return resultSet;
		}
		return java.util.Collections.emptyList();
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleAttribute(de.tu_dresden.mgt.resource.mgt.IMgtMetaInformation metaInformation, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedStructuralFeature expectedFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EAttribute attribute, String prefix) {
		Set<Object> proposals = new HashSet<Object>();
		
		String feature = expectedFeature.getFeature().getEContainingClass().getName() + "." 
							+ expectedFeature.getFeature().getName();
		Set<String> ownCompletions = new HashSet<String>();
		ownCompletions.add("Assertion.assert");
		ownCompletions.add("UIElementLocator.id");
		ownCompletions.add("Keyword.name");
		// Propose some plugged in Adapters
		if(feature.equals("TestSuite.adapter")) {
			proposals.addAll(AdapterUtils.getAdapterProposals());
		} 
		// Propose completions for elements, provided by adapter
		else if(ownCompletions.contains(feature)) {
			IAdapter currAdapter = AdapterUtils.getCurrentAdapterFromModel(container);
			if(currAdapter != null) {
				if(feature.equals("Assertion.assert")) {
					proposals.addAll(currAdapter.getAssertionProposals());
				}
				else if(feature.equals("UIElementLocator.id")) {
					proposals.addAll(currAdapter.getElementIds(AdapterUtils.getAppUnderTest(container)));				
				}
				else if(feature.equals("Keyword.name")) {
					proposals.addAll(currAdapter.getKeywords());				
				}
			}			
		}
		
		if(proposals.isEmpty()) {
			for (Object defaultProp : attributeValueProvider.getDefaultValues(attribute)) {
				proposals.add(defaultProp);
			}
		}
		
		java.util.Collection<MgtCompletionProposal> resultSet = new java.util.LinkedHashSet<MgtCompletionProposal>();
		if (proposals != null) {
			for (Object defaultValue : proposals) {
				if (defaultValue != null) {
					IMgtTokenResolverFactory tokenResolverFactory = metaInformation.getTokenResolverFactory();
					String tokenName = expectedFeature.getTokenName();
					if (tokenName != null) {
						IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
						if (tokenResolver != null) {
							String defaultValueAsString = tokenResolver.deResolve(defaultValue, attribute, container);
							boolean matchesPrefix = matches(defaultValueAsString, prefix);
							resultSet.add(new MgtCompletionProposal(defaultValueAsString, prefix, matchesPrefix, expectedFeature.getFeature(), container));
						}
					}
				}
			}
		}
		return resultSet;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleKeyword(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedCsString csString, String prefix) {
		String proposal = csString.getValue();
		boolean matchesPrefix = matches(proposal, prefix);
		return java.util.Collections.singleton(new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal(proposal, prefix, matchesPrefix, null, null));
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleBooleanTerminal(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedBooleanTerminal expectedBooleanTerminal, String prefix) {
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> result = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>(2);
		de.tu_dresden.mgt.resource.mgt.grammar.MgtBooleanTerminal booleanTerminal = expectedBooleanTerminal.getBooleanTerminal();
		result.addAll(handleLiteral(booleanTerminal.getAttribute(), prefix, booleanTerminal.getTrueLiteral()));
		result.addAll(handleLiteral(booleanTerminal.getAttribute(), prefix, booleanTerminal.getFalseLiteral()));
		return result;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleEnumerationTerminal(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedEnumerationTerminal expectedEnumerationTerminal, String prefix) {
		java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> result = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal>(2);
		de.tu_dresden.mgt.resource.mgt.grammar.MgtEnumerationTerminal enumerationTerminal = expectedEnumerationTerminal.getEnumerationTerminal();
		java.util.Map<String, String> literalMapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : literalMapping.keySet()) {
			result.addAll(handleLiteral(enumerationTerminal.getAttribute(), prefix, literalMapping.get(literalName)));
		}
		return result;
	}
	
	private java.util.Collection<de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal> handleLiteral(org.eclipse.emf.ecore.EAttribute attribute, String prefix, String literal) {
		if ("".equals(literal)) {
			return java.util.Collections.emptySet();
		}
		boolean matchesPrefix = matches(literal, prefix);
		return java.util.Collections.singleton(new de.tu_dresden.mgt.resource.mgt.ui.MgtCompletionProposal(literal, prefix, matchesPrefix, null, null));
	}
	
	/**
	 * Calculates the prefix for each given expected element. The prefix depends on
	 * the current document content, the cursor position, and the position where the
	 * element is expected.
	 */
	private void setPrefixes(java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements, String content, int cursorOffset) {
		if (cursorOffset < 0) {
			return;
		}
		for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement : expectedElements) {
			String prefix = findPrefix(expectedElements, expectedElement, content, cursorOffset);
			expectedElement.setPrefix(prefix);
		}
	}
	
	public de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[] getElementsExpectedAt(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[] allExpectedElements, int cursorOffset) {
		java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedAtCursor = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal>();
		for (int i = 0; i < allExpectedElements.length; i++) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement = allExpectedElements[i];
			int startIncludingHidden = expectedElement.getStartIncludingHiddenTokens();
			int end = getEnd(allExpectedElements, i);
			if (cursorOffset >= startIncludingHidden && cursorOffset <= end) {
				expectedAtCursor.add(expectedElement);
			}
		}
		return expectedAtCursor.toArray(new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[expectedAtCursor.size()]);
	}
	
	private int getEnd(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal[] allExpectedElements, int indexInList) {
		de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtIndex = allExpectedElements[indexInList];
		int startIncludingHidden = elementAtIndex.getStartIncludingHiddenTokens();
		int startExcludingHidden = elementAtIndex.getStartExcludingHiddenTokens();
		for (int i = indexInList + 1; i < allExpectedElements.length; i++) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal elementAtI = allExpectedElements[i];
			int startIncludingHiddenForI = elementAtI.getStartIncludingHiddenTokens();
			int startExcludingHiddenForI = elementAtI.getStartExcludingHiddenTokens();
			if (startIncludingHidden != startIncludingHiddenForI || startExcludingHidden != startExcludingHiddenForI) {
				return startIncludingHiddenForI - 1;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private boolean matches(String proposal, String prefix) {
		return (proposal.toLowerCase().startsWith(prefix.toLowerCase()) || de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.matchCamelCase(prefix, proposal) != null) && !proposal.equals(prefix);
	}
	
	public org.eclipse.swt.graphics.Image getImage(org.eclipse.emf.ecore.EObject element) {
		if (!org.eclipse.core.runtime.Platform.isRunning()) {
			return null;
		}
		org.eclipse.emf.edit.provider.ComposedAdapterFactory adapterFactory = new org.eclipse.emf.edit.provider.ComposedAdapterFactory(org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory());
		org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider labelProvider = new org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider(adapterFactory);
		return labelProvider.getImage(element);
	}
}
