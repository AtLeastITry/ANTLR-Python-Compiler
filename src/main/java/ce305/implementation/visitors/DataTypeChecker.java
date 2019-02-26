package ce305.implementation.visitors;

import ce305.abstraction.*;
import ce305.abstraction.expressions.*;
import ce305.abstraction.functions.*;
import ce305.abstraction.statements.*;

public class DataTypeChecker extends ASTVisitor<Boolean>
{
    private final DataType _type;

    public DataTypeChecker(DataType type) {
        _type = type;
    }

    @Override
    public Boolean visit(ProgramNode node) {
        return node.children.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(BinaryExpressionNode node) {
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(AssignmentNode node) {
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(NegateNode node) {
        return this.visit(node.innerNode);
    }

    @Override
    public Boolean visit(FunctionNode node) {
        return node.dataType == _type && node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(ValueNode node) {
        try {
            switch(_type) {
                case INTEGER:
                    Integer.parseInt(node.value.toString());
                    break;
                case FLOAT:
                    Float.parseFloat(node.value.toString());
                    break;
            }
        }
        catch(Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean visit(VariableNode node) {
        return true;
    }

    @Override
    public Boolean visit(DeclarationNode node) {
        return true;
    }

    @Override
    public Boolean visit(IfStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c)) && this.visit(node.child);
    }

    @Override
    public Boolean visit(ElseStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(ElseIfStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c)) && this.visit(node.child);
    }

    @Override
    public Boolean visit(BooleanExpressionNode node) {
        return this.visit(node.left) && this.visit(node.right);
    }

    @Override
    public Boolean visit(WhileStatementNode node) {
        return node.body.stream().allMatch(c -> this.visit(c));
    }

    @Override
    public Boolean visit(FunctionParamNode node) {
        return true;
    }

    @Override
    public Boolean visit(FunctionReturnStatementNode node) {
        return this.visit(node.expression);
    }
}