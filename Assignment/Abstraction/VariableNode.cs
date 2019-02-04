namespace Assignment.Abstraction
{
    internal struct VariableNode: INode
    {
        public VariableNode(string value)
        {
            this.Value = value;
        }

        public string Value { get; }
    }
}
