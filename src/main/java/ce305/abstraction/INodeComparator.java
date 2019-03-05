package ce305.abstraction;

import java.util.Comparator;

import ce305.abstraction.dependency.DependencyGraph;

public class INodeComparator implements Comparator<INode> {
    private final DependencyGraph _dependencyGraph;

    public INodeComparator(DependencyGraph dependencyGraph) {
        _dependencyGraph = dependencyGraph;
    }


    @Override
    public int compare(INode a, INode b) {
        if (_dependencyGraph.containsCycle(a, b)) {
            throw new RuntimeException("Dependency cycle detected");
        }

        if (_dependencyGraph.containsDependancy(a, b)) {
            return 1;
        }

        if (_dependencyGraph.containsDependancy(b, a)) {
            return -1;
        }

        return 0;
    }

}