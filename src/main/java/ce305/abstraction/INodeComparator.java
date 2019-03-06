package ce305.abstraction;

import java.util.Comparator;

import ce305.abstraction.dependency.Dependency;
import ce305.abstraction.dependency.DependencyGraph;

public class INodeComparator implements Comparator<INode> {
    private final DependencyGraph _dependencyGraph;

    public INodeComparator(DependencyGraph dependencyGraph) {
        _dependencyGraph = dependencyGraph;
    }


    @Override
    public int compare(INode a, INode b) {
        Dependency aDependency = DependencyGraph.buildDependency(a);
        Dependency bDependency = DependencyGraph.buildDependency(b);

        if (_dependencyGraph.containsCycle(aDependency, bDependency)) {
            throw new RuntimeException("Dependency cycle detected");
        }

        if (_dependencyGraph.containsDependancy(aDependency, bDependency)) {
            return 1;
        }

        if (_dependencyGraph.containsDependancy(bDependency, aDependency)) {
            return -1;
        }

        return 0;
    }

}