using Assignment.Abstraction;
using System;

namespace Assignment.Implementation.Visitors
{
    internal class VisualizationVisitor
    {
        private const string IndentString = "|   ";

        public string Visit(ProgramNode node, string tempIndent)
        {
            var temp = $"{tempIndent}+- {nameof(ProgramNode)}";

            tempIndent += IndentString;

            foreach(var child in node.Children)
            {
                temp += this.Visit(child, tempIndent);
            }

            return temp;
        }

        public string Visit(AdditionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(AdditionNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(SubtractionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(SubtractionNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(MultiplicationNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(MultiplicationNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(DivisionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(DivisionNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(NegateNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(NegateNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.InnerNode, tempIndent);

            return temp;
        }

        public string Visit(FunctionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(FunctionNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Argument, tempIndent);

            return temp;
        }

        public string Visit(ValueNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(ValueNode)}(value: {node.Value})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(VariableNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(VariableNode)}(value: {node.Value})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(AssignmentNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(AssignmentNode)}";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(DeclarationNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {nameof(DeclarationNode)}(name: {node.Name})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(INode node, string tempIndent = "")
        {
            return this.Visit((dynamic)node, tempIndent);
        }
    }
}
