// $ANTLR ${project.version} ${buildNumber}

	package de.tu_dresden.mgt.resource.mgt.mopp;


import org.antlr.runtime3_3_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class MgtParser extends MgtANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGNAME", "IDENTIFIER", "INTEGER", "QUOTED_34_34", "FLOAT", "LINEBREAK", "SL_COMMENT", "WHITESPACE", "'TESTSUITE'", "'{'", "'suiteName'", "':'", "','", "'systemUnderTest'", "'adapter'", "'}'", "'TESTCASE'", "'caseName'", "';'", "'ASSERT'", "'('", "')'", "'FAIL'", "'ERROR'", "'INCONCL'", "'PASS'", "'id'", "'SEQUENCE'", "'seq:'", "'true'", "'false'"
    };
    public static final int EOF=-1;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int BIGNAME=4;
    public static final int IDENTIFIER=5;
    public static final int INTEGER=6;
    public static final int QUOTED_34_34=7;
    public static final int FLOAT=8;
    public static final int LINEBREAK=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    // delegates
    // delegators


        public MgtParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MgtParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[32+1];
             
             
        }
        

    public String[] getTokenNames() { return MgtParser.tokenNames; }
    public String getGrammarFileName() { return "Mgt.g"; }


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
    	protected java.util.List<org.antlr.runtime3_3_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_3_0.RecognitionException>());
    	
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
    	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
    	
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
    	
    	public void addExpectedElement(de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal expectedElement = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal(terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
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
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_3_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
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
    				return new MgtParser(new org.antlr.runtime3_3_0.CommonTokenStream(new MgtLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new MgtParser(new org.antlr.runtime3_3_0.CommonTokenStream(new MgtLexer(new org.antlr.runtime3_3_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			de.tu_dresden.mgt.resource.mgt.mopp.MgtPlugin.logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public MgtParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_3_0.RecognitionException {
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
    	
    	public Object getMissingSymbol(org.antlr.runtime3_3_0.IntStream arg0, org.antlr.runtime3_3_0.RecognitionException arg1, int arg2, org.antlr.runtime3_3_0.BitSet arg3) {
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
    		} catch (org.antlr.runtime3_3_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_3_0.RecognitionException re : lexerExceptions) {
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
    		final org.antlr.runtime3_3_0.CommonTokenStream tokenStream = (org.antlr.runtime3_3_0.CommonTokenStream) getTokenStream();
    		de.tu_dresden.mgt.resource.mgt.IMgtParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_3_0.Lexer lexer = (org.antlr.runtime3_3_0.Lexer) tokenStream.getTokenSource();
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
    			org.antlr.runtime3_3_0.CommonToken nextToken = (org.antlr.runtime3_3_0.CommonToken) tokenStream.get(i);
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
    						java.util.Collection<de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (de.tu_dresden.mgt.resource.mgt.util.MgtPair<de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
    							de.tu_dresden.mgt.resource.mgt.IMgtExpectedElement newFollower = newFollowerPair.getLeft();
    							de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal newFollowTerminal = new de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
    			org.antlr.runtime3_3_0.CommonToken tokenAtIndex = (org.antlr.runtime3_3_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_3_0.IntStream input, int ttype, org.antlr.runtime3_3_0.BitSet follow) throws org.antlr.runtime3_3_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_3_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
    			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_3_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_3_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
    			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
    			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
    			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_3_0.CommonToken) {
    			final org.antlr.runtime3_3_0.CommonToken ct = (org.antlr.runtime3_3_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_3_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_3_0.MismatchedTokenException) {
    			org.antlr.runtime3_3_0.MismatchedTokenException mte = (org.antlr.runtime3_3_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_3_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_3_0.EarlyExitException) {
    			org.antlr.runtime3_3_0.EarlyExitException eee = (org.antlr.runtime3_3_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedSetException) {
    			org.antlr.runtime3_3_0.MismatchedSetException mse = (org.antlr.runtime3_3_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedNotSetException) {
    			org.antlr.runtime3_3_0.MismatchedNotSetException mse = (org.antlr.runtime3_3_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_3_0.MismatchedRangeException) {
    			org.antlr.runtime3_3_0.MismatchedRangeException mre = (org.antlr.runtime3_3_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_3_0.FailedPredicateException) {
    			org.antlr.runtime3_3_0.FailedPredicateException fpe = (org.antlr.runtime3_3_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	protected void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			this.incompleteObjects.pop();
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	



    // $ANTLR start "start"
    // Mgt.g:493:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        de.tu_dresden.mgt.TestSuite c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Mgt.g:494:1: ( (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF )
            // Mgt.g:495:2: (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_0, 0);
              		expectedElementsIndexOfLastCompleteElement = 0;
              	
            }
            // Mgt.g:500:2: (c0= parse_de_tu_005fdresden_mgt_TestSuite )
            // Mgt.g:501:3: c0= parse_de_tu_005fdresden_mgt_TestSuite
            {
            pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestSuite_in_start82);
            c0=parse_de_tu_005fdresden_mgt_TestSuite();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		retrieveLayoutInformation(element, null, null, false);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestSuite"
    // Mgt.g:509:1: parse_de_tu_005fdresden_mgt_TestSuite returns [de.tu_dresden.mgt.TestSuite element = null] : a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}' ;
    public final de.tu_dresden.mgt.TestSuite parse_de_tu_005fdresden_mgt_TestSuite() throws RecognitionException {
        de.tu_dresden.mgt.TestSuite element =  null;
        int parse_de_tu_005fdresden_mgt_TestSuite_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a15=null;
        de.tu_dresden.mgt.Sequence a13_0 = null;

        de.tu_dresden.mgt.TestCase a14_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Mgt.g:512:1: (a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}' )
            // Mgt.g:513:2: a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}'
            {
            a0=(Token)match(input,12,FOLLOW_12_in_parse_de_tu_005fdresden_mgt_TestSuite115); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_1, 1);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_de_tu_005fdresden_mgt_TestSuite129); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_2, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_2, 2);
              	
            }
            a2=(Token)match(input,14,FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite143); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_4, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_3, 3);
              	
            }
            a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite157); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_4, 4);
              	
            }
            // Mgt.g:569:2: (a4= BIGNAME )
            // Mgt.g:570:3: a4= BIGNAME
            {
            a4=(Token)match(input,BIGNAME,FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite175); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              				incompleteObjects.push(element);
              			}
              			if (a4 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BIGNAME");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__NAME), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_6, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_5, 5);
              	
            }
            a5=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestSuite196); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_7, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_6, 6);
              	
            }
            a6=(Token)match(input,17,FOLLOW_17_in_parse_de_tu_005fdresden_mgt_TestSuite210); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_9, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_7, 7);
              	
            }
            a7=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite224); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_10, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_8, 8);
              	
            }
            // Mgt.g:647:2: (a8= BIGNAME )
            // Mgt.g:648:3: a8= BIGNAME
            {
            a8=(Token)match(input,BIGNAME,FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite242); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              				incompleteObjects.push(element);
              			}
              			if (a8 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BIGNAME");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a8).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__SYSTEM_UNDER_TEST), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_11, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a8, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_9, 9);
              	
            }
            a9=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestSuite263); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_12, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_10, 10);
              	
            }
            a10=(Token)match(input,18,FOLLOW_18_in_parse_de_tu_005fdresden_mgt_TestSuite277); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_14, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a10, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_11, 11);
              	
            }
            a11=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite291); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_15, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_12, 12);
              	
            }
            // Mgt.g:725:2: (a12= IDENTIFIER )
            // Mgt.g:726:3: a12= IDENTIFIER
            {
            a12=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestSuite309); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              				incompleteObjects.push(element);
              			}
              			if (a12 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a12).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_SUITE__ADAPTER), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_16, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a12, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_13, 13, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_0);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 13, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
              	
            }
            // Mgt.g:762:2: ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Mgt.g:763:3: ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) )
            	    {
            	    // Mgt.g:763:3: ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) )
            	    // Mgt.g:764:4: (a13_0= parse_de_tu_005fdresden_mgt_Sequence )
            	    {
            	    // Mgt.g:764:4: (a13_0= parse_de_tu_005fdresden_mgt_Sequence )
            	    // Mgt.g:765:5: a13_0= parse_de_tu_005fdresden_mgt_Sequence
            	    {
            	    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Sequence_in_parse_de_tu_005fdresden_mgt_TestSuite345);
            	    a13_0=parse_de_tu_005fdresden_mgt_Sequence();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            	      						incompleteObjects.push(element);
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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_13, 14, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 14, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_13, 15, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_0);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 15, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
              	
            }
            // Mgt.g:799:2: ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Mgt.g:800:3: ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) )
            	    {
            	    // Mgt.g:800:3: ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) )
            	    // Mgt.g:801:4: (a14_0= parse_de_tu_005fdresden_mgt_TestCase )
            	    {
            	    // Mgt.g:801:4: (a14_0= parse_de_tu_005fdresden_mgt_TestCase )
            	    // Mgt.g:802:5: a14_0= parse_de_tu_005fdresden_mgt_TestCase
            	    {
            	    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestCase_in_parse_de_tu_005fdresden_mgt_TestSuite401);
            	    a14_0=parse_de_tu_005fdresden_mgt_TestCase();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            	      						incompleteObjects.push(element);
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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 16, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_15, 16);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 17, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_15, 17);
              	
            }
            a15=(Token)match(input,19,FOLLOW_19_in_parse_de_tu_005fdresden_mgt_TestSuite442); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_20, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a15, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_de_tu_005fdresden_mgt_TestSuite_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestSuite"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestCase"
    // Mgt.g:851:1: parse_de_tu_005fdresden_mgt_TestCase returns [de.tu_dresden.mgt.TestCase element = null] : a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}' ;
    public final de.tu_dresden.mgt.TestCase parse_de_tu_005fdresden_mgt_TestCase() throws RecognitionException {
        de.tu_dresden.mgt.TestCase element =  null;
        int parse_de_tu_005fdresden_mgt_TestCase_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        de.tu_dresden.mgt.AbstractTestStep a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Mgt.g:854:1: (a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}' )
            // Mgt.g:855:2: a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}'
            {
            a0=(Token)match(input,20,FOLLOW_20_in_parse_de_tu_005fdresden_mgt_TestCase471); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_16, 19);
              	
            }
            a1=(Token)match(input,13,FOLLOW_13_in_parse_de_tu_005fdresden_mgt_TestCase485); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_2, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_17, 20);
              	
            }
            a2=(Token)match(input,21,FOLLOW_21_in_parse_de_tu_005fdresden_mgt_TestCase499); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_4, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_18, 21);
              	
            }
            a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestCase513); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_19, 22);
              	
            }
            // Mgt.g:911:2: (a4= IDENTIFIER )
            // Mgt.g:912:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestCase531); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              				incompleteObjects.push(element);
              			}
              			if (a4 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a4).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.TEST_CASE__NAME), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_6, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a4, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 23, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 23, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 23, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              	
            }
            // Mgt.g:949:2: ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||LA3_0==23||LA3_0==32) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Mgt.g:950:3: ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' )
            	    {
            	    // Mgt.g:950:3: ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' )
            	    // Mgt.g:951:4: (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';'
            	    {
            	    // Mgt.g:951:4: (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep )
            	    // Mgt.g:952:5: a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep
            	    {
            	    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_TestCase567);
            	    a5_0=parse_de_tu_005fdresden_mgt_AbstractTestStep();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            	      						incompleteObjects.push(element);
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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 24);
            	      			
            	    }
            	    a6=(Token)match(input,22,FOLLOW_22_in_parse_de_tu_005fdresden_mgt_TestCase595); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_8_0_0_1, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 25, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 25, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 25, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_24, 25);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 26, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 26, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 26, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_2);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_24, 26);
              	
            }
            a7=(Token)match(input,19,FOLLOW_19_in_parse_de_tu_005fdresden_mgt_TestCase628); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_9, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 27, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_15, 27);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_de_tu_005fdresden_mgt_TestCase_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestCase"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Assertion"
    // Mgt.g:1021:1: parse_de_tu_005fdresden_mgt_Assertion returns [de.tu_dresden.mgt.Assertion element = null] : a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) ) )? ;
    public final de.tu_dresden.mgt.Assertion parse_de_tu_005fdresden_mgt_Assertion() throws RecognitionException {
        de.tu_dresden.mgt.Assertion element =  null;
        int parse_de_tu_005fdresden_mgt_Assertion_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        de.tu_dresden.mgt.Keyword a3_0 = null;

        de.tu_dresden.mgt.TestDate a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Mgt.g:1024:1: (a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) ) )? )
            // Mgt.g:1025:2: a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) ) )?
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_de_tu_005fdresden_mgt_Assertion657); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_25, 28);
              	
            }
            // Mgt.g:1039:2: (a1= IDENTIFIER )
            // Mgt.g:1040:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Assertion675); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__ASSERT), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_26, 29);
              	
            }
            a2=(Token)match(input,24,FOLLOW_24_in_parse_de_tu_005fdresden_mgt_Assertion696); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_2, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 30, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_3);
              	
            }
            // Mgt.g:1089:2: (a3_0= parse_de_tu_005fdresden_mgt_Keyword )
            // Mgt.g:1090:3: a3_0= parse_de_tu_005fdresden_mgt_Keyword
            {
            pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_Assertion714);
            a3_0=parse_de_tu_005fdresden_mgt_Keyword();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
              				incompleteObjects.push(element);
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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 31);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 31);
              	
            }
            // Mgt.g:1116:2: ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Mgt.g:1117:3: (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    {
                    // Mgt.g:1117:3: (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    // Mgt.g:1118:4: a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate )
                    {
                    a4=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Assertion741); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_4_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_29, 32, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_4);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_30, 32, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_4);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_31, 32, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_4);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_32, 32, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_4);
                      			
                    }
                    // Mgt.g:1135:4: (a5_0= parse_de_tu_005fdresden_mgt_TestDate )
                    // Mgt.g:1136:5: a5_0= parse_de_tu_005fdresden_mgt_TestDate
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Assertion767);
                    a5_0=parse_de_tu_005fdresden_mgt_TestDate();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                      						incompleteObjects.push(element);
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 33);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 34);
              	
            }
            a6=(Token)match(input,25,FOLLOW_25_in_parse_de_tu_005fdresden_mgt_Assertion808); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_5, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_33, 35);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 35);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 35);
              	
            }
            // Mgt.g:1184:2: ( (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Mgt.g:1185:3: (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) )
                    {
                    // Mgt.g:1185:3: (a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) ) )
                    // Mgt.g:1186:4: a7= ':' ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) )
                    {
                    a7=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Assertion831); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_35, 36);
                      			
                    }
                    // Mgt.g:1200:4: ( (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' ) )
                    // Mgt.g:1201:5: (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' )
                    {
                    // Mgt.g:1201:5: (a8= 'FAIL' | a9= 'ERROR' | a10= 'INCONCL' | a11= 'PASS' )
                    int alt5=4;
                    switch ( input.LA(1) ) {
                    case 26:
                        {
                        alt5=1;
                        }
                        break;
                    case 27:
                        {
                        alt5=2;
                        }
                        break;
                    case 28:
                        {
                        alt5=3;
                        }
                        break;
                    case 29:
                        {
                        alt5=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // Mgt.g:1202:6: a8= 'FAIL'
                            {
                            a8=(Token)match(input,26,FOLLOW_26_in_parse_de_tu_005fdresden_mgt_Assertion864); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              						if (element == null) {
                              							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                              							incompleteObjects.push(element);
                              						}
                              						collectHiddenTokens(element);
                              						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
                              						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a8, element);
                              						// set value of enumeration attribute
                              						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.FAIL_VALUE).getInstance();
                              						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
                              						completedElement(value, false);
                              					
                            }

                            }
                            break;
                        case 2 :
                            // Mgt.g:1215:12: a9= 'ERROR'
                            {
                            a9=(Token)match(input,27,FOLLOW_27_in_parse_de_tu_005fdresden_mgt_Assertion883); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              						if (element == null) {
                              							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                              							incompleteObjects.push(element);
                              						}
                              						collectHiddenTokens(element);
                              						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
                              						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a9, element);
                              						// set value of enumeration attribute
                              						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.ERROR_VALUE).getInstance();
                              						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
                              						completedElement(value, false);
                              					
                            }

                            }
                            break;
                        case 3 :
                            // Mgt.g:1228:12: a10= 'INCONCL'
                            {
                            a10=(Token)match(input,28,FOLLOW_28_in_parse_de_tu_005fdresden_mgt_Assertion902); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              						if (element == null) {
                              							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                              							incompleteObjects.push(element);
                              						}
                              						collectHiddenTokens(element);
                              						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
                              						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a10, element);
                              						// set value of enumeration attribute
                              						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.INCONCLUSIVE_VALUE).getInstance();
                              						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
                              						completedElement(value, false);
                              					
                            }

                            }
                            break;
                        case 4 :
                            // Mgt.g:1241:12: a11= 'PASS'
                            {
                            a11=(Token)match(input,29,FOLLOW_29_in_parse_de_tu_005fdresden_mgt_Assertion921); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              						if (element == null) {
                              							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                              							incompleteObjects.push(element);
                              						}
                              						collectHiddenTokens(element);
                              						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_1, null, true);
                              						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a11, element);
                              						// set value of enumeration attribute
                              						Object value = de.tu_dresden.mgt.MgtPackage.eINSTANCE.getVerdict().getEEnumLiteral(de.tu_dresden.mgt.Verdict.PASS_VALUE).getInstance();
                              						element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.ASSERTION__VERDICT), value);
                              						completedElement(value, false);
                              					
                            }

                            }
                            break;

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 37);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 37);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 38);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 38);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_de_tu_005fdresden_mgt_Assertion_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Assertion"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_UIElementLocator"
    // Mgt.g:1272:1: parse_de_tu_005fdresden_mgt_UIElementLocator returns [de.tu_dresden.mgt.UIElementLocator element = null] : a0= 'id' (a1= IDENTIFIER ) ;
    public final de.tu_dresden.mgt.UIElementLocator parse_de_tu_005fdresden_mgt_UIElementLocator() throws RecognitionException {
        de.tu_dresden.mgt.UIElementLocator element =  null;
        int parse_de_tu_005fdresden_mgt_UIElementLocator_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Mgt.g:1275:1: (a0= 'id' (a1= IDENTIFIER ) )
            // Mgt.g:1276:2: a0= 'id' (a1= IDENTIFIER )
            {
            a0=(Token)match(input,30,FOLLOW_30_in_parse_de_tu_005fdresden_mgt_UIElementLocator980); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createUIElementLocator();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_37, 39);
              	
            }
            // Mgt.g:1290:2: (a1= IDENTIFIER )
            // Mgt.g:1291:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_UIElementLocator998); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createUIElementLocator();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.UI_ELEMENT_LOCATOR__ID), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_1, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_38, 40);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 40);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 40);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 40);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 40);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_de_tu_005fdresden_mgt_UIElementLocator_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_UIElementLocator"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Keyword"
    // Mgt.g:1332:1: parse_de_tu_005fdresden_mgt_Keyword returns [de.tu_dresden.mgt.Keyword element = null] : (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )? ;
    public final de.tu_dresden.mgt.Keyword parse_de_tu_005fdresden_mgt_Keyword() throws RecognitionException {
        de.tu_dresden.mgt.Keyword element =  null;
        int parse_de_tu_005fdresden_mgt_Keyword_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        de.tu_dresden.mgt.UIElementLocator a2_0 = null;

        de.tu_dresden.mgt.TestDate a4_0 = null;

        de.tu_dresden.mgt.TestDate a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Mgt.g:1335:1: ( (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )? )
            // Mgt.g:1336:2: (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )?
            {
            // Mgt.g:1336:2: (a0= IDENTIFIER )
            // Mgt.g:1337:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Keyword1038); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
              				incompleteObjects.push(element);
              			}
              			if (a0 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.KEYWORD__NAME), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_0, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_39, 41);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_38, 41);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 41);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 41);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 41);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 41);
              	
            }
            // Mgt.g:1377:2: ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==30) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // Mgt.g:1378:3: (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) )
                    {
                    // Mgt.g:1378:3: (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) )
                    // Mgt.g:1379:4: a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator )
                    {
                    a1=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1068); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_1_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_36, 42, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_5);
                      			
                    }
                    // Mgt.g:1393:4: (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator )
                    // Mgt.g:1394:5: a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_UIElementLocator_in_parse_de_tu_005fdresden_mgt_Keyword1094);
                    a2_0=parse_de_tu_005fdresden_mgt_UIElementLocator();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                      						incompleteObjects.push(element);
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_38, 43);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 43);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 43);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 43);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 43);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_38, 44);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 44);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 44);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 44);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 44);
              	
            }
            // Mgt.g:1434:2: ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Mgt.g:1435:3: (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* )
                    {
                    // Mgt.g:1435:3: (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* )
                    // Mgt.g:1436:4: a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )*
                    {
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1144); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_0, null, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a3, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_29, 45, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_30, 45, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_31, 45, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_32, 45, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                      			
                    }
                    // Mgt.g:1453:4: (a4_0= parse_de_tu_005fdresden_mgt_TestDate )
                    // Mgt.g:1454:5: a4_0= parse_de_tu_005fdresden_mgt_TestDate
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1170);
                    a4_0=parse_de_tu_005fdresden_mgt_TestDate();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      					if (terminateParsing) {
                      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
                      					}
                      					if (element == null) {
                      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                      						incompleteObjects.push(element);
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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 46);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 46);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 46);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 46);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 46);
                      			
                    }
                    // Mgt.g:1483:4: ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==16) ) {
                            switch ( input.LA(2) ) {
                            case INTEGER:
                                {
                                int LA8_3 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case 33:
                                {
                                int LA8_4 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case 34:
                                {
                                int LA8_5 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case QUOTED_34_34:
                                {
                                int LA8_6 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case FLOAT:
                                {
                                int LA8_7 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;

                            }

                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Mgt.g:1484:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    	    {
                    	    // Mgt.g:1484:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    	    // Mgt.g:1485:6: a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
                    	    {
                    	    a5=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Keyword1211); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                    	      							incompleteObjects.push(element);
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_2_0_0_0, null, true);
                    	      						copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_29, 47, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_30, 47, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_31, 47, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_32, 47, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_6);
                    	      					
                    	    }
                    	    // Mgt.g:1502:6: (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
                    	    // Mgt.g:1503:7: a6_0= parse_de_tu_005fdresden_mgt_TestDate
                    	    {
                    	    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1245);
                    	    a6_0=parse_de_tu_005fdresden_mgt_TestDate();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      							if (terminateParsing) {
                    	      								throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
                    	      							}
                    	      							if (element == null) {
                    	      								element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                    	      								incompleteObjects.push(element);
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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 48);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 48);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 48);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 48);
                    	      						addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 48);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 49);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 49);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 49);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 49);
                      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 49);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 50);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_27, 50);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 50);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 50);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_de_tu_005fdresden_mgt_Keyword_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Keyword"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Sequence"
    // Mgt.g:1555:1: parse_de_tu_005fdresden_mgt_Sequence returns [de.tu_dresden.mgt.Sequence element = null] : a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}' ;
    public final de.tu_dresden.mgt.Sequence parse_de_tu_005fdresden_mgt_Sequence() throws RecognitionException {
        de.tu_dresden.mgt.Sequence element =  null;
        int parse_de_tu_005fdresden_mgt_Sequence_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        de.tu_dresden.mgt.AbstractTestStep a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Mgt.g:1558:1: (a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}' )
            // Mgt.g:1559:2: a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}'
            {
            a0=(Token)match(input,31,FOLLOW_31_in_parse_de_tu_005fdresden_mgt_Sequence1334); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_41, 51);
              	
            }
            // Mgt.g:1573:2: (a1= IDENTIFIER )
            // Mgt.g:1574:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Sequence1352); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENCE__NAME), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_2, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_42, 52);
              	
            }
            a2=(Token)match(input,13,FOLLOW_13_in_parse_de_tu_005fdresden_mgt_Sequence1373); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_4, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 53, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 53, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 53, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              	
            }
            // Mgt.g:1625:2: ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==IDENTIFIER||LA10_0==23||LA10_0==32) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Mgt.g:1626:3: ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' )
            	    {
            	    // Mgt.g:1626:3: ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' )
            	    // Mgt.g:1627:4: (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';'
            	    {
            	    // Mgt.g:1627:4: (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep )
            	    // Mgt.g:1628:5: a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep
            	    {
            	    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_Sequence1402);
            	    a3_0=parse_de_tu_005fdresden_mgt_AbstractTestStep();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      					if (terminateParsing) {
            	      						throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
            	      					}
            	      					if (element == null) {
            	      						element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            	      						incompleteObjects.push(element);
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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 54);
            	      			
            	    }
            	    a4=(Token)match(input,22,FOLLOW_22_in_parse_de_tu_005fdresden_mgt_Sequence1430); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            	      					incompleteObjects.push(element);
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_6_0_0_1, null, true);
            	      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a4, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 55, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 55, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 55, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
            	      				addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_43, 55);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_20, 56, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_21, 56, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_22, 56, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_7);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_43, 56);
              	
            }
            a5=(Token)match(input,19,FOLLOW_19_in_parse_de_tu_005fdresden_mgt_Sequence1463); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_8, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_13, 57, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_0);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_14, 57, de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.FEATURE_1);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_de_tu_005fdresden_mgt_Sequence_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Sequence"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_SequentialStep"
    // Mgt.g:1697:1: parse_de_tu_005fdresden_mgt_SequentialStep returns [de.tu_dresden.mgt.SequentialStep element = null] : a0= 'seq:' (a1= IDENTIFIER ) ;
    public final de.tu_dresden.mgt.SequentialStep parse_de_tu_005fdresden_mgt_SequentialStep() throws RecognitionException {
        de.tu_dresden.mgt.SequentialStep element =  null;
        int parse_de_tu_005fdresden_mgt_SequentialStep_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Mgt.g:1700:1: (a0= 'seq:' (a1= IDENTIFIER ) )
            // Mgt.g:1701:2: a0= 'seq:' (a1= IDENTIFIER )
            {
            a0=(Token)match(input,32,FOLLOW_32_in_parse_de_tu_005fdresden_mgt_SequentialStep1492); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequentialStep();
              			incompleteObjects.push(element);
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_0, null, true);
              		copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_44, 58);
              	
            }
            // Mgt.g:1715:2: (a1= IDENTIFIER )
            // Mgt.g:1716:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_SequentialStep1510); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequentialStep();
              				incompleteObjects.push(element);
              			}
              			if (a1 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("IDENTIFIER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.SEQUENTIAL_STEP__SEQUENCE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a1).getStopIndex());
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
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, element);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a1, proxy);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 59);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 59);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_de_tu_005fdresden_mgt_SequentialStep_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_SequentialStep"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Integer"
    // Mgt.g:1758:1: parse_de_tu_005fdresden_mgt_Integer returns [de.tu_dresden.mgt.Integer element = null] : (a0= INTEGER ) ;
    public final de.tu_dresden.mgt.Integer parse_de_tu_005fdresden_mgt_Integer() throws RecognitionException {
        de.tu_dresden.mgt.Integer element =  null;
        int parse_de_tu_005fdresden_mgt_Integer_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Mgt.g:1761:1: ( (a0= INTEGER ) )
            // Mgt.g:1762:2: (a0= INTEGER )
            {
            // Mgt.g:1762:2: (a0= INTEGER )
            // Mgt.g:1763:3: a0= INTEGER
            {
            a0=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_de_tu_005fdresden_mgt_Integer1550); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createInteger();
              				incompleteObjects.push(element);
              			}
              			if (a0 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.INTEGER__DATA_VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_7_0_0_0, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 60);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 60);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 60);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 60);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_de_tu_005fdresden_mgt_Integer_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Integer"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Boolean"
    // Mgt.g:1803:1: parse_de_tu_005fdresden_mgt_Boolean returns [de.tu_dresden.mgt.Boolean element = null] : ( (a0= 'true' | a1= 'false' ) ) ;
    public final de.tu_dresden.mgt.Boolean parse_de_tu_005fdresden_mgt_Boolean() throws RecognitionException {
        de.tu_dresden.mgt.Boolean element =  null;
        int parse_de_tu_005fdresden_mgt_Boolean_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Mgt.g:1806:1: ( ( (a0= 'true' | a1= 'false' ) ) )
            // Mgt.g:1807:2: ( (a0= 'true' | a1= 'false' ) )
            {
            // Mgt.g:1807:2: ( (a0= 'true' | a1= 'false' ) )
            // Mgt.g:1808:3: (a0= 'true' | a1= 'false' )
            {
            // Mgt.g:1808:3: (a0= 'true' | a1= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==33) ) {
                alt11=1;
            }
            else if ( (LA11_0==34) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // Mgt.g:1809:4: a0= 'true'
                    {
                    a0=(Token)match(input,33,FOLLOW_33_in_parse_de_tu_005fdresden_mgt_Boolean1595); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createBoolean();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_8_0_0_0, true, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a0, element);
                      				// set value of boolean attribute
                      				Object value = true;
                      				element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE), value);
                      				completedElement(value, false);
                      			
                    }

                    }
                    break;
                case 2 :
                    // Mgt.g:1822:8: a1= 'false'
                    {
                    a1=(Token)match(input,34,FOLLOW_34_in_parse_de_tu_005fdresden_mgt_Boolean1610); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createBoolean();
                      					incompleteObjects.push(element);
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_8_0_0_0, false, true);
                      				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken)a1, element);
                      				// set value of boolean attribute
                      				Object value = false;
                      				element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.BOOLEAN__DATA_VALUE), value);
                      				completedElement(value, false);
                      			
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 61);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 61);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 61);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 61);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_de_tu_005fdresden_mgt_Boolean_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Boolean"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_String"
    // Mgt.g:1847:1: parse_de_tu_005fdresden_mgt_String returns [de.tu_dresden.mgt.String element = null] : (a0= QUOTED_34_34 ) ;
    public final de.tu_dresden.mgt.String parse_de_tu_005fdresden_mgt_String() throws RecognitionException {
        de.tu_dresden.mgt.String element =  null;
        int parse_de_tu_005fdresden_mgt_String_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Mgt.g:1850:1: ( (a0= QUOTED_34_34 ) )
            // Mgt.g:1851:2: (a0= QUOTED_34_34 )
            {
            // Mgt.g:1851:2: (a0= QUOTED_34_34 )
            // Mgt.g:1852:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_de_tu_005fdresden_mgt_String1650); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createString();
              				incompleteObjects.push(element);
              			}
              			if (a0 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.String resolved = (java.lang.String) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.STRING__DATA_VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_9_0_0_0, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 62);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 62);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 62);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 62);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_de_tu_005fdresden_mgt_String_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_String"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_Float"
    // Mgt.g:1892:1: parse_de_tu_005fdresden_mgt_Float returns [de.tu_dresden.mgt.Float element = null] : (a0= FLOAT ) ;
    public final de.tu_dresden.mgt.Float parse_de_tu_005fdresden_mgt_Float() throws RecognitionException {
        de.tu_dresden.mgt.Float element =  null;
        int parse_de_tu_005fdresden_mgt_Float_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Mgt.g:1895:1: ( (a0= FLOAT ) )
            // Mgt.g:1896:2: (a0= FLOAT )
            {
            // Mgt.g:1896:2: (a0= FLOAT )
            // Mgt.g:1897:3: a0= FLOAT
            {
            a0=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_parse_de_tu_005fdresden_mgt_Float1690); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              			if (terminateParsing) {
              				throw new de.tu_dresden.mgt.resource.mgt.mopp.MgtTerminateParsingException();
              			}
              			if (element == null) {
              				element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createFloat();
              				incompleteObjects.push(element);
              			}
              			if (a0 != null) {
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("FLOAT");
              				tokenResolver.setOptions(getOptions());
              				de.tu_dresden.mgt.resource.mgt.IMgtTokenResolveResult result = getFreshTokenResolveResult();
              				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), result);
              				Object resolvedObject = result.getResolvedToken();
              				if (resolvedObject == null) {
              					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_3_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_3_0.CommonToken) a0).getStopIndex());
              				}
              				java.lang.Float resolved = (java.lang.Float) resolvedObject;
              				if (resolved != null) {
              					Object value = resolved;
              					element.eSet(element.eClass().getEStructuralFeature(de.tu_dresden.mgt.MgtPackage.FLOAT__DATA_VALUE), value);
              					completedElement(value, false);
              				}
              				collectHiddenTokens(element);
              				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_10_0_0_0, resolved, true);
              				copyLocalizationInfos((org.antlr.runtime3_3_0.CommonToken) a0, element);
              			}
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_28, 63);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_40, 63);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_23, 63);
              		addExpectedElement(de.tu_dresden.mgt.resource.mgt.grammar.MgtFollowSetProvider.TERMINAL_34, 63);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_de_tu_005fdresden_mgt_Float_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Float"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_AbstractTestStep"
    // Mgt.g:1937:1: parse_de_tu_005fdresden_mgt_AbstractTestStep returns [de.tu_dresden.mgt.AbstractTestStep element = null] : (c0= parse_de_tu_005fdresden_mgt_Assertion | c1= parse_de_tu_005fdresden_mgt_Keyword | c2= parse_de_tu_005fdresden_mgt_SequentialStep );
    public final de.tu_dresden.mgt.AbstractTestStep parse_de_tu_005fdresden_mgt_AbstractTestStep() throws RecognitionException {
        de.tu_dresden.mgt.AbstractTestStep element =  null;
        int parse_de_tu_005fdresden_mgt_AbstractTestStep_StartIndex = input.index();
        de.tu_dresden.mgt.Assertion c0 = null;

        de.tu_dresden.mgt.Keyword c1 = null;

        de.tu_dresden.mgt.SequentialStep c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Mgt.g:1938:1: (c0= parse_de_tu_005fdresden_mgt_Assertion | c1= parse_de_tu_005fdresden_mgt_Keyword | c2= parse_de_tu_005fdresden_mgt_SequentialStep )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt12=1;
                }
                break;
            case IDENTIFIER:
                {
                alt12=2;
                }
                break;
            case 32:
                {
                alt12=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // Mgt.g:1939:2: c0= parse_de_tu_005fdresden_mgt_Assertion
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Assertion_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1722);
                    c0=parse_de_tu_005fdresden_mgt_Assertion();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Mgt.g:1940:4: c1= parse_de_tu_005fdresden_mgt_Keyword
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1732);
                    c1=parse_de_tu_005fdresden_mgt_Keyword();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Mgt.g:1941:4: c2= parse_de_tu_005fdresden_mgt_SequentialStep
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_SequentialStep_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1742);
                    c2=parse_de_tu_005fdresden_mgt_SequentialStep();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_de_tu_005fdresden_mgt_AbstractTestStep_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_AbstractTestStep"


    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestDate"
    // Mgt.g:1945:1: parse_de_tu_005fdresden_mgt_TestDate returns [de.tu_dresden.mgt.TestDate element = null] : (c0= parse_de_tu_005fdresden_mgt_Integer | c1= parse_de_tu_005fdresden_mgt_Boolean | c2= parse_de_tu_005fdresden_mgt_String | c3= parse_de_tu_005fdresden_mgt_Float );
    public final de.tu_dresden.mgt.TestDate parse_de_tu_005fdresden_mgt_TestDate() throws RecognitionException {
        de.tu_dresden.mgt.TestDate element =  null;
        int parse_de_tu_005fdresden_mgt_TestDate_StartIndex = input.index();
        de.tu_dresden.mgt.Integer c0 = null;

        de.tu_dresden.mgt.Boolean c1 = null;

        de.tu_dresden.mgt.String c2 = null;

        de.tu_dresden.mgt.Float c3 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Mgt.g:1946:1: (c0= parse_de_tu_005fdresden_mgt_Integer | c1= parse_de_tu_005fdresden_mgt_Boolean | c2= parse_de_tu_005fdresden_mgt_String | c3= parse_de_tu_005fdresden_mgt_Float )
            int alt13=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt13=1;
                }
                break;
            case 33:
            case 34:
                {
                alt13=2;
                }
                break;
            case QUOTED_34_34:
                {
                alt13=3;
                }
                break;
            case FLOAT:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // Mgt.g:1947:2: c0= parse_de_tu_005fdresden_mgt_Integer
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Integer_in_parse_de_tu_005fdresden_mgt_TestDate1763);
                    c0=parse_de_tu_005fdresden_mgt_Integer();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Mgt.g:1948:4: c1= parse_de_tu_005fdresden_mgt_Boolean
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Boolean_in_parse_de_tu_005fdresden_mgt_TestDate1773);
                    c1=parse_de_tu_005fdresden_mgt_Boolean();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Mgt.g:1949:4: c2= parse_de_tu_005fdresden_mgt_String
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_String_in_parse_de_tu_005fdresden_mgt_TestDate1783);
                    c2=parse_de_tu_005fdresden_mgt_String();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Mgt.g:1950:4: c3= parse_de_tu_005fdresden_mgt_Float
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Float_in_parse_de_tu_005fdresden_mgt_TestDate1793);
                    c3=parse_de_tu_005fdresden_mgt_Float();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_de_tu_005fdresden_mgt_TestDate_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestDate"

    // $ANTLR start synpred10_Mgt
    public final void synpred10_Mgt_fragment() throws RecognitionException {   
        Token a5=null;
        de.tu_dresden.mgt.TestDate a6_0 = null;


        // Mgt.g:1484:5: ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )
        // Mgt.g:1484:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
        {
        // Mgt.g:1484:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
        // Mgt.g:1485:6: a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
        {
        a5=(Token)match(input,16,FOLLOW_16_in_synpred10_Mgt1211); if (state.failed) return ;
        // Mgt.g:1502:6: (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
        // Mgt.g:1503:7: a6_0= parse_de_tu_005fdresden_mgt_TestDate
        {
        pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_synpred10_Mgt1245);
        a6_0=parse_de_tu_005fdresden_mgt_TestDate();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred10_Mgt

    // Delegated rules

    public final boolean synpred10_Mgt() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Mgt_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestSuite_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_de_tu_005fdresden_mgt_TestSuite115 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_de_tu_005fdresden_mgt_TestSuite129 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite143 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite175 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestSuite196 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_parse_de_tu_005fdresden_mgt_TestSuite210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite242 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestSuite263 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_de_tu_005fdresden_mgt_TestSuite277 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite291 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestSuite309 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Sequence_in_parse_de_tu_005fdresden_mgt_TestSuite345 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestCase_in_parse_de_tu_005fdresden_mgt_TestSuite401 = new BitSet(new long[]{0x0000000080180000L});
    public static final BitSet FOLLOW_19_in_parse_de_tu_005fdresden_mgt_TestSuite442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_de_tu_005fdresden_mgt_TestCase471 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_de_tu_005fdresden_mgt_TestCase485 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_de_tu_005fdresden_mgt_TestCase499 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestCase513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestCase531 = new BitSet(new long[]{0x0000000100800020L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_TestCase567 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_de_tu_005fdresden_mgt_TestCase595 = new BitSet(new long[]{0x0000000100880020L});
    public static final BitSet FOLLOW_19_in_parse_de_tu_005fdresden_mgt_TestCase628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_de_tu_005fdresden_mgt_Assertion657 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Assertion675 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_parse_de_tu_005fdresden_mgt_Assertion696 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_Assertion714 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Assertion741 = new BitSet(new long[]{0x00000006000001C0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Assertion767 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_de_tu_005fdresden_mgt_Assertion808 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Assertion831 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_26_in_parse_de_tu_005fdresden_mgt_Assertion864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_de_tu_005fdresden_mgt_Assertion883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_de_tu_005fdresden_mgt_Assertion902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_de_tu_005fdresden_mgt_Assertion921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_parse_de_tu_005fdresden_mgt_UIElementLocator980 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_UIElementLocator998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Keyword1038 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1068 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_UIElementLocator_in_parse_de_tu_005fdresden_mgt_Keyword1094 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1144 = new BitSet(new long[]{0x00000006000001C0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1170 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Keyword1211 = new BitSet(new long[]{0x00000006000001C0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1245 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_31_in_parse_de_tu_005fdresden_mgt_Sequence1334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Sequence1352 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_de_tu_005fdresden_mgt_Sequence1373 = new BitSet(new long[]{0x0000000100800020L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_Sequence1402 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_de_tu_005fdresden_mgt_Sequence1430 = new BitSet(new long[]{0x0000000100880020L});
    public static final BitSet FOLLOW_19_in_parse_de_tu_005fdresden_mgt_Sequence1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_de_tu_005fdresden_mgt_SequentialStep1492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_SequentialStep1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_parse_de_tu_005fdresden_mgt_Integer1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_parse_de_tu_005fdresden_mgt_Boolean1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parse_de_tu_005fdresden_mgt_Boolean1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_de_tu_005fdresden_mgt_String1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_parse_de_tu_005fdresden_mgt_Float1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Assertion_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_SequentialStep_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Integer_in_parse_de_tu_005fdresden_mgt_TestDate1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Boolean_in_parse_de_tu_005fdresden_mgt_TestDate1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_String_in_parse_de_tu_005fdresden_mgt_TestDate1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Float_in_parse_de_tu_005fdresden_mgt_TestDate1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred10_Mgt1211 = new BitSet(new long[]{0x00000006000001C0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_synpred10_Mgt1245 = new BitSet(new long[]{0x0000000000000002L});

}