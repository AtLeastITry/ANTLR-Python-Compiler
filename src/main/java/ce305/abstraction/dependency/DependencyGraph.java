package ce305.abstraction.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import ce305.abstraction.INode;

public final class DependencyGraph {
    public final Map<Dependency, Set<Dependency>> _dependencies;

    public DependencyGraph() {
        _dependencies = new HashMap<>();
    }

    private Dependency buildDependency(INode node) {
        return new Dependency(node.id, node.getDisplayName());
    }

    public boolean containsCycle(INode a, INode b) {
        return this.containsDependancy(a, b) && this.containsDependancy(b, a);
    }

    public boolean containsDependancy(INode parent, INode dependency) {
        Dependency parentDependency = buildDependency(parent);
        if (!_dependencies.containsKey(parentDependency)) {
            return false;
        }

        return _dependencies.get(parentDependency).contains(buildDependency(dependency));
    }

    public void addDependancy(INode parent, INode dependency) {
        Dependency parentDependency = buildDependency(parent);

        if (_dependencies.containsKey(parentDependency)) {
            _dependencies.get(parentDependency).add(buildDependency(dependency));
        }
        else {
            Set<Dependency> scopedDependencies = new HashSet<>();
            scopedDependencies.add(buildDependency(dependency));
            _dependencies.put(parentDependency, scopedDependencies);
        }
    }
}