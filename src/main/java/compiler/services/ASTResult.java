package compiler.services;

import compiler.abstraction.INode;
import compiler.abstraction.dependency.DependencyGraph;

public class ASTResult {
    public INode tree;
    public DependencyGraph dependencyGraph;

    public ASTResult(INode tree, DependencyGraph dependencyGraph) {
        this.tree = tree;
        this.dependencyGraph = dependencyGraph;
    }
}