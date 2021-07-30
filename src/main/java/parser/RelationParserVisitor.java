// Generated from RelationParser.g4 by ANTLR 4.9.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RelationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RelationParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RelationParser#full}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFull(RelationParser.FullContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#facts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFacts(RelationParser.FactsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(RelationParser.FactContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#refinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefinement(RelationParser.RefinementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#nonrefinement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonrefinement(RelationParser.NonrefinementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSystem(RelationParser.SystemContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#conj_system}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConj_system(RelationParser.Conj_systemContext ctx);
	/**
	 * Visit a parse tree produced by {@link RelationParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(RelationParser.TermContext ctx);
}