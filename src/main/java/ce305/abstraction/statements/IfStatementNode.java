package ce305.abstraction.statements;

import java.util.Collection;
import java.util.UUID;

import ce305.abstraction.INode;

public class IfStatementNode extends INode {
    public final Collection<INode> body;
    public final INode child;
    public final INode expression;

    public IfStatementNode(Collection<INode> body, INode expression, INode child) {
        super();
        this.body = body;
        this.child = child;
        this.expression = expression;
    }

    public IfStatementNode(Collection<INode> body, INode expression, INode child, UUID id) {
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