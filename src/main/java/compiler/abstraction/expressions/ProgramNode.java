package compiler.abstraction.expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import compiler.abstraction.INode;

public class ProgramNode extends INode {
    public final List<INode> children;

    public ProgramNode() {
        super();
        this.children = new ArrayList<INode>();
    }

    public ProgramNode(UUID id) {
        super(id);
        this.children = new ArrayList<INode>();
    }

    public ProgramNode(List<INode> children) {
        super();
        this.children = children;
    }

    public ProgramNode(List<INode> children, UUID id) {
        super(id);
        this.children = children;
    }

    @Override
    public String getDisplayName() {
        return ProgramNode.class.getSimpleName();
    }
}