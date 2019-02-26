package ce305.abstraction.statements;

import ce305.abstraction.INode;

public class FunctionReturnStatementNode implements INode {
    public INode expression;

    public FunctionReturnStatementNode(INode expression) {
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return FunctionReturnStatementNode.class.getName();
    }
}