package ce305.abstraction.statements;

import java.util.Collection;

import ce305.abstraction.INode;

public class ElseStatementNode implements INode {
    public final Collection<INode> body;

    public ElseStatementNode(Collection<INode> body) {
        super();
        this.body = body;
    }

    @Override
    public String getDisplayName() {
        return ElseStatementNode.class.getSimpleName();
    }
}