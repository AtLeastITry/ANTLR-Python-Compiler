package ce305.abstraction.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import ce305.abstraction.INode;

public final class DependencyGraph {
    private final Map<UUID, Set<UUID>> _dependencies;

    public DependencyGraph() {
        _dependencies = new HashMap<>();
    }

    public boolean containsCycle(INode a, INode b) {
        return this.containsDependancy(a, b) && this.containsDependancy(b, a);
    }

    public boolean containsDependancy(INode parent, INode dependency) {
        if (!_dependencies.containsKey(parent.id)) {
            return false;
        }

        return _dependencies.get(parent.id).contains(dependency.id);
    }

    public void addDependancy(INode parent, INode dependency) {
        if (_dependencies.containsKey(parent.id)) {
            _dependencies.get(parent.id).add(dependency.id);
        }
        else {
            Set<UUID> scopedDependencies = new HashSet<>();
            scopedDependencies.add(dependency.id);
            _dependencies.put(parent.id, scopedDependencies);
        }
    }
}