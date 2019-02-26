package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.INode;
import ce305.abstraction.expressions.AssignmentNode;
import ce305.abstraction.expressions.BinaryExpressionNode;
import ce305.abstraction.expressions.BooleanExpressionNode;
import ce305.abstraction.expressions.DeclarationNode;
import ce305.abstraction.expressions.FunctionCallNode;
import ce305.abstraction.expressions.NegateNode;
import ce305.abstraction.expressions.ProgramNode;
import ce305.abstraction.expressions.ValueNode;
import ce305.abstraction.expressions.VariableNode;
import ce305.abstraction.functions.FunctionCallParamNode;
import ce305.abstraction.functions.FunctionNode;
import ce305.abstraction.functions.FunctionParamNode;
import ce305.abstraction.statements.ElseIfStatementNode;
import ce305.abstraction.statements.ElseStatementNode;
import ce305.abstraction.statements.FunctionReturnStatementNode;
import ce305.abstraction.statements.IfStatementNode;
import ce305.abstraction.statements.WhileStatementNode;
import ce305.abstraction.utils.Symbol;
import ce305.implementation.errors.DuplicateDefinitionException;
import ce305.implementation.errors.IncorrectDataType;
import ce305.implementation.errors.UndefinedFunctionException;
import ce305.implementation.errors.UndefinedVariableException;
import ce305.implementation.utils.SymbolTable;

public class SemanticAnalyser extends ASTVisitor<INode> {
    private Stack<SymbolTable> _tableStack = new Stack<>();

    private SymbolTable symbolTable() {
        return _tableStack.peek();
    }

    @Override
    public INode visit(ProgramNode node) {
        _tableStack.add(new SymbolTable());
        ArrayList<INode> children = new ArrayList<>();

        for (INode child : node.children) {
            children.add(this.visit(child));
        }

        return new ProgramNode(children);
    }

    @Override
    public INode visit(BinaryExpressionNode node) {
        return new BinaryExpressionNode(this.visit(node.left), this.visit(node.right), node.operation);
    }

    @Override
    public INode visit(AssignmentNode node) {
        INode left = this.visit(node.left);
        INode right = this.visit(node.right);

        if (left instanceof VariableNode) {
            Symbol temp = this.symbolTable().get(((VariableNode) left).value);
            if (temp != null) {
                if (!new DataTypeChecker(temp.dataType, this.symbolTable()).visit(right))
                    throw new IncorrectDataType(
                            String.format("\"%s\" was expecting data type of %s", temp.name, temp.dataType));
            } else {
                throw new UndefinedVariableException(String.format(
                        "Variable \"%s\" has not been defined in the current scope", ((VariableNode) left).value));
            }
        }

        return new AssignmentNode(left, right);
    }

    @Override
    public INode visit(NegateNode node) {
        return new NegateNode(this.visit(node.innerNode));
    }

    @Override
    public INode visit(FunctionNode node) {
        this.symbolTable().add(new Symbol(node.name, node.dataType, node.params));
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();
        return new FunctionNode(node.dataType, node.name, node.body, node.params);
    }

    @Override
    public INode visit(ValueNode node) {
        if (this.symbolTable().contains(node.value.toString())) {
            return new VariableNode(node.value.toString());
        }

        Pattern p = Pattern.compile("[A-Za-z]+");
        Matcher m = p.matcher(node.value.toString());

        if (m.find()) {
            throw new UndefinedVariableException(
                    String.format("Variable \"%s\" has not been defined in the current scope", node.value));
        }

        return node;
    }

    @Override
    public INode visit(VariableNode node) {
        if (!this.symbolTable().contains(node.value.toString()))
            throw new UndefinedVariableException(
                    String.format("Variable \"%s\" has not been defined in the current scope", node.value));

        return node;
    }

    @Override
    public INode visit(DeclarationNode node) {
        if (this.symbolTable().contains(node.name))
            throw new DuplicateDefinitionException(
                    String.format("\"%s\" already exists in the current scope", node.name));

        this.symbolTable().add(new Symbol(node.name, node.dataType));

        return node;
    }

    @Override
    public INode visit(IfStatementNode node) {
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();

        return new IfStatementNode(body, node.expression, node.child != null ? this.visit(node.child) : node.child);
    }

    @Override
    public INode visit(ElseStatementNode node) {
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();
        return new ElseStatementNode(body);
    }

    @Override
    public INode visit(ElseIfStatementNode node) {
        _tableStack.add(new SymbolTable(this.symbolTable()));

        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }
        _tableStack.pop();
        return new ElseIfStatementNode(body, node.expression, node.child != null ? this.visit(node.child) : node.child);
    }

    @Override
    public INode visit(BooleanExpressionNode node) {
        return new BooleanExpressionNode(this.visit(node.left), this.visit(node.right), node.operation);
    }

    @Override
    public INode visit(WhileStatementNode node) {
        _tableStack.add(new SymbolTable(this.symbolTable()));
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : node.body) {
            body.add(this.visit(child));
        }

        _tableStack.pop();
        return new WhileStatementNode(body, node.expression);
    }

    @Override
    public INode visit(FunctionParamNode node) {
        return node;
    }

    @Override
    public INode visit(FunctionReturnStatementNode node) {
        return node;
    }

    @Override
    public INode visit(FunctionCallNode node) {
        Symbol symbol = this.symbolTable().get(node.name);

        if (symbol == null) {
            throw new UndefinedFunctionException(String.format("Function \"%s\" has not been defined in the current scope", node.name));
        }

        List<FunctionParamNode> paramDefinitions = (List<FunctionParamNode>)symbol.value;
        ArrayList<FunctionCallParamNode> params = new ArrayList<>();

        for (int i = 0; i < node.params.size(); i++) {
            FunctionCallParamNode param = (FunctionCallParamNode)this.visit(node.params.get(i));
            FunctionParamNode paramDefinition = paramDefinitions.get(i);

            if (!new DataTypeChecker(paramDefinition.dataType, this.symbolTable()).visit(param))
                    throw new IncorrectDataType(
                            String.format("Function \"%s\" was expecting data type of %s for \"%s\" param", node.name, paramDefinition.dataType, paramDefinition.name));
            params.add(param);
        }

        return new FunctionCallNode(node.name, params);
    }

    @Override
    public INode visit(FunctionCallParamNode node) {
        return new FunctionCallParamNode(this.visit(node.expression));
    }
}