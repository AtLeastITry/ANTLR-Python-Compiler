package ce305.abstraction.statements;

import java.util.List;
import java.util.UUID;

import ce305.abstraction.INode;

public class IfStatementNode extends INode {
    public final List<INode> body;
    public final INode child;
    public final INode expression;

    public IfStatementNode(List<INode> body, INode expression, INode child) {
        super();
        this.body = body;
        this.child = child;
        this.expression = expression;
    }

    public IfStatementNode(List<INode> body, INode expression, INode child, UUID id) {
        super(id);
        this.body = body;
        this.child = child;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return IfStatementNode.class.getSimpleName();
    }
}