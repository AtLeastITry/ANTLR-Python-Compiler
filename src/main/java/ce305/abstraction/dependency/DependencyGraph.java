package ce305.abstraction.dependency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ce305.abstraction.INode;
import ce305.utils.Console;

public final class DependencyGraph {
    private final Map<Dependency, Set<Dependency>> _dependencies;

    public DependencyGraph() {
        _dependencies = new HashMap<>();
    }

    public static Dependency buildDependency(INode node) {
        return new Dependency(node.id, node.getDisplayName());
    }

    public boolean containsCycle(Dependency a, Dependency b) {
        Console.writeLine("a: " + a.toString());
        Console.writeLine("b: " + b.toString());

        return this.containsDependancy(a, b) && this.containsDependancy(b, a);
    }

    public boolean containsDependancy(Dependency parent, Dependency dependency) {
        if (!_dependencies.containsKey(parent)) {
            return false;
        }
        Set<Dependency> dependencies = _dependencies.get(parent);

        if (dependencies.stream().anyMatch(d -> d.equals(dependency))) {
            return true;
        }

        for (Dependency temp : dependencies) {
            if (this.containsDependancy(temp, dependency)) {
                return true;
            }
        }

        return false;
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

    public String buildGraph() {
        StringBuilder sb = new StringBuilder();

        sb.append("digraph g {\r\n\trankdir=LR");
        Set<Map.Entry<Dependency, Set<Dependency>>> entries = this._dependencies.entrySet();
        for (Map.Entry<Dependency, Set<Dependency>> entry : entries) {
            for (Dependency dependency : entry.getValue()) {
                sb.append("\r\n\t\t");
                sb.append(String.format("\"%s\"", entry.getKey().toString()));
                sb.append(" -> ");
                sb.append(String.format("\"%s\"", dependency.toString()));
            }
            
        }

        sb.append("\r\n}");

        return sb.toString();
    }
}