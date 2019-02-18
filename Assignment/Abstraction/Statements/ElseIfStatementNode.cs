using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal struct ElseIfStatementNode : IBooleanStatementNode
    {
        public ElseIfStatementNode(IEnumerable<INode> body, INode expression)
        {
            this.Body = body;
            this.Expression = expression;
        }

        public IEnumerable<INode> Body { get; }
        public INode Expression { get; }

        public string DisplayName()
        {
            return nameof(ElseIfStatementNode);
        }
    }
}
