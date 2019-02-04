namespace Assignment.Abstraction
{
    internal struct DivisionNode : IInfixNode
    {
        public DivisionNode(INode left, INode right)
        {
            this.Left = left;
            this.Right = right;
        }

        public INode Left { get; }
        public INode Right { get; }
    }
}
