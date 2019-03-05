package ce305.abstraction.utils;

import java.util.UUID;

public class Scope {
    public final UUID id;
    public final ScopeType type;

    public Scope(UUID id, ScopeType type) {
        super();
        this.id = id;
        this.type = type;
    }
}