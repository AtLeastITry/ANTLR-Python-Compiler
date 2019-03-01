package ce305.abstraction.functions;

import ce305.abstraction.INode;

public class FunctionCallParamNode implements INode {
    public INode expression;

    public FunctionCallParamNode(INode expression) {
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return FunctionCallParamNode.class.getSimpleName();
    }
}