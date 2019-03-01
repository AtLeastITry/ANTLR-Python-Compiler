package ce305.abstraction.expressions;

import ce305.abstraction.INode;

public class ValueNode implements INode {
    public final Object value;

    public ValueNode(Object value) {
        super();
        this.value = value;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(value: %s)", ValueNode.class.getSimpleName(), this.value);
    }
}