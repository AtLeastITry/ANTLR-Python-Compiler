package ce305.abstraction;

import java.util.UUID;

public abstract class INode {

    public INode(UUID id) {
        this.id = id;
    }

    public INode() {
        this.id = UUID.randomUUID();
    }

    public UUID id;
    public abstract String getDisplayName();
}