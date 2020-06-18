package compiler.abstraction.expressions;

import java.util.UUID;

import compiler.abstraction.INode;

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