package ce305.abstraction.expressions;

import java.util.UUID;

import ce305.abstraction.INode;

public class ValueNode extends INode {
    public final Object value;

    public ValueNode(Object value) {
        super();
        this.value = value;
    }

    public ValueNode(Object value, UUID id) {
        super(id);
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(value: %s)", ValueNode.class.getSimpleName(), this.value);
    }
}