package compiler.abstraction.dot;

import java.util.UUID;

import compiler.abstraction.INode;

public class DotNode {
    public final String lable;
    public final UUID id;

    public DotNode(INode node) {
        this.lable = node.getDisplayName();
        this.id = node.id;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((DotNode)obj).id);
    }
}