package ce305.implementation.visitors;

import java.util.ArrayList;
import java.util.Optional;

import ce305.abstraction.INode;
import ce305.abstraction.expressions.AssignmentNode;
import ce305.abstraction.expressions.BinaryExpressionNode;
import ce305.abstraction.expressions.BooleanExpressionNode;
import ce305.abstraction.expressions.DeclarationNode;
import ce305.abstraction.expressions.FunctionCallNode;
import ce305.abstraction.expressions.NegateNode;
import ce305.abstraction.expressions.ParenthesesExpressionNode;
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