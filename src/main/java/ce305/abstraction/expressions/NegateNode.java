package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class NegateNode implements INode {
    public final INode innerNode;

    public NegateNode(INode innerNode) {
        super();
        this.innerNode = innerNode;
    }

    @Override
    public String getDisplayName() {
        return NegateNode.class.getSimpleName();
    }
}