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

    public ASTSorter(INode tree) {
        DependencyGraphBinder dependencyGraphBinder = new DependencyGraphBinder();
        dependencyGraphBinder.bind(tree, BinderType.DeclarationOnly);
        DependencyGraph dependencyGraph = dependencyGraphBinder.bind(tree, BinderType.SyntaxOnly);

        _comparator = new INodeComparator(dependencyGraph);
    }

    @Override
    public INode visit(ProgramNode node) {
        ArrayList<INode> body = Sorting.selectionSort(node.children, _comparator);

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
        ArrayList<INode> body = Sorting.selectionSort(node.body, _comparator);

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
        ArrayList<INode> body = Sorting.selectionSort(node.body, _comparator);
        INode child = null;

        if (node.child != null) {
            child = this.visit(node.child);
        }

        return new IfStatementNode(body, node.expression, child, node.id);
    }

    @Override
    public INode visit(ElseStatementNode node) {
        ArrayList<INode> body = Sorting.selectionSort(node.body, _comparator);
        return new ElseStatementNode(body, node.id);
    }

    @Override
    public INode visit(ElseIfStatementNode node) {
        ArrayList<INode> body = Sorting.selectionSort(node.body, _comparator);
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
        ArrayList<INode> body = Sorting.selectionSort(node.body, _comparator);

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