package ce305.abstraction.expressions;

import ce305.abstraction.BooleanOperation;
import ce305.abstraction.INode;

public class BooleanExpressionNode implements INode {
    public final INode left;
    public final INode right;
    public final BooleanOperation operation;

    public BooleanExpressionNode(INode left, INode right, BooleanOperation operation) {
        super();
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation: %s)", BooleanExpressionNode.class.getName(), this.operation);
    }
}