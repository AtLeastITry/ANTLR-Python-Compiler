package ce305.abstraction.expressions;

import java.util.UUID;

import ce305.abstraction.INode;

public class AssignmentNode extends INode {
    public final INode left;
    public final INode right;

    public AssignmentNode(INode left, INode right) {
        super();
        this.left = left;
        this.right = right;
    }

    public AssignmentNode(INode left, INode right, UUID id) {
        super(id);
        this.left = left;
        this.right = right;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s left(%s) right(%s)", AssignmentNode.class.getSimpleName(), this.left.getDisplayName(), this.right.getDisplayName());
    }
}