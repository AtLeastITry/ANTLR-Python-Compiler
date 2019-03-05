package ce305.abstraction.expressions;

import java.util.UUID;

import ce305.abstraction.INode;

public class ParenthesesExpressionNode extends INode {
    public INode innerExpression;

    public ParenthesesExpressionNode(INode innerExpression) {
        super();
        this.innerExpression = innerExpression;
    }

    public ParenthesesExpressionNode(INode innerExpression, UUID id) {
        super(id);
        this.innerExpression = innerExpression;
    }

    @Override
    public String getDisplayName() {
        return ParenthesesExpressionNode.class.getSimpleName();
    }
}