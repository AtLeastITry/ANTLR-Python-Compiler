package ce305.abstraction.expressions;

import ce305.abstraction.ArithmeticOperation;
import ce305.abstraction.INode;

public class BinaryExpressionNode implements INode {
    public final INode left;
    public final INode right;
    public final ArithmeticOperation operation;

    public BinaryExpressionNode(INode left, INode right, ArithmeticOperation operation) {
        super();
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%(operation: %)", BinaryExpressionNode.class.getName(), this.operation);
    }
}