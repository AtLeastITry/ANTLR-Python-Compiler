package ce305.abstraction.expressions;

import java.util.UUID;

import ce305.abstraction.INode;

public class VariableNode extends INode {
    public final String value;

    public VariableNode(String value) {
        super();
        this.value = value;
    }

    public VariableNode(String value, UUID id) {
        super(id);
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(value: %s)", VariableNode.class.getSimpleName(), this.value);
    }
}