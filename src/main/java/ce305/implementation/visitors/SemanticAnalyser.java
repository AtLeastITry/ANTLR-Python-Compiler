package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import ce305.abstraction.*;
import ce305.abstraction.expressions.*;
import ce305.abstraction.statements.*;
import ce305.abstraction.utils.Symbol;
import ce305.implementation.errors.DuplicateDefinitionException;
import ce305.implementation.errors.IncorrectDataType;
import ce305.implementation.errors.UndefinedVariableException;
import ce305.implementation.utils.*;

public class SemanticAnalyser extends ASTVisitor<INode>
{
    private Stack<SymbolTable> _tableStack = new Stack<>();
    private SymbolTable symbolTable() {
        return _tableStack.peek();
    }

    @Override
    public INode visit(ProgramNode node)
    {
        _tableStack.add(new SymbolTable());
        ArrayList<INode> children = new ArrayList<>();

        for (INode child : node.children) {
            children.add(this.visit(child));
        }

        return new ProgramNode(children);
    }

    @Override
    public INode visit(BinaryExpressionNode node)
    {
        return new BinaryExpressionNode(this.visit(node.left), this.visit(node.right), node.operation);
    }

    @Override
    public INode visit(AssignmentNode node)
    {
        INode left = this.visit(node.left);
        INode right = this.visit(node.right);

        if (left instanceof VariableNode)
        {
            Symbol temp = this.symbolTable().get(((VariableNode)left).value);
            if (temp != null)
            {
                if (!new DataTypeChecker(temp.dataType).visit(right))
                    throw new IncorrectDataType(String.format("\"%\" was expecting data type of %", temp.name, temp.dataType));
            }
            else
            {
                throw new UndefinedVariableException(String.format("Variable \"%\" has not been defined in the current scope", ((VariableNode)left).value));
            }
        }

        return new AssignmentNode(left, right);
    }

    @Override
    public INode visit(NegateNode node)
    {
        return new NegateNode(this.visit(node.innerNode));
    }

    @Override
    public INode visit(FunctionNode node)
    {
        return new FunctionNode(node.function, this.visit(node.argument));
    }

    @Override
    public INode visit(ValueNode node)
    {
        if (this.symbolTable().contains(node.value.toString()))
        {
            return new VariableNode(node.value.toString());
        } 
        
        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(node.value.toString());

        if (m.find()) {
            throw new UndefinedVariableException(String.format("Variable \"%\" has not been defined in the current scope", node.value));
        }            

        return node;
    }

    @Override
    public INode visit(VariableNode node)
    {
        if (!this.symbolTable().contains(node.value.toString()))
            throw new UndefinedVariableException(String.format("Variable \"%\" has not been defined in the current scope", node.value));

        return node;
    }

    @Override
    public INode visit(DeclarationNode node)
    {
        if (this.symbolTable().contains(node.name))
            throw new DuplicateDefinitionException(String.format("\"%\" already exists in the current scope", node.name));

            this.symbolTable().add(new Symbol(node.name, node.dataType));

        return node;
    }

    @Override
    public INode visit(IfStatementNode node)
    {
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();

        return new IfStatementNode(body, node.expression, node.child != null ? this.visit(node.child) : node.child);
    }

    @Override
    public INode visit(ElseStatementNode node)
    {
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();
        return new ElseStatementNode(body);
    }

    @Override
    public INode visit(ElseIfStatementNode node)
    {
        _tableStack.add(new SymbolTable(this.symbolTable()));

        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }
        _tableStack.pop();
        return new ElseIfStatementNode(
            body, node.expression, node.child != null ? this.visit(node.child) : node.child
        );
    }

    @Override
    public INode visit(BooleanExpressionNode node)
    {
        return new BooleanExpressionNode(this.visit(node.left), this.visit(node.right), node.operation);
    }
}