package ce305.abstraction.functions;

import java.util.UUID;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;

public class FunctionParamNode extends INode {
    public final String name;
    public final DataType dataType;

    public FunctionParamNode(String name, DataType dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    public FunctionParamNode(String name, DataType dataType, UUID id) {
        super(id);
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s, type: %s)", FunctionParamNode.class.getSimpleName(), this.name, this.dataType);
    }
}