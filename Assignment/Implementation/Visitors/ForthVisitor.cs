using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;
using Assignment.Extensions;
using System;
using System.Linq;

namespace Assignment.Implementation
{
    internal class ForthVisitor : IASTVisitor<string>
    {
        public string Visit(ProgramNode node)
        {
            // Visit each child and join them to a new line.
            return string.Join(Environment.NewLine, node.Children.Select(c => this.Visit(c)));
        }

        private bool ContainsVariable(INode tree, VariableNode variableNode)
        {
            // Check whether node is a variable node, if so compare the values
            if (tree.GetType() == typeof(VariableNode))
            {
                return ((VariableNode)tree).Value == variableNode.Value;
            }

            // Recursively check whether the children of the tree contain the specified variable node.
            if (tree.GetType() == typeof(BinaryExpressionNode))
            {
                return this.ContainsVariable(((BinaryExpressionNode)tree).Left, variableNode) 
                    || this.ContainsVariable(((AssignmentNode)tree).Left, variableNode) 
                    || this.ContainsVariable(((BinaryExpressionNode)tree).Right, variableNode) 
                    || this.ContainsVariable(((AssignmentNode)tree).Right, variableNode);
            }

            return false;
        }

        public string Visit(BinaryExpressionNode node)
        {
            // Check which operation is being used, and then build a string with the left node, right node and operator.
            switch(node.Operation)
            {
                case ArithmeticOperations.ADDITION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} +";
                case ArithmeticOperations.SUBTRACTION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} -";
                case ArithmeticOperations.MULTIPLICATION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} *";
                case ArithmeticOperations.DIVISION:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} /";
                case ArithmeticOperations.POWER:
                    return $"{this.Visit(node.Left)} {this.Visit(node.Right)} ^";
                default:
                    return "";
            }
        }

        public string Visit(AssignmentNode node)
        {
            // Check to see if the right side is a binary expression
            if (node.Right.GetType() == typeof(BinaryExpressionNode))
            {
                // Check whether the right node contains the variable being assigned to
                if (this.ContainsVariable(node.Right, (VariableNode)node.Left))
                {
                    var exprRight = (BinaryExpressionNode)node.Right;

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

        public string Visit(IfStatementNode node)
        {
            return "";
        }

        public string Visit(ElseStatementNode node)
        {
            return "";
        }

        public string Visit(ElseIfStatementNode node)
        {
            return "";
        }

        public string Visit(BooleanExpressionNode node)
        {
            return "";
        }

        public string Visit(INode node)
        {
            return this.Visit((dynamic)node);
        }
    }
}