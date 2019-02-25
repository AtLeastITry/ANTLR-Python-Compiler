package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class VariableNode implements INode {
    public final String value;

    public VariableNode(String value) {
        super();
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%(value: %)", ValueNode.class.getName(), this.value);
    }
}