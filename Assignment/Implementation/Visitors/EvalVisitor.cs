using Assignment.Abstraction;
using System;
using System.Collections.Generic;

namespace Assignment.Implementation
{
    internal class EvalVisitor : IASTVisitor<decimal>
    {
        private static Dictionary<string, decimal> _tempMemory = new Dictionary<string, decimal>();

        public static void ClearMemory()
        {
            _tempMemory.Clear();
        }

        public decimal Visit(ProgramNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(AdditionNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(SubtractionNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(MultiplicationNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(DivisionNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(NegateNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(FunctionNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(ValueNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(VariableNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(AssignmentNode node)
        {
            throw new NotImplementedException();
        }

        public decimal Visit(INode node)
        {
            return this.Visit((dynamic)node);
        }

        public decimal Visit(DeclarationNode node)
        {
            throw new NotImplementedException();
        }
    }
}
