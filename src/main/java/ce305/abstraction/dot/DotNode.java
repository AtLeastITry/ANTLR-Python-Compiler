package ce305.abstraction.dot;

import java.util.UUID;

public class DotNode {
    public final String lable;
    public final UUID id;

    public DotNode(String label) {
        this.lable = label;
        this.id = UUID.randomUUID();
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