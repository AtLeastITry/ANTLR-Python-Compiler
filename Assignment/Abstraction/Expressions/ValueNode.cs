namespace Assignment.Abstraction.Expressions
{
    internal struct ValueNode: INode
    {
        public ValueNode(object value)
        {
            this.Value = value;
        }

        public object Value { get; }

        public string DisplayName()
        {
            return $"{nameof(ValueNode)}(value: {this.Value})";
        }
    }
}
