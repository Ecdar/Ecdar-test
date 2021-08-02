// Generated from RelationParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RelationParser}.
 */
public interface RelationParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RelationParser#full}.
	 * @param ctx the parse tree
	 */
	void enterFull(RelationParser.FullContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#full}.
	 * @param ctx the parse tree
	 */
	void exitFull(RelationParser.FullContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#facts}.
	 * @param ctx the parse tree
	 */
	void enterFacts(RelationParser.FactsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#facts}.
	 * @param ctx the parse tree
	 */
	void exitFacts(RelationParser.FactsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterFact(RelationParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitFact(RelationParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#refinement}.
	 * @param ctx the parse tree
	 */
	void enterRefinement(RelationParser.RefinementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#refinement}.
	 * @param ctx the parse tree
	 */
	void exitRefinement(RelationParser.RefinementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#nonrefinement}.
	 * @param ctx the parse tree
	 */
	void enterNonrefinement(RelationParser.NonrefinementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#nonrefinement}.
	 * @param ctx the parse tree
	 */
	void exitNonrefinement(RelationParser.NonrefinementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#locallyconsistent}.
	 * @param ctx the parse tree
	 */
	void enterLocallyconsistent(RelationParser.LocallyconsistentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#locallyconsistent}.
	 * @param ctx the parse tree
	 */
	void exitLocallyconsistent(RelationParser.LocallyconsistentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#notlocallyconsistent}.
	 * @param ctx the parse tree
	 */
	void enterNotlocallyconsistent(RelationParser.NotlocallyconsistentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#notlocallyconsistent}.
	 * @param ctx the parse tree
	 */
	void exitNotlocallyconsistent(RelationParser.NotlocallyconsistentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(RelationParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(RelationParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#conj_system}.
	 * @param ctx the parse tree
	 */
	void enterConj_system(RelationParser.Conj_systemContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#conj_system}.
	 * @param ctx the parse tree
	 */
	void exitConj_system(RelationParser.Conj_systemContext ctx);
	/**
	 * Enter a parse tree produced by {@link RelationParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(RelationParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RelationParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(RelationParser.TermContext ctx);
}