namespace Assignment.Abstraction
{
    internal struct StatementNode: INode
    {
        public StatementNode(INode node)
        {
            this.InnerNode = node;
        }

        public INode InnerNode { get; }
    }
}
