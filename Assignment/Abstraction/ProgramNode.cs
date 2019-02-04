using System.Collections.Generic;

namespace Assignment.Abstraction
{
    internal class ProgramNode: INode
    {
        public ProgramNode()
        {
            this.Body = new List<INode>();
        }

        public List<INode> Body { get; }
    }
}
