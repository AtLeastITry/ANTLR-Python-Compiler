using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal struct IfStatementNode : IBooleanStatementNode
    {
        public IfStatementNode(IEnumerable<INode> body, INode expression)
        {
            this.Body = body;
            this.Expression = expression;
        }

        public IEnumerable<INode> Body { get; }
        public INode Expression { get; }

        public string DisplayName()
        {
            return nameof(IfStatementNode);
        }
    }
}
