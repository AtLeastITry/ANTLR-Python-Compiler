// Generated from C:/Git/CE305/src/main/antlr4\Language.g4 by ANTLR 4.7.2
package ce305.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(LanguageParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(LanguageParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(LanguageParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(LanguageParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functionReturnStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturnStatement(LanguageParser.FunctionReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functionReturnStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturnStatement(LanguageParser.FunctionReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParam(LanguageParser.FunctionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParam(LanguageParser.FunctionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(LanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(LanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(LanguageParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(LanguageParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(LanguageParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(LanguageParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(LanguageParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(LanguageParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LanguageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(LanguageParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(LanguageParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(LanguageParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(LanguageParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(LanguageParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(LanguageParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LanguageParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(LanguageParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(LanguageParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(LanguageParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(LanguageParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(LanguageParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(LanguageParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallParam(LanguageParser.FunctionCallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallParam(LanguageParser.FunctionCallParamContext ctx);
}