namespace Assignment.Abstraction
{
    internal struct AdditionNode : IInfixNode
    {
        public AdditionNode(INode left, INode right)
        {
            this.Left = left;
            this.Right = right;
        }

        public INode Left { get; }
        public INode Right { get; }
    }
}
