package compiler.abstraction.dependency;

import java.util.Hashtable;
import java.util.UUID;

import compiler.abstraction.expressions.DeclarationNode;
import compiler.abstraction.functions.FunctionNode;
import compiler.abstraction.utils.Scope;
import compiler.abstraction.utils.ScopeType;

public class DependencyTable {
    public DependencyTable parent;
    public Scope scope;
    private Hashtable<String, FunctionNode> _functions = new Hashtable<>();
    private Hashtable<String, DeclarationNode> _variables = new Hashtable<>();

    public DependencyTable(ScopeType type)
    {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = null;
    }

    public DependencyTable(Scope scope)
    {
        this.scope = scope;
    }

    public DependencyTable(Scope scope, DependencyTable parent)
    {
        this.scope = scope;
        this.parent = parent;
    }

    public DependencyTable(DependencyTable parent, ScopeType type)
    {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = parent;
    }

    public void add(FunctionNode dependency) {
        _functions.put(dependency.id.toString(), dependency);
    }


    public void add(DeclarationNode dependency) {
        _variables.put(dependency.id.toString(), dependency);
    }

    public boolean contains(FunctionNode dependency) {
        if (_functions.containsKey(dependency.id.toString())) {
            return true;
        }

        if (this.parent != null) {
            return this.parent.contains(dependency);
        }

        return false;
    }

    public boolean contains(DeclarationNode dependency) {
        if (_variables.containsKey(dependency.id.toString())) {
            return true;
        }

        if (this.parent != null) {
            return this.parent.contains(dependency);
        }

        return false;
    }

    public FunctionNode get(FunctionNode dependency) {
        if (_functions.containsKey(dependency.id.toString())) {
            return _functions.get(dependency.id.toString());
        }

        if (this.parent != null && this.parent.contains(dependency)) {
            return this.parent.get(dependency);
        }

        return null;
    }

    public DeclarationNode get(DeclarationNode dependency) {
        if (_variables.containsKey(dependency.id.toString())) {
            return _variables.get(dependency.id.toString());
        }

        if (this.parent != null && this.parent.contains(dependency)) {
            return this.parent.get(dependency);
        }

        return null;
    }
}