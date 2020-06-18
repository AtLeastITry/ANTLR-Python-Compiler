package compiler.implementation.visitors;

import java.util.ArrayList;
import java.util.Optional;

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

public class ASTDependencyRetriever extends ASTVisitor<ArrayList<INode>> {
    private ArrayList<INode> _dependencies;
    private ArrayList<FunctionNode> _functions;
    private ArrayList<DeclarationNode> _variables;

    public ASTDependencyRetriever(ArrayList<FunctionNode> functions, ArrayList<DeclarationNode> variables) {
        _dependencies = new ArrayList<>();
        _functions = functions;
        _variables = variables;
    }


    @Override
    public ArrayList<INode> visit(ProgramNode node) {
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(BinaryExpressionNode node) {
        this.visit(node.left);
        this.visit(node.right);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(AssignmentNode node) {
        this.visit(node.left);
        this.visit(node.right);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(NegateNode node) {
        this.visit(node.innerNode);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionNode node) {
        _dependencies.add(node);

        for (INode child : node.body) {
            this.visit(child);
        }

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(ValueNode node) {
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(VariableNode node) {
        Optional<DeclarationNode> dependency = _variables.stream().filter(v -> v.name.equals(node.value)).findFirst();

        if (dependency.isPresent()) {
            _dependencies.add(dependency.get());
        }

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(DeclarationNode node) {
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(IfStatementNode node) {
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }

        if (node.child != null) {
            this.visit(node.child);
        }        
        
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(ElseStatementNode node) {
        for (INode child : node.body) {
            this.visit(child);
        }
        
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(ElseIfStatementNode node) {
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }

        if (node.child != null) {
            this.visit(node.child);
        }        
        
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(BooleanExpressionNode node) {
        this.visit(node.left);
        this.visit(node.right);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(WhileStatementNode node) {
        this.visit(node.expression);

        for (INode child : node.body) {
            this.visit(child);
        }
        
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionParamNode node) {
        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionReturnStatementNode node) {
        this.visit(node.expression);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionCallNode node) {
        Optional<FunctionNode> dependency = _functions.stream().filter(f -> f.name.equals(node.name)).findFirst();

        if (dependency.isPresent()) {
            _dependencies.add(dependency.get());
        }

        for(INode param: node.params) {
            this.visit(param);
        }

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(FunctionCallParamNode node) {
        this.visit(node.expression);

        return _dependencies;
    }

    @Override
    public ArrayList<INode> visit(ParenthesesExpressionNode node) {
        this.visit(node.innerExpression);

        return _dependencies;
    }

}