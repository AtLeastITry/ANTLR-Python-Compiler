using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal struct IfStatementNode : IBooleanStatementNode
    {
        public IfStatementNode(IEnumerable<INode> body, INode expression, INode child)
        {
            this.Body = body;
            this.Expression = expression;
            this.Child = child;
        }

        public IEnumerable<INode> Body { get; }
        public INode Expression { get; }
        public INode Child { get; }

        public string DisplayName()
        {
            return nameof(IfStatementNode);
        }
    }
}
