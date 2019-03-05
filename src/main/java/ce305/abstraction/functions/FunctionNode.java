package ce305.abstraction.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;
import ce305.abstraction.statements.FunctionReturnStatementNode;

public class FunctionNode extends INode {
    public DataType dataType;
    public String name;    
    public Collection<INode> body;
    public List<FunctionParamNode> params;

    public FunctionNode(DataType dataType, String name, Collection<INode> body, List<FunctionParamNode> params) {
        super();
        this.dataType = dataType;
        this.name = name;
        ArrayList<INode> newBody = new ArrayList<>();

        for (INode node : body) {
            if (node instanceof FunctionReturnStatementNode) {
                newBody.add(new FunctionReturnStatementNode(((FunctionReturnStatementNode)node).expression, this));
            }
            else {
                newBody.add(node);
            }
        }

        this.body = newBody;
        this.params = params;
    }

    public FunctionNode(DataType dataType, String name, Collection<INode> body, List<FunctionParamNode> params, UUID id) {
        super(id);
        this.dataType = dataType;
        this.name = name;
        ArrayList<INode> newBody = new ArrayList<>();

        for (INode node : body) {
            if (node instanceof FunctionReturnStatementNode) {
                newBody.add(new FunctionReturnStatementNode(((FunctionReturnStatementNode)node).expression, this));
            }
            else {
                newBody.add(node);
            }
        }

        this.body = newBody;
        this.params = params;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s type: %s)", FunctionNode.class.getSimpleName(), this.name, this.dataType);
    }
}