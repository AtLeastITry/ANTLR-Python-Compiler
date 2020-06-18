package compiler.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import compiler.abstraction.ArithmeticOperation;
import compiler.abstraction.AssignmentOperation;
import compiler.abstraction.BooleanOperation;
import compiler.abstraction.DataType;
import compiler.abstraction.INode;
import compiler.abstraction.expressions.AssignmentNode;
import compiler.abstraction.expressions.BinaryExpressionNode;
import compiler.abstraction.expressions.BooleanExpressionNode;
import compiler.abstraction.expressions.DeclarationNode;
import compiler.abstraction.expressions.FunctionCallNode;
import compiler.abstraction.expressions.NegateNode;
import compiler.abstraction.expressions.ParenthesesExpressionNode;
import compiler.abstraction.expressions.ProgramNode;
import compiler.abstraction.expressions.ValueNode;
import compiler.abstraction.expressions.VariableNode;
import compiler.abstraction.functions.FunctionCallParamNode;
import compiler.abstraction.functions.FunctionNode;
import compiler.abstraction.functions.FunctionParamNode;
import compiler.abstraction.statements.ElseIfStatementNode;
import compiler.abstraction.statements.ElseStatementNode;
import compiler.abstraction.statements.FunctionReturnStatementNode;
import compiler.abstraction.statements.IfStatementNode;
import compiler.abstraction.statements.WhileStatementNode;
import compiler.abstraction.utils.KeyWords;
import compiler.gen.*;
import compiler.gen.LanguageParser.*;
import compiler.implementation.errors.KeywordException;
import compiler.implementation.errors.UnsupportedDataTypeException;
import compiler.implementation.errors.UnsupportedNodeException;

public class ParseVisitor extends LanguageBaseVisitor<INode> {
    public INode visitCompileUnit(CompileUnitContext context) {
        return this.visitStatements(context.statements());
    }

    public INode visitStatements(StatementsContext context) {
        ProgramNode result = new ProgramNode();

        // Loop through each of the statements the ANTLR parser finds
        for (StatementContext statement : context.statement()) {
            // If the statement is empty or null, then just skip it.
            if (statement.toString() == null || statement.toString() == "") {
                continue;
            }
            
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null) {
                result.children.add(node);
            }
        }

        return result;
    }

    @Override
    public INode visitStatement(StatementContext context) {
        // Check which type of statement has been generated and call the appropiate function
        FunctionStatementContext functionStatement = context.functionStatement();
        if (functionStatement != null) {
            return this.visitFunctionStatement(functionStatement);
        }

        FunctionReturnStatementContext functionReturnStatement = context.functionReturnStatement();
        if (functionReturnStatement != null) {
            return this.visitFunctionReturnStatement(functionReturnStatement);
        }

        DeclarationContext declaration = context.declaration();
        if (declaration != null) {
            return this.visitDeclaration(declaration);
        }

        AssignmentContext assignment = context.assignment();
        if (assignment != null) {
            return this.visitAssignment(assignment);
        }

        IfElseStatementContext ifElseStatement = context.ifElseStatement();
        if (ifElseStatement != null) {
            return this.visitIfElseStatement(ifElseStatement);
        }

        WhileStatementContext whileStatement = context.whileStatement();
        if (whileStatement != null) {
            return this.visitWhileStatement(whileStatement);
        }

        ExprContext expr = context.expr();
        if (expr != null) {
            return this.visitExpr(expr);
        }

        return null;
    }

    public INode visitExpr(ExprContext context) {
        // Check the instance type of the expression context and call the appropiate function.
        if (context instanceof ParensExprContext) {
            return this.visitParensExpr((ParensExprContext) context);
        }
        if (context instanceof UnaryExprContext) {
            return this.visitUnaryExpr((UnaryExprContext) context);
        }
        if (context instanceof InfixExprContext) {
            return this.visitInfixExpr((InfixExprContext) context);
        }
        if (context instanceof ValueExprContext) {
            return this.visitValueExpr((ValueExprContext) context);
        }
        if (context instanceof NotExprContext) {
            return this.visitNotExpr((NotExprContext) context);
        }
        if (context instanceof BooleanExprContext) {
            return this.visitBooleanExpr((BooleanExprContext) context);
        }

        if (context instanceof FunctionCallExprContext) {
            return this.visitFunctionCallExpr((FunctionCallExprContext) context);
        }

        return null;
    }

    public INode visitIfElseStatement(IfElseStatementContext context) {
        // Recursively get all of the if/else if/else statements up front
        IfStatementNode ifStatement = (IfStatementNode) this.visitIfStatement(context.ifStat);
        List<ElseIfStatementNode> elseIfStatements = context.elseIfStatement().stream()
                .map(x -> (ElseIfStatementNode) this.visitElseIfStatement(x)).collect(Collectors.toList());
        ElseStatementNode elseStatement = (ElseStatementNode) this.visitElseStatement(context.elseStatement());

        //Loop through the statements and chain them together, such that it will be "if statement" -> "if else" -> "else"
        if (elseIfStatements != null && elseIfStatements.size() > 0) {
            for (int i = elseIfStatements.size() - 2; i >= 0; i--) {
                ElseIfStatementNode current = elseIfStatements.get(i);
                ElseIfStatementNode sibling = elseIfStatements.get(i + 1);

                if (i == elseIfStatements.size() - 2 && elseStatement != null) {
                    elseIfStatements.set(i + 1, new ElseIfStatementNode(sibling.body, sibling.expression, elseStatement));
                }

                elseIfStatements.set(i, new ElseIfStatementNode(current.body, current.expression, elseIfStatements.get(i + 1)));
            }

            if (elseIfStatements.size() == 1) {
                ElseIfStatementNode elseIfStatementNode = elseIfStatements.get(0);

                elseIfStatements.set(0, new ElseIfStatementNode(elseIfStatementNode.body, elseIfStatementNode.expression, elseStatement));
            }

            return new IfStatementNode(ifStatement.body, ifStatement.expression, elseIfStatements.get(0));
        } else {
            if (elseStatement != null) {
                return new IfStatementNode(ifStatement.body, ifStatement.expression, elseStatement);
            }
        }

        return new IfStatementNode(ifStatement.body, ifStatement.expression, null);
    }

    public INode visitIfStatement(IfStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new IfStatementNode(children, this.visitExpr(context.expression), null);
    }

    public INode visitElseStatement(ElseStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new ElseStatementNode(children);
    }

    public INode visitElseIfStatement(ElseIfStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new ElseIfStatementNode(children, this.visitExpr(context.expression), null);
    }

    @Override
    public INode visitWhileStatement(WhileStatementContext context) {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new WhileStatementNode(children, this.visitExpr(context.expression));
    }

    @Override
    public INode visitFunctionStatement(FunctionStatementContext context) {
        String name = context.name.getText();

        // Throw if the name of the variable matches one of the predefined keywords.
        if (KeyWords.check(name)) {
            // This occurs when a user has attempted to use an expression operator that is not supported.
            throw new KeywordException(String.format("You cannot use the keyword %s as an identifier", name));
        }

        // Throw if an unsupported data type is attempted.
        DataType dataType = KeyWords.getType(context.type.getText());

        if (dataType == null) {
            throw new UnsupportedDataTypeException(
                    String.format("The data type: %s is currently unsupported", context.type.getText()));
        }

        List<INode> body = new ArrayList<>();
        for (StatementContext statement : context.body.statement()) {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line.
            if (node != null)
                body.add(node);
        }

        List<FunctionParamNode> params = new ArrayList<>();

        for (FunctionParamContext param : context.functionParam()) {
            FunctionParamNode node = (FunctionParamNode) this.visitFunctionParam(param);

            // If the node is null then it was probably a new line.
            if (node != null)
                params.add(node);
        }

        return new FunctionNode(dataType, name, body, params);
    }

    @Override
    public INode visitFunctionReturnStatement(FunctionReturnStatementContext context) {
        return new FunctionReturnStatementNode(this.visitExpr(context.expr()));
    }

    @Override
    public INode visitFunctionParam(FunctionParamContext context) {
        DeclarationContext declaration = context.declaration();
        String name = declaration.name.getText();

        // Throw if the name of the variable matches one of the predefined keywords
        if (KeyWords.check(name)) {
            // This occurs when a user has attempted to use an expression operator that is
            // not supported.
            throw new KeywordException(String.format("You cannot use the keyword %s as an identifier", name));
        }

        // Throw if an unsupported data type is attempted
        DataType dataType = KeyWords.getType(declaration.type.getText());

        if (dataType == null) {
            throw new UnsupportedDataTypeException(
                    String.format("The data type: %s is currently unsupported", declaration.type.getText()));
        }

        return new FunctionParamNode(name, dataType);
    }

    public INode visitBooleanExpr(BooleanExprContext context) {
        // Check which type of expression has been declared using the type parsed by the
        // ANTLR parser, then return the appropiate value
        switch (context.op.getType()) {
        case LanguageLexer.EQUALS:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.EQUALS);
        case LanguageLexer.NEGATIVEEQUALS:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.NEGATIVEEQUALS);
        case LanguageLexer.GREATERTHAN:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.GREATERTHAN);
        case LanguageLexer.LESSTHAN:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.LESSTHAN);
        case LanguageLexer.GREATERTHANEQUALS:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.GREATERTHANEQUALS);
        case LanguageLexer.LESSTHANEQUALS:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.LESSTHANEQUALS);
        case LanguageLexer.OR:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.OR);
        case LanguageLexer.AND:
            return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    BooleanOperation.AND);
        default:
            // This occurs when a user has attempted to use an expression operator that is
            // not supported.
            throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    public INode visitDeclaration(DeclarationContext context) {
        String name = context.name.getText();

        // Throw if the name of the variable matches one of the predefined keywords
        if (KeyWords.check(name)) {
            // This occurs when a user has attempted to use an expression operator that is
            // not supported.
            throw new KeywordException(String.format("You cannot use the keyword %s as an identifier", name));
        }

        // Throw if an unsupported data type is attempted
        DataType dataType = KeyWords.getType(context.type.getText());

        if (dataType == null) {
            throw new UnsupportedDataTypeException(
                    String.format("The data type: %s is currently unsupported", context.type.getText()));
        }

        return new DeclarationNode(name, dataType);
    }

    public INode visitValueExpr(ValueExprContext context) {
        return new ValueNode(context.value.getText());
    }

    public INode visitParensExpr(ParensExprContext context) {
        return new ParenthesesExpressionNode(this.visitExpr(context.expr()));
    }

    public INode visitInfixExpr(InfixExprContext context) {
        // Check which type of expression has been declared using the type parsed by the
        // ANTLR parser, then return the appropiate value
        switch (context.op.getType()) {
        case LanguageLexer.PLUS:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.ADDITION);
        case LanguageLexer.MINUS:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.SUBTRACTION);
        case LanguageLexer.MULT:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.MULTIPLICATION);
        case LanguageLexer.DIV:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.DIVISION);
        case LanguageLexer.POWER:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.POWER);
        case LanguageLexer.MODULO:
            return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right),
                    ArithmeticOperation.MODULO);
        default:
            // This occurs when a user has attempted to use an expression operator that is
            // not supported.
            throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    public INode visitAssignment(AssignmentContext context) {
        // Remove all new line characters
        String name = context.variable.getText().replace("\r", "").replace("\n", "");
        switch (context.op.getType()) {
            case LanguageLexer.AssignOP:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.ASSIGN);
            case LanguageLexer.ASSIGNPLUS:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.ADDITION);
            case LanguageLexer.ASSIGNMINUS:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.SUBTRACTION);
            case LanguageLexer.ASSIGNMULT:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.MULTIPLICATION);
            case LanguageLexer.ASSIGNDIV:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.DIVISION);
            case LanguageLexer.ASSIGNPOWER:
                return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right), AssignmentOperation.POWER);
            default:
                // This occurs when a user has attempted to use an expression operator that is
                // not supported.
                throw new UnsupportedNodeException("Node is unsupported");
            }
    }

    public INode visitUnaryExpr(UnaryExprContext context) {
        // Check which type of expression has been declared using the type parsed by the
        // ANTLR parser, then return the appropiate value
        switch (context.op.getType()) {
        case LanguageLexer.PLUS:
            return this.visitExpr(context.expr());
        case LanguageLexer.MINUS:
            return new NegateNode(this.visitExpr(context.expr()));
        default:
            throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    @Override
    public INode visitFunctionCallParam(FunctionCallParamContext context) {
        return new FunctionCallParamNode(this.visit(context.expr()));
    }

    @Override
    public INode visitFunctionCallExpr(FunctionCallExprContext context) {
        ArrayList<FunctionCallParamNode> params = new ArrayList<>();

        for (FunctionCallParamContext param : context.functionCallParam()) {
            params.add((FunctionCallParamNode)this.visitFunctionCallParam(param));
        }

        return new FunctionCallNode(context.name.getText(), params);
    }
}