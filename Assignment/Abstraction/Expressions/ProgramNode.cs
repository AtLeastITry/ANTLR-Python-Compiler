using System;
using System.Collections.Generic;

namespace Assignment.Abstraction.Expressions
{
    internal class ProgramNode: INode
    {
        public ProgramNode()
        {
            this.Children = new List<INode>();
        }

        public List<INode> Children { get; }

        public string DisplayName()
        {
            return nameof(ProgramNode);
        }
    }
}
