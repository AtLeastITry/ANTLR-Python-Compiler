package ce305.abstraction.functions;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;

public class FunctionParamNode implements INode {
    public final String name;
    public final DataType dataType;

    public FunctionParamNode(String name, DataType dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s)", FunctionParamNode.class.getName(), this.name);
    }
}