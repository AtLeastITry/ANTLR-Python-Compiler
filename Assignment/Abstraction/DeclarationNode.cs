namespace Assignment.Abstraction
{
    internal struct DeclarationNode: INode
    {
        public DeclarationNode(string name)
        {
            this.Name = name;
        }

        public string Name { get; }

        public string DisplayName()
        {
            return $"{nameof(DeclarationNode)}(name: {this.Name})";
        }
    }
}
