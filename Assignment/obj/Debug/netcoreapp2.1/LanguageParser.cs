//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.6.6
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from D:\Git\CE305\Assignment\Grammar\Language.g4 by ANTLR 4.6.6

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

namespace Assignment.Grammar {
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using System.Collections.Generic;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.6.6")]
[System.CLSCompliant(false)]
public partial class LanguageParser : Parser {
	public const int
		NUM=1, PLUS=2, MINUS=3, MULT=4, DIV=5, LPARA=6, RPARA=7, AssignOP=8, VAR=9, 
		WS=10, ID=11;
	public const int
		RULE_compileUnit = 0, RULE_expr = 1;
	public static readonly string[] ruleNames = {
		"compileUnit", "expr"
	};

	private static readonly string[] _LiteralNames = {
		null, null, "'+'", "'-'", "'*'", "'/'", "'('", "')'", "':='"
	};
	private static readonly string[] _SymbolicNames = {
		null, "NUM", "PLUS", "MINUS", "MULT", "DIV", "LPARA", "RPARA", "AssignOP", 
		"VAR", "WS", "ID"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[System.Obsolete("Use Vocabulary instead.")]
	public static readonly string[] tokenNames = GenerateTokenNames(DefaultVocabulary, _SymbolicNames.Length);

	private static string[] GenerateTokenNames(IVocabulary vocabulary, int length) {
		string[] tokenNames = new string[length];
		for (int i = 0; i < tokenNames.Length; i++) {
			tokenNames[i] = vocabulary.GetLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = vocabulary.GetSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}

		return tokenNames;
	}

	[System.Obsolete("Use IRecognizer.Vocabulary instead.")]
	public override string[] TokenNames
	{
		get
		{
			return tokenNames;
		}
	}

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "Language.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string SerializedAtn { get { return _serializedATN; } }

	public LanguageParser(ITokenStream input)
		: base(input)
	{
		_interp = new ParserATNSimulator(this,_ATN);
	}
	public partial class CompileUnitContext : ParserRuleContext {
		public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ITerminalNode Eof() { return GetToken(LanguageParser.Eof, 0); }
		public CompileUnitContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_compileUnit; } }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterCompileUnit(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitCompileUnit(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitCompileUnit(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public CompileUnitContext compileUnit() {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, State);
		EnterRule(_localctx, 0, RULE_compileUnit);
		try {
			EnterOuterAlt(_localctx, 1);
			{
			State = 4; expr(0);
			State = 5; Match(Eof);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.ReportError(this, re);
			_errHandler.Recover(this, re);
		}
		finally {
			ExitRule();
		}
		return _localctx;
	}

	public partial class ExprContext : ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState)
			: base(parent, invokingState)
		{
		}
		public override int RuleIndex { get { return RULE_expr; } }
	 
		public ExprContext() { }
		public virtual void CopyFrom(ExprContext context) {
			base.CopyFrom(context);
		}
	}
	public partial class AssignmentExprContext : ExprContext {
		public IToken variable;
		public IToken op;
		public ExprContext right;
		public ITerminalNode VAR() { return GetToken(LanguageParser.VAR, 0); }
		public ITerminalNode AssignOP() { return GetToken(LanguageParser.AssignOP, 0); }
		public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public AssignmentExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterAssignmentExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitAssignmentExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitAssignmentExpr(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class InfixExprContext : ExprContext {
		public ExprContext left;
		public IToken op;
		public ExprContext right;
		public ExprContext[] expr() {
			return GetRuleContexts<ExprContext>();
		}
		public ExprContext expr(int i) {
			return GetRuleContext<ExprContext>(i);
		}
		public ITerminalNode MULT() { return GetToken(LanguageParser.MULT, 0); }
		public ITerminalNode DIV() { return GetToken(LanguageParser.DIV, 0); }
		public ITerminalNode PLUS() { return GetToken(LanguageParser.PLUS, 0); }
		public ITerminalNode MINUS() { return GetToken(LanguageParser.MINUS, 0); }
		public InfixExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterInfixExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitInfixExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitInfixExpr(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class UnaryExprContext : ExprContext {
		public IToken op;
		public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ITerminalNode PLUS() { return GetToken(LanguageParser.PLUS, 0); }
		public ITerminalNode MINUS() { return GetToken(LanguageParser.MINUS, 0); }
		public UnaryExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterUnaryExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitUnaryExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitUnaryExpr(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class FuncExprContext : ExprContext {
		public IToken func;
		public ITerminalNode LPARA() { return GetToken(LanguageParser.LPARA, 0); }
		public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ITerminalNode RPARA() { return GetToken(LanguageParser.RPARA, 0); }
		public ITerminalNode ID() { return GetToken(LanguageParser.ID, 0); }
		public FuncExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterFuncExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitFuncExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitFuncExpr(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class ValueExprContext : ExprContext {
		public IToken value;
		public ITerminalNode NUM() { return GetToken(LanguageParser.NUM, 0); }
		public ITerminalNode VAR() { return GetToken(LanguageParser.VAR, 0); }
		public ValueExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterValueExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitValueExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitValueExpr(this);
			else return visitor.VisitChildren(this);
		}
	}
	public partial class ParensExprContext : ExprContext {
		public ITerminalNode LPARA() { return GetToken(LanguageParser.LPARA, 0); }
		public ExprContext expr() {
			return GetRuleContext<ExprContext>(0);
		}
		public ITerminalNode RPARA() { return GetToken(LanguageParser.RPARA, 0); }
		public ParensExprContext(ExprContext context) { CopyFrom(context); }
		public override void EnterRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.EnterParensExpr(this);
		}
		public override void ExitRule(IParseTreeListener listener) {
			ILanguageListener typedListener = listener as ILanguageListener;
			if (typedListener != null) typedListener.ExitParensExpr(this);
		}
		public override TResult Accept<TResult>(IParseTreeVisitor<TResult> visitor) {
			ILanguageVisitor<TResult> typedVisitor = visitor as ILanguageVisitor<TResult>;
			if (typedVisitor != null) return typedVisitor.VisitParensExpr(this);
			else return visitor.VisitChildren(this);
		}
	}

	[RuleVersion(0)]
	public ExprContext expr() {
		return expr(0);
	}

	private ExprContext expr(int _p) {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = State;
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		EnterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			EnterOuterAlt(_localctx, 1);
			{
			State = 23;
			_errHandler.Sync(this);
			switch ( Interpreter.AdaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				State = 8; Match(LPARA);
				State = 9; expr(0);
				State = 10; Match(RPARA);
				}
				break;

			case 2:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				State = 12;
				((UnaryExprContext)_localctx).op = _input.Lt(1);
				_la = _input.La(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((UnaryExprContext)_localctx).op = _errHandler.RecoverInline(this);
				} else {
					if (_input.La(1) == TokenConstants.Eof) {
						matchedEOF = true;
					}

					_errHandler.ReportMatch(this);
					Consume();
				}
				State = 13; expr(6);
				}
				break;

			case 3:
				{
				_localctx = new AssignmentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				State = 14; ((AssignmentExprContext)_localctx).variable = Match(VAR);
				State = 15; ((AssignmentExprContext)_localctx).op = Match(AssignOP);
				State = 16; ((AssignmentExprContext)_localctx).right = expr(3);
				}
				break;

			case 4:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				State = 17; ((FuncExprContext)_localctx).func = Match(ID);
				State = 18; Match(LPARA);
				State = 19; expr(0);
				State = 20; Match(RPARA);
				}
				break;

			case 5:
				{
				_localctx = new ValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				State = 22;
				((ValueExprContext)_localctx).value = _input.Lt(1);
				_la = _input.La(1);
				if ( !(_la==NUM || _la==VAR) ) {
					((ValueExprContext)_localctx).value = _errHandler.RecoverInline(this);
				} else {
					if (_input.La(1) == TokenConstants.Eof) {
						matchedEOF = true;
					}

					_errHandler.ReportMatch(this);
					Consume();
				}
				}
				break;
			}
			_ctx.stop = _input.Lt(-1);
			State = 33;
			_errHandler.Sync(this);
			_alt = Interpreter.AdaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=global::Antlr4.Runtime.Atn.ATN.InvalidAltNumber ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) TriggerExitRuleEvent();
					_prevctx = _localctx;
					{
					State = 31;
					_errHandler.Sync(this);
					switch ( Interpreter.AdaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						PushNewRecursionContext(_localctx, _startState, RULE_expr);
						State = 25;
						if (!(Precpred(_ctx, 5))) throw new FailedPredicateException(this, "Precpred(_ctx, 5)");
						State = 26;
						((InfixExprContext)_localctx).op = _input.Lt(1);
						_la = _input.La(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((InfixExprContext)_localctx).op = _errHandler.RecoverInline(this);
						} else {
							if (_input.La(1) == TokenConstants.Eof) {
								matchedEOF = true;
							}

							_errHandler.ReportMatch(this);
							Consume();
						}
						State = 27; ((InfixExprContext)_localctx).right = expr(6);
						}
						break;

					case 2:
						{
						_localctx = new InfixExprContext(new ExprContext(_parentctx, _parentState));
						((InfixExprContext)_localctx).left = _prevctx;
						PushNewRecursionContext(_localctx, _startState, RULE_expr);
						State = 28;
						if (!(Precpred(_ctx, 4))) throw new FailedPredicateException(this, "Precpred(_ctx, 4)");
						State = 29;
						((InfixExprContext)_localctx).op = _input.Lt(1);
						_la = _input.La(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((InfixExprContext)_localctx).op = _errHandler.RecoverInline(this);
						} else {
							if (_input.La(1) == TokenConstants.Eof) {
								matchedEOF = true;
							}

							_errHandler.ReportMatch(this);
							Consume();
						}
						State = 30; ((InfixExprContext)_localctx).right = expr(5);
						}
						break;
					}
					} 
				}
				State = 35;
				_errHandler.Sync(this);
				_alt = Interpreter.AdaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.ReportError(this, re);
			_errHandler.Recover(this, re);
		}
		finally {
			UnrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public override bool Sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private bool expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return Precpred(_ctx, 5);

		case 1: return Precpred(_ctx, 4);
		}
		return true;
	}

	public static readonly string _serializedATN =
		"\x3\xAF6F\x8320\x479D\xB75C\x4880\x1605\x191C\xAB37\x3\r\'\x4\x2\t\x2"+
		"\x4\x3\t\x3\x3\x2\x3\x2\x3\x2\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3"+
		"\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x5\x3\x1A\n\x3"+
		"\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\x3\a\x3\"\n\x3\f\x3\xE\x3%\v\x3\x3\x3"+
		"\x2\x2\x3\x4\x4\x2\x2\x4\x2\x2\x5\x3\x2\x4\x5\x4\x2\x3\x3\v\v\x3\x2\x6"+
		"\a*\x2\x6\x3\x2\x2\x2\x4\x19\x3\x2\x2\x2\x6\a\x5\x4\x3\x2\a\b\a\x2\x2"+
		"\x3\b\x3\x3\x2\x2\x2\t\n\b\x3\x1\x2\n\v\a\b\x2\x2\v\f\x5\x4\x3\x2\f\r"+
		"\a\t\x2\x2\r\x1A\x3\x2\x2\x2\xE\xF\t\x2\x2\x2\xF\x1A\x5\x4\x3\b\x10\x11"+
		"\a\v\x2\x2\x11\x12\a\n\x2\x2\x12\x1A\x5\x4\x3\x5\x13\x14\a\r\x2\x2\x14"+
		"\x15\a\b\x2\x2\x15\x16\x5\x4\x3\x2\x16\x17\a\t\x2\x2\x17\x1A\x3\x2\x2"+
		"\x2\x18\x1A\t\x3\x2\x2\x19\t\x3\x2\x2\x2\x19\xE\x3\x2\x2\x2\x19\x10\x3"+
		"\x2\x2\x2\x19\x13\x3\x2\x2\x2\x19\x18\x3\x2\x2\x2\x1A#\x3\x2\x2\x2\x1B"+
		"\x1C\f\a\x2\x2\x1C\x1D\t\x4\x2\x2\x1D\"\x5\x4\x3\b\x1E\x1F\f\x6\x2\x2"+
		"\x1F \t\x2\x2\x2 \"\x5\x4\x3\a!\x1B\x3\x2\x2\x2!\x1E\x3\x2\x2\x2\"%\x3"+
		"\x2\x2\x2#!\x3\x2\x2\x2#$\x3\x2\x2\x2$\x5\x3\x2\x2\x2%#\x3\x2\x2\x2\x5"+
		"\x19!#";
	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN.ToCharArray());
}
} // namespace Assignment.Grammar
