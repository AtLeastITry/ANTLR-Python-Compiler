using Assignment.Extensions;

namespace Assignment.Abstraction.Expressions
{
    internal struct BinaryExpressionNode : IExpressionNode
    {
        public BinaryExpressionNode(INode left, INode right, ArithmeticOperations operation)
        {
            this.Left = left;
            this.Right = right;
            this.Operation = operation;
        }

        public ArithmeticOperations Operation { get; }
        public INode Left { get; }
        public INode Right { get; }

        public string DisplayName()
        {
            return $"{nameof(BinaryExpressionNode)}(operation: {this.Operation.GetDisplayName()})";
        }
    }
}
