package ce305.abstraction.statements;

import ce305.abstraction.INode;
import ce305.abstraction.functions.FunctionNode;

public class FunctionReturnStatementNode implements INode {
    public FunctionNode parent;
    public INode expression;

    public FunctionReturnStatementNode(INode expression) {
        this.parent = null;
        this.expression = expression;
    }

    public FunctionReturnStatementNode(INode expression, FunctionNode parent) {
        this.expression = expression;
        this.parent = parent;
    }

    @Override
    public String getDisplayName() {
        return FunctionReturnStatementNode.class.getSimpleName();
    }
}