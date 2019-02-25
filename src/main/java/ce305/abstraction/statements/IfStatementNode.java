package ce305.abstraction.statements;

import java.util.Collection;

import ce305.abstraction.INode;

public class IfStatementNode implements INode {
    public final Collection<INode> body;
    public final INode child;
    public final INode expression;

    public IfStatementNode(Collection<INode> body, INode child, INode expression) {
        super();
        this.body = body;
        this.child = child;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return IfStatementNode.class.getName();
    }
}