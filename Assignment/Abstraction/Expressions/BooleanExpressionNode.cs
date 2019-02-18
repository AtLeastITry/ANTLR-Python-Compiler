using Assignment.Extensions;
using System;

namespace Assignment.Abstraction.Expressions
{
    internal struct BooleanExpressionNode : IExpressionNode
    {
        public BooleanExpressionNode(INode left, INode right, BooleanOperations operation)
        {
            this.Operation = operation;
            this.Left = left;
            this.Right = right;
        }

        public BooleanOperations Operation { get; }
        public INode Left { get; }
        public INode Right { get; }

        public string DisplayName()
        {
            return $"{nameof(BooleanExpressionNode)}(operation: {this.Operation.GetDisplayName()})";
        }
    }
}
