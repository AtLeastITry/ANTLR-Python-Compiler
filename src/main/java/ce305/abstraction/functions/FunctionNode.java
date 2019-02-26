package ce305.abstraction.functions;

import java.util.Collection;
import java.util.List;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;

public class FunctionNode implements INode {
    public DataType dataType;
    public String name;    
    public Collection<INode> body;
    public List<FunctionParamNode> params;

    public FunctionNode(DataType dataType, String name, Collection<INode> body, List<FunctionParamNode> params) {
        this.dataType = dataType;
        this.name = name;
        this.body = body;
        this.params = params;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s type: %s)", FunctionNode.class.getName(), this.name, this.dataType);
    }
}