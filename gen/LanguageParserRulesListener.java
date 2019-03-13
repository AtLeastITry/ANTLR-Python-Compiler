// Generated from C:/Git/CE305/src/main/antlr4\LanguageParserRules.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParserRules}.
 */
public interface LanguageParserRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#tokens}.
	 * @param ctx the parse tree
	 */
	void enterTokens(LanguageParserRules.TokensContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#tokens}.
	 * @param ctx the parse tree
	 */
	void exitTokens(LanguageParserRules.TokensContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(LanguageParserRules.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(LanguageParserRules.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParserRules.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParserRules.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(LanguageParserRules.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(LanguageParserRules.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#functionReturnStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturnStatement(LanguageParserRules.FunctionReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#functionReturnStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturnStatement(LanguageParserRules.FunctionReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#functionParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParam(LanguageParserRules.FunctionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#functionParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParam(LanguageParserRules.FunctionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(LanguageParserRules.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(LanguageParserRules.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(LanguageParserRules.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#ifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(LanguageParserRules.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(LanguageParserRules.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(LanguageParserRules.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(LanguageParserRules.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(LanguageParserRules.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(LanguageParserRules.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(LanguageParserRules.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageParserRules.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageParserRules.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LanguageParserRules.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LanguageParserRules.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(LanguageParserRules.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(LanguageParserRules.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(LanguageParserRules.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(LanguageParserRules.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(LanguageParserRules.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(LanguageParserRules.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LanguageParserRules.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LanguageParserRules.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(LanguageParserRules.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(LanguageParserRules.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(LanguageParserRules.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(LanguageParserRules.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(LanguageParserRules.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link LanguageParserRules#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(LanguageParserRules.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParserRules#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallParam(LanguageParserRules.FunctionCallParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParserRules#functionCallParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallParam(LanguageParserRules.FunctionCallParamContext ctx);
}