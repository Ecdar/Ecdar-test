// Generated from RelationParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RelationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, WS=2, SEMI=3, CONJ=4, COMP=5, LPARAN=6, RPARAN=7, VAR_NAME=8, 
		DOT=9, REFINES=10, NOTREFINES=11, LOCALCONSISTENCY=12, NOTLOCALCONSISTENCY=13;
	public static final int
		RULE_full = 0, RULE_facts = 1, RULE_fact = 2, RULE_refinement = 3, RULE_nonrefinement = 4, 
		RULE_locallyconsistent = 5, RULE_notlocallyconsistent = 6, RULE_system = 7, 
		RULE_conj_system = 8, RULE_term = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"full", "facts", "fact", "refinement", "nonrefinement", "locallyconsistent", 
			"notlocallyconsistent", "system", "conj_system", "term"
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

	@Override
	public String getGrammarFileName() { return "RelationParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RelationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FullContext extends ParserRuleContext {
		public FactsContext facts() {
			return getRuleContext(FactsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RelationParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(RelationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RelationParser.NEWLINE, i);
		}
		public FullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterFull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitFull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitFull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullContext full() throws RecognitionException {
		FullContext _localctx = new FullContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_full);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(20);
				match(NEWLINE);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			facts();
			setState(27);
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

	public static class FactsContext extends ParserRuleContext {
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public FactsContext facts() {
			return getRuleContext(FactsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RelationParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RelationParser.NEWLINE, i);
		}
		public FactsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_facts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterFacts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitFacts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitFacts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactsContext facts() throws RecognitionException {
		FactsContext _localctx = new FactsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_facts);
		int _la;
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				fact();
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(30);
					match(NEWLINE);
					}
					}
					setState(33); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(35);
				facts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				fact();
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(38);
					match(NEWLINE);
					}
					}
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FactContext extends ParserRuleContext {
		public RefinementContext refinement() {
			return getRuleContext(RefinementContext.class,0);
		}
		public NonrefinementContext nonrefinement() {
			return getRuleContext(NonrefinementContext.class,0);
		}
		public LocallyconsistentContext locallyconsistent() {
			return getRuleContext(LocallyconsistentContext.class,0);
		}
		public NotlocallyconsistentContext notlocallyconsistent() {
			return getRuleContext(NotlocallyconsistentContext.class,0);
		}
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fact);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				refinement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				nonrefinement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				locallyconsistent();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				notlocallyconsistent();
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

	public static class RefinementContext extends ParserRuleContext {
		public SystemContext left;
		public SystemContext right;
		public TerminalNode REFINES() { return getToken(RelationParser.REFINES, 0); }
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public RefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterRefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitRefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitRefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefinementContext refinement() throws RecognitionException {
		RefinementContext _localctx = new RefinementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_refinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			((RefinementContext)_localctx).left = system(0);
			setState(53);
			match(REFINES);
			setState(54);
			((RefinementContext)_localctx).right = system(0);
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

	public static class NonrefinementContext extends ParserRuleContext {
		public SystemContext left;
		public SystemContext right;
		public TerminalNode NOTREFINES() { return getToken(RelationParser.NOTREFINES, 0); }
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public NonrefinementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonrefinement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterNonrefinement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitNonrefinement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitNonrefinement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonrefinementContext nonrefinement() throws RecognitionException {
		NonrefinementContext _localctx = new NonrefinementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nonrefinement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			((NonrefinementContext)_localctx).left = system(0);
			setState(57);
			match(NOTREFINES);
			setState(58);
			((NonrefinementContext)_localctx).right = system(0);
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

	public static class LocallyconsistentContext extends ParserRuleContext {
		public SystemContext comp;
		public TerminalNode LOCALCONSISTENCY() { return getToken(RelationParser.LOCALCONSISTENCY, 0); }
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public LocallyconsistentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locallyconsistent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterLocallyconsistent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitLocallyconsistent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitLocallyconsistent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocallyconsistentContext locallyconsistent() throws RecognitionException {
		LocallyconsistentContext _localctx = new LocallyconsistentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_locallyconsistent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(LOCALCONSISTENCY);
			setState(61);
			((LocallyconsistentContext)_localctx).comp = system(0);
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

	public static class NotlocallyconsistentContext extends ParserRuleContext {
		public SystemContext comp;
		public TerminalNode NOTLOCALCONSISTENCY() { return getToken(RelationParser.NOTLOCALCONSISTENCY, 0); }
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public NotlocallyconsistentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notlocallyconsistent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterNotlocallyconsistent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitNotlocallyconsistent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitNotlocallyconsistent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotlocallyconsistentContext notlocallyconsistent() throws RecognitionException {
		NotlocallyconsistentContext _localctx = new NotlocallyconsistentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_notlocallyconsistent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(NOTLOCALCONSISTENCY);
			setState(64);
			((NotlocallyconsistentContext)_localctx).comp = system(0);
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

	public static class SystemContext extends ParserRuleContext {
		public Conj_systemContext conj_system() {
			return getRuleContext(Conj_systemContext.class,0);
		}
		public List<SystemContext> system() {
			return getRuleContexts(SystemContext.class);
		}
		public SystemContext system(int i) {
			return getRuleContext(SystemContext.class,i);
		}
		public TerminalNode COMP() { return getToken(RelationParser.COMP, 0); }
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitSystem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitSystem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		return system(0);
	}

	private SystemContext system(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SystemContext _localctx = new SystemContext(_ctx, _parentState);
		SystemContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_system, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(67);
			conj_system(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SystemContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_system);
					setState(69);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(70);
					match(COMP);
					setState(71);
					system(3);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class Conj_systemContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<Conj_systemContext> conj_system() {
			return getRuleContexts(Conj_systemContext.class);
		}
		public Conj_systemContext conj_system(int i) {
			return getRuleContext(Conj_systemContext.class,i);
		}
		public TerminalNode CONJ() { return getToken(RelationParser.CONJ, 0); }
		public Conj_systemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conj_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterConj_system(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitConj_system(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitConj_system(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conj_systemContext conj_system() throws RecognitionException {
		return conj_system(0);
	}

	private Conj_systemContext conj_system(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Conj_systemContext _localctx = new Conj_systemContext(_ctx, _parentState);
		Conj_systemContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_conj_system, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(78);
			term();
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Conj_systemContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conj_system);
					setState(80);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(81);
					match(CONJ);
					setState(82);
					conj_system(3);
					}
					} 
				}
				setState(87);
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

	public static class TermContext extends ParserRuleContext {
		public Token prefix;
		public Token comp;
		public TerminalNode DOT() { return getToken(RelationParser.DOT, 0); }
		public List<TerminalNode> VAR_NAME() { return getTokens(RelationParser.VAR_NAME); }
		public TerminalNode VAR_NAME(int i) {
			return getToken(RelationParser.VAR_NAME, i);
		}
		public TerminalNode LPARAN() { return getToken(RelationParser.LPARAN, 0); }
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public TerminalNode RPARAN() { return getToken(RelationParser.RPARAN, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RelationParserListener ) ((RelationParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RelationParserVisitor ) return ((RelationParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				((TermContext)_localctx).prefix = match(VAR_NAME);
				setState(89);
				match(DOT);
				setState(90);
				((TermContext)_localctx).comp = match(VAR_NAME);
				}
				break;
			case LPARAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(LPARAN);
				setState(92);
				system(0);
				setState(93);
				match(RPARAN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return system_sempred((SystemContext)_localctx, predIndex);
		case 8:
			return conj_system_sempred((Conj_systemContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean system_sempred(SystemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean conj_system_sempred(Conj_systemContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17d\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\3\3\3\3\6\3\"\n\3\r\3\16\3"+
		"#\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\5\3/\n\3\3\4\3\4\3\4\3\4\5\4"+
		"\65\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\7\tK\n\t\f\t\16\tN\13\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"V\n\n\f\n\16\nY\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13b\n\13\3\13"+
		"\2\4\20\22\f\2\4\6\b\n\f\16\20\22\24\2\2\2c\2\31\3\2\2\2\4.\3\2\2\2\6"+
		"\64\3\2\2\2\b\66\3\2\2\2\n:\3\2\2\2\f>\3\2\2\2\16A\3\2\2\2\20D\3\2\2\2"+
		"\22O\3\2\2\2\24a\3\2\2\2\26\30\7\3\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31"+
		"\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\5\4\3\2\35"+
		"\36\7\2\2\3\36\3\3\2\2\2\37!\5\6\4\2 \"\7\3\2\2! \3\2\2\2\"#\3\2\2\2#"+
		"!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\5\4\3\2&/\3\2\2\2\'+\5\6\4\2(*\7\3\2\2"+
		")(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2\2.\37\3\2\2"+
		"\2.\'\3\2\2\2/\5\3\2\2\2\60\65\5\b\5\2\61\65\5\n\6\2\62\65\5\f\7\2\63"+
		"\65\5\16\b\2\64\60\3\2\2\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65"+
		"\7\3\2\2\2\66\67\5\20\t\2\678\7\f\2\289\5\20\t\29\t\3\2\2\2:;\5\20\t\2"+
		";<\7\r\2\2<=\5\20\t\2=\13\3\2\2\2>?\7\16\2\2?@\5\20\t\2@\r\3\2\2\2AB\7"+
		"\17\2\2BC\5\20\t\2C\17\3\2\2\2DE\b\t\1\2EF\5\22\n\2FL\3\2\2\2GH\f\4\2"+
		"\2HI\7\7\2\2IK\5\20\t\5JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\21\3"+
		"\2\2\2NL\3\2\2\2OP\b\n\1\2PQ\5\24\13\2QW\3\2\2\2RS\f\4\2\2ST\7\6\2\2T"+
		"V\5\22\n\5UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\23\3\2\2\2YW\3\2\2"+
		"\2Z[\7\n\2\2[\\\7\13\2\2\\b\7\n\2\2]^\7\b\2\2^_\5\20\t\2_`\7\t\2\2`b\3"+
		"\2\2\2aZ\3\2\2\2a]\3\2\2\2b\25\3\2\2\2\n\31#+.\64LWa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}