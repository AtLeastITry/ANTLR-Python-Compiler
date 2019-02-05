namespace Assignment.Abstraction
{
    internal struct ExpressionNode : IInfixNode
    {
        public ExpressionNode(INode left, INode right, Operations operation)
        {
            this.Left = left;
            this.Right = right;
            this.Operation = operation;
        }

        public Operations Operation { get; }
        public INode Left { get; }
        public INode Right { get; }
    }
}
