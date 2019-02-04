namespace Assignment.Abstraction
{
    internal struct MultiplicationNode : IInfixNode
    {
        public MultiplicationNode(INode left, INode right)
        {
            this.Left = left;
            this.Right = right;
        }

        public INode Left { get; }
        public INode Right { get; }
    }
}
