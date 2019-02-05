using Assignment.Abstraction;
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
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} =";
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