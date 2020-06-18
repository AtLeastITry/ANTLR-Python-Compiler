package compiler.abstraction.expressions;

import java.util.UUID;

import compiler.abstraction.DataType;
import compiler.abstraction.INode;

public class DeclarationNode extends INode {
    public final String name;
    public final DataType dataType;

    public DeclarationNode(String name, DataType dataType) {
        super();
        this.name = name;
        this.dataType = dataType;
    }

    public DeclarationNode(String name, DataType dataType, UUID id) {
        super(id);
        this.name = name;
        this.dataType = dataType;
    }

    @Override
    public String getDisplayName() {
        return String.format("%s(name: %s, type: %s)", DeclarationNode.class.getSimpleName(), this.name, this.dataType);
    }
}