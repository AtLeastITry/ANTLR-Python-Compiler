namespace Assignment.Abstraction
{
    internal struct VariableNode: INode
    {
        public VariableNode(string value)
        {
            this.Value = value;
        }

        public string Value { get; }

        public string DisplayName()
        {
            return $"{nameof(VariableNode)}(value: {this.Value})";
        }
    }
}
