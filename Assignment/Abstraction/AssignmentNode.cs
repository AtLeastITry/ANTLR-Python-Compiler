namespace Assignment.Abstraction
{
    internal struct AssignmentNode : IInfixNode
    {
        public AssignmentNode(INode left, INode right)
        {
            this.Left = left;
            this.Right = right;
        }

        public INode Left { get; }
        public INode Right { get; }
    }
}
