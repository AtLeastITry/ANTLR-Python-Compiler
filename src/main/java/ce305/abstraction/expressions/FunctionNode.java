package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class FunctionNode implements INode {
    public final String function;
    public final INode argument;

    public FunctionNode(String function, INode argument) {
        super();
        this.function = function;
        this.argument = argument;
    }

    @Override
    public String getDisplayName() {
        return String.format("%(name: %)", FunctionNode.class.getName(), this.function);
    }
}