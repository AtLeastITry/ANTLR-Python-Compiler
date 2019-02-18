﻿namespace Assignment.Abstraction.Expressions
{
    internal struct NegateNode: INode
    {
        public NegateNode(INode innerNode)
        {
            this.InnerNode = innerNode;
        }

        public INode InnerNode { get; }

        public string DisplayName()
        {
            return nameof(NegateNode);
        }
    }
}