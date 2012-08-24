// $ANTLR 3.4

	package de.tu_dresden.mgt.resource.mgt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class MgtParser extends MgtANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIGNAME", "FLOAT", "IDENTIFIER", "INTEGER", "LINEBREAK", "QUOTED_34_34", "SL_COMMENT", "WHITESPACE", "'('", "')'", "','", "':'", "';'", "'ASSERT'", "'ERROR'", "'FAIL'", "'INCONCL'", "'PASS'", "'SEQUENCE'", "'TESTCASE'", "'TESTSUITE'", "'adapter'", "'caseName'", "'false'", "'id'", "'seq:'", "'suiteName'", "'systemUnderTest'", "'true'", "'{'", "'}'"
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
    public static final int FLOAT=5;
    public static final int IDENTIFIER=6;
    public static final int INTEGER=7;
    public static final int LINEBREAK=8;
    public static final int QUOTED_34_34=9;
    public static final int SL_COMMENT=10;
    public static final int WHITESPACE=11;

    // delegates
    public MgtANTLRParserBase[] getDelegates() {
        return new MgtANTLRParserBase[] {};
    }

    // delegators


    public MgtParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public MgtParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(32 + 1);
         

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
    	



    // $ANTLR start "start"
    // Mgt.g:529:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        de.tu_dresden.mgt.TestSuite c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Mgt.g:530:2: ( (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF )
            // Mgt.g:531:2: (c0= parse_de_tu_005fdresden_mgt_TestSuite ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Mgt.g:536:2: (c0= parse_de_tu_005fdresden_mgt_TestSuite )
            // Mgt.g:537:3: c0= parse_de_tu_005fdresden_mgt_TestSuite
            {
            pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_TestSuite_in_start82);
            c0=parse_de_tu_005fdresden_mgt_TestSuite();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestSuite"
    // Mgt.g:545:1: parse_de_tu_005fdresden_mgt_TestSuite returns [de.tu_dresden.mgt.TestSuite element = null] : a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}' ;
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
        de.tu_dresden.mgt.Sequence a13_0 =null;

        de.tu_dresden.mgt.TestCase a14_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Mgt.g:548:2: (a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}' )
            // Mgt.g:549:2: a0= 'TESTSUITE' a1= '{' a2= 'suiteName' a3= ':' (a4= BIGNAME ) a5= ',' a6= 'systemUnderTest' a7= ':' (a8= BIGNAME ) a9= ',' a10= 'adapter' a11= ':' (a12= IDENTIFIER ) ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )* ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+ a15= '}'
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_de_tu_005fdresden_mgt_TestSuite115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,33,FOLLOW_33_in_parse_de_tu_005fdresden_mgt_TestSuite129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[2]);
            	}

            a2=(Token)match(input,30,FOLLOW_30_in_parse_de_tu_005fdresden_mgt_TestSuite143); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[3]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite157); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[4]);
            	}

            // Mgt.g:605:2: (a4= BIGNAME )
            // Mgt.g:606:3: a4= BIGNAME
            {
            a4=(Token)match(input,BIGNAME,FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite175); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[5]);
            	}

            a5=(Token)match(input,14,FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite196); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_7, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[6]);
            	}

            a6=(Token)match(input,31,FOLLOW_31_in_parse_de_tu_005fdresden_mgt_TestSuite210); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[7]);
            	}

            a7=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite224); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_10, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[8]);
            	}

            // Mgt.g:683:2: (a8= BIGNAME )
            // Mgt.g:684:3: a8= BIGNAME
            {
            a8=(Token)match(input,BIGNAME,FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite242); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[9]);
            	}

            a9=(Token)match(input,14,FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite263); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_12, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[10]);
            	}

            a10=(Token)match(input,25,FOLLOW_25_in_parse_de_tu_005fdresden_mgt_TestSuite277); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_14, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[11]);
            	}

            a11=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite291); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_15, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[12]);
            	}

            // Mgt.g:761:2: (a12= IDENTIFIER )
            // Mgt.g:762:3: a12= IDENTIFIER
            {
            a12=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestSuite309); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[14]);
            	}

            // Mgt.g:798:2: ( ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==22) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Mgt.g:799:3: ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) )
            	    {
            	    // Mgt.g:799:3: ( (a13_0= parse_de_tu_005fdresden_mgt_Sequence ) )
            	    // Mgt.g:800:4: (a13_0= parse_de_tu_005fdresden_mgt_Sequence )
            	    {
            	    // Mgt.g:800:4: (a13_0= parse_de_tu_005fdresden_mgt_Sequence )
            	    // Mgt.g:801:5: a13_0= parse_de_tu_005fdresden_mgt_Sequence
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[15]);
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[16]);
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
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[17]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[18]);
            	}

            // Mgt.g:835:2: ( ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==23) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Mgt.g:836:3: ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) )
            	    {
            	    // Mgt.g:836:3: ( (a14_0= parse_de_tu_005fdresden_mgt_TestCase ) )
            	    // Mgt.g:837:4: (a14_0= parse_de_tu_005fdresden_mgt_TestCase )
            	    {
            	    // Mgt.g:837:4: (a14_0= parse_de_tu_005fdresden_mgt_TestCase )
            	    // Mgt.g:838:5: a14_0= parse_de_tu_005fdresden_mgt_TestCase
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[19]);
            	    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[20]);
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
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[21]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[22]);
            	}

            a15=(Token)match(input,34,FOLLOW_34_in_parse_de_tu_005fdresden_mgt_TestSuite442); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestSuite();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_0_0_0_20, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
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
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_de_tu_005fdresden_mgt_TestSuite_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestSuite"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestCase"
    // Mgt.g:887:1: parse_de_tu_005fdresden_mgt_TestCase returns [de.tu_dresden.mgt.TestCase element = null] : a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}' ;
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
        de.tu_dresden.mgt.AbstractTestStep a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Mgt.g:890:2: (a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}' )
            // Mgt.g:891:2: a0= 'TESTCASE' a1= '{' a2= 'caseName' a3= ':' (a4= IDENTIFIER ) ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+ a7= '}'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_de_tu_005fdresden_mgt_TestCase471); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[23]);
            	}

            a1=(Token)match(input,33,FOLLOW_33_in_parse_de_tu_005fdresden_mgt_TestCase485); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[24]);
            	}

            a2=(Token)match(input,26,FOLLOW_26_in_parse_de_tu_005fdresden_mgt_TestCase499); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[25]);
            	}

            a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestCase513); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[26]);
            	}

            // Mgt.g:947:2: (a4= IDENTIFIER )
            // Mgt.g:948:3: a4= IDENTIFIER
            {
            a4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestCase531); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[27]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[28]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[29]);
            	}

            // Mgt.g:985:2: ( ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENTIFIER||LA3_0==17||LA3_0==29) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Mgt.g:986:3: ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' )
            	    {
            	    // Mgt.g:986:3: ( (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';' )
            	    // Mgt.g:987:4: (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a6= ';'
            	    {
            	    // Mgt.g:987:4: (a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep )
            	    // Mgt.g:988:5: a5_0= parse_de_tu_005fdresden_mgt_AbstractTestStep
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[30]);
            	    			}

            	    a6=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestCase595); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_8_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[31]);
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[32]);
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[33]);
            	    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[34]);
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
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestCase(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[38]);
            	}

            a7=(Token)match(input,34,FOLLOW_34_in_parse_de_tu_005fdresden_mgt_TestCase628); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createTestCase();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_1_0_0_9, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[39]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[40]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_de_tu_005fdresden_mgt_TestCase_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestCase"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Assertion"
    // Mgt.g:1057:1: parse_de_tu_005fdresden_mgt_Assertion returns [de.tu_dresden.mgt.Assertion element = null] : a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) ) )? ;
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
        de.tu_dresden.mgt.Keyword a3_0 =null;

        de.tu_dresden.mgt.TestDate a5_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Mgt.g:1060:2: (a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) ) )? )
            // Mgt.g:1061:2: a0= 'ASSERT' (a1= IDENTIFIER ) a2= '(' (a3_0= parse_de_tu_005fdresden_mgt_Keyword ) ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )? a6= ')' ( (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) ) )?
            {
            a0=(Token)match(input,17,FOLLOW_17_in_parse_de_tu_005fdresden_mgt_Assertion657); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[41]);
            	}

            // Mgt.g:1075:2: (a1= IDENTIFIER )
            // Mgt.g:1076:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Assertion675); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[42]);
            	}

            a2=(Token)match(input,12,FOLLOW_12_in_parse_de_tu_005fdresden_mgt_Assertion696); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[43]);
            	}

            // Mgt.g:1125:2: (a3_0= parse_de_tu_005fdresden_mgt_Keyword )
            // Mgt.g:1126:3: a3_0= parse_de_tu_005fdresden_mgt_Keyword
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[45]);
            	}

            // Mgt.g:1152:2: ( (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Mgt.g:1153:3: (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    {
                    // Mgt.g:1153:3: (a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    // Mgt.g:1154:4: a4= ',' (a5_0= parse_de_tu_005fdresden_mgt_TestDate )
                    {
                    a4=(Token)match(input,14,FOLLOW_14_in_parse_de_tu_005fdresden_mgt_Assertion741); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_4_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[46]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[47]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[48]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getAssertion(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[49]);
                    			}

                    // Mgt.g:1171:4: (a5_0= parse_de_tu_005fdresden_mgt_TestDate )
                    // Mgt.g:1172:5: a5_0= parse_de_tu_005fdresden_mgt_TestDate
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[50]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[51]);
            	}

            a6=(Token)match(input,13,FOLLOW_13_in_parse_de_tu_005fdresden_mgt_Assertion808); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_5, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[54]);
            	}

            // Mgt.g:1220:2: ( (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Mgt.g:1221:3: (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) )
                    {
                    // Mgt.g:1221:3: (a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) ) )
                    // Mgt.g:1222:4: a7= ':' ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) )
                    {
                    a7=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Assertion831); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createAssertion();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_2_0_0_6_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[55]);
                    			}

                    // Mgt.g:1236:4: ( (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' ) )
                    // Mgt.g:1237:5: (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' )
                    {
                    // Mgt.g:1237:5: (a8= 'FAIL' |a9= 'ERROR' |a10= 'INCONCL' |a11= 'PASS' )
                    int alt5=4;
                    switch ( input.LA(1) ) {
                    case 19:
                        {
                        alt5=1;
                        }
                        break;
                    case 18:
                        {
                        alt5=2;
                        }
                        break;
                    case 20:
                        {
                        alt5=3;
                        }
                        break;
                    case 21:
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
                            // Mgt.g:1238:6: a8= 'FAIL'
                            {
                            a8=(Token)match(input,19,FOLLOW_19_in_parse_de_tu_005fdresden_mgt_Assertion864); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }
                            break;
                        case 2 :
                            // Mgt.g:1251:12: a9= 'ERROR'
                            {
                            a9=(Token)match(input,18,FOLLOW_18_in_parse_de_tu_005fdresden_mgt_Assertion883); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }
                            break;
                        case 3 :
                            // Mgt.g:1264:12: a10= 'INCONCL'
                            {
                            a10=(Token)match(input,20,FOLLOW_20_in_parse_de_tu_005fdresden_mgt_Assertion902); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }
                            break;
                        case 4 :
                            // Mgt.g:1277:12: a11= 'PASS'
                            {
                            a11=(Token)match(input,21,FOLLOW_21_in_parse_de_tu_005fdresden_mgt_Assertion921); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
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

                            }
                            break;

                    }


                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[56]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[57]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[58]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[59]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_de_tu_005fdresden_mgt_Assertion_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Assertion"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_UIElementLocator"
    // Mgt.g:1308:1: parse_de_tu_005fdresden_mgt_UIElementLocator returns [de.tu_dresden.mgt.UIElementLocator element = null] : a0= 'id' (a1= IDENTIFIER ) ;
    public final de.tu_dresden.mgt.UIElementLocator parse_de_tu_005fdresden_mgt_UIElementLocator() throws RecognitionException {
        de.tu_dresden.mgt.UIElementLocator element =  null;

        int parse_de_tu_005fdresden_mgt_UIElementLocator_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Mgt.g:1311:2: (a0= 'id' (a1= IDENTIFIER ) )
            // Mgt.g:1312:2: a0= 'id' (a1= IDENTIFIER )
            {
            a0=(Token)match(input,28,FOLLOW_28_in_parse_de_tu_005fdresden_mgt_UIElementLocator980); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createUIElementLocator();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_3_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[60]);
            	}

            // Mgt.g:1326:2: (a1= IDENTIFIER )
            // Mgt.g:1327:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_UIElementLocator998); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[61]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[62]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[63]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[65]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_de_tu_005fdresden_mgt_UIElementLocator_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_UIElementLocator"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Keyword"
    // Mgt.g:1368:1: parse_de_tu_005fdresden_mgt_Keyword returns [de.tu_dresden.mgt.Keyword element = null] : (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )? ;
    public final de.tu_dresden.mgt.Keyword parse_de_tu_005fdresden_mgt_Keyword() throws RecognitionException {
        de.tu_dresden.mgt.Keyword element =  null;

        int parse_de_tu_005fdresden_mgt_Keyword_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        de.tu_dresden.mgt.UIElementLocator a2_0 =null;

        de.tu_dresden.mgt.TestDate a4_0 =null;

        de.tu_dresden.mgt.TestDate a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Mgt.g:1371:2: ( (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )? )
            // Mgt.g:1372:2: (a0= IDENTIFIER ) ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )? ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )?
            {
            // Mgt.g:1372:2: (a0= IDENTIFIER )
            // Mgt.g:1373:3: a0= IDENTIFIER
            {
            a0=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Keyword1038); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[71]);
            	}

            // Mgt.g:1413:2: ( (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==28) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // Mgt.g:1414:3: (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) )
                    {
                    // Mgt.g:1414:3: (a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator ) )
                    // Mgt.g:1415:4: a1= ':' (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator )
                    {
                    a1=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1068); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_1_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[72]);
                    			}

                    // Mgt.g:1429:4: (a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator )
                    // Mgt.g:1430:5: a2_0= parse_de_tu_005fdresden_mgt_UIElementLocator
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[73]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[74]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[75]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[76]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[77]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[78]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[79]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[80]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[81]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[82]);
            	}

            // Mgt.g:1470:2: ( (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Mgt.g:1471:3: (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* )
                    {
                    // Mgt.g:1471:3: (a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )* )
                    // Mgt.g:1472:4: a3= ':' (a4_0= parse_de_tu_005fdresden_mgt_TestDate ) ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )*
                    {
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1144); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[83]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[84]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[85]);
                    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[86]);
                    			}

                    // Mgt.g:1489:4: (a4_0= parse_de_tu_005fdresden_mgt_TestDate )
                    // Mgt.g:1490:5: a4_0= parse_de_tu_005fdresden_mgt_TestDate
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

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[87]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[88]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[89]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[90]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[91]);
                    			}

                    // Mgt.g:1519:4: ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            switch ( input.LA(2) ) {
                            case INTEGER:
                                {
                                int LA8_3 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case 32:
                                {
                                int LA8_4 = input.LA(3);

                                if ( (synpred10_Mgt()) ) {
                                    alt8=1;
                                }


                                }
                                break;
                            case 27:
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
                    	    // Mgt.g:1520:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    	    {
                    	    // Mgt.g:1520:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
                    	    // Mgt.g:1521:6: a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
                    	    {
                    	    a5=(Token)match(input,14,FOLLOW_14_in_parse_de_tu_005fdresden_mgt_Keyword1211); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (element == null) {
                    	    							element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createKeyword();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						collectHiddenTokens(element);
                    	    						retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_4_0_0_2_0_0_2_0_0_0, null, true);
                    	    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
                    	    					}

                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[92]);
                    	    						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[93]);
                    	    						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[94]);
                    	    						addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getKeyword(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[95]);
                    	    					}

                    	    // Mgt.g:1538:6: (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
                    	    // Mgt.g:1539:7: a6_0= parse_de_tu_005fdresden_mgt_TestDate
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

                    	    }


                    	    if ( state.backtracking==0 ) {
                    	    						// expected elements (follow set)
                    	    						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[96]);
                    	    						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[97]);
                    	    						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[98]);
                    	    						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[99]);
                    	    						addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[100]);
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
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[101]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[102]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[103]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[104]);
                    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[105]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[106]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[107]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[108]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[109]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_de_tu_005fdresden_mgt_Keyword_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Keyword"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Sequence"
    // Mgt.g:1591:1: parse_de_tu_005fdresden_mgt_Sequence returns [de.tu_dresden.mgt.Sequence element = null] : a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}' ;
    public final de.tu_dresden.mgt.Sequence parse_de_tu_005fdresden_mgt_Sequence() throws RecognitionException {
        de.tu_dresden.mgt.Sequence element =  null;

        int parse_de_tu_005fdresden_mgt_Sequence_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a5=null;
        de.tu_dresden.mgt.AbstractTestStep a3_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Mgt.g:1594:2: (a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}' )
            // Mgt.g:1595:2: a0= 'SEQUENCE' (a1= IDENTIFIER ) a2= '{' ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+ a5= '}'
            {
            a0=(Token)match(input,22,FOLLOW_22_in_parse_de_tu_005fdresden_mgt_Sequence1334); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[110]);
            	}

            // Mgt.g:1609:2: (a1= IDENTIFIER )
            // Mgt.g:1610:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Sequence1352); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[111]);
            	}

            a2=(Token)match(input,33,FOLLOW_33_in_parse_de_tu_005fdresden_mgt_Sequence1373); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[114]);
            	}

            // Mgt.g:1661:2: ( ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==IDENTIFIER||LA10_0==17||LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Mgt.g:1662:3: ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' )
            	    {
            	    // Mgt.g:1662:3: ( (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';' )
            	    // Mgt.g:1663:4: (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep ) a4= ';'
            	    {
            	    // Mgt.g:1663:4: (a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep )
            	    // Mgt.g:1664:5: a3_0= parse_de_tu_005fdresden_mgt_AbstractTestStep
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

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[115]);
            	    			}

            	    a4=(Token)match(input,16,FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Sequence1430); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_6_0_0_1, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[116]);
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[117]);
            	    				addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[118]);
            	    				addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[119]);
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
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getSequence(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[123]);
            	}

            a5=(Token)match(input,34,FOLLOW_34_in_parse_de_tu_005fdresden_mgt_Sequence1463); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequence();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_5_0_0_8, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(de.tu_dresden.mgt.MgtPackage.eINSTANCE.getTestSuite(), de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[125]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_de_tu_005fdresden_mgt_Sequence_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Sequence"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_SequentialStep"
    // Mgt.g:1733:1: parse_de_tu_005fdresden_mgt_SequentialStep returns [de.tu_dresden.mgt.SequentialStep element = null] : a0= 'seq:' (a1= IDENTIFIER ) ;
    public final de.tu_dresden.mgt.SequentialStep parse_de_tu_005fdresden_mgt_SequentialStep() throws RecognitionException {
        de.tu_dresden.mgt.SequentialStep element =  null;

        int parse_de_tu_005fdresden_mgt_SequentialStep_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Mgt.g:1736:2: (a0= 'seq:' (a1= IDENTIFIER ) )
            // Mgt.g:1737:2: a0= 'seq:' (a1= IDENTIFIER )
            {
            a0=(Token)match(input,29,FOLLOW_29_in_parse_de_tu_005fdresden_mgt_SequentialStep1492); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = de.tu_dresden.mgt.MgtFactory.eINSTANCE.createSequentialStep();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, de.tu_dresden.mgt.resource.mgt.grammar.MgtGrammarInformationProvider.MGT_6_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[126]);
            	}

            // Mgt.g:1751:2: (a1= IDENTIFIER )
            // Mgt.g:1752:3: a1= IDENTIFIER
            {
            a1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_SequentialStep1510); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[127]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[128]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_de_tu_005fdresden_mgt_SequentialStep_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_SequentialStep"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Integer"
    // Mgt.g:1794:1: parse_de_tu_005fdresden_mgt_Integer returns [de.tu_dresden.mgt.Integer element = null] : (a0= INTEGER ) ;
    public final de.tu_dresden.mgt.Integer parse_de_tu_005fdresden_mgt_Integer() throws RecognitionException {
        de.tu_dresden.mgt.Integer element =  null;

        int parse_de_tu_005fdresden_mgt_Integer_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Mgt.g:1797:2: ( (a0= INTEGER ) )
            // Mgt.g:1798:2: (a0= INTEGER )
            {
            // Mgt.g:1798:2: (a0= INTEGER )
            // Mgt.g:1799:3: a0= INTEGER
            {
            a0=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parse_de_tu_005fdresden_mgt_Integer1550); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[129]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[130]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[131]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[132]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_de_tu_005fdresden_mgt_Integer_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Integer"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Boolean"
    // Mgt.g:1839:1: parse_de_tu_005fdresden_mgt_Boolean returns [de.tu_dresden.mgt.Boolean element = null] : ( (a0= 'true' |a1= 'false' ) ) ;
    public final de.tu_dresden.mgt.Boolean parse_de_tu_005fdresden_mgt_Boolean() throws RecognitionException {
        de.tu_dresden.mgt.Boolean element =  null;

        int parse_de_tu_005fdresden_mgt_Boolean_StartIndex = input.index();

        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Mgt.g:1842:2: ( ( (a0= 'true' |a1= 'false' ) ) )
            // Mgt.g:1843:2: ( (a0= 'true' |a1= 'false' ) )
            {
            // Mgt.g:1843:2: ( (a0= 'true' |a1= 'false' ) )
            // Mgt.g:1844:3: (a0= 'true' |a1= 'false' )
            {
            // Mgt.g:1844:3: (a0= 'true' |a1= 'false' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==32) ) {
                alt11=1;
            }
            else if ( (LA11_0==27) ) {
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
                    // Mgt.g:1845:4: a0= 'true'
                    {
                    a0=(Token)match(input,32,FOLLOW_32_in_parse_de_tu_005fdresden_mgt_Boolean1595); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;
                case 2 :
                    // Mgt.g:1858:8: a1= 'false'
                    {
                    a1=(Token)match(input,27,FOLLOW_27_in_parse_de_tu_005fdresden_mgt_Boolean1610); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
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

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[133]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[134]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[135]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[136]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_de_tu_005fdresden_mgt_Boolean_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Boolean"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_String"
    // Mgt.g:1883:1: parse_de_tu_005fdresden_mgt_String returns [de.tu_dresden.mgt.String element = null] : (a0= QUOTED_34_34 ) ;
    public final de.tu_dresden.mgt.String parse_de_tu_005fdresden_mgt_String() throws RecognitionException {
        de.tu_dresden.mgt.String element =  null;

        int parse_de_tu_005fdresden_mgt_String_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Mgt.g:1886:2: ( (a0= QUOTED_34_34 ) )
            // Mgt.g:1887:2: (a0= QUOTED_34_34 )
            {
            // Mgt.g:1887:2: (a0= QUOTED_34_34 )
            // Mgt.g:1888:3: a0= QUOTED_34_34
            {
            a0=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_de_tu_005fdresden_mgt_String1650); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[140]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_de_tu_005fdresden_mgt_String_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_String"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_Float"
    // Mgt.g:1928:1: parse_de_tu_005fdresden_mgt_Float returns [de.tu_dresden.mgt.Float element = null] : (a0= FLOAT ) ;
    public final de.tu_dresden.mgt.Float parse_de_tu_005fdresden_mgt_Float() throws RecognitionException {
        de.tu_dresden.mgt.Float element =  null;

        int parse_de_tu_005fdresden_mgt_Float_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Mgt.g:1931:2: ( (a0= FLOAT ) )
            // Mgt.g:1932:2: (a0= FLOAT )
            {
            // Mgt.g:1932:2: (a0= FLOAT )
            // Mgt.g:1933:3: a0= FLOAT
            {
            a0=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_parse_de_tu_005fdresden_mgt_Float1690); if (state.failed) return element;

            if ( state.backtracking==0 ) {
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

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(null, de.tu_dresden.mgt.resource.mgt.mopp.MgtExpectationConstants.EXPECTATIONS[144]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_de_tu_005fdresden_mgt_Float_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_Float"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_AbstractTestStep"
    // Mgt.g:1973:1: parse_de_tu_005fdresden_mgt_AbstractTestStep returns [de.tu_dresden.mgt.AbstractTestStep element = null] : (c0= parse_de_tu_005fdresden_mgt_Assertion |c1= parse_de_tu_005fdresden_mgt_Keyword |c2= parse_de_tu_005fdresden_mgt_SequentialStep );
    public final de.tu_dresden.mgt.AbstractTestStep parse_de_tu_005fdresden_mgt_AbstractTestStep() throws RecognitionException {
        de.tu_dresden.mgt.AbstractTestStep element =  null;

        int parse_de_tu_005fdresden_mgt_AbstractTestStep_StartIndex = input.index();

        de.tu_dresden.mgt.Assertion c0 =null;

        de.tu_dresden.mgt.Keyword c1 =null;

        de.tu_dresden.mgt.SequentialStep c2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Mgt.g:1974:2: (c0= parse_de_tu_005fdresden_mgt_Assertion |c1= parse_de_tu_005fdresden_mgt_Keyword |c2= parse_de_tu_005fdresden_mgt_SequentialStep )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt12=1;
                }
                break;
            case IDENTIFIER:
                {
                alt12=2;
                }
                break;
            case 29:
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
                    // Mgt.g:1975:2: c0= parse_de_tu_005fdresden_mgt_Assertion
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Assertion_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1722);
                    c0=parse_de_tu_005fdresden_mgt_Assertion();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Mgt.g:1976:4: c1= parse_de_tu_005fdresden_mgt_Keyword
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1732);
                    c1=parse_de_tu_005fdresden_mgt_Keyword();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Mgt.g:1977:4: c2= parse_de_tu_005fdresden_mgt_SequentialStep
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_SequentialStep_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1742);
                    c2=parse_de_tu_005fdresden_mgt_SequentialStep();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_de_tu_005fdresden_mgt_AbstractTestStep_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_AbstractTestStep"



    // $ANTLR start "parse_de_tu_005fdresden_mgt_TestDate"
    // Mgt.g:1981:1: parse_de_tu_005fdresden_mgt_TestDate returns [de.tu_dresden.mgt.TestDate element = null] : (c0= parse_de_tu_005fdresden_mgt_Integer |c1= parse_de_tu_005fdresden_mgt_Boolean |c2= parse_de_tu_005fdresden_mgt_String |c3= parse_de_tu_005fdresden_mgt_Float );
    public final de.tu_dresden.mgt.TestDate parse_de_tu_005fdresden_mgt_TestDate() throws RecognitionException {
        de.tu_dresden.mgt.TestDate element =  null;

        int parse_de_tu_005fdresden_mgt_TestDate_StartIndex = input.index();

        de.tu_dresden.mgt.Integer c0 =null;

        de.tu_dresden.mgt.Boolean c1 =null;

        de.tu_dresden.mgt.String c2 =null;

        de.tu_dresden.mgt.Float c3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Mgt.g:1982:2: (c0= parse_de_tu_005fdresden_mgt_Integer |c1= parse_de_tu_005fdresden_mgt_Boolean |c2= parse_de_tu_005fdresden_mgt_String |c3= parse_de_tu_005fdresden_mgt_Float )
            int alt13=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt13=1;
                }
                break;
            case 27:
            case 32:
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
                    // Mgt.g:1983:2: c0= parse_de_tu_005fdresden_mgt_Integer
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Integer_in_parse_de_tu_005fdresden_mgt_TestDate1763);
                    c0=parse_de_tu_005fdresden_mgt_Integer();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Mgt.g:1984:4: c1= parse_de_tu_005fdresden_mgt_Boolean
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Boolean_in_parse_de_tu_005fdresden_mgt_TestDate1773);
                    c1=parse_de_tu_005fdresden_mgt_Boolean();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Mgt.g:1985:4: c2= parse_de_tu_005fdresden_mgt_String
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_String_in_parse_de_tu_005fdresden_mgt_TestDate1783);
                    c2=parse_de_tu_005fdresden_mgt_String();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Mgt.g:1986:4: c3= parse_de_tu_005fdresden_mgt_Float
                    {
                    pushFollow(FOLLOW_parse_de_tu_005fdresden_mgt_Float_in_parse_de_tu_005fdresden_mgt_TestDate1793);
                    c3=parse_de_tu_005fdresden_mgt_Float();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_de_tu_005fdresden_mgt_TestDate_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_de_tu_005fdresden_mgt_TestDate"

    // $ANTLR start synpred10_Mgt
    public final void synpred10_Mgt_fragment() throws RecognitionException {
        Token a5=null;
        de.tu_dresden.mgt.TestDate a6_0 =null;


        // Mgt.g:1520:5: ( (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) ) )
        // Mgt.g:1520:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
        {
        // Mgt.g:1520:5: (a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate ) )
        // Mgt.g:1521:6: a5= ',' (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
        {
        a5=(Token)match(input,14,FOLLOW_14_in_synpred10_Mgt1211); if (state.failed) return ;

        // Mgt.g:1538:6: (a6_0= parse_de_tu_005fdresden_mgt_TestDate )
        // Mgt.g:1539:7: a6_0= parse_de_tu_005fdresden_mgt_TestDate
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
    public static final BitSet FOLLOW_24_in_parse_de_tu_005fdresden_mgt_TestSuite115 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_de_tu_005fdresden_mgt_TestSuite129 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_de_tu_005fdresden_mgt_TestSuite143 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite175 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite196 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_de_tu_005fdresden_mgt_TestSuite210 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_BIGNAME_in_parse_de_tu_005fdresden_mgt_TestSuite242 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_parse_de_tu_005fdresden_mgt_TestSuite263 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_de_tu_005fdresden_mgt_TestSuite277 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestSuite291 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestSuite309 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Sequence_in_parse_de_tu_005fdresden_mgt_TestSuite345 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestCase_in_parse_de_tu_005fdresden_mgt_TestSuite401 = new BitSet(new long[]{0x0000000400800000L});
    public static final BitSet FOLLOW_34_in_parse_de_tu_005fdresden_mgt_TestSuite442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_de_tu_005fdresden_mgt_TestCase471 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_de_tu_005fdresden_mgt_TestCase485 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_de_tu_005fdresden_mgt_TestCase499 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_TestCase513 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_TestCase531 = new BitSet(new long[]{0x0000000020020040L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_TestCase567 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_TestCase595 = new BitSet(new long[]{0x0000000420020040L});
    public static final BitSet FOLLOW_34_in_parse_de_tu_005fdresden_mgt_TestCase628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_de_tu_005fdresden_mgt_Assertion657 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Assertion675 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_parse_de_tu_005fdresden_mgt_Assertion696 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_Assertion714 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_parse_de_tu_005fdresden_mgt_Assertion741 = new BitSet(new long[]{0x00000001080002A0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Assertion767 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_parse_de_tu_005fdresden_mgt_Assertion808 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Assertion831 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_19_in_parse_de_tu_005fdresden_mgt_Assertion864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_de_tu_005fdresden_mgt_Assertion883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_parse_de_tu_005fdresden_mgt_Assertion902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_de_tu_005fdresden_mgt_Assertion921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_parse_de_tu_005fdresden_mgt_UIElementLocator980 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_UIElementLocator998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Keyword1038 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1068 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_UIElementLocator_in_parse_de_tu_005fdresden_mgt_Keyword1094 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_de_tu_005fdresden_mgt_Keyword1144 = new BitSet(new long[]{0x00000001080002A0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1170 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parse_de_tu_005fdresden_mgt_Keyword1211 = new BitSet(new long[]{0x00000001080002A0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_parse_de_tu_005fdresden_mgt_Keyword1245 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_22_in_parse_de_tu_005fdresden_mgt_Sequence1334 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_Sequence1352 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_de_tu_005fdresden_mgt_Sequence1373 = new BitSet(new long[]{0x0000000020020040L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_AbstractTestStep_in_parse_de_tu_005fdresden_mgt_Sequence1402 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_de_tu_005fdresden_mgt_Sequence1430 = new BitSet(new long[]{0x0000000420020040L});
    public static final BitSet FOLLOW_34_in_parse_de_tu_005fdresden_mgt_Sequence1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_de_tu_005fdresden_mgt_SequentialStep1492 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parse_de_tu_005fdresden_mgt_SequentialStep1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_parse_de_tu_005fdresden_mgt_Integer1550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_parse_de_tu_005fdresden_mgt_Boolean1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parse_de_tu_005fdresden_mgt_Boolean1610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_de_tu_005fdresden_mgt_String1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_parse_de_tu_005fdresden_mgt_Float1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Assertion_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Keyword_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_SequentialStep_in_parse_de_tu_005fdresden_mgt_AbstractTestStep1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Integer_in_parse_de_tu_005fdresden_mgt_TestDate1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Boolean_in_parse_de_tu_005fdresden_mgt_TestDate1773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_String_in_parse_de_tu_005fdresden_mgt_TestDate1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_Float_in_parse_de_tu_005fdresden_mgt_TestDate1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred10_Mgt1211 = new BitSet(new long[]{0x00000001080002A0L});
    public static final BitSet FOLLOW_parse_de_tu_005fdresden_mgt_TestDate_in_synpred10_Mgt1245 = new BitSet(new long[]{0x0000000000000002L});

}