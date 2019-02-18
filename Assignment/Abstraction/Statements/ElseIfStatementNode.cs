using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal struct ElseIfStatementNode : IBooleanStatementNode
    {
        public ElseIfStatementNode(IEnumerable<INode> body, INode expression, INode child)
        {
            this.Body = body;
            this.Expression = expression;
            this.Child = child;
        }

        public IEnumerable<INode> Body { get; }
        public INode Child { get; }
        public INode Expression { get; }

        public string DisplayName()
        {
            return nameof(ElseIfStatementNode);
        }
    }
}
