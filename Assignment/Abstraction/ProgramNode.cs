using System.Collections.Generic;

namespace Assignment.Abstraction
{
    internal class ProgramNode: INode
    {
        public ProgramNode()
        {
            this.Children = new List<INode>();
        }

        public List<INode> Children { get; }
    }
}
