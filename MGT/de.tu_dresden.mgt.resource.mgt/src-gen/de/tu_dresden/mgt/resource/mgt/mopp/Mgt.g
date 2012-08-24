grammar Mgt;

options {
	superClass = MgtANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package de.tu_dresden.mgt.resource.mgt.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package de.tu_dresden.mgt.resource.mgt.mopp;
}

@members{
	private de.tu_dresden.mgt.resource.mgt.IMgtTokenResolverFactory tokenResolverFactory = new de.tu_dresden.mgt.resource.mgt.mopp.MgtTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> expectedElements = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>() {
			public boolean execute(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new de.tu_dresden.mgt.resource.mgt.IMgtProblem() {
					public de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity getSeverity() {
						return de.tu_dresden.mgt.resource.mgt.MgtEProblemSeverity.ERROR;
					}
					public de.tu_dresden.mgt.resource.mgt.MgtEProblemType getType() {
						return de.tu_dresden.mgt.resource.mgt.MgtEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
		if (!this.rememberExpectedElements) {
			return;
		}
		int terminalID = ids[0];
		int followSetID = ids[1];
		de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement terminal = de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINALS[terminalID];
		de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[] containmentFeatures = new de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.LINKS[ids[i]];
		}
		de.tu_dresden.mgt.resource.mgt.grammar.MgtContainmentTrace containmentTrace = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal(container, terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
			this.expectedElementsIndexOfLastCompleteElement = 0;
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>() {
			public boolean execute(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
				de.tu_dresden.mgt.resource.mgt.IMgtLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>() {
			public boolean execute(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
				de.tu_dresden.mgt.resource.mgt.IMgtLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>() {
			public boolean execute(de.tu_dresden.mgt.resource.mgt.IMgtTextResource resource) {
				de.tu_dresden.mgt.resource.mgt.IMgtLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public de.tu_dresden.mgt.resource.mgt.IMgtTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new MgtParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MgtLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new MgtParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MgtLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new de.tu_dresden.mgt.resource.mgt.util.MgtRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public MgtParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((MgtLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((MgtLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == de.tu_dresden.mgt.TestSuite.class) {
				return parse_de_tu_005fdresden_mgt_TestSuite();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.TestCase.class) {
				return parse_de_tu_005fdresden_mgt_TestCase();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Assertion.class) {
				return parse_de_tu_005fdresden_mgt_Assertion();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.UIElementLocator.class) {
				return parse_de_tu_005fdresden_mgt_UIElementLocator();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Keyword.class) {
				return parse_de_tu_005fdresden_mgt_Keyword();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Sequence.class) {
				return parse_de_tu_005fdresden_mgt_Sequence();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.SequentialStep.class) {
				return parse_de_tu_005fdresden_mgt_SequentialStep();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Integer.class) {
				return parse_de_tu_005fdresden_mgt_Integer();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Boolean.class) {
				return parse_de_tu_005fdresden_mgt_Boolean();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.String.class) {
				return parse_de_tu_005fdresden_mgt_String();
			}
			if (type.getInstanceClass() == de.tu_dresden.mgt.Float.class) {
				return parse_de_tu_005fdresden_mgt_Float();
			}
		}
		throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtUnexpectedContentTypeException(typeObject);
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(de.tu_dresden.mgt.resource.mgt.IMgtOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public de.tu_dresden.mgt.resource.mgt.IMgtParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource>>();
		de.tu_dresden.mgt.resource.mgt.mopp.MgtParseResult parseResult = new de.tu_dresden.mgt.resource.mgt.mopp.MgtParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, de.tu_dresden.mgt.resource.mgt.IMgtTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		de.tu_dresden.mgt.resource.mgt.IMgtParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (de.tu_dresden.mgt.resource.mgt.IMgtCommand<de.tu_dresden.mgt.resource.mgt.IMgtTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal>();
		java.util.List<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal> newFollowSet = new java.util.ArrayList<de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 64;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
			if (nextToken.getType() < 0) {
				break;
			}
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, de.tu_dresden.mgt.resource.mgt.mopp.MgtContainedFeature[]> newFollowerPair : newFollowers) {
							de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							de.tu_dresden.mgt.resource.mgt.grammar.MgtContainmentTrace containmentTrace = new de.tu_dresden.mgt.resource.mgt.grammar.MgtContainmentTrace(null, newFollowerPair.getRight());
							de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal newFollowTerminal = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal(container, newFollower, followSetID, containmentTrace);
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parser is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private void startIncompleteElement(Object object) {
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
		}
	}
	
	private void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			boolean exists = this.incompleteObjects.remove(object);
			if (!exists) {
			}
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
		if (incompleteObjects.isEmpty()) {
			return null;
		}
		return incompleteObjects.get(incompleteObjects.size() - 1);
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_de_tu_005fdresden_mgt_TestSuite{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_de_tu_005fdresden_mgt_TestSuite returns [de.tu_dresden.mgt.TestSuite element = null]
@init{
}
:
	a0 = 'TESTSUITE' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[2]);
	}
	
	a2 = 'suiteName' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[3]);
	}
	
	a3 = ':' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a4 = BIGNAME		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BIGNAME");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[5]);
	}
	
	a5 = ',' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[6]);
	}
	
	a6 = 'systemUnderTest' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[7]);
	}
	
	a7 = ':' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		a8 = BIGNAME		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
				startIncompleteElement(element);
			}
			if (a8 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BIGNAME");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_11, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[9]);
	}
	
	a9 = ',' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_12, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[10]);
	}
	
	a10 = 'adapter' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_14, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[11]);
	}
	
	a11 = ':' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[12]);
	}
	
	(
		a12 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
				startIncompleteElement(element);
			}
			if (a12 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_16, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			(
				a13_0 = parse_de_tu_005fdresden_mgt_Sequence				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
						startIncompleteElement(element);
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							Object value = a13_0;
							addObjectToList(element, de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SEQUENCES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_18_0_0_0, a13_0, true);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[16]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[18]);
	}
	
	(
		(
			(
				a14_0 = parse_de_tu_005fdresden_mgt_TestCase				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
						startIncompleteElement(element);
					}
					if (a14_0 != null) {
						if (a14_0 != null) {
							Object value = a14_0;
							addObjectToList(element, de.tu_dresden.mgt.MgtPackage.TEST_SUITE__TEST_CASES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_19_0_0_0, a14_0, true);
						copyLocalizationInfos(a14_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[19]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[20]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[22]);
	}
	
	a15 = '}' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_20, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
	}
	{
		// expected elements (follow set)
	}
	
;

parse_de_tu_005fdresden_mgt_TestCase returns [de.tu_dresden.mgt.TestCase element = null]
@init{
}
:
	a0 = 'TESTCASE' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[23]);
	}
	
	a1 = '{' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[24]);
	}
	
	a2 = 'caseName' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[25]);
	}
	
	a3 = ':' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[26]);
	}
	
	(
		a4 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[29]);
	}
	
	(
		(
			(
				a5_0 = parse_de_tu_005fdresden_mgt_AbstractTestStep				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, de.tu_dresden.mgt.MgtPackage.TEST_CASE__TEST_STEPS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_8_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[30]);
			}
			
			a6 = ';' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_8_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[34]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[38]);
	}
	
	a7 = '}' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[40]);
	}
	
;

parse_de_tu_005fdresden_mgt_Assertion returns [de.tu_dresden.mgt.Assertion element = null]
@init{
}
:
	a0 = 'ASSERT' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[41]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[42]);
	}
	
	a2 = '(' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[43]);
	}
	
	(
		a3_0 = parse_de_tu_005fdresden_mgt_Keyword		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ACTUAL), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_3, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[44]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[45]);
	}
	
	(
		(
			a4 = ',' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[49]);
			}
			
			(
				a5_0 = parse_de_tu_005fdresden_mgt_TestDate				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__EXPECTED), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_4_0_0_1, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[50]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[51]);
	}
	
	a6 = ')' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[54]);
	}
	
	(
		(
			a7 = ':' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[55]);
			}
			
			(
				(
					a8 = 'FAIL' {
						if (element == null) {
							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
						// set value of enumeration attribute
						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.FAIL_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
						completedElement(value, false);
					}
					|					a9 = 'ERROR' {
						if (element == null) {
							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
						// set value of enumeration attribute
						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.ERROR_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
						completedElement(value, false);
					}
					|					a10 = 'INCONCL' {
						if (element == null) {
							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
						// set value of enumeration attribute
						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.INCONCLUSIVE_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
						completedElement(value, false);
					}
					|					a11 = 'PASS' {
						if (element == null) {
							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
						// set value of enumeration attribute
						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.PASS_VALUE).getInstance();
						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
						completedElement(value, false);
					}
				)
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[56]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[57]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[58]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[59]);
	}
	
;

parse_de_tu_005fdresden_mgt_UIElementLocator returns [de.tu_dresden.mgt.UIElementLocator element = null]
@init{
}
:
	a0 = 'id' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createUIElementLocator();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[60]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createUIElementLocator();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[61]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[62]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[65]);
	}
	
;

parse_de_tu_005fdresden_mgt_Keyword returns [de.tu_dresden.mgt.Keyword element = null]
@init{
}
:
	(
		a0 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[71]);
	}
	
	(
		(
			a1 = ':' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[72]);
			}
			
			(
				a2_0 = parse_de_tu_005fdresden_mgt_UIElementLocator				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
						startIncompleteElement(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__TARGET), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_1_0_0_1, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[77]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[82]);
	}
	
	(
		(
			a3 = ':' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[84]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[85]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[86]);
			}
			
			(
				a4_0 = parse_de_tu_005fdresden_mgt_TestDate				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[88]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[89]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[90]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[91]);
			}
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_2_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[92]);
						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[93]);
						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[94]);
						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[95]);
					}
					
					(
						a6_0 = parse_de_tu_005fdresden_mgt_TestDate						{
							if (terminateParsing) {
								throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
							}
							if (element == null) {
								element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
								startIncompleteElement(element);
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									Object value = a6_0;
									addObjectToList(element, de.tu_dresden.mgt.MgtPackage.KEYWORD__TEST_DATA, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_2_0_0_1, a6_0, true);
								copyLocalizationInfos(a6_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[96]);
						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[97]);
						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[98]);
						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[99]);
						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[100]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[101]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[102]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[103]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[104]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[105]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[109]);
	}
	
;

parse_de_tu_005fdresden_mgt_Sequence returns [de.tu_dresden.mgt.Sequence element = null]
@init{
}
:
	a0 = 'SEQUENCE' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[110]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[111]);
	}
	
	a2 = '{' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[114]);
	}
	
	(
		(
			(
				a3_0 = parse_de_tu_005fdresden_mgt_AbstractTestStep				{
					if (terminateParsing) {
						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
					}
					if (element == null) {
						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, de.tu_dresden.mgt.MgtPackage.SEQUENCE__STEPS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_6_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[115]);
			}
			
			a4 = ';' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_6_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[116]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[118]);
				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[119]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[123]);
	}
	
	a5 = '}' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[125]);
	}
	
;

parse_de_tu_005fdresden_mgt_SequentialStep returns [de.tu_dresden.mgt.SequentialStep element = null]
@init{
}
:
	a0 = 'seq:' {
		if (element == null) {
			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequentialStep();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[126]);
	}
	
	(
		a1 = IDENTIFIER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequentialStep();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				de.tu_dresden.mgt.Sequence proxy = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
				collectHiddenTokens(element);
				registerContextDependentProxy(new de.tu_dresden.mgt.resource.mgt.mopp.MgtContextDependentURIFragmentFactory<de.tu_dresden.mgt.SequentialStep, de.tu_dresden.mgt.Sequence>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSequentialStepSequenceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_1, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[128]);
	}
	
;

parse_de_tu_005fdresden_mgt_Integer returns [de.tu_dresden.mgt.Integer element = null]
@init{
}
:
	(
		a0 = INTEGER		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createInteger();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_7_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[131]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[132]);
	}
	
;

parse_de_tu_005fdresden_mgt_Boolean returns [de.tu_dresden.mgt.Boolean element = null]
@init{
}
:
	(
		(
			a0 = 'true' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createBoolean();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_8_0_0_0, true, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of boolean attribute
				Object value = true;
				element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE), value);
				completedElement(value, false);
			}
			|			a1 = 'false' {
				if (element == null) {
					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createBoolean();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_8_0_0_0, false, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of boolean attribute
				Object value = false;
				element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[133]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[134]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[135]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[136]);
	}
	
;

parse_de_tu_005fdresden_mgt_String returns [de.tu_dresden.mgt.String element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createString();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_9_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[139]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[140]);
	}
	
;

parse_de_tu_005fdresden_mgt_Float returns [de.tu_dresden.mgt.Float element = null]
@init{
}
:
	(
		a0 = FLOAT		
		{
			if (terminateParsing) {
				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
			}
			if (element == null) {
				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createFloat();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("FLOAT");
				tokenResolver.setOptions(getOptions());
				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Float resolved = (java.lang.Float) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_10_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[141]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[144]);
	}
	
;

parse_de_tu_005fdresden_mgt_AbstractTestStep returns [de.tu_dresden.mgt.AbstractTestStep element = null]
:
	c0 = parse_de_tu_005fdresden_mgt_Assertion{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_de_tu_005fdresden_mgt_Keyword{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_de_tu_005fdresden_mgt_SequentialStep{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_de_tu_005fdresden_mgt_TestDate returns [de.tu_dresden.mgt.TestDate element = null]
:
	c0 = parse_de_tu_005fdresden_mgt_Integer{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_de_tu_005fdresden_mgt_Boolean{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_de_tu_005fdresden_mgt_String{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_de_tu_005fdresden_mgt_Float{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

IDENTIFIER:
	(('a'..'z')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*)
;
BIGNAME:
	(('A'..'Z')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*)
;
INTEGER:
	(('-')?('1'..'9')('0'..'9')*|'0')
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
FLOAT:
	(('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ )
;
SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	{ _channel = 99; }
;
WHITESPACE:
	((' '|'\t'|'\f'))
	{ _channel = 99; }
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

