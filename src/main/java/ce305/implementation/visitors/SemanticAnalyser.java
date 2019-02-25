package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
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

public class SemanticAnalyser
{
    public INode visit(ProgramNode node) throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        SymbolTable symbolTable = new SymbolTable();
        ArrayList<INode> children = new ArrayList<>();

        for (INode child : node.children) {
            children.add(this.visit(child, symbolTable));
        }

        return new ProgramNode(children);
    }

    public INode visit(BinaryExpressionNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        return new BinaryExpressionNode(this.visit(node.left, symbolTable), this.visit(node.right, symbolTable), node.operation);
    }

    public INode visit(AssignmentNode node, SymbolTable symbolTable) throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        INode left = this.visit(node.left, symbolTable);
        INode right = this.visit(node.right, symbolTable);

        if (left instanceof VariableNode)
        {
            Symbol temp = symbolTable.get(((VariableNode)left).value);
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

    public INode visit(NegateNode node, SymbolTable symbolTable) throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        return new NegateNode(this.visit(node.innerNode, symbolTable));
    }

    public INode visit(FunctionNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        return new FunctionNode(node.function, this.visit(node.argument, symbolTable));
    }

    public INode visit(ValueNode node, SymbolTable symbolTable) throws UndefinedVariableException
    {
        if (symbolTable.contains(node.value.toString()))
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

    public INode visit(VariableNode node, SymbolTable symbolTable) throws UndefinedVariableException
    {
        if (!symbolTable.contains(node.value.toString()))
            throw new UndefinedVariableException(String.format("Variable \"%\" has not been defined in the current scope", node.value));

        return node;
    }

    public INode visit(DeclarationNode node, SymbolTable symbolTable) throws DuplicateDefinitionException
    {
        if (symbolTable.contains(node.name))
            throw new DuplicateDefinitionException(String.format("\"%\" already exists in the current scope", node.name));

        symbolTable.add(new Symbol(node.name, node.dataType));

        return node;
    }

    public INode visit(IfStatementNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        SymbolTable tempTable = new SymbolTable(symbolTable);

        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child, symbolTable));
        }

        return new IfStatementNode(body, node.expression, node.child != null ? this.visit(node.child, tempTable) : node.child);
    }

    public INode visit(ElseStatementNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        SymbolTable tempTable = new SymbolTable(symbolTable);
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child, symbolTable));
        }

        return new ElseStatementNode(body);
    }

    public INode visit(ElseIfStatementNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        SymbolTable tempTable = new SymbolTable(symbolTable);

        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child, symbolTable));
        }

        return new ElseIfStatementNode(
            body, node.expression, node.child != null ? this.visit(node.child, tempTable) : node.child
        );
    }

    public INode visit(BooleanExpressionNode node, SymbolTable symbolTable)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        return new BooleanExpressionNode(this.visit(node.left, symbolTable), this.visit(node.right, symbolTable), node.operation);
    }

    public INode visit(INode node, SymbolTable symbolTable) throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        if (node instanceof ProgramNode) {
            return this.visit((ProgramNode)node);
        }

        if (node instanceof BinaryExpressionNode) {
            return this.visit((BinaryExpressionNode)node, symbolTable);
        }

        if (node instanceof AssignmentNode) {
            return this.visit((AssignmentNode)node, symbolTable);
        }

        if (node instanceof NegateNode) {
            return this.visit((NegateNode)node, symbolTable);
        }

        if (node instanceof FunctionNode) {
            return this.visit((FunctionNode)node, symbolTable);
        }

        if (node instanceof ValueNode) {
            return this.visit((ValueNode)node, symbolTable);
        }

        if (node instanceof VariableNode) {
            return this.visit((VariableNode)node, symbolTable);
        }

        if (node instanceof DeclarationNode) {
            return this.visit((DeclarationNode)node, symbolTable);
        }

        if (node instanceof IfStatementNode) {
            return this.visit((IfStatementNode)node, symbolTable);
        }

        if (node instanceof ElseStatementNode) {
            return this.visit((ElseStatementNode)node, symbolTable);
        }

        if (node instanceof ElseIfStatementNode) {
            return this.visit((ElseIfStatementNode)node, symbolTable);
        }

        if (node instanceof BooleanExpressionNode) {
            return this.visit((BooleanExpressionNode)node, symbolTable);
        }

        return null;
    }

    public INode visit(INode node) throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException
    {
        if (node instanceof ProgramNode) {
            return this.visit((ProgramNode)node);
        }

        return null;
    }
}