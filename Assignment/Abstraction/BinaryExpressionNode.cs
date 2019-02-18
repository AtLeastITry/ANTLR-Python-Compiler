namespace Assignment.Abstraction
{
    internal struct BinaryExpressionNode : IExpressionNode
    {
        public BinaryExpressionNode(INode left, INode right, Operations operation)
        {
            this.Left = left;
            this.Right = right;
            this.Operation = operation;
        }

        public Operations Operation { get; }
        public INode Left { get; }
        public INode Right { get; }

        public string DisplayName()
        {
            return $"{nameof(BinaryExpressionNode)}(operation: {this.Operation})";
        }
    }
}
