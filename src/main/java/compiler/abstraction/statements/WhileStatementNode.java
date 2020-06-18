package compiler.abstraction.statements;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import compiler.abstraction.INode;

public class WhileStatementNode extends INode {
    public final List<INode> body;
    public final INode expression;

    public WhileStatementNode(List<INode> body, INode expression) {
        super();
        this.body = body;
        this.expression = expression;
    }

    public WhileStatementNode(List<INode> body, INode expression, UUID id) {
        super(id);
        this.body = body;
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return WhileStatementNode.class.getSimpleName();
    }
}