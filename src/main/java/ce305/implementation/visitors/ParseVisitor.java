package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ce305.abstraction.ArithmeticOperation;
import ce305.abstraction.BooleanOperation;
import ce305.abstraction.DataType;
import ce305.abstraction.INode;
import ce305.abstraction.expressions.AssignmentNode;
import ce305.abstraction.expressions.BinaryExpressionNode;
import ce305.abstraction.expressions.BooleanExpressionNode;
import ce305.abstraction.expressions.DeclarationNode;
import ce305.abstraction.expressions.NegateNode;
import ce305.abstraction.expressions.ProgramNode;
import ce305.abstraction.expressions.ValueNode;
import ce305.abstraction.expressions.VariableNode;
import ce305.abstraction.statements.ElseIfStatementNode;
import ce305.abstraction.statements.ElseStatementNode;
import ce305.abstraction.statements.IfStatementNode;
import ce305.abstraction.statements.WhileStatementNode;
import ce305.abstraction.utils.KeyWords;
import ce305.gen.*;
import ce305.gen.LanguageParser.*;
import ce305.implementation.errors.KeywordException;
import ce305.implementation.errors.UnsupportedDataTypeException;
import ce305.implementation.errors.UnsupportedNodeException;

public class ParseVisitor extends LanguageBaseVisitor<INode> {
    public INode visitCompileUnit(CompileUnitContext context)
    {
        return this.visitStatements(context.statements());
    }

    public INode visitStatements(StatementsContext context)
    {
        ProgramNode result = new ProgramNode();

        // Loop through each of the expressions the ANTLR parser finds
        for (StatementContext statement : context.statement()) {
            if (statement.toString() == null || statement.toString() == "")
            {
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
        if (context instanceof ParensExprContext) {
            return this.visitParensExpr((ParensExprContext)context);
        }
        if (context instanceof UnaryExprContext) {
            return this.visitUnaryExpr((UnaryExprContext)context);
        }
        if (context instanceof InfixExprContext) {
            return this.visitInfixExpr((InfixExprContext)context);
        }
        if (context instanceof ValueExprContext) {
            return this.visitValueExpr((ValueExprContext)context);
        }
        if (context instanceof NotExprContext) {
            return this.visitNotExpr((NotExprContext)context);
        }
        if (context instanceof BooleanExprContext) {
            return this.visitBooleanExpr((BooleanExprContext)context);
        }

        return null;
    }

    public INode visitIfElseStatement(IfElseStatementContext context)
    {
        IfStatementNode ifStatement = (IfStatementNode)this.visitIfStatement(context.ifStat);
        List<ElseIfStatementNode> elseIfStatements = context.elseIfStatement().stream().map(x -> (ElseIfStatementNode)this.visitElseIfStatement(x)).collect(Collectors.toList());
        ElseStatementNode elseStatement = (ElseStatementNode)this.visitElseStatement(context.elseStatement());

        if (elseIfStatements != null && elseIfStatements.size() > 0)
        {
            for (int i = elseIfStatements.size() - 2; i >= 0; i--)
            {
                ElseIfStatementNode current = elseIfStatements.get(i);
                ElseIfStatementNode sibling = elseIfStatements.get(i + 1);

                if (i == elseIfStatements.size() - 2)
                {
                    if (elseStatement != null)
                    {
                        elseIfStatements.set(i + 1, new ElseIfStatementNode(sibling.body, sibling.expression, elseStatement));
                    }
                }


                elseIfStatements.set(i, new ElseIfStatementNode(current.body, current.expression, elseIfStatements.get(i + 1)));
            }

            return new IfStatementNode(ifStatement.body, ifStatement.expression, elseIfStatements.get(0));
        }
        else
        {
            if (elseStatement != null)
            {
                return new IfStatementNode(ifStatement.body, ifStatement.expression, elseStatement);
            }
        }

        return new IfStatementNode(ifStatement.body, ifStatement.expression, null);
    }

    public INode visitIfStatement(IfStatementContext context)
    {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement: context.body.statement())
        {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new IfStatementNode(children, this.visitExpr(context.expression), null);
    }

    public INode visitElseStatement(ElseStatementContext context)
    {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement: context.body.statement())
        {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new ElseStatementNode(children);
    }

    public INode visitElseIfStatement(ElseIfStatementContext context)
    {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement: context.body.statement())
        {
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
        for (StatementContext statement: context.body.statement())
        {
            INode node = this.visitStatement(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new WhileStatementNode(children, this.visitExpr(context.expression));
    }

    public INode visitBooleanExpr(BooleanExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch (context.op.getType())
        {
            case LanguageLexer.EQUALS:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.EQUALS);
            case LanguageLexer.NEGATIVEEQUALS:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.NEGATIVEEQUALS);
            case LanguageLexer.GREATERTHAN:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.GREATERTHAN);
            case LanguageLexer.LESSTHAN:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.LESSTHAN);
            case LanguageLexer.GREATERTHANEQUALS:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.GREATERTHANEQUALS);
            case LanguageLexer.LESSTHANEQUALS:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.LESSTHANEQUALS);
            case LanguageLexer.OR:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.OR);
            case LanguageLexer.AND:
                return new BooleanExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), BooleanOperation.AND);
            default:
                // This occurs when a user has attempted to use an expression operator that is not supported.
                throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    public INode visitDeclaration(DeclarationContext context)
    {
        String name = context.name.getText();

        // Throw if the name of the variable matches one of the predefined keywords
        if (KeyWords.check(name))
        {
            // This occurs when a user has attempted to use an expression operator that is not supported.
            throw new KeywordException(String.format("You cannot use the keyword %s as an identifier", name));            
        }

        // Throw if an unsupported data type is attempted
        DataType dataType = KeyWords.getType(context.type.getText());

        if (dataType == null) {
            throw new UnsupportedDataTypeException(String.format("The data type: %s is currently unsupported", context.type.getText()));
        }
        
        return new DeclarationNode(name, dataType);
    }

    public INode visitValueExpr(ValueExprContext context)
    {
        return new ValueNode(context.value.getText());
    }

    public INode visitParensExpr(ParensExprContext context)
    {
        return this.visitExpr(context.expr());
    }

    public INode visitInfixExpr(InfixExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch(context.op.getType())
        {
            case LanguageLexer.PLUS:
                return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), ArithmeticOperation.ADDITION);
            case LanguageLexer.MINUS:
                return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), ArithmeticOperation.SUBTRACTION);
            case LanguageLexer.MULT:
                return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), ArithmeticOperation.MULTIPLICATION);
            case LanguageLexer.DIV:
                return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), ArithmeticOperation.DIVISION);
            case LanguageLexer.POWER:
                return new BinaryExpressionNode(this.visitExpr(context.left), this.visitExpr(context.right), ArithmeticOperation.POWER);
            default:
                // This occurs when a user has attempted to use an expression operator that is not supported.
                throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    public INode visitAssignment(AssignmentContext context)
    {
        // Remove all new line characters
        String name = context.variable.getText().replace("\r", "").replace("\n", "");
        return new AssignmentNode(new VariableNode(name), this.visitExpr(context.right));
    }

    public INode visitUnaryExpr(UnaryExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch(context.op.getType())
        {
            case LanguageLexer.PLUS:
                return this.visitExpr(context.expr());
            case LanguageLexer.MINUS:
                return new NegateNode(this.visitExpr(context.expr()));
            default:
                throw new UnsupportedNodeException("Node is unsupported");
        }
    }

    // public INode visitFuncExpr(FuncExprContext context)
    // {
    //     var funcName = context.func.Text;
        
    //     // Attempt to generate the mathmatical function
    //     var func = typeof(Math)
    //     .GetMethods(BindingFlags.Public | BindingFlags.Static)
    //     .Where(m => m.ReturnType == typeof(double))
    //     .Where(m => m.GetParameters().Select(p => p.ParameterType).SequenceEqual(new[] { typeof(double) }))
    //     .FirstOrDefault(m => m.Name.Equals(funcName, StringComparison.OrdinalIgnoreCase));

    //     // If unable to generate the function then throw an error
    //     if (func == null)
    //         throw new NotSupportedException(string.Format("Function {0} is not supported", funcName));

    //     return new FunctionNode(funcName, this.visit(context.expr()));
    // }
}