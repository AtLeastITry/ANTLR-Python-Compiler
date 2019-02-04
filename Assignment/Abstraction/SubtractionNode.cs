namespace Assignment.Abstraction
{
    internal struct SubtractionNode : IInfixNode
    {
        public SubtractionNode(INode left, INode right)
        {
            this.Left = left;
            this.Right = right;
        }

        public INode Left { get; }
        public INode Right { get; }
    }
}
