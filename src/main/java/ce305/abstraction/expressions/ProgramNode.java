package ce305.abstraction.expressions;

import java.util.ArrayList;
import java.util.List;

import ce305.abstraction.INode;

public class ProgramNode implements INode {
    public final List<INode> children;

    public ProgramNode() {
        super();
        this.children = new ArrayList<INode>();
    }

    public ProgramNode(List<INode> children) {
        super();
        this.children = children;
    }

    @Override
    public String getDisplayName() {
        return ProgramNode.class.getSimpleName();
    }
}