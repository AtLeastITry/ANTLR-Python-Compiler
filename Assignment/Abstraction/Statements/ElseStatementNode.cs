using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal struct ElseStatementNode : IBooleanStatementNode
    {
        public ElseStatementNode(IEnumerable<INode> body)
        {
            this.Body = body;
        }

        public IEnumerable<INode> Body { get; }

        public string DisplayName()
        {
            return nameof(ElseStatementNode);
        }
    }
}
