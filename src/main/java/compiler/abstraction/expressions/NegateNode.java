package compiler.abstraction.expressions;

import java.util.UUID;

import compiler.abstraction.INode;

public class NegateNode extends INode {
    public final INode innerNode;

    public NegateNode(INode innerNode) {
        super();
        this.innerNode = innerNode;
    }

    public NegateNode(INode innerNode, UUID id) {
        super(id);
        this.innerNode = innerNode;
    }

    @Override
    public String getDisplayName() {
        return NegateNode.class.getSimpleName();
    }
}