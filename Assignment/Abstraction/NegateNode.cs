namespace Assignment.Abstraction
{
    internal struct NegateNode: INode
    {
        public NegateNode(INode innerNode)
        {
            this.InnerNode = innerNode;
        }

        public INode InnerNode { get; }
    }
}
