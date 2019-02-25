package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class AssignmentNode implements INode {
    public final INode left;
    public final INode right;

    public AssignmentNode(INode left, INode right) {
        super();
        this.left = left;
        this.right = right;
    }

    @Override
    public String getDisplayName() {
        return AssignmentNode.class.getName();
    }
}