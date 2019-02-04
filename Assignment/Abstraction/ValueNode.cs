namespace Assignment.Abstraction
{
    internal struct ValueNode: INode
    {
        public ValueNode(object value)
        {
            this.Value = value;
        }

        public object Value { get; }
    }
}
