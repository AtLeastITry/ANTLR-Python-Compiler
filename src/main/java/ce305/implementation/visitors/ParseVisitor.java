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
import ce305.abstraction.utils.KeyWords;
import ce305.gen.LanguageBaseVisitor;
import ce305.gen.LanguageLexer;
import ce305.gen.LanguageParser.AssignmentContext;
import ce305.gen.LanguageParser.BooleanExprContext;
import ce305.gen.LanguageParser.CompileUnitContext;
import ce305.gen.LanguageParser.DeclarationContext;
import ce305.gen.LanguageParser.ElseIfStatementContext;
import ce305.gen.LanguageParser.ElseStatementContext;
import ce305.gen.LanguageParser.IfElseStatementContext;
import ce305.gen.LanguageParser.IfStatementContext;
import ce305.gen.LanguageParser.InfixExprContext;
import ce305.gen.LanguageParser.ParensExprContext;
import ce305.gen.LanguageParser.StatementContext;
import ce305.gen.LanguageParser.StatementsContext;
import ce305.gen.LanguageParser.UnaryExprContext;
import ce305.gen.LanguageParser.ValueExprContext;
import ce305.implementation.errors.KeywordException;
import ce305.implementation.errors.UnsupportedDataTypeException;
import ce305.implementation.errors.UnsupportedNodeException;

public class ParseVisitor extends LanguageBaseVisitor<INode> {
    public List<Exception> exceptions = new ArrayList<>();

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
            INode node = this.visit(statement);

            // If the node is null then it was probably a new line
            if (node != null) {
                result.children.add(node);
            }                
        }

        return result;
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
            if (statement.toString() != null || statement.toString() != "")
            {
                continue;
            }

            INode node = this.visit(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new IfStatementNode(children, this.visit(context.expression), null);
    }

    public INode visitElseStatement(ElseStatementContext context)
    {
        List<INode> children = new ArrayList<>();
        for (StatementContext statement: context.body.statement())
        {
            if (statement.toString() != null || statement.toString() != "")
            {
                continue;
            }

            INode node = this.visit(statement);

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
            if (statement.toString() != null || statement.toString() != "")
            {
                continue;
            }

            INode node = this.visit(statement);

            // If the node is null then it was probably a new line
            if (node != null)
                children.add(node);
        }

        return new ElseIfStatementNode(children, this.visit(context.expression), null);
    }

    public INode visitBooleanExpr(BooleanExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch (context.op.getType())
        {
            case LanguageLexer.EQUALS:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.EQUALS);
            case LanguageLexer.NEGATIVEEQUALS:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.NEGATIVEEQUALS);
            case LanguageLexer.GREATERTHAN:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.GREATERTHAN);
            case LanguageLexer.LESSTHAN:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.LESSTHAN);
            case LanguageLexer.GREATERTHANEQUALS:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.GREATERTHANEQUALS);
            case LanguageLexer.LESSTHANEQUALS:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.LESSTHANEQUALS);
            case LanguageLexer.OR:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.OR);
            case LanguageLexer.AND:
                return new BooleanExpressionNode(this.visit(context.left), this.visit(context.right), BooleanOperation.AND);
            default:
                // This occurs when a user has attempted to use an expression operator that is not supported.
                exceptions.add(new UnsupportedNodeException("Node is unsupported"));
                return null;
        }
    }

    public INode visitDeclaration(DeclarationContext context)
    {
        String name = context.name.getText();

        // Throw if the name of the variable matches one of the predefined keywords
        if (KeyWords.check(name))
        {
            // This occurs when a user has attempted to use an expression operator that is not supported.
            exceptions.add(new KeywordException(String.format("You cannot use the keyword % as an identifier", name)));
            return null;
        }

        // Throw if an unsupported data type is attempted
        try {
            return new DeclarationNode(name, DataType.valueOf(context.type.getText()));
        }
        catch(Exception e) {
            exceptions.add(new UnsupportedDataTypeException(String.format("The data type: % is currently unsupported", context.type.getText())));
            return null;
        }
    }

    public INode visitValueExpr(ValueExprContext context)
    {
        return new ValueNode(context.value.getText());
    }

    public INode visitParensExpr(ParensExprContext context)
    {
        return this.visit(context.expr());
    }

    public INode visitInfixExpr(InfixExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch(context.op.getType())
        {
            case LanguageLexer.PLUS:
                return new BinaryExpressionNode(this.visit(context.left), this.visit(context.right), ArithmeticOperation.ADDITION);
            case LanguageLexer.MINUS:
                return new BinaryExpressionNode(this.visit(context.left), this.visit(context.right), ArithmeticOperation.SUBTRACTION);
            case LanguageLexer.MULT:
                return new BinaryExpressionNode(this.visit(context.left), this.visit(context.right), ArithmeticOperation.MULTIPLICATION);
            case LanguageLexer.DIV:
                return new BinaryExpressionNode(this.visit(context.left), this.visit(context.right), ArithmeticOperation.DIVISION);
            case LanguageLexer.POWER:
                return new BinaryExpressionNode(this.visit(context.left), this.visit(context.right), ArithmeticOperation.POWER);
            default:
                // This occurs when a user has attempted to use an expression operator that is not supported.
                exceptions.add(new UnsupportedNodeException("Node is unsupported"));
                return null;
        }
    }

    public INode visitAssignment(AssignmentContext context)
    {
        // Remove all new line characters
        String name = context.variable.getText().replace("\r", "").replace("\n", "");
        return new AssignmentNode(new VariableNode(name), this.visit(context.right));
    }

    public INode visitUnaryExpr(UnaryExprContext context)
    {
        // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
        switch(context.op.getType())
        {
            case LanguageLexer.PLUS:
                return this.visit(context.expr());
            case LanguageLexer.MINUS:
                return new NegateNode(this.visit(context.expr()));
            default:
            exceptions.add(new UnsupportedNodeException("Node is unsupported"));
            return null;
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