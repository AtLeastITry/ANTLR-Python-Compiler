package compiler.abstraction.expressions;

import java.util.UUID;

import compiler.abstraction.BooleanOperation;
import compiler.abstraction.INode;

public class BooleanExpressionNode extends INode {
    public final INode left;
    public final INode right;
    public final BooleanOperation operation;

    public BooleanExpressionNode(INode left, INode right, BooleanOperation operation) {
        super();
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public BooleanExpressionNode(INode left, INode right, BooleanOperation operation, UUID id) {
        super(id);
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation: %s)", BooleanExpressionNode.class.getSimpleName(), this.operation);
    }
}