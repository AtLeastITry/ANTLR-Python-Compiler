package ce305.implementation.utils;

import java.util.Hashtable;
import java.util.UUID;

import ce305.abstraction.utils.Scope;
import ce305.abstraction.utils.Symbol;

public class SymbolTable {
    public SymbolTable parent;
    public Scope scope;
    private Hashtable<String, Symbol> _table = new Hashtable<>();

    public SymbolTable()
    {
        this.scope = new Scope(UUID.randomUUID());
        this.parent = null;
    }

    public SymbolTable(Scope scope)
    {
        this.scope = scope;
    }

    public SymbolTable(Scope scope, SymbolTable parent)
    {
        this.scope = scope;
        this.parent = parent;
    }

    public SymbolTable(SymbolTable parent)
    {
        this.scope = new Scope(UUID.randomUUID());
        this.parent = parent;
    }

    public void add(Symbol symbol) {
        symbol.scope = this.scope;
        _table.put(symbol.name, symbol);
    }

    public boolean contains(String name) {
        if (_table.containsKey(name)) {
            return true;
        }

        if (this.parent != null) {
            return this.parent.contains(name);
        }

        return false;
    }

    public Symbol get(String name) {
        if (_table.containsKey(name)) {
            return _table.get(name);
        }

        if (this.parent != null && this.parent.contains(name)) {
            return this.parent.get(name);
        }

        return null;
    }
}