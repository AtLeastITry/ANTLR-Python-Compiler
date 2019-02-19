using Assignment.Abstraction;
using Assignment.Abstraction.Utils;
using Assignment.Implementation.Errors;
using System;
using System.Collections;

namespace Assignment.Implementation.Utils
{
    internal class SymbolTable
    {
        public SymbolTable Parent { get; }
        public Scope Scope { get; }
        private readonly Hashtable _table = new Hashtable();

        public SymbolTable()
        {
            this.Scope = new Scope(Guid.NewGuid());
            this.Parent = null;
        }

        public SymbolTable(Scope scope)
        {
            this.Scope = scope;
        }

        public SymbolTable(Scope scope, SymbolTable parent)
        {
            this.Scope = scope;
            this.Parent = parent;
        }

        public SymbolTable(SymbolTable parent)
        {
            this.Scope = new Scope(Guid.NewGuid());
            this.Parent = parent;
        }

        public void Add(Symbol symbol)
        {
            symbol.Scope = this.Scope;
            _table.Add(symbol.Name, symbol);
        }

        public bool Contains(string name)
        {
            if (_table.ContainsKey(name))
                return true;

            if (this.Parent != null)
                return this.Parent.Contains(name);

            return false;
        }

        public bool TryGet(string name, out Symbol symbol)
        {
            if (_table.ContainsKey(name))
            {
                symbol = (Symbol)_table[name];
                return true;
            }

            if (this.Parent != null)
            {
                return this.Parent.TryGet(name, out symbol);
            }

            symbol = default(Symbol);
            return false;
        }
    }
}
