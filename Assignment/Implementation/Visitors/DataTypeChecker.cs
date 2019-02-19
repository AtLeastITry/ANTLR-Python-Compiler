using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;
using Assignment.Implementation.Errors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment.Implementation.Visitors
{
    internal class DataTypeChecker
    {
        public bool Visit(ProgramNode node, DataTypes dataType)
        {
            return node.Children.All(c => this.Visit(c, dataType));
        }

        public bool Visit(BinaryExpressionNode node, DataTypes dataType)
        {
            return this.Visit(node.Left, dataType) && this.Visit(node.Right, dataType);
        }

        public bool Visit(AssignmentNode node, DataTypes dataType)
        {
            return this.Visit(node.Left, dataType) && this.Visit(node.Right, dataType);
        }

        public bool Visit(NegateNode node, DataTypes dataType)
        {
            return this.Visit(node.InnerNode, dataType);
        }

        public bool Visit(FunctionNode node, DataTypes dataType)
        {
            return this.Visit(node.Argument, dataType);
        }

        public bool Visit(ValueNode node, DataTypes dataType)
        {
            switch (dataType)
            {
                case DataTypes.INTEGER:
                    if (!int.TryParse(node.Value.ToString(), out int intValue))
                    {
                        return false;
                    }
                    break;
                case DataTypes.DECIMAL:
                    if (!decimal.TryParse(node.Value.ToString(), out decimal decimalValue))
                    {
                        return false;
                    }
                    break;
            }

            return true;
        }

        public bool Visit(VariableNode node, DataTypes dataType)
        {
            return true;
        }

        public bool Visit(DeclarationNode node, DataTypes dataType)
        {
            return true;
        }

        public bool Visit(IfStatementNode node, DataTypes dataType)
        {
            return node.Body.All(c => this.Visit(c, dataType)) && this.Visit(node.Child, dataType);
        }

        public bool Visit(ElseStatementNode node, DataTypes dataType)
        {
            return node.Body.All(c => this.Visit(c, dataType));
        }

        public bool Visit(ElseIfStatementNode node, DataTypes dataType)
        {
            return node.Body.All(c => this.Visit(c, dataType)) && this.Visit(node.Child, dataType);
        }

        public bool Visit(BooleanExpressionNode node, DataTypes dataType)
        {
            return this.Visit(node.Left, dataType) && this.Visit(node.Right, dataType);
        }

        public bool Visit(INode node, DataTypes dataType)
        {
            return this.Visit((dynamic)node, dataType);
        }
    }
}
