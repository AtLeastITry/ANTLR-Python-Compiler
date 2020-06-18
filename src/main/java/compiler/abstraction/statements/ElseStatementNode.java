package compiler.abstraction.statements;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import compiler.abstraction.INode;

public class ElseStatementNode extends INode {
    public final List<INode> body;

    public ElseStatementNode(List<INode> body) {
        super();
        this.body = body;
    }

    public ElseStatementNode(List<INode> body, UUID id) {
        super(id);
        this.body = body;
    }

    @Override
    public String getDisplayName() {
        return ElseStatementNode.class.getSimpleName();
    }
}