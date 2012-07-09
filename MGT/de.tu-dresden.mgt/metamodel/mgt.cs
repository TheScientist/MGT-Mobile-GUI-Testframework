SYNTAXDEF mgt
FOR <http://mgt/1.0>
START TestSuite

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	usePredefinedTokens = "false";
	overrideCodeCompletionHelper = "false";
	overrideLaunchConfigurationDelegate = "false";
	overrideLaunchConfigurationMainTab = "false";
	overridePluginXML = "false";
	overrideManifest = "false";
	overrideUIPluginXML = "false";
	overrideUIManifest = "false";
	//disableTokenSorting = "true";
}

TOKENS {
	DEFINE IDENTIFIER $('a'..'z')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE BIGNAME $('A'..'Z')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
}

TOKENSTYLES {
	//"ASSERTION" COLOR #000000, ITALIC, BOLD; 
	//"LOCATOR" COLOR #000000, UNDERLINE;
	"INTEGER" COLOR #0000FF; 
}

RULES {
	TestSuite ::= "TESTSUITE" #1 "{" !1
						"suiteName"":" name[BIGNAME]"," !1
	                    "systemUnderTest"":" systemUnderTest[BIGNAME]"," !1
						"adapter"":" adapter[IDENTIFIER] !1
						(sequences!1)* 
						(testCases!0)+
					"}";
	@SuppressWarnings(featureWithoutSyntax)//Verdict not used in Language, at least for now
	TestCase ::= "TESTCASE" #1 "{" !2
						"caseName" ":" name[IDENTIFIER] !2
						(testSteps ";"!1)+ 
					"}";
	Assertion ::= "ASSERT" assert[IDENTIFIER]"(" actual ("," expected)? ")" (":" 
					verdict[fail : "FAIL", error : "ERROR", inconclusive : "INCONCL", pass : "PASS"])?;
	UIElementLocator ::= "id" id[IDENTIFIER];
	Keyword ::= name[IDENTIFIER]  (":" target)?  (":" testData ("," testData)*)?  ;
	Sequence ::= "SEQUENCE" #1 name[IDENTIFIER] #1"{" !1
						(steps ";"!1)+ !0
					"}";
	SequentialStep ::= "seq:" sequence[IDENTIFIER];
	Integer ::= dataValue[INTEGER];
	Boolean ::= dataValue["true" : "false"];
	String ::= dataValue['"','"'];
	Float ::= dataValue[FLOAT];
}