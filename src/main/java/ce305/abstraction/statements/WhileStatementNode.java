package ce305.abstraction.statements;

import java.util.Collection;

import ce305.abstraction.INode;

public class WhileStatementNode implements INode {
    public final Collection<INode> body;
    public final INode expression;

    public WhileStatementNode(Collection<INode> body, INode expression) {
        super();
        this.body = body;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return WhileStatementNode.class.getSimpleName();
    }
}