namespace Assignment.Abstraction
{
    internal class Symbol
    {
        public Symbol(string name, DataTypes type)
        {
            this.Name = name;
            this.Type = type;
        }

        public string Name { get; }
        public DataTypes Type { get; }
        public uint Scope { get; set; }
    }
}
