// Generated from C:/Git/compiler/src/main/antlr4\Language.g4 by ANTLR 4.7.2
package compiler.gen;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULT=3, DIV=4, POWER=5, MODULO=6, ASSIGNPLUS=7, ASSIGNMINUS=8, 
		ASSIGNMULT=9, ASSIGNDIV=10, ASSIGNPOWER=11, ASSIGNMODULO=12, EQUALS=13, 
		NEGATIVEEQUALS=14, NOT=15, GREATERTHAN=16, LESSTHAN=17, GREATERTHANEQUALS=18, 
		LESSTHANEQUALS=19, OR=20, AND=21, INT=22, FLOAT=23, BOOL=24, VOID=25, 
		ELSE=26, IF=27, WHILE=28, RETURN=29, LPARA=30, RPARA=31, LBRAC=32, RBRAC=33, 
		COMMA=34, AssignOP=35, VAR=36, NUM=37, EndOfLine=38, WS=39;
	public static final int
		RULE_compileUnit = 0, RULE_statements = 1, RULE_statement = 2, RULE_functionStatement = 3, 
		RULE_functionReturnStatement = 4, RULE_functionParam = 5, RULE_whileStatement = 6, 
		RULE_ifElseStatement = 7, RULE_ifStatement = 8, RULE_elseIfStatement = 9, 
		RULE_elseStatement = 10, RULE_assignment = 11, RULE_binaryAssignment = 12, 
		RULE_declaration = 13, RULE_expr = 14, RULE_functionCallParam = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "statements", "statement", "functionStatement", "functionReturnStatement", 
			"functionParam", "whileStatement", "ifElseStatement", "ifStatement", 
			"elseIfStatement", "elseStatement", "assignment", "binaryAssignment", 
			"declaration", "expr", "functionCallParam"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", "'+='", "'-='", "'*='", 
			"'/='", "'^='", "'%='", "'=='", "'!='", "'!'", "'>'", "'<'", "'>='", 
			"'<='", "'||'", "'&&'", "'int'", "'float'", "'bool'", "'void'", "'else'", 
			"'if'", "'while'", "'return'", "'('", "')'", "'{'", "'}'", "','", "'='", 
			null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "MULT", "DIV", "POWER", "MODULO", "ASSIGNPLUS", 
			"ASSIGNMINUS", "ASSIGNMULT", "ASSIGNDIV", "ASSIGNPOWER", "ASSIGNMODULO", 
			"EQUALS", "NEGATIVEEQUALS", "NOT", "GREATERTHAN", "LESSTHAN", "GREATERTHANEQUALS", 
			"LESSTHANEQUALS", "OR", "AND", "INT", "FLOAT", "BOOL", "VOID", "ELSE", 
			"IF", "WHILE", "RETURN", "LPARA", "RPARA", "LBRAC", "RBRAC", "COMMA", 
			"AssignOP", "VAR", "NUM", "EndOfLine", "WS"
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
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCompileUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCompileUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			statements();
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << VOID) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << LPARA) | (1L << VAR) | (1L << NUM))) != 0)) {
				{
				{
				setState(34);
				statement();
				setState(35);
				match(EndOfLine);
				}
				}
				setState(41);
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
		public FunctionStatementContext functionStatement() {
			return getRuleContext(FunctionStatementContext.class,0);
		}
		public FunctionReturnStatementContext functionReturnStatement() {
			return getRuleContext(FunctionReturnStatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfElseStatementContext ifElseStatement() {
			return getRuleContext(IfElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				functionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				functionReturnStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				declaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				assignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				ifElseStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				whileStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(48);
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

	public static class FunctionStatementContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public FunctionParamContext params;
		public StatementsContext body;
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public TerminalNode LBRAC() { return getToken(LanguageParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(LanguageParser.RBRAC, 0); }
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
		}
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(LanguageParser.VOID, 0); }
		public FunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStatementContext functionStatement() throws RecognitionException {
		FunctionStatementContext _localctx = new FunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionStatement);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				((FunctionStatementContext)_localctx).type = match(FLOAT);
				setState(52);
				((FunctionStatementContext)_localctx).name = match(VAR);
				setState(53);
				match(LPARA);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << COMMA))) != 0)) {
					{
					{
					setState(54);
					((FunctionStatementContext)_localctx).params = functionParam();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(RPARA);
				setState(61);
				match(LBRAC);
				setState(62);
				((FunctionStatementContext)_localctx).body = statements();
				setState(63);
				match(RBRAC);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((FunctionStatementContext)_localctx).type = match(INT);
				setState(66);
				((FunctionStatementContext)_localctx).name = match(VAR);
				setState(67);
				match(LPARA);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << COMMA))) != 0)) {
					{
					{
					setState(68);
					((FunctionStatementContext)_localctx).params = functionParam();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(RPARA);
				setState(75);
				match(LBRAC);
				setState(76);
				((FunctionStatementContext)_localctx).body = statements();
				setState(77);
				match(RBRAC);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				((FunctionStatementContext)_localctx).type = match(BOOL);
				setState(80);
				((FunctionStatementContext)_localctx).name = match(VAR);
				setState(81);
				match(LPARA);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << COMMA))) != 0)) {
					{
					{
					setState(82);
					((FunctionStatementContext)_localctx).params = functionParam();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(88);
				match(RPARA);
				setState(89);
				match(LBRAC);
				setState(90);
				((FunctionStatementContext)_localctx).body = statements();
				setState(91);
				match(RBRAC);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				((FunctionStatementContext)_localctx).type = match(VOID);
				setState(94);
				((FunctionStatementContext)_localctx).name = match(VAR);
				setState(95);
				match(LPARA);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << BOOL) | (1L << COMMA))) != 0)) {
					{
					{
					setState(96);
					((FunctionStatementContext)_localctx).params = functionParam();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(RPARA);
				setState(103);
				match(LBRAC);
				setState(104);
				((FunctionStatementContext)_localctx).body = statements();
				setState(105);
				match(RBRAC);
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
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionReturnStatementContext extends ParserRuleContext {
		public ExprContext expression;
		public TerminalNode RETURN() { return getToken(LanguageParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctionReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctionReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctionReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionReturnStatementContext functionReturnStatement() throws RecognitionException {
		FunctionReturnStatementContext _localctx = new FunctionReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionReturnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(RETURN);
			setState(110);
			((FunctionReturnStatementContext)_localctx).expression = expr(0);
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

	public static class FunctionParamContext extends ParserRuleContext {
		public DeclarationContext param;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LanguageParser.COMMA, 0); }
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctionParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctionParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParam);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((FunctionParamContext)_localctx).param = declaration();
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(COMMA);
				setState(114);
				((FunctionParamContext)_localctx).param = declaration();
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
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public ExprContext expression;
		public StatementsContext body;
		public TerminalNode WHILE() { return getToken(LanguageParser.WHILE, 0); }
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public TerminalNode LBRAC() { return getToken(LanguageParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(LanguageParser.RBRAC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(WHILE);
			setState(118);
			match(LPARA);
			setState(119);
			((WhileStatementContext)_localctx).expression = expr(0);
			setState(120);
			match(RPARA);
			setState(121);
			match(LBRAC);
			setState(122);
			((WhileStatementContext)_localctx).body = statements();
			setState(123);
			match(RBRAC);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStatementContext ifElseStatement() throws RecognitionException {
		IfElseStatementContext _localctx = new IfElseStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifElseStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((IfElseStatementContext)_localctx).ifStat = ifStatement();
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					((IfElseStatementContext)_localctx).elseIfStat = elseIfStatement();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(132);
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
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public TerminalNode LBRAC() { return getToken(LanguageParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(LanguageParser.RBRAC, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(IF);
			setState(136);
			match(LPARA);
			setState(137);
			((IfStatementContext)_localctx).expression = expr(0);
			setState(138);
			match(RPARA);
			setState(139);
			match(LBRAC);
			setState(140);
			((IfStatementContext)_localctx).body = statements();
			setState(141);
			match(RBRAC);
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
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public TerminalNode LBRAC() { return getToken(LanguageParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(LanguageParser.RBRAC, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ELSE);
			setState(144);
			match(IF);
			setState(145);
			match(LPARA);
			setState(146);
			((ElseIfStatementContext)_localctx).expression = expr(0);
			setState(147);
			match(RPARA);
			setState(148);
			match(LBRAC);
			setState(149);
			((ElseIfStatementContext)_localctx).body = statements();
			setState(150);
			match(RBRAC);
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
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public TerminalNode LBRAC() { return getToken(LanguageParser.LBRAC, 0); }
		public TerminalNode RBRAC() { return getToken(LanguageParser.RBRAC, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ELSE);
			setState(153);
			match(LBRAC);
			setState(154);
			((ElseStatementContext)_localctx).body = statements();
			setState(155);
			match(RBRAC);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AssignOP() { return getToken(LanguageParser.AssignOP, 0); }
		public TerminalNode ASSIGNPLUS() { return getToken(LanguageParser.ASSIGNPLUS, 0); }
		public TerminalNode ASSIGNMINUS() { return getToken(LanguageParser.ASSIGNMINUS, 0); }
		public TerminalNode ASSIGNMULT() { return getToken(LanguageParser.ASSIGNMULT, 0); }
		public TerminalNode ASSIGNDIV() { return getToken(LanguageParser.ASSIGNDIV, 0); }
		public TerminalNode ASSIGNPOWER() { return getToken(LanguageParser.ASSIGNPOWER, 0); }
		public TerminalNode ASSIGNMODULO() { return getToken(LanguageParser.ASSIGNMODULO, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((AssignmentContext)_localctx).variable = match(VAR);
			setState(158);
			((AssignmentContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASSIGNPLUS) | (1L << ASSIGNMINUS) | (1L << ASSIGNMULT) | (1L << ASSIGNDIV) | (1L << ASSIGNPOWER) | (1L << ASSIGNMODULO) | (1L << AssignOP))) != 0)) ) {
				((AssignmentContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(159);
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

	public static class BinaryAssignmentContext extends ParserRuleContext {
		public Token variable;
		public ExprContext right;
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BinaryAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBinaryAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBinaryAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBinaryAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryAssignmentContext binaryAssignment() throws RecognitionException {
		BinaryAssignmentContext _localctx = new BinaryAssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_binaryAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			((BinaryAssignmentContext)_localctx).variable = match(VAR);
			setState(162);
			((BinaryAssignmentContext)_localctx).right = expr(0);
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
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_declaration);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				((DeclarationContext)_localctx).type = match(FLOAT);
				setState(165);
				((DeclarationContext)_localctx).name = match(VAR);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				((DeclarationContext)_localctx).type = match(INT);
				setState(167);
				((DeclarationContext)_localctx).name = match(VAR);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				((DeclarationContext)_localctx).type = match(BOOL);
				setState(169);
				((DeclarationContext)_localctx).name = match(VAR);
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
		public TerminalNode MODULO() { return getToken(LanguageParser.MODULO, 0); }
		public TerminalNode PLUS() { return getToken(LanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LanguageParser.MINUS, 0); }
		public InfixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterInfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitInfixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitInfixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(LanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LanguageParser.MINUS, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueExprContext extends ExprContext {
		public Token value;
		public TerminalNode NUM() { return getToken(LanguageParser.NUM, 0); }
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public ValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitValueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitValueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(LanguageParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBooleanExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBooleanExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBooleanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExprContext extends ExprContext {
		public Token name;
		public FunctionCallParamContext params;
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public List<FunctionCallParamContext> functionCallParam() {
			return getRuleContexts(FunctionCallParamContext.class);
		}
		public FunctionCallParamContext functionCallParam(int i) {
			return getRuleContext(FunctionCallParamContext.class,i);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode LPARA() { return getToken(LanguageParser.LPARA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPARA() { return getToken(LanguageParser.RPARA, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(173);
				match(LPARA);
				setState(174);
				expr(0);
				setState(175);
				match(RPARA);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
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
				setState(178);
				expr(8);
				}
				break;
			case 3:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
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
			case 4:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(NOT);
				setState(181);
				expr(3);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((FunctionCallExprContext)_localctx).name = match(VAR);
				setState(183);
				match(LPARA);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << NOT) | (1L << LPARA) | (1L << COMMA) | (1L << VAR) | (1L << NUM))) != 0)) {
					{
					{
					setState(184);
					((FunctionCallExprContext)_localctx).params = functionCallParam();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				match(RPARA);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(194);
						((InfixExprContext)_localctx).op = match(POWER);
						setState(195);
						((InfixExprContext)_localctx).right = expr(8);
						}
						break;
					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(197);
						((InfixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MODULO))) != 0)) ) {
							((InfixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(198);
						((InfixExprContext)_localctx).right = expr(7);
						}
						break;
					case 3:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(200);
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
						setState(201);
						((InfixExprContext)_localctx).right = expr(6);
						}
						break;
					case 4:
						{
						_localctx = new BooleanExprContext(new ExprContext(_parentctx, _parentState));
						((BooleanExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(203);
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
						setState(204);
						((BooleanExprContext)_localctx).right = expr(3);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class FunctionCallParamContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(LanguageParser.COMMA, 0); }
		public FunctionCallParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctionCallParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctionCallParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctionCallParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallParamContext functionCallParam() throws RecognitionException {
		FunctionCallParamContext _localctx = new FunctionCallParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionCallParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
			case LPARA:
			case VAR:
			case NUM:
				{
				setState(210);
				expr(0);
				}
				break;
			case COMMA:
				{
				setState(211);
				match(COMMA);
				setState(212);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64"+
		"\n\4\3\5\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5V\n\5\f\5\16\5Y\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5d\n\5"+
		"\f\5\16\5g\13\5\3\5\3\5\3\5\3\5\3\5\5\5n\n\5\3\6\3\6\3\6\3\7\3\7\3\7\5"+
		"\7v\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\7\t\u0082\n\t\f\t\16\t"+
		"\u0085\13\t\3\t\5\t\u0088\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ad\n\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00bc"+
		"\n\20\f\20\16\20\u00bf\13\20\3\20\5\20\u00c2\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d0\n\20\f\20\16\20\u00d3"+
		"\13\20\3\21\3\21\3\21\5\21\u00d8\n\21\3\21\2\3\36\22\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \2\7\4\2\t\16%%\3\2\3\4\3\2&\'\4\2\5\6\b\b\4\2\17"+
		"\20\22\27\2\u00e6\2\"\3\2\2\2\4)\3\2\2\2\6\63\3\2\2\2\bm\3\2\2\2\no\3"+
		"\2\2\2\fu\3\2\2\2\16w\3\2\2\2\20\177\3\2\2\2\22\u0089\3\2\2\2\24\u0091"+
		"\3\2\2\2\26\u009a\3\2\2\2\30\u009f\3\2\2\2\32\u00a3\3\2\2\2\34\u00ac\3"+
		"\2\2\2\36\u00c1\3\2\2\2 \u00d7\3\2\2\2\"#\5\4\3\2#\3\3\2\2\2$%\5\6\4\2"+
		"%&\7(\2\2&(\3\2\2\2\'$\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\5\3\2\2"+
		"\2+)\3\2\2\2,\64\5\b\5\2-\64\5\n\6\2.\64\5\34\17\2/\64\5\30\r\2\60\64"+
		"\5\20\t\2\61\64\5\16\b\2\62\64\5\36\20\2\63,\3\2\2\2\63-\3\2\2\2\63.\3"+
		"\2\2\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2"+
		"\2\2\65\66\7\31\2\2\66\67\7&\2\2\67;\7 \2\28:\5\f\7\298\3\2\2\2:=\3\2"+
		"\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7!\2\2?@\7\"\2\2@A\5\4"+
		"\3\2AB\7#\2\2Bn\3\2\2\2CD\7\30\2\2DE\7&\2\2EI\7 \2\2FH\5\f\7\2GF\3\2\2"+
		"\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7!\2\2MN\7\"\2"+
		"\2NO\5\4\3\2OP\7#\2\2Pn\3\2\2\2QR\7\32\2\2RS\7&\2\2SW\7 \2\2TV\5\f\7\2"+
		"UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7!\2\2"+
		"[\\\7\"\2\2\\]\5\4\3\2]^\7#\2\2^n\3\2\2\2_`\7\33\2\2`a\7&\2\2ae\7 \2\2"+
		"bd\5\f\7\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2"+
		"hi\7!\2\2ij\7\"\2\2jk\5\4\3\2kl\7#\2\2ln\3\2\2\2m\65\3\2\2\2mC\3\2\2\2"+
		"mQ\3\2\2\2m_\3\2\2\2n\t\3\2\2\2op\7\37\2\2pq\5\36\20\2q\13\3\2\2\2rv\5"+
		"\34\17\2st\7$\2\2tv\5\34\17\2ur\3\2\2\2us\3\2\2\2v\r\3\2\2\2wx\7\36\2"+
		"\2xy\7 \2\2yz\5\36\20\2z{\7!\2\2{|\7\"\2\2|}\5\4\3\2}~\7#\2\2~\17\3\2"+
		"\2\2\177\u0083\5\22\n\2\u0080\u0082\5\24\13\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0087\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0086\u0088\5\26\f\2\u0087\u0086\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\21\3\2\2\2\u0089\u008a\7\35\2\2\u008a\u008b\7 \2"+
		"\2\u008b\u008c\5\36\20\2\u008c\u008d\7!\2\2\u008d\u008e\7\"\2\2\u008e"+
		"\u008f\5\4\3\2\u008f\u0090\7#\2\2\u0090\23\3\2\2\2\u0091\u0092\7\34\2"+
		"\2\u0092\u0093\7\35\2\2\u0093\u0094\7 \2\2\u0094\u0095\5\36\20\2\u0095"+
		"\u0096\7!\2\2\u0096\u0097\7\"\2\2\u0097\u0098\5\4\3\2\u0098\u0099\7#\2"+
		"\2\u0099\25\3\2\2\2\u009a\u009b\7\34\2\2\u009b\u009c\7\"\2\2\u009c\u009d"+
		"\5\4\3\2\u009d\u009e\7#\2\2\u009e\27\3\2\2\2\u009f\u00a0\7&\2\2\u00a0"+
		"\u00a1\t\2\2\2\u00a1\u00a2\5\36\20\2\u00a2\31\3\2\2\2\u00a3\u00a4\7&\2"+
		"\2\u00a4\u00a5\5\36\20\2\u00a5\33\3\2\2\2\u00a6\u00a7\7\31\2\2\u00a7\u00ad"+
		"\7&\2\2\u00a8\u00a9\7\30\2\2\u00a9\u00ad\7&\2\2\u00aa\u00ab\7\32\2\2\u00ab"+
		"\u00ad\7&\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ad\35\3\2\2\2\u00ae\u00af\b\20\1\2\u00af\u00b0\7 \2\2\u00b0\u00b1"+
		"\5\36\20\2\u00b1\u00b2\7!\2\2\u00b2\u00c2\3\2\2\2\u00b3\u00b4\t\3\2\2"+
		"\u00b4\u00c2\5\36\20\n\u00b5\u00c2\t\4\2\2\u00b6\u00b7\7\21\2\2\u00b7"+
		"\u00c2\5\36\20\5\u00b8\u00b9\7&\2\2\u00b9\u00bd\7 \2\2\u00ba\u00bc\5 "+
		"\21\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c2\7!"+
		"\2\2\u00c1\u00ae\3\2\2\2\u00c1\u00b3\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1"+
		"\u00b6\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c2\u00d1\3\2\2\2\u00c3\u00c4\f\t"+
		"\2\2\u00c4\u00c5\7\7\2\2\u00c5\u00d0\5\36\20\n\u00c6\u00c7\f\b\2\2\u00c7"+
		"\u00c8\t\5\2\2\u00c8\u00d0\5\36\20\t\u00c9\u00ca\f\7\2\2\u00ca\u00cb\t"+
		"\3\2\2\u00cb\u00d0\5\36\20\b\u00cc\u00cd\f\4\2\2\u00cd\u00ce\t\6\2\2\u00ce"+
		"\u00d0\5\36\20\5\u00cf\u00c3\3\2\2\2\u00cf\u00c6\3\2\2\2\u00cf\u00c9\3"+
		"\2\2\2\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\37\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d8\5\36\20"+
		"\2\u00d5\u00d6\7$\2\2\u00d6\u00d8\5\36\20\2\u00d7\u00d4\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8!\3\2\2\2\22)\63;IWemu\u0083\u0087\u00ac\u00bd\u00c1"+
		"\u00cf\u00d1\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}