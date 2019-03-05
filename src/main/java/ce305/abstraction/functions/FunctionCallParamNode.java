package ce305.abstraction.functions;

import java.util.UUID;

import ce305.abstraction.INode;

public class FunctionCallParamNode extends INode {
    public INode expression;

    public FunctionCallParamNode(INode expression) {
        super();
        this.expression = expression;
    }

    public FunctionCallParamNode(INode expression, UUID id) {
        super(id);
        this.expression = expression;
    }

    @Override
    public String getDisplayName() {
        return FunctionCallParamNode.class.getSimpleName();
    }
}