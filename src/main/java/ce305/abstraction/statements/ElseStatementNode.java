package ce305.abstraction.statements;

import java.util.Collection;
import java.util.UUID;

import ce305.abstraction.INode;

public class ElseStatementNode extends INode {
    public final Collection<INode> body;

    public ElseStatementNode(Collection<INode> body) {
        super();
        this.body = body;
    }

    public ElseStatementNode(Collection<INode> body, UUID id) {
        super(id);
        this.body = body;
    }

    @Override
    public String getDisplayName() {
        return ElseStatementNode.class.getSimpleName();
    }
}