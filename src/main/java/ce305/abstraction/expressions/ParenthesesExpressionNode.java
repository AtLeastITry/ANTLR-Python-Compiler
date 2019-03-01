package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class ParenthesesExpressionNode implements INode {
    public INode innerExpression;

    public ParenthesesExpressionNode(INode innerExpression) {
        this.innerExpression = innerExpression;
    }

    @Override
    public String getDisplayName() {
        return ParenthesesExpressionNode.class.getName();
    }
}