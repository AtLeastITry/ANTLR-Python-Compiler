package ce305.abstraction.statements;

import java.util.List;

import ce305.abstraction.INode;

public class ElseIfStatementNode implements INode {
    public final List<INode> body;
    public final INode child;
    public final INode expression;

    public ElseIfStatementNode(List<INode> body, INode expression, INode child) {
        super();
        this.body = body;
        this.child = child;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return ElseIfStatementNode.class.getName();
    }
}