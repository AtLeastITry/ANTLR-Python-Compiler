package compiler.implementation.binders;

import compiler.abstraction.*;
import compiler.abstraction.expressions.*;
import compiler.abstraction.functions.*;
import compiler.abstraction.statements.*;

public abstract class Binder<T> {
    public abstract T bind(ProgramNode node, BinderType type);
    public abstract T bind(BinaryExpressionNode node, BinderType type);
    public abstract T bind(AssignmentNode node, BinderType type);
    public abstract T bind(NegateNode node, BinderType type);
    public abstract T bind(FunctionNode node, BinderType type);
    public abstract T bind(ValueNode node, BinderType type);
    public abstract T bind(VariableNode node, BinderType type);
    public abstract T bind(DeclarationNode node, BinderType type);
    public abstract T bind(IfStatementNode node, BinderType type);
    public abstract T bind(ElseStatementNode node, BinderType type);
    public abstract T bind(ElseIfStatementNode node, BinderType type);
    public abstract T bind(BooleanExpressionNode node, BinderType type);
    public abstract T bind(WhileStatementNode node, BinderType type);
    public abstract T bind(FunctionParamNode node, BinderType type);
    public abstract T bind(FunctionReturnStatementNode node, BinderType type);
    public abstract T bind(FunctionCallNode node, BinderType type);
    public abstract T bind(FunctionCallParamNode node, BinderType type);
    public abstract T bind(ParenthesesExpressionNode node, BinderType type);

    public T bind(INode node, BinderType type)
    {
        if (node instanceof ProgramNode) {
            return this.bind((ProgramNode)node, type);
        }

        if (node instanceof BinaryExpressionNode) {
            return this.bind((BinaryExpressionNode)node, type);
        }

        if (node instanceof AssignmentNode) {
            return this.bind((AssignmentNode)node, type);
        }

        if (node instanceof NegateNode) {
            return this.bind((NegateNode)node, type);
        }

        if (node instanceof FunctionNode) {
            return this.bind((FunctionNode)node, type);
        }

        if (node instanceof ValueNode) {
            return this.bind((ValueNode)node, type);
        }

        if (node instanceof VariableNode) {
            return this.bind((VariableNode)node, type);
        }

        if (node instanceof DeclarationNode) {
            return this.bind((DeclarationNode)node, type);
        }

        if (node instanceof IfStatementNode) {
            return this.bind((IfStatementNode)node, type);
        }

        if (node instanceof ElseStatementNode) {
            return this.bind((ElseStatementNode)node, type);
        }

        if (node instanceof ElseIfStatementNode) {
            return this.bind((ElseIfStatementNode)node, type);
        }

        if (node instanceof BooleanExpressionNode) {
            return this.bind((BooleanExpressionNode)node, type);
        }

        if (node instanceof WhileStatementNode) {
            return this.bind((WhileStatementNode)node, type);
        }

        if (node instanceof FunctionParamNode) {
            return this.bind((FunctionParamNode)node, type);
        }

        if (node instanceof FunctionReturnStatementNode) {
            return this.bind((FunctionReturnStatementNode)node, type);
        }

        if (node instanceof FunctionCallNode) {
            return this.bind((FunctionCallNode)node, type);
        }

        if (node instanceof FunctionCallParamNode) {
            return this.bind((FunctionCallParamNode)node, type);
        }

        if (node instanceof ParenthesesExpressionNode) {
            return this.bind((ParenthesesExpressionNode)node, type);
        }

        return null;
    }
}