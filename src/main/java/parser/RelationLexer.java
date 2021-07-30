// Generated from RelationLexer.g4 by ANTLR 4.9.1
package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, SEMI=3, CONJ=4, COMP=5, LPARAN=6, RPARAN=7, COMPONENT=8, 
		REFINES=9, NOTREFINES=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "WS", "SEMI", "CONJ", "COMP", "LPARAN", "RPARAN", "COMPONENT", 
			"REFINES", "NOTREFINES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "';'", "'&&'", "'||'", "'('", "')'", null, "'<='", 
			"'</='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "WS", "SEMI", "CONJ", "COMP", "LPARAN", "RPARAN", "COMPONENT", 
			"REFINES", "NOTREFINES"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fA\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\5\2\33\n\2\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\6\t\61\n\t\r\t\16\t\62\3"+
		"\t\3\t\6\t\67\n\t\r\t\16\t8\3\n\3\n\3\n\3\13\3\13\3\13\3\13\2\2\f\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\6\4\2\f\f\17\17\4\2\13"+
		"\13\"\"\6\2\62;C\\aac|\3\2\60\60\2D\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\3\32\3\2\2\2\5\35\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2"+
		"\13(\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21\60\3\2\2\2\23:\3\2\2\2\25=\3\2"+
		"\2\2\27\30\7\17\2\2\30\33\7\f\2\2\31\33\t\2\2\2\32\27\3\2\2\2\32\31\3"+
		"\2\2\2\33\4\3\2\2\2\34\36\t\3\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3"+
		"\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\b\3\2\2\"\6\3\2\2\2#$\7=\2\2$\b\3\2\2"+
		"\2%&\7(\2\2&\'\7(\2\2\'\n\3\2\2\2()\7~\2\2)*\7~\2\2*\f\3\2\2\2+,\7*\2"+
		"\2,\16\3\2\2\2-.\7+\2\2.\20\3\2\2\2/\61\t\4\2\2\60/\3\2\2\2\61\62\3\2"+
		"\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\66\t\5\2\2\65\67\t\4"+
		"\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\22\3\2\2\2:;\7>"+
		"\2\2;<\7?\2\2<\24\3\2\2\2=>\7>\2\2>?\7\61\2\2?@\7?\2\2@\26\3\2\2\2\7\2"+
		"\32\37\628\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}