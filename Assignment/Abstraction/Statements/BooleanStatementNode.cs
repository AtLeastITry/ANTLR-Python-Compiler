using System.Collections.Generic;

namespace Assignment.Abstraction.Statements
{
    internal interface IBooleanStatementNode : INode
    {
        IEnumerable<INode> Body { get; }
    }
}
