namespace Assignment.Abstraction.Expressions
{
    internal struct DeclarationNode: INode
    {
        public DeclarationNode(string name, DataTypes dataType)
        {
            this.Name = name;
            this.DataType = dataType;
        }

        public string Name { get; }
        public DataTypes DataType { get; }

        public string DisplayName()
        {
            return $"{nameof(DeclarationNode)}(name: {this.Name})";
        }
    }
}
