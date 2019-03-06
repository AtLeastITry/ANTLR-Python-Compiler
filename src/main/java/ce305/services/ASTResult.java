package ce305.services;

import ce305.abstraction.INode;
import ce305.abstraction.dependency.DependencyGraph;

public class ASTResult {
    public INode tree;
    public DependencyGraph dependencyGraph;

    public ASTResult(INode tree, DependencyGraph dependencyGraph) {
        this.tree = tree;
        this.dependencyGraph = dependencyGraph;
    }
}