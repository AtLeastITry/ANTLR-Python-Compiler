using System;

namespace Assignment.Abstraction
{
    internal struct FunctionNode: INode
    {
        public FunctionNode(string function, INode argument)
        {
            this.Function = function;
            this.Argument = argument;
        }

        public string Function { get; }
        public INode Argument { get; }

        public string DisplayName()
        {
            return nameof(FunctionNode);
        }
    }
}
