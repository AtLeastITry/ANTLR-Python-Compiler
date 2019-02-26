// Generated from C:/Git/CE305/src/main/antlr4\Language.g4 by ANTLR 4.7.2
package ce305.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, PLUS=9, 
		MINUS=10, MULT=11, DIV=12, POWER=13, EQUALS=14, NEGATIVEEQUALS=15, NOT=16, 
		GREATERTHAN=17, LESSTHAN=18, GREATERTHANEQUALS=19, LESSTHANEQUALS=20, 
		OR=21, AND=22, AssignOP=23, VAR=24, NUM=25, EndOfLine=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "PLUS", 
			"MINUS", "MULT", "DIV", "POWER", "EQUALS", "NEGATIVEEQUALS", "NOT", "GREATERTHAN", 
			"LESSTHAN", "GREATERTHANEQUALS", "LESSTHANEQUALS", "OR", "AND", "AssignOP", 
			"VAR", "NUM", "EndOfLine", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'INTEGER'", "'DECIMAL'", "'if'", "'('", "')'", "'{'", "'}'", "'else'", 
			"'+'", "'-'", "'*'", "'/'", "'^'", "'=='", "'!='", "'!'", "'>'", "'<'", 
			"'>='", "'<='", "'||'", "'&&'", "'='", null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "PLUS", "MINUS", 
			"MULT", "DIV", "POWER", "EQUALS", "NEGATIVEEQUALS", "NOT", "GREATERTHAN", 
			"LESSTHAN", "GREATERTHANEQUALS", "LESSTHANEQUALS", "OR", "AND", "AssignOP", 
			"VAR", "NUM", "EndOfLine", "WS"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\6\31\177"+
		"\n\31\r\31\16\31\u0080\3\32\6\32\u0084\n\32\r\32\16\32\u0085\3\32\3\32"+
		"\6\32\u008a\n\32\r\32\16\32\u008b\5\32\u008e\n\32\3\32\3\32\5\32\u0092"+
		"\n\32\3\32\6\32\u0095\n\32\r\32\16\32\u0096\5\32\u0099\n\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\2\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\35\3\2\6\3\2\62;\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2"+
		"\u00a6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2"+
		"\2\5A\3\2\2\2\7I\3\2\2\2\tL\3\2\2\2\13N\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2"+
		"\21T\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]\3\2\2\2\31_\3\2\2\2\33a\3\2\2"+
		"\2\35c\3\2\2\2\37f\3\2\2\2!i\3\2\2\2#k\3\2\2\2%m\3\2\2\2\'o\3\2\2\2)r"+
		"\3\2\2\2+u\3\2\2\2-x\3\2\2\2/{\3\2\2\2\61~\3\2\2\2\63\u0083\3\2\2\2\65"+
		"\u009a\3\2\2\2\67\u009c\3\2\2\29:\7K\2\2:;\7P\2\2;<\7V\2\2<=\7G\2\2=>"+
		"\7I\2\2>?\7G\2\2?@\7T\2\2@\4\3\2\2\2AB\7F\2\2BC\7G\2\2CD\7E\2\2DE\7K\2"+
		"\2EF\7O\2\2FG\7C\2\2GH\7N\2\2H\6\3\2\2\2IJ\7k\2\2JK\7h\2\2K\b\3\2\2\2"+
		"LM\7*\2\2M\n\3\2\2\2NO\7+\2\2O\f\3\2\2\2PQ\7}\2\2Q\16\3\2\2\2RS\7\177"+
		"\2\2S\20\3\2\2\2TU\7g\2\2UV\7n\2\2VW\7u\2\2WX\7g\2\2X\22\3\2\2\2YZ\7-"+
		"\2\2Z\24\3\2\2\2[\\\7/\2\2\\\26\3\2\2\2]^\7,\2\2^\30\3\2\2\2_`\7\61\2"+
		"\2`\32\3\2\2\2ab\7`\2\2b\34\3\2\2\2cd\7?\2\2de\7?\2\2e\36\3\2\2\2fg\7"+
		"#\2\2gh\7?\2\2h \3\2\2\2ij\7#\2\2j\"\3\2\2\2kl\7@\2\2l$\3\2\2\2mn\7>\2"+
		"\2n&\3\2\2\2op\7@\2\2pq\7?\2\2q(\3\2\2\2rs\7>\2\2st\7?\2\2t*\3\2\2\2u"+
		"v\7~\2\2vw\7~\2\2w,\3\2\2\2xy\7(\2\2yz\7(\2\2z.\3\2\2\2{|\7?\2\2|\60\3"+
		"\2\2\2}\177\4c|\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\62\3\2\2\2\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008d\3\2"+
		"\2\2\u0087\u0089\7\60\2\2\u0088\u008a\t\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u0087\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0098\3\2\2\2\u008f"+
		"\u0091\t\3\2\2\u0090\u0092\t\4\2\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0094\3\2\2\2\u0093\u0095\t\2\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2"+
		"\2\2\u0098\u008f\3\2\2\2\u0098\u0099\3\2\2\2\u0099\64\3\2\2\2\u009a\u009b"+
		"\7=\2\2\u009b\66\3\2\2\2\u009c\u009d\t\5\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\b\34\2\2\u009f8\3\2\2\2\n\2\u0080\u0085\u008b\u008d\u0091\u0096"+
		"\u0098\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}