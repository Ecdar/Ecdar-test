// Generated from RelationLexer.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, SEMI=3, CONJ=4, COMP=5, LPARAN=6, RPARAN=7, VAR_NAME=8, 
		DOT=9, REFINES=10, NOTREFINES=11, LOCALCONSISTENCY=12, NOTLOCALCONSISTENCY=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "WS", "SEMI", "CONJ", "COMP", "LPARAN", "RPARAN", "VAR_NAME", 
			"DOT", "REFINES", "NOTREFINES", "LOCALCONSISTENCY", "NOTLOCALCONSISTENCY"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "';'", "'&&'", "'||'", "'('", "')'", null, "'.'", "'<='", 
			"'</='", "'locally-consistent:'", "'not-locally-consistent:'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "SEMI", "CONJ", "COMP", "LPARAN", "RPARAN", "VAR_NAME", 
			"DOT", "REFINES", "NOTREFINES", "LOCALCONSISTENCY", "NOTLOCALCONSISTENCY"
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


	public RelationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RelationLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\5\2!\n\2\3\3\6\3$\n\3\r\3\16"+
		"\3%\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\6\t\67"+
		"\n\t\r\t\16\t8\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\5\4\2\f\f\17\17\4\2\13"+
		"\13\"\"\6\2\62;C\\aac|\2q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3 \3\2\2\2\5#\3\2\2"+
		"\2\7)\3\2\2\2\t+\3\2\2\2\13.\3\2\2\2\r\61\3\2\2\2\17\63\3\2\2\2\21\66"+
		"\3\2\2\2\23:\3\2\2\2\25<\3\2\2\2\27?\3\2\2\2\31C\3\2\2\2\33W\3\2\2\2\35"+
		"\36\7\17\2\2\36!\7\f\2\2\37!\t\2\2\2 \35\3\2\2\2 \37\3\2\2\2!\4\3\2\2"+
		"\2\"$\t\3\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\b"+
		"\3\2\2(\6\3\2\2\2)*\7=\2\2*\b\3\2\2\2+,\7(\2\2,-\7(\2\2-\n\3\2\2\2./\7"+
		"~\2\2/\60\7~\2\2\60\f\3\2\2\2\61\62\7*\2\2\62\16\3\2\2\2\63\64\7+\2\2"+
		"\64\20\3\2\2\2\65\67\t\4\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3"+
		"\2\2\29\22\3\2\2\2:;\7\60\2\2;\24\3\2\2\2<=\7>\2\2=>\7?\2\2>\26\3\2\2"+
		"\2?@\7>\2\2@A\7\61\2\2AB\7?\2\2B\30\3\2\2\2CD\7n\2\2DE\7q\2\2EF\7e\2\2"+
		"FG\7c\2\2GH\7n\2\2HI\7n\2\2IJ\7{\2\2JK\7/\2\2KL\7e\2\2LM\7q\2\2MN\7p\2"+
		"\2NO\7u\2\2OP\7k\2\2PQ\7u\2\2QR\7v\2\2RS\7g\2\2ST\7p\2\2TU\7v\2\2UV\7"+
		"<\2\2V\32\3\2\2\2WX\7p\2\2XY\7q\2\2YZ\7v\2\2Z[\7/\2\2[\\\7n\2\2\\]\7q"+
		"\2\2]^\7e\2\2^_\7c\2\2_`\7n\2\2`a\7n\2\2ab\7{\2\2bc\7/\2\2cd\7e\2\2de"+
		"\7q\2\2ef\7p\2\2fg\7u\2\2gh\7k\2\2hi\7u\2\2ij\7v\2\2jk\7g\2\2kl\7p\2\2"+
		"lm\7v\2\2mn\7<\2\2n\34\3\2\2\2\6\2 %8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}