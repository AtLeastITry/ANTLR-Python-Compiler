package compiler.implementation.visitors;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import compiler.abstraction.INode;
import compiler.abstraction.INodeComparator;
import compiler.abstraction.dependency.Dependency;
import compiler.abstraction.dependency.DependencyGraph;
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
import compiler.implementation.binders.BinderType;
import compiler.implementation.binders.DependencyGraphBinder;
import compiler.utils.FileHelper;
import compiler.utils.Sorting;

public class ASTSorter extends ASTVisitor<INode> {
    private final INodeComparator _comparator;
    private final DependencyGraph _dependencyGraph;

    public DependencyGraph getDependencyGraph() {
        return _dependencyGraph;
    }

    public ASTSorter(INode tree, String fileName) {
        DependencyGraphBinder dependencyGraphBinder = new DependencyGraphBinder();

        // First pass to allow declarations of functions and variables to be handled
        dependencyGraphBinder.bind(tree, BinderType.DeclarationOnly);

        // Second pass to build up the dependency graph
        _dependencyGraph = dependencyGraphBinder.bind(tree, BinderType.SyntaxOnly);
        FileHelper.generateGraphFile(_dependencyGraph, fileName);
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