// Generated from C:/Git/CE305/src/main/antlr4\Language.g4 by ANTLR 4.7.2
package ce305.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(LanguageParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(LanguageParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functionReturnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturnStatement(LanguageParser.FunctionReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(LanguageParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(LanguageParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifElseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStatement(LanguageParser.IfElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(LanguageParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(LanguageParser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(LanguageParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#binaryAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAssignment(LanguageParser.BinaryAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfixExpr(LanguageParser.InfixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(LanguageParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(LanguageParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(LanguageParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(LanguageParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(LanguageParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functionCallParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallParam(LanguageParser.FunctionCallParamContext ctx);
}