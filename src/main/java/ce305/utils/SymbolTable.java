package ce305.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

import ce305.abstraction.DataType;
import ce305.abstraction.INode;
import ce305.abstraction.functions.FunctionNode;
import ce305.abstraction.functions.FunctionParamNode;
import ce305.abstraction.utils.Scope;
import ce305.abstraction.utils.ScopeType;
import ce305.abstraction.utils.Symbol;

public class SymbolTable {
    public SymbolTable parent;
    public Scope scope;
    private Hashtable<String, Symbol> _table = new Hashtable<>();

    public SymbolTable(ScopeType type)
    {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = null;

        if (type == ScopeType.Program) {
            
            ArrayList<FunctionParamNode> intPrintParams = new ArrayList<FunctionParamNode>();
            intPrintParams.add(new FunctionParamNode("a", DataType.INTEGER));
            FunctionNode intPrint = new FunctionNode(DataType.INTEGER, "print", new ArrayList<INode>(), intPrintParams);

            ArrayList<FunctionParamNode> floatPrintParams = new ArrayList<FunctionParamNode>();
            floatPrintParams.add(new FunctionParamNode("a", DataType.FLOAT));
            FunctionNode floatPrint = new FunctionNode(DataType.FLOAT, "print", new ArrayList<INode>(), floatPrintParams);

            ArrayList<FunctionParamNode> boolPrintParams = new ArrayList<FunctionParamNode>();
            boolPrintParams.add(new FunctionParamNode("a", DataType.BOOL));
            FunctionNode boolPrint = new FunctionNode(DataType.BOOL, "print", new ArrayList<INode>(), boolPrintParams);

            this.add(new Symbol(new FunctionNameDefinition(intPrint).toString(), DataType.INTEGER, intPrint.params));
            this.add(new Symbol(new FunctionNameDefinition(floatPrint).toString(), DataType.FLOAT, floatPrint.params));
            this.add(new Symbol(new FunctionNameDefinition(boolPrint).toString(), DataType.BOOL, boolPrint.params));
        }
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

    public SymbolTable(SymbolTable parent, ScopeType type)
    {
        this.scope = new Scope(UUID.randomUUID(), type);
        this.parent = parent;
    }

    public void add(Symbol symbol) {
        symbol.scope = this.scope;
        _table.put(symbol.name, symbol);
    }

    public boolean containsDeclaration(String name) {
        if (_table.containsKey(name)) {
            return true;
        }

        if (this.scope.type != ScopeType.Function && this.parent != null) {
            return this.parent.containsDeclaration(name);
        }

        return false;
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