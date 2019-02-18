using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;

namespace Assignment.Implementation.Visitors
{
    internal class SemanticAnalyser
    {
        public void Visit(ProgramNode node, string tempIndent)
        {
            foreach(var child in node.Children)
            {
                this.Visit(child);
            }
        }

        public void Visit(BinaryExpressionNode node, string tempIndent)
        {
            this.Visit(node.Left);
            this.Visit(node.Right);
        }

        public void Visit(AssignmentNode node, string tempIndent)
        {
        }

        public void Visit(NegateNode node, string tempIndent)
        {
        }

        public void Visit(FunctionNode node, string tempIndent)
        {
        }

        public void Visit(ValueNode node, string tempIndent)
        {
        }

        public void Visit(VariableNode node, string tempIndent)
        {
        }

        public void Visit(DeclarationNode node, string tempIndent)
        {
        }

        public void Visit(IfStatementNode node, string tempIndent)
        {
        }

        public void Visit(ElseStatementNode node, string tempIndent)
        {
        }

        public void Visit(ElseIfStatementNode node, string tempIndent)
        {
        }

        public void Visit(BooleanExpressionNode node, string tempIndent)
        {
        }

        public void Visit(INode node, string tempIndent = "")
        {
            return this.Visit((dynamic)node, tempIndent);
        }
    }
}
