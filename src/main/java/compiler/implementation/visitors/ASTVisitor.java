package compiler.implementation.visitors;

import compiler.abstraction.*;
import compiler.abstraction.expressions.*;
import compiler.abstraction.functions.*;
import compiler.abstraction.statements.*;

public abstract class ASTVisitor<T> {
    public abstract T visit(ProgramNode node);
    public abstract T visit(BinaryExpressionNode node);
    public abstract T visit(AssignmentNode node);
    public abstract T visit(NegateNode node);
    public abstract T visit(FunctionNode node);
    public abstract T visit(ValueNode node);
    public abstract T visit(VariableNode node);
    public abstract T visit(DeclarationNode node);
    public abstract T visit(IfStatementNode node);
    public abstract T visit(ElseStatementNode node);
    public abstract T visit(ElseIfStatementNode node);
    public abstract T visit(BooleanExpressionNode node);
    public abstract T visit(WhileStatementNode node);
    public abstract T visit(FunctionParamNode node);
    public abstract T visit(FunctionReturnStatementNode node);
    public abstract T visit(FunctionCallNode node);
    public abstract T visit(FunctionCallParamNode node);
    public abstract T visit(ParenthesesExpressionNode node);

    public T visit(INode node)
    {
        if (node instanceof ProgramNode) {
            return this.visit((ProgramNode)node);
        }

        if (node instanceof BinaryExpressionNode) {
            return this.visit((BinaryExpressionNode)node);
        }

        if (node instanceof AssignmentNode) {
            return this.visit((AssignmentNode)node);
        }

        if (node instanceof NegateNode) {
            return this.visit((NegateNode)node);
        }

        if (node instanceof FunctionNode) {
            return this.visit((FunctionNode)node);
        }

        if (node instanceof ValueNode) {
            return this.visit((ValueNode)node);
        }

        if (node instanceof VariableNode) {
            return this.visit((VariableNode)node);
        }

        if (node instanceof DeclarationNode) {
            return this.visit((DeclarationNode)node);
        }

        if (node instanceof IfStatementNode) {
            return this.visit((IfStatementNode)node);
        }

        if (node instanceof ElseStatementNode) {
            return this.visit((ElseStatementNode)node);
        }

        if (node instanceof ElseIfStatementNode) {
            return this.visit((ElseIfStatementNode)node);
        }

        if (node instanceof BooleanExpressionNode) {
            return this.visit((BooleanExpressionNode)node);
        }

        if (node instanceof WhileStatementNode) {
            return this.visit((WhileStatementNode)node);
        }

        if (node instanceof FunctionParamNode) {
            return this.visit((FunctionParamNode)node);
        }

        if (node instanceof FunctionReturnStatementNode) {
            return this.visit((FunctionReturnStatementNode)node);
        }

        if (node instanceof FunctionCallNode) {
            return this.visit((FunctionCallNode)node);
        }

        if (node instanceof FunctionCallParamNode) {
            return this.visit((FunctionCallParamNode)node);
        }

        if (node instanceof ParenthesesExpressionNode) {
            return this.visit((ParenthesesExpressionNode)node);
        }

        return null;
    }
}