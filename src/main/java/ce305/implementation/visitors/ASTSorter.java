package ce305.implementation.visitors;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import ce305.abstraction.INode;
import ce305.abstraction.INodeComparator;
import ce305.abstraction.dependency.Dependency;
import ce305.abstraction.dependency.DependencyGraph;
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
import ce305.implementation.binders.BinderType;
import ce305.implementation.binders.DependencyGraphBinder;
import ce305.implementation.utils.Sorting;

public class ASTSorter extends ASTVisitor<INode> {
    private final INodeComparator _comparator;
    private final DependencyGraph _dependencyGraph;

    public DependencyGraph getDependencyGraph() {
        return _dependencyGraph;
    }

    public ASTSorter(INode tree) {
        DependencyGraphBinder dependencyGraphBinder = new DependencyGraphBinder();

        // First pass to allow declarations of functions and variables to be handled
        dependencyGraphBinder.bind(tree, BinderType.DeclarationOnly);

        // Second pass to build up the dependency graph
        _dependencyGraph = dependencyGraphBinder.bind(tree, BinderType.SyntaxOnly);

        // Create a comparator to be used through the service
        _comparator = new INodeComparator(_dependencyGraph);
    }

    @Override
    public INode visit(ProgramNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.children, _comparator)) {
            body.add(this.visit(child));
        }

        return new ProgramNode(body);
    }

    @Override
    public INode visit(BinaryExpressionNode node) {
        return node;
    }

    @Override
    public INode visit(AssignmentNode node) {
        return node;
    }

    @Override
    public INode visit(NegateNode node) {
        return node;
    }

    @Override
    public INode visit(FunctionNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.body, _comparator)) {
            body.add(this.visit(child));
        }

        return new FunctionNode(node.dataType, node.name, body, node.params);
    }

    @Override
    public INode visit(ValueNode node) {
        return node;
    }

    @Override
    public INode visit(VariableNode node) {
        return node;
    }

    @Override
    public INode visit(DeclarationNode node) {
        return node;
    }

    @Override
    public INode visit(IfStatementNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.body, _comparator)) {
            body.add(this.visit(child));
        }

        INode child = null;

        if (node.child != null) {
            child = this.visit(node.child);
        }

        return new IfStatementNode(body, node.expression, child, node.id);
    }

    @Override
    public INode visit(ElseStatementNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.body, _comparator)) {
            body.add(this.visit(child));
        }
        return new ElseStatementNode(body, node.id);
    }

    @Override
    public INode visit(ElseIfStatementNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.body, _comparator)) {
            body.add(this.visit(child));
        }
        INode child = null;

        if (node.child != null) {
            child = this.visit(node.child);
        }

        return new ElseIfStatementNode(body, node.expression, child, node.id);
    }

    @Override
    public INode visit(BooleanExpressionNode node) {
        return node;
    }

    @Override
    public INode visit(WhileStatementNode node) {
        // Re-order nodes based on the dependancy graph using a selection sort
        ArrayList<INode> body = new ArrayList<>();

        for (INode child : Sorting.selectionSort(node.body, _comparator)) {
            body.add(this.visit(child));
        }

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
        return node;
    }

    @Override
    public INode visit(FunctionCallParamNode node) {
        return node;
    }

    @Override
    public INode visit(ParenthesesExpressionNode node) {
        return node;
    }

}