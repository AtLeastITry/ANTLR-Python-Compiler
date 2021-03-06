package compiler.abstraction.statements;

import java.util.UUID;

import compiler.abstraction.INode;
import compiler.abstraction.functions.FunctionNode;

public class FunctionReturnStatementNode extends INode {
    public FunctionNode parent;
    public INode expression;

    public FunctionReturnStatementNode(INode expression) {
        super();
        this.parent = null;
        this.expression = expression;
    }

    public FunctionReturnStatementNode(INode expression, UUID id) {
        super(id);
        this.parent = null;
        this.expression = expression;
    }

    public FunctionReturnStatementNode(INode expression, FunctionNode parent) {
        super();
        this.expression = expression;
        this.parent = parent;
    }

    public FunctionReturnStatementNode(INode expression, FunctionNode parent, UUID id) {
        super(id);
        this.expression = expression;
        this.parent = parent;
    }
    

    @Override
    public String getDisplayName() {
        return FunctionReturnStatementNode.class.getSimpleName();
    }
}