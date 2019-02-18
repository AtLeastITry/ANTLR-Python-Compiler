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

        public string Visit(BinaryExpressionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()})";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(AssignmentNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()})";
            tempIndent += IndentString;

            temp += this.Visit(node.Left, tempIndent);
            temp += this.Visit(node.Right, tempIndent);

            return temp;
        }

        public string Visit(NegateNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()}";
            tempIndent += IndentString;

            temp += this.Visit(node.InnerNode, tempIndent);

            return temp;
        }

        public string Visit(FunctionNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()}";
            tempIndent += IndentString;

            temp += this.Visit(node.Argument, tempIndent);

            return temp;
        }

        public string Visit(ValueNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(VariableNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(DeclarationNode node, string tempIndent)
        {
            var temp = $"{Environment.NewLine}{tempIndent}+- {node.DisplayName()})";
            tempIndent += IndentString;

            return temp;
        }

        public string Visit(INode node, string tempIndent = "")
        {
            return this.Visit((dynamic)node, tempIndent);
        }
    }
}
