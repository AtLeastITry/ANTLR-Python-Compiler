using Assignment.Abstraction;
using Assignment.Extensions;
using System;
using System.Text;

namespace Assignment.Implementation
{
    internal class PostFixVisitor : IASTVisitor<string>
    {
        public string Visit(ProgramNode node)
        {
            var sb = new StringBuilder();

            foreach(var line in node.Children)
            {
                if (line != null)
                    sb.Append($"{this.Visit(line)}{Environment.NewLine}");
            }

            return sb.ToString();
        }

        private bool ContainsVariable(INode tree, VariableNode variableNode)
        {
            if (tree.GetType() == typeof(VariableNode))
            {
                return ((VariableNode)tree).Value == variableNode.Value;
            }

            if (tree.GetType() == typeof(ExpressionNode))
            {
                return this.ContainsVariable(((ExpressionNode)tree).Left, variableNode) || this.ContainsVariable(((ExpressionNode)tree).Right, variableNode);
            }

            return false;
        }

        public string Visit(ExpressionNode node)
        {
            switch(node.Operation)
            {
                case Operations.ADDITION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} +";
                case Operations.SUBTRACTION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} -";
                case Operations.MULTIPLICATION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} *";
                case Operations.DIVISION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} /";
                case Operations.ASSIGNMENT:
                    if (node.Right.GetType() == typeof(ExpressionNode))
                    {
                        if (this.ContainsVariable(node.Right, (VariableNode)node.Left))
                        {
                            var exprRight = (ExpressionNode)node.Right;

                            if (exprRight.Left.GetType() == typeof(ValueNode))
                            {
                                return $"{this.Visit(exprRight.Left)} {this.Visit(node.Left)} {exprRight.Operation.GetDisplayName()}!";
                            }

                            if (exprRight.Right.GetType() == typeof(ValueNode))
                            {
                                return $"{this.Visit(exprRight.Right)} {this.Visit(node.Left)} {exprRight.Operation.GetDisplayName()}!";
                            }
                        }
                    }

                    return $"{this.Visit(node.Right)} {this.Visit(node.Left)} !";
                case Operations.POWER:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} ^";
                default:
                    return "";
            }
        }

        public string Visit(NegateNode node)
        {
            return $"-{this.Visit(node.InnerNode)}";
        }

        public string Visit(FunctionNode node)
        {
            return $"{node.Function}({this.Visit(node.Argument)})";
        }

        public string Visit(ValueNode node)
        {
            return node.Value.ToString();
        }

        public string Visit(VariableNode node)
        {
            return node.Value;
        }

        public string Visit(DeclarationNode node)
        {
            return $"VARIABLE {node.Name}";
        }

        public string Visit(INode node)
        {
            return this.Visit((dynamic)node);
        }
    }
}