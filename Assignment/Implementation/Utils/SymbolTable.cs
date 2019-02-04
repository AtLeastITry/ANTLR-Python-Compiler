using Assignment.Abstraction;
using Assignment.Implementation.Errors;
using System.Collections;

namespace Assignment.Implementation.Utils
{
    internal class SymbolTable
    {
        public SymbolTable Parent { get; }
        public uint Scope { get; }
        private readonly Hashtable _table = new Hashtable();

        public SymbolTable()
        {
            this.Scope = 0;
            this.Parent = null;
        }

        public SymbolTable(uint scope)
        {
            this.Scope = scope;
        }

        public SymbolTable(uint scope, SymbolTable parent)
        {
            this.Scope = scope;
            this.Parent = parent;
        }

        public void Add(Symbol symbol)
        {
            if (_table.Contains(symbol.Name))
                throw new DuplicateDefinitionException($"\"{symbol.Name}\" already exists in the current scope");

            symbol.Scope = this.Scope;

            _table.Add(symbol.Name, symbol);
        }

        public bool Contains(string name)
        {
            return _table.ContainsKey(name);
        }

        public bool TryGet(string name, out Symbol symbol)
        {
            if (!_table.ContainsKey(name))
            {
                symbol = null;
                return false;
            }

            symbol = (Symbol)_table[name];
            return true;
        }
    }
}
