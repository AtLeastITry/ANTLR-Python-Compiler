package ce305.abstraction.expressions;

import java.util.List;
import java.util.UUID;

import ce305.abstraction.INode;
import ce305.abstraction.functions.FunctionCallParamNode;

public class FunctionCallNode extends INode {
    public String name;
    public List<FunctionCallParamNode> params;

    public FunctionCallNode(String name, List<FunctionCallParamNode> params) {
        super();
        this.name = name;
        this.params = params;
    }

    public FunctionCallNode(String name, List<FunctionCallParamNode> params, UUID id) {
        super(id);
        this.name = name;
        this.params = params;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s)", FunctionCallNode.class.getSimpleName(), this.name);
    }
}