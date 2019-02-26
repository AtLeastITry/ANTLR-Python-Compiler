// Generated from d:\Git\CE305\src\main\antlr4\Language.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, PLUS=7, MINUS=8, MULT=9, 
		DIV=10, POWER=11, EQUALS=12, NEGATIVEEQUALS=13, NOT=14, GREATERTHAN=15, 
		LESSTHAN=16, GREATERTHANEQUALS=17, LESSTHANEQUALS=18, OR=19, AND=20, AssignOP=21, 
		VAR=22, NUM=23, INTERGER=24, DECIMAL=25, EndOfLine=26, WS=27;
	public static final int
		RULE_compileUnit = 0, RULE_statements = 1, RULE_statement = 2, RULE_ifElseStatement = 3, 
		RULE_ifStatement = 4, RULE_elseIfStatement = 5, RULE_elseStatement = 6, 
		RULE_assignment = 7, RULE_declaration = 8, RULE_expr = 9;
	public static final String[] ruleNames = {
		"compileUnit", "statements", "statement", "ifElseStatement", "ifStatement", 
		"elseIfStatement", "elseStatement", "assignment", "declaration", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'+'", "'-'", "'*'", 
		"'/'", "'^'", "'=='", "'!='", "'!'", "'>'", "'<'", "'>='", "'<='", "'||'", 
		"'&&'", "'='", null, null, "'INTEGER'", "'DECIMAL'", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "PLUS", "MINUS", "MULT", "DIV", 
		"POWER", "EQUALS", "NEGATIVEEQUALS", "NOT", "GREATERTHAN", "LESSTHAN", 
		"GREATERTHANEQUALS", "LESSTHANEQUALS", "OR", "AND", "AssignOP", "VAR", 
		"NUM", "INTERGER", "DECIMAL", "EndOfLine", "WS"
	};
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompileUnitContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			statements();
			setState(21);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> EndOfLine() { return getTokens(LanguageParser.EndOfLine); }
		public TerminalNode EndOfLine(int i) {
			return getToken(LanguageParser.EndOfLine, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			statement();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EndOfLine) {
				{
				{
				setState(24);
				match(EndOfLine);
				setState(25);
				statement();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(33);
				ifElseStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(34);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseStatementContext extends ParserRuleContext {
		public IfStatementContext ifStat;
		public ElseIfStatementContext elseIfStat;
		public ElseStatementContext elseStat;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStatement; }
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifElseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			((IfElseStatementContext)_localctx).ifStat = ifStatement();
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((IfElseStatementContext)_localctx).elseIfStat = elseIfStatement();
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(44);
				((IfElseStatementContext)_localctx).elseStat = elseStatement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ExprContext expression;
		public StatementsContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__0);
			setState(48);
			match(T__1);
			setState(49);
			((IfStatementContext)_localctx).expression = expr(0);
			setState(50);
			match(T__2);
			setState(51);
			match(T__3);
			setState(52);
			((IfStatementContext)_localctx).body = statements();
			setState(53);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStatementContext extends ParserRuleContext {
		public ExprContext expression;
		public StatementsContext body;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(T__5);
			setState(56);
			match(T__0);
			setState(57);
			match(T__1);
			setState(58);
			((ElseIfStatementContext)_localctx).expression = expr(0);
			setState(59);
			match(T__2);
			setState(60);
			match(T__3);
			setState(61);
			((ElseIfStatementContext)_localctx).body = statements();
			setState(62);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public StatementsContext body;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__5);
			setState(65);
			match(T__3);
			setState(66);
			((ElseStatementContext)_localctx).body = statements();
			setState(67);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public Token variable;
		public Token op;
		public ExprContext right;
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode AssignOP() { return getToken(LanguageParser.AssignOP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((AssignmentContext)_localctx).variable = match(VAR);
			setState(70);
			((AssignmentContext)_localctx).op = match(AssignOP);
			setState(71);
			((AssignmentContext)_localctx).right = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode INTERGER() { return getToken(LanguageParser.INTERGER, 0); }
		public TerminalNode DECIMAL() { return getToken(LanguageParser.DECIMAL, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((DeclarationContext)_localctx).type = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INTERGER || _la==DECIMAL) ) {
				((DeclarationContext)_localctx).type = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(74);
			((DeclarationContext)_localctx).name = match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InfixExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POWER() { return getToken(LanguageParser.POWER, 0); }
		public TerminalNode MULT() { return getToken(LanguageParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(LanguageParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(LanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LanguageParser.MINUS, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(LanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LanguageParser.MINUS, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ValueExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(LanguageParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public ValueExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(LanguageParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class BooleanExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(LanguageParser.EQUALS, 0); }
		public TerminalNode NEGATIVEEQUALS() { return getToken(LanguageParser.NEGATIVEEQUALS, 0); }
		public TerminalNode GREATERTHAN() { return getToken(LanguageParser.GREATERTHAN, 0); }
		public TerminalNode LESSTHAN() { return getToken(LanguageParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHANEQUALS() { return getToken(LanguageParser.GREATERTHANEQUALS, 0); }
		public TerminalNode LESSTHANEQUALS() { return getToken(LanguageParser.LESSTHANEQUALS, 0); }
		public TerminalNode OR() { return getToken(LanguageParser.OR, 0); }
		public TerminalNode AND() { return getToken(LanguageParser.AND, 0); }
		public BooleanExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParensExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(77);
				match(T__1);
				setState(78);
				expr(0);
				setState(79);
				match(T__2);
				}
				break;
			case PLUS:
			case MINUS:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(82);
				expr(7);
				}
				break;
			case VAR:
			case NUM:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				((ValueExprContext)_localctx).value = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==NUM) ) {
					((ValueExprContext)_localctx).value = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case NOT:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(NOT);
				setState(85);
				expr(2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(89);
						((InfixExprContext)_localctx).op = match(POWER);
						setState(90);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(92);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(93);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(95);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(96);
						((InfixExprContext)_localctx).right = expr(5);
						}
						break;
					case 4:
						{
						_localctx = new BooleanExprContext(new ExprContext(_parentctx, _parentState));
						((BooleanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(98);
						((BooleanExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << NEGATIVEEQUALS) | (1L << GREATERTHAN) | (1L << LESSTHAN) | (1L << GREATERTHANEQUALS) | (1L << LESSTHANEQUALS) | (1L << OR) | (1L << AND))) != 0)) ) {
							((BooleanExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(99);
						((BooleanExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35l\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\4\3\4\3\4\3\4\5\4&"+
		"\n\4\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13Y\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\7\13g\n\13\f\13\16\13j\13\13\3\13\2\3\24\f\2\4\6\b\n\f\16\20"+
		"\22\24\2\7\3\2\32\33\3\2\t\n\3\2\30\31\3\2\13\f\4\2\16\17\21\26\2n\2\26"+
		"\3\2\2\2\4\31\3\2\2\2\6%\3\2\2\2\b\'\3\2\2\2\n\61\3\2\2\2\f9\3\2\2\2\16"+
		"B\3\2\2\2\20G\3\2\2\2\22K\3\2\2\2\24X\3\2\2\2\26\27\5\4\3\2\27\30\7\2"+
		"\2\3\30\3\3\2\2\2\31\36\5\6\4\2\32\33\7\34\2\2\33\35\5\6\4\2\34\32\3\2"+
		"\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\5\3\2\2\2 \36\3\2\2\2"+
		"!&\5\22\n\2\"&\5\20\t\2#&\5\b\5\2$&\5\24\13\2%!\3\2\2\2%\"\3\2\2\2%#\3"+
		"\2\2\2%$\3\2\2\2&\7\3\2\2\2\'+\5\n\6\2(*\5\f\7\2)(\3\2\2\2*-\3\2\2\2+"+
		")\3\2\2\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2\2.\60\5\16\b\2/.\3\2\2\2/\60\3\2"+
		"\2\2\60\t\3\2\2\2\61\62\7\3\2\2\62\63\7\4\2\2\63\64\5\24\13\2\64\65\7"+
		"\5\2\2\65\66\7\6\2\2\66\67\5\4\3\2\678\7\7\2\28\13\3\2\2\29:\7\b\2\2:"+
		";\7\3\2\2;<\7\4\2\2<=\5\24\13\2=>\7\5\2\2>?\7\6\2\2?@\5\4\3\2@A\7\7\2"+
		"\2A\r\3\2\2\2BC\7\b\2\2CD\7\6\2\2DE\5\4\3\2EF\7\7\2\2F\17\3\2\2\2GH\7"+
		"\30\2\2HI\7\27\2\2IJ\5\24\13\2J\21\3\2\2\2KL\t\2\2\2LM\7\30\2\2M\23\3"+
		"\2\2\2NO\b\13\1\2OP\7\4\2\2PQ\5\24\13\2QR\7\5\2\2RY\3\2\2\2ST\t\3\2\2"+
		"TY\5\24\13\tUY\t\4\2\2VW\7\20\2\2WY\5\24\13\4XN\3\2\2\2XS\3\2\2\2XU\3"+
		"\2\2\2XV\3\2\2\2Yh\3\2\2\2Z[\f\b\2\2[\\\7\r\2\2\\g\5\24\13\t]^\f\7\2\2"+
		"^_\t\5\2\2_g\5\24\13\b`a\f\6\2\2ab\t\3\2\2bg\5\24\13\7cd\f\3\2\2de\t\6"+
		"\2\2eg\5\24\13\4fZ\3\2\2\2f]\3\2\2\2f`\3\2\2\2fc\3\2\2\2gj\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2i\25\3\2\2\2jh\3\2\2\2\t\36%+/Xfh";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}