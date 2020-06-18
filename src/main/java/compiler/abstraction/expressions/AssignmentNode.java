package compiler.abstraction.expressions;

import java.util.UUID;

import compiler.abstraction.AssignmentOperation;
import compiler.abstraction.INode;

public class AssignmentNode extends INode {
    public final INode left;
    public final INode right;
    public final AssignmentOperation operation;

    public AssignmentNode(INode left, INode right, AssignmentOperation operation) {
        super();
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public AssignmentNode(INode left, INode right, AssignmentOperation operation, UUID id) {
        super(id);
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(operation:%s)", AssignmentNode.class.getSimpleName(), this.operation.toString());
    }
}