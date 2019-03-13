// Generated from C:/Git/CE305/src/main/antlr4\LanguageParserRules.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParserRules}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageParserRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#tokens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokens(LanguageParserRules.TokensContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(LanguageParserRules.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LanguageParserRules.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(LanguageParserRules.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#functionReturnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturnStatement(LanguageParserRules.FunctionReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(LanguageParserRules.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(LanguageParserRules.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(LanguageParserRules.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LanguageParserRules.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(LanguageParserRules.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(LanguageParserRules.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParserRules.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LanguageParserRules.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(LanguageParserRules.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(LanguageParserRules.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(LanguageParserRules.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LanguageParserRules.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(LanguageParserRules.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(LanguageParserRules.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(LanguageParserRules.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParserRules#functionCallParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallParam(LanguageParserRules.FunctionCallParamContext ctx);
}