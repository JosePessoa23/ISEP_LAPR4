// Generated from C:/Users/Rita Lello/Documents/lei21_22_s4_2de_02/base.core/src/main/java/eapli/base/surveymanagement/application/grammar\SurveyGrammar.g4 by ANTLR 4.10.1
package eapli.base.surveymanagement.application.grammar.ANTLR;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SurveyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, NUMBER=2, LETTER=3, SPACE=4, END=5, MANDATORY=6, OPTIONAL=7, 
		CONDITION_DEPENDENT=8, FREE_TEXT=9, NUMERIC=10, SINGLE_CHOICE1=11, SINGLE_CHOICE2=12, 
		MULTIPLE_CHOICE1=13, MULTIPLE_CHOICE2=14, SORTING_OPTIONS=15, SCALLING_OPTIONS=16, 
		CHOICEMARK=17;
	public static final int
		RULE_prog = 0, RULE_survey = 1, RULE_surveyID = 2, RULE_alphanumeric = 3, 
		RULE_title = 4, RULE_welcomeMessage = 5, RULE_sentence = 6, RULE_sectionList = 7, 
		RULE_finalMessage = 8, RULE_section = 9, RULE_sectionID = 10, RULE_shortDescription = 11, 
		RULE_obligatoriness = 12, RULE_condition = 13, RULE_content = 14, RULE_question = 15, 
		RULE_questionID = 16, RULE_questionSentence = 17, RULE_type = 18, RULE_choices = 19, 
		RULE_choice = 20, RULE_choiceID = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "survey", "surveyID", "alphanumeric", "title", "welcomeMessage", 
			"sentence", "sectionList", "finalMessage", "section", "sectionID", "shortDescription", 
			"obligatoriness", "condition", "content", "question", "questionID", "questionSentence", 
			"type", "choices", "choice", "choiceID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "' '", null, "'mandatory'", "'optional'", "'condition dependent'", 
			"'free-text'", "'numeric'", "'single-choice'", "'single-choice with input value'", 
			"'multiple-choice'", "'multiple-choice with input value'", "'sorting options'", 
			"'scalling options'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "NUMBER", "LETTER", "SPACE", "END", "MANDATORY", "OPTIONAL", 
			"CONDITION_DEPENDENT", "FREE_TEXT", "NUMERIC", "SINGLE_CHOICE1", "SINGLE_CHOICE2", 
			"MULTIPLE_CHOICE1", "MULTIPLE_CHOICE2", "SORTING_OPTIONS", "SCALLING_OPTIONS", 
			"CHOICEMARK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SurveyGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SurveyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public SurveyContext survey() {
			return getRuleContext(SurveyContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			survey();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SurveyContext extends ParserRuleContext {
		public SurveyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_survey; }
	 
		public SurveyContext() { }
		public void copyFrom(SurveyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuestionarioContext extends SurveyContext {
		public SurveyIDContext surveyID() {
			return getRuleContext(SurveyIDContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyGrammarParser.NEWLINE, i);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public WelcomeMessageContext welcomeMessage() {
			return getRuleContext(WelcomeMessageContext.class,0);
		}
		public SectionListContext sectionList() {
			return getRuleContext(SectionListContext.class,0);
		}
		public FinalMessageContext finalMessage() {
			return getRuleContext(FinalMessageContext.class,0);
		}
		public QuestionarioContext(SurveyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterQuestionario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitQuestionario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitQuestionario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurveyContext survey() throws RecognitionException {
		SurveyContext _localctx = new SurveyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_survey);
		try {
			_localctx = new QuestionarioContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			surveyID();
			setState(47);
			match(NEWLINE);
			setState(48);
			title();
			setState(49);
			match(NEWLINE);
			setState(50);
			welcomeMessage();
			setState(51);
			sectionList();
			setState(52);
			finalMessage();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SurveyIDContext extends ParserRuleContext {
		public AlphanumericContext alphanumeric() {
			return getRuleContext(AlphanumericContext.class,0);
		}
		public SurveyIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_surveyID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterSurveyID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitSurveyID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitSurveyID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SurveyIDContext surveyID() throws RecognitionException {
		SurveyIDContext _localctx = new SurveyIDContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_surveyID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			alphanumeric();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlphanumericContext extends ParserRuleContext {
		public TerminalNode LETTER() { return getToken(SurveyGrammarParser.LETTER, 0); }
		public AlphanumericContext alphanumeric() {
			return getRuleContext(AlphanumericContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(SurveyGrammarParser.NUMBER, 0); }
		public AlphanumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphanumeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterAlphanumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitAlphanumeric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitAlphanumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlphanumericContext alphanumeric() throws RecognitionException {
		AlphanumericContext _localctx = new AlphanumericContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_alphanumeric);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(LETTER);
				setState(57);
				alphanumeric();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(NUMBER);
				setState(59);
				alphanumeric();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(LETTER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(61);
				match(NUMBER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			sentence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WelcomeMessageContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SurveyGrammarParser.NEWLINE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public WelcomeMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcomeMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterWelcomeMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitWelcomeMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitWelcomeMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WelcomeMessageContext welcomeMessage() throws RecognitionException {
		WelcomeMessageContext _localctx = new WelcomeMessageContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_welcomeMessage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << LETTER) | (1L << END))) != 0)) {
				{
				{
				setState(66);
				sentence();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public List<TerminalNode> LETTER() { return getTokens(SurveyGrammarParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(SurveyGrammarParser.LETTER, i);
		}
		public TerminalNode SPACE() { return getToken(SurveyGrammarParser.SPACE, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SurveyGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SurveyGrammarParser.NUMBER, i);
		}
		public List<TerminalNode> END() { return getTokens(SurveyGrammarParser.END); }
		public TerminalNode END(int i) {
			return getToken(SurveyGrammarParser.END, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentence);
		int _la;
		try {
			int _alt;
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(74);
						match(LETTER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(77); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(79);
					match(SPACE);
					}
				}

				setState(82);
				sentence();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(83);
						match(NUMBER);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(86); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(88);
					match(SPACE);
					}
				}

				setState(91);
				sentence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(92);
						match(END);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(95); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SPACE) {
					{
					setState(97);
					match(SPACE);
					}
				}

				setState(100);
				sentence();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(101);
						match(END);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(104); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionListContext extends ParserRuleContext {
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public SectionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterSectionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitSectionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitSectionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionListContext sectionList() throws RecognitionException {
		SectionListContext _localctx = new SectionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sectionList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(108);
					section();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(111); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinalMessageContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SurveyGrammarParser.NEWLINE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public FinalMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterFinalMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitFinalMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitFinalMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalMessageContext finalMessage() throws RecognitionException {
		FinalMessageContext _localctx = new FinalMessageContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_finalMessage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << LETTER) | (1L << END))) != 0)) {
				{
				{
				setState(113);
				sentence();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionContext extends ParserRuleContext {
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
	 
		public SectionContext() { }
		public void copyFrom(SectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeccaoContext extends SectionContext {
		public SectionIDContext sectionID() {
			return getRuleContext(SectionIDContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(SurveyGrammarParser.SPACE, 0); }
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyGrammarParser.NEWLINE, i);
		}
		public ShortDescriptionContext shortDescription() {
			return getRuleContext(ShortDescriptionContext.class,0);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode END() { return getToken(SurveyGrammarParser.END, 0); }
		public SeccaoContext(SectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterSeccao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitSeccao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitSeccao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_section);
		int _la;
		try {
			_localctx = new SeccaoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			sectionID();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END) {
				{
				setState(122);
				match(END);
				}
			}

			setState(125);
			match(SPACE);
			setState(126);
			title();
			setState(127);
			match(NEWLINE);
			setState(128);
			shortDescription();
			setState(129);
			obligatoriness();
			setState(130);
			match(NEWLINE);
			setState(131);
			content();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SectionIDContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(SurveyGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SurveyGrammarParser.NUMBER, i);
		}
		public SectionIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sectionID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterSectionID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitSectionID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitSectionID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionIDContext sectionID() throws RecognitionException {
		SectionIDContext _localctx = new SectionIDContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sectionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				match(NUMBER);
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShortDescriptionContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SurveyGrammarParser.NEWLINE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public ShortDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shortDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterShortDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitShortDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitShortDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShortDescriptionContext shortDescription() throws RecognitionException {
		ShortDescriptionContext _localctx = new ShortDescriptionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_shortDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << LETTER) | (1L << END))) != 0)) {
				{
				{
				setState(138);
				sentence();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObligatorinessContext extends ParserRuleContext {
		public TerminalNode MANDATORY() { return getToken(SurveyGrammarParser.MANDATORY, 0); }
		public TerminalNode OPTIONAL() { return getToken(SurveyGrammarParser.OPTIONAL, 0); }
		public TerminalNode CONDITION_DEPENDENT() { return getToken(SurveyGrammarParser.CONDITION_DEPENDENT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ObligatorinessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obligatoriness; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterObligatoriness(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitObligatoriness(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitObligatoriness(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObligatorinessContext obligatoriness() throws RecognitionException {
		ObligatorinessContext _localctx = new ObligatorinessContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_obligatoriness);
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MANDATORY:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(MANDATORY);
				}
				break;
			case OPTIONAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(OPTIONAL);
				}
				break;
			case CONDITION_DEPENDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(CONDITION_DEPENDENT);
				setState(149);
				condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(SurveyGrammarParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(SurveyGrammarParser.SPACE, i);
		}
		public SectionIDContext sectionID() {
			return getRuleContext(SectionIDContext.class,0);
		}
		public QuestionIDContext questionID() {
			return getRuleContext(QuestionIDContext.class,0);
		}
		public ChoiceIDContext choiceID() {
			return getRuleContext(ChoiceIDContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(SPACE);
			setState(153);
			sectionID();
			setState(154);
			match(SPACE);
			setState(155);
			questionID();
			setState(156);
			match(SPACE);
			setState(157);
			choiceID();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContentContext extends ParserRuleContext {
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_content);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(159);
					question();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(162); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionContext extends ParserRuleContext {
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	 
		public QuestionContext() { }
		public void copyFrom(QuestionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuestaoContext extends QuestionContext {
		public QuestionIDContext questionID() {
			return getRuleContext(QuestionIDContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(SurveyGrammarParser.SPACE, 0); }
		public QuestionSentenceContext questionSentence() {
			return getRuleContext(QuestionSentenceContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SurveyGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SurveyGrammarParser.NEWLINE, i);
		}
		public ObligatorinessContext obligatoriness() {
			return getRuleContext(ObligatorinessContext.class,0);
		}
		public TerminalNode END() { return getToken(SurveyGrammarParser.END, 0); }
		public QuestaoContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterQuestao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitQuestao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitQuestao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_question);
		int _la;
		try {
			_localctx = new QuestaoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			questionID();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END) {
				{
				setState(165);
				match(END);
				}
			}

			setState(168);
			match(SPACE);
			setState(169);
			questionSentence();
			setState(170);
			type();
			setState(171);
			match(NEWLINE);
			setState(172);
			obligatoriness();
			setState(173);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionIDContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(SurveyGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SurveyGrammarParser.NUMBER, i);
		}
		public QuestionIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterQuestionID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitQuestionID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitQuestionID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionIDContext questionID() throws RecognitionException {
		QuestionIDContext _localctx = new QuestionIDContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_questionID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				match(NUMBER);
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionSentenceContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SurveyGrammarParser.NEWLINE, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public QuestionSentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionSentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterQuestionSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitQuestionSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitQuestionSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionSentenceContext questionSentence() throws RecognitionException {
		QuestionSentenceContext _localctx = new QuestionSentenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_questionSentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(180);
				sentence();
				}
				}
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << LETTER) | (1L << END))) != 0) );
			setState(185);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FREE_TEXT() { return getToken(SurveyGrammarParser.FREE_TEXT, 0); }
		public TerminalNode NUMERIC() { return getToken(SurveyGrammarParser.NUMERIC, 0); }
		public TerminalNode SINGLE_CHOICE1() { return getToken(SurveyGrammarParser.SINGLE_CHOICE1, 0); }
		public ChoicesContext choices() {
			return getRuleContext(ChoicesContext.class,0);
		}
		public TerminalNode SINGLE_CHOICE2() { return getToken(SurveyGrammarParser.SINGLE_CHOICE2, 0); }
		public TerminalNode MULTIPLE_CHOICE1() { return getToken(SurveyGrammarParser.MULTIPLE_CHOICE1, 0); }
		public TerminalNode MULTIPLE_CHOICE2() { return getToken(SurveyGrammarParser.MULTIPLE_CHOICE2, 0); }
		public TerminalNode SORTING_OPTIONS() { return getToken(SurveyGrammarParser.SORTING_OPTIONS, 0); }
		public TerminalNode SCALLING_OPTIONS() { return getToken(SurveyGrammarParser.SCALLING_OPTIONS, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FREE_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(FREE_TEXT);
				}
				break;
			case NUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(NUMERIC);
				}
				break;
			case SINGLE_CHOICE1:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				match(SINGLE_CHOICE1);
				setState(190);
				choices();
				}
				break;
			case SINGLE_CHOICE2:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				match(SINGLE_CHOICE2);
				setState(192);
				choices();
				}
				break;
			case MULTIPLE_CHOICE1:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				match(MULTIPLE_CHOICE1);
				setState(194);
				choices();
				}
				break;
			case MULTIPLE_CHOICE2:
				enterOuterAlt(_localctx, 6);
				{
				setState(195);
				match(MULTIPLE_CHOICE2);
				setState(196);
				choices();
				}
				break;
			case SORTING_OPTIONS:
				enterOuterAlt(_localctx, 7);
				{
				setState(197);
				match(SORTING_OPTIONS);
				setState(198);
				choices();
				}
				break;
			case SCALLING_OPTIONS:
				enterOuterAlt(_localctx, 8);
				{
				setState(199);
				match(SCALLING_OPTIONS);
				setState(200);
				choices();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoicesContext extends ParserRuleContext {
		public List<ChoiceContext> choice() {
			return getRuleContexts(ChoiceContext.class);
		}
		public ChoiceContext choice(int i) {
			return getRuleContext(ChoiceContext.class,i);
		}
		public ChoicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterChoices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitChoices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitChoices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoicesContext choices() throws RecognitionException {
		ChoicesContext _localctx = new ChoicesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_choices);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(203);
					choice();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(206); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoiceContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SurveyGrammarParser.NEWLINE, 0); }
		public ChoiceIDContext choiceID() {
			return getRuleContext(ChoiceIDContext.class,0);
		}
		public TerminalNode CHOICEMARK() { return getToken(SurveyGrammarParser.CHOICEMARK, 0); }
		public TerminalNode SPACE() { return getToken(SurveyGrammarParser.SPACE, 0); }
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public ChoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterChoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitChoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitChoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceContext choice() throws RecognitionException {
		ChoiceContext _localctx = new ChoiceContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_choice);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(NEWLINE);
			setState(209);
			choiceID();
			setState(210);
			match(CHOICEMARK);
			setState(211);
			match(SPACE);
			setState(212);
			sentence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChoiceIDContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(SurveyGrammarParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(SurveyGrammarParser.LETTER, i);
		}
		public ChoiceIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choiceID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).enterChoiceID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SurveyGrammarListener ) ((SurveyGrammarListener)listener).exitChoiceID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SurveyGrammarVisitor ) return ((SurveyGrammarVisitor<? extends T>)visitor).visitChoiceID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceIDContext choiceID() throws RecognitionException {
		ChoiceIDContext _localctx = new ChoiceIDContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_choiceID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(214);
				match(LETTER);
				}
				}
				setState(217); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LETTER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
			throw new RuntimeException();
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0011\u00dc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003?\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0005"+
		"\u0005D\b\u0005\n\u0005\f\u0005G\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0004\u0006L\b\u0006\u000b\u0006\f\u0006M\u0001\u0006\u0003\u0006"+
		"Q\b\u0006\u0001\u0006\u0001\u0006\u0004\u0006U\b\u0006\u000b\u0006\f\u0006"+
		"V\u0001\u0006\u0003\u0006Z\b\u0006\u0001\u0006\u0001\u0006\u0004\u0006"+
		"^\b\u0006\u000b\u0006\f\u0006_\u0001\u0006\u0003\u0006c\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006g\b\u0006\u000b\u0006\f\u0006h\u0003\u0006"+
		"k\b\u0006\u0001\u0007\u0004\u0007n\b\u0007\u000b\u0007\f\u0007o\u0001"+
		"\b\u0005\bs\b\b\n\b\f\bv\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t|"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0004\n\u0087\b\n\u000b\n\f\n\u0088\u0001\u000b\u0005\u000b\u008c\b"+
		"\u000b\n\u000b\f\u000b\u008f\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0097\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0004\u000e\u00a1\b\u000e\u000b\u000e\f"+
		"\u000e\u00a2\u0001\u000f\u0001\u000f\u0003\u000f\u00a7\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0004\u0010\u00b1\b\u0010\u000b\u0010\f\u0010\u00b2\u0001"+
		"\u0011\u0004\u0011\u00b6\b\u0011\u000b\u0011\f\u0011\u00b7\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00ca\b\u0012\u0001\u0013"+
		"\u0004\u0013\u00cd\b\u0013\u000b\u0013\f\u0013\u00ce\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0004"+
		"\u0015\u00d8\b\u0015\u000b\u0015\f\u0015\u00d9\u0001\u0015\u0000\u0000"+
		"\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*\u0000\u0000\u00e7\u0000,\u0001\u0000\u0000\u0000"+
		"\u0002.\u0001\u0000\u0000\u0000\u00046\u0001\u0000\u0000\u0000\u0006>"+
		"\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nE\u0001\u0000\u0000"+
		"\u0000\fj\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000\u0000\u0010"+
		"t\u0001\u0000\u0000\u0000\u0012y\u0001\u0000\u0000\u0000\u0014\u0086\u0001"+
		"\u0000\u0000\u0000\u0016\u008d\u0001\u0000\u0000\u0000\u0018\u0096\u0001"+
		"\u0000\u0000\u0000\u001a\u0098\u0001\u0000\u0000\u0000\u001c\u00a0\u0001"+
		"\u0000\u0000\u0000\u001e\u00a4\u0001\u0000\u0000\u0000 \u00b0\u0001\u0000"+
		"\u0000\u0000\"\u00b5\u0001\u0000\u0000\u0000$\u00c9\u0001\u0000\u0000"+
		"\u0000&\u00cc\u0001\u0000\u0000\u0000(\u00d0\u0001\u0000\u0000\u0000*"+
		"\u00d7\u0001\u0000\u0000\u0000,-\u0003\u0002\u0001\u0000-\u0001\u0001"+
		"\u0000\u0000\u0000./\u0003\u0004\u0002\u0000/0\u0005\u0001\u0000\u0000"+
		"01\u0003\b\u0004\u000012\u0005\u0001\u0000\u000023\u0003\n\u0005\u0000"+
		"34\u0003\u000e\u0007\u000045\u0003\u0010\b\u00005\u0003\u0001\u0000\u0000"+
		"\u000067\u0003\u0006\u0003\u00007\u0005\u0001\u0000\u0000\u000089\u0005"+
		"\u0003\u0000\u00009?\u0003\u0006\u0003\u0000:;\u0005\u0002\u0000\u0000"+
		";?\u0003\u0006\u0003\u0000<?\u0005\u0003\u0000\u0000=?\u0005\u0002\u0000"+
		"\u0000>8\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0007\u0001\u0000\u0000\u0000"+
		"@A\u0003\f\u0006\u0000A\t\u0001\u0000\u0000\u0000BD\u0003\f\u0006\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HI\u0005\u0001\u0000\u0000I\u000b\u0001\u0000\u0000\u0000"+
		"JL\u0005\u0003\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000"+
		"\u0000\u0000OQ\u0005\u0004\u0000\u0000PO\u0001\u0000\u0000\u0000PQ\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000Rk\u0003\f\u0006\u0000SU\u0005"+
		"\u0002\u0000\u0000TS\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000"+
		"\u0000XZ\u0005\u0004\u0000\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[k\u0003\f\u0006\u0000\\^\u0005"+
		"\u0005\u0000\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000"+
		"\u0000ac\u0005\u0004\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000dk\u0003\f\u0006\u0000eg\u0005\u0005"+
		"\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jK\u0001\u0000\u0000\u0000jT\u0001\u0000\u0000\u0000j]\u0001\u0000\u0000"+
		"\u0000jf\u0001\u0000\u0000\u0000k\r\u0001\u0000\u0000\u0000ln\u0003\u0012"+
		"\t\u0000ml\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000p\u000f\u0001\u0000\u0000\u0000"+
		"qs\u0003\f\u0006\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000wx\u0005\u0001\u0000\u0000x\u0011\u0001"+
		"\u0000\u0000\u0000y{\u0003\u0014\n\u0000z|\u0005\u0005\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0005\u0004\u0000\u0000~\u007f\u0003\b\u0004\u0000\u007f\u0080\u0005"+
		"\u0001\u0000\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081\u0082\u0003"+
		"\u0018\f\u0000\u0082\u0083\u0005\u0001\u0000\u0000\u0083\u0084\u0003\u001c"+
		"\u000e\u0000\u0084\u0013\u0001\u0000\u0000\u0000\u0085\u0087\u0005\u0002"+
		"\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u0015\u0001\u0000\u0000\u0000\u008a\u008c\u0003\f\u0006"+
		"\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\u0001\u0000\u0000\u0091\u0017\u0001\u0000\u0000"+
		"\u0000\u0092\u0097\u0005\u0006\u0000\u0000\u0093\u0097\u0005\u0007\u0000"+
		"\u0000\u0094\u0095\u0005\b\u0000\u0000\u0095\u0097\u0003\u001a\r\u0000"+
		"\u0096\u0092\u0001\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u0019\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u0004\u0000\u0000\u0099\u009a\u0003\u0014\n\u0000\u009a"+
		"\u009b\u0005\u0004\u0000\u0000\u009b\u009c\u0003 \u0010\u0000\u009c\u009d"+
		"\u0005\u0004\u0000\u0000\u009d\u009e\u0003*\u0015\u0000\u009e\u001b\u0001"+
		"\u0000\u0000\u0000\u009f\u00a1\u0003\u001e\u000f\u0000\u00a0\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u001d\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a6\u0003 \u0010\u0000\u00a5\u00a7\u0005\u0005"+
		"\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0004"+
		"\u0000\u0000\u00a9\u00aa\u0003\"\u0011\u0000\u00aa\u00ab\u0003$\u0012"+
		"\u0000\u00ab\u00ac\u0005\u0001\u0000\u0000\u00ac\u00ad\u0003\u0018\f\u0000"+
		"\u00ad\u00ae\u0005\u0001\u0000\u0000\u00ae\u001f\u0001\u0000\u0000\u0000"+
		"\u00af\u00b1\u0005\u0002\u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3!\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b6\u0003\f\u0006\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba"+
		"\u0005\u0001\u0000\u0000\u00ba#\u0001\u0000\u0000\u0000\u00bb\u00ca\u0005"+
		"\t\u0000\u0000\u00bc\u00ca\u0005\n\u0000\u0000\u00bd\u00be\u0005\u000b"+
		"\u0000\u0000\u00be\u00ca\u0003&\u0013\u0000\u00bf\u00c0\u0005\f\u0000"+
		"\u0000\u00c0\u00ca\u0003&\u0013\u0000\u00c1\u00c2\u0005\r\u0000\u0000"+
		"\u00c2\u00ca\u0003&\u0013\u0000\u00c3\u00c4\u0005\u000e\u0000\u0000\u00c4"+
		"\u00ca\u0003&\u0013\u0000\u00c5\u00c6\u0005\u000f\u0000\u0000\u00c6\u00ca"+
		"\u0003&\u0013\u0000\u00c7\u00c8\u0005\u0010\u0000\u0000\u00c8\u00ca\u0003"+
		"&\u0013\u0000\u00c9\u00bb\u0001\u0000\u0000\u0000\u00c9\u00bc\u0001\u0000"+
		"\u0000\u0000\u00c9\u00bd\u0001\u0000\u0000\u0000\u00c9\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c1\u0001\u0000\u0000\u0000\u00c9\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c9\u00c5\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00ca%\u0001\u0000\u0000\u0000\u00cb\u00cd\u0003(\u0014\u0000"+
		"\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000"+
		"\u00cf\'\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0001\u0000\u0000\u00d1"+
		"\u00d2\u0003*\u0015\u0000\u00d2\u00d3\u0005\u0011\u0000\u0000\u00d3\u00d4"+
		"\u0005\u0004\u0000\u0000\u00d4\u00d5\u0003\f\u0006\u0000\u00d5)\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0005\u0003\u0000\u0000\u00d7\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da+\u0001\u0000"+
		"\u0000\u0000\u0017>EMPVY_bhjot{\u0088\u008d\u0096\u00a2\u00a6\u00b2\u00b7"+
		"\u00c9\u00ce\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}