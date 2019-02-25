package ce305.gen;
// Generated from D:/Git/assignment/src/main/antlr4\Language.g4 by ANTLR 4.7.2
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
		IF=1, ELSE=2, FOR=3, WHILE=4, LBRAC=5, RBRAC=6, PLUS=7, MINUS=8, MULT=9, 
		DIV=10, POWER=11, LPARA=12, RPARA=13, EQUALS=14, NEGATIVEEQUALS=15, NOT=16, 
		GREATERTHAN=17, LESSTHAN=18, GREATERTHANEQUALS=19, LESSTHANEQUALS=20, 
		OR=21, AND=22, AssignOP=23, VAR=24, NUM=25, INTERGER=26, DECIMAL=27, EndOfLine=28, 
		WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "FOR", "WHILE", "LBRAC", "RBRAC", "PLUS", "MINUS", "MULT", 
			"DIV", "POWER", "LPARA", "RPARA", "EQUALS", "NEGATIVEEQUALS", "NOT", 
			"GREATERTHAN", "LESSTHAN", "GREATERTHANEQUALS", "LESSTHANEQUALS", "OR", 
			"AND", "AssignOP", "VAR", "NUM", "INTERGER", "DECIMAL", "EndOfLine", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'for'", "'while'", "'{'", "'}'", "'+'", "'-'", 
			"'*'", "'/'", "'^'", "'('", "')'", "'=='", "'!='", "'!'", "'>'", "'<'", 
			"'>='", "'<='", "'||'", "'&&'", "'='", null, null, "'INTEGER'", "'DECIMAL'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "FOR", "WHILE", "LBRAC", "RBRAC", "PLUS", "MINUS", 
			"MULT", "DIV", "POWER", "LPARA", "RPARA", "EQUALS", "NEGATIVEEQUALS", 
			"NOT", "GREATERTHAN", "LESSTHAN", "GREATERTHANEQUALS", "LESSTHANEQUALS", 
			"OR", "AND", "AssignOP", "VAR", "NUM", "INTERGER", "DECIMAL", "EndOfLine", 
			"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\6\31}\n\31"+
		"\r\31\16\31~\3\32\6\32\u0082\n\32\r\32\16\32\u0083\3\32\3\32\6\32\u0088"+
		"\n\32\r\32\16\32\u0089\5\32\u008c\n\32\3\32\3\32\5\32\u0090\n\32\3\32"+
		"\6\32\u0093\n\32\r\32\16\32\u0094\5\32\u0097\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37\3\2\6\3\2\62;\4\2GGgg\4\2--//\5\2\13\f\17\17"+
		"\"\"\2\u00b4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5@\3\2\2\2\7E\3\2\2\2\tI\3\2\2\2\13O\3\2"+
		"\2\2\rQ\3\2\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27[\3"+
		"\2\2\2\31]\3\2\2\2\33_\3\2\2\2\35a\3\2\2\2\37d\3\2\2\2!g\3\2\2\2#i\3\2"+
		"\2\2%k\3\2\2\2\'m\3\2\2\2)p\3\2\2\2+s\3\2\2\2-v\3\2\2\2/y\3\2\2\2\61|"+
		"\3\2\2\2\63\u0081\3\2\2\2\65\u0098\3\2\2\2\67\u00a0\3\2\2\29\u00a8\3\2"+
		"\2\2;\u00aa\3\2\2\2=>\7k\2\2>?\7h\2\2?\4\3\2\2\2@A\7g\2\2AB\7n\2\2BC\7"+
		"u\2\2CD\7g\2\2D\6\3\2\2\2EF\7h\2\2FG\7q\2\2GH\7t\2\2H\b\3\2\2\2IJ\7y\2"+
		"\2JK\7j\2\2KL\7k\2\2LM\7n\2\2MN\7g\2\2N\n\3\2\2\2OP\7}\2\2P\f\3\2\2\2"+
		"QR\7\177\2\2R\16\3\2\2\2ST\7-\2\2T\20\3\2\2\2UV\7/\2\2V\22\3\2\2\2WX\7"+
		",\2\2X\24\3\2\2\2YZ\7\61\2\2Z\26\3\2\2\2[\\\7`\2\2\\\30\3\2\2\2]^\7*\2"+
		"\2^\32\3\2\2\2_`\7+\2\2`\34\3\2\2\2ab\7?\2\2bc\7?\2\2c\36\3\2\2\2de\7"+
		"#\2\2ef\7?\2\2f \3\2\2\2gh\7#\2\2h\"\3\2\2\2ij\7@\2\2j$\3\2\2\2kl\7>\2"+
		"\2l&\3\2\2\2mn\7@\2\2no\7?\2\2o(\3\2\2\2pq\7>\2\2qr\7?\2\2r*\3\2\2\2s"+
		"t\7~\2\2tu\7~\2\2u,\3\2\2\2vw\7(\2\2wx\7(\2\2x.\3\2\2\2yz\7?\2\2z\60\3"+
		"\2\2\2{}\4c|\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\62\3\2\2"+
		"\2\u0080\u0082\t\2\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u008b\3\2\2\2\u0085\u0087\7\60\2\2"+
		"\u0086\u0088\t\2\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0085\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u0096\3\2\2\2\u008d\u008f\t\3\2\2\u008e\u0090\t\4"+
		"\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u0093\t\2\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u008d\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\64\3\2\2\2\u0098\u0099\7K\2\2\u0099\u009a\7P\2\2"+
		"\u009a\u009b\7V\2\2\u009b\u009c\7G\2\2\u009c\u009d\7I\2\2\u009d\u009e"+
		"\7G\2\2\u009e\u009f\7T\2\2\u009f\66\3\2\2\2\u00a0\u00a1\7F\2\2\u00a1\u00a2"+
		"\7G\2\2\u00a2\u00a3\7E\2\2\u00a3\u00a4\7K\2\2\u00a4\u00a5\7O\2\2\u00a5"+
		"\u00a6\7C\2\2\u00a6\u00a7\7N\2\2\u00a78\3\2\2\2\u00a8\u00a9\7=\2\2\u00a9"+
		":\3\2\2\2\u00aa\u00ab\t\5\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\b\36\2\2"+
		"\u00ad<\3\2\2\2\n\2~\u0083\u0089\u008b\u008f\u0094\u0096\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}