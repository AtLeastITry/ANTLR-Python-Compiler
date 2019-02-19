using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;
using Assignment.Abstraction.Utils;
using Assignment.Implementation.Errors;
using Assignment.Implementation.Utils;
using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Assignment.Implementation.Visitors
{
    internal class SemanticAnalyser
    {

        public INode Visit(ProgramNode node)
        {
            var symbolTable = new SymbolTable();
            return new ProgramNode(node.Children.Select(c => this.Visit(c, symbolTable)).ToList());
        }

        public INode Visit(BinaryExpressionNode node, SymbolTable symbolTable)
        {
            return new BinaryExpressionNode(this.Visit(node.Left, symbolTable), this.Visit(node.Right, symbolTable), node.Operation);
        }

        public INode Visit(AssignmentNode node, SymbolTable symbolTable)
        {
            var left = this.Visit(node.Left, symbolTable);
            var right = this.Visit(node.Right, symbolTable);
            if (left.GetType() == typeof(VariableNode))
            {
                if (symbolTable.TryGet(((VariableNode)left).Value, out Symbol symbol))
                {
                    if (!new DataTypeChecker().Visit(right, symbol.Type))
                        throw new IncorrectDataType($"\"{symbol.Name}\" was expecting data type of {symbol.Type}");
                }
                else
                {
                    throw new UndefinedVariableException($"Variable \"{((VariableNode)left).Value}\" has not been defined in the current scope");
                }
            }

            return new AssignmentNode(left, right);
        }

        public INode Visit(NegateNode node, SymbolTable symbolTable)
        {
            return new NegateNode(this.Visit(node.InnerNode, symbolTable));
        }

        public INode Visit(FunctionNode node, SymbolTable symbolTable)
        {
            return new FunctionNode(node.Function, this.Visit(node.Argument, symbolTable));
        }

        public INode Visit(ValueNode node, SymbolTable symbolTable)
        {
            if (symbolTable.Contains(node.Value.ToString()))
            {
                return new VariableNode(node.Value.ToString());
            }

            if (new Regex("a-zA-Z").IsMatch(node.Value.ToString()))
                throw new UndefinedVariableException($"Variable \"{node.Value}\" has not been defined in the current scope");

            return node;
        }

        public INode Visit(VariableNode node, SymbolTable symbolTable)
        {
            if (!symbolTable.Contains(node.Value.ToString()))
                throw new UndefinedVariableException($"Variable \"{node.Value}\" has not been defined in the current scope");

            return node;
        }

        public INode Visit(DeclarationNode node, SymbolTable symbolTable)
        {
            if (symbolTable.Contains(node.Name))
                throw new DuplicateDefinitionException($"\"{node.Name}\" already exists in the current scope");

            symbolTable.Add(new Symbol(node.Name, node.DataType));

            return node;
        }

        public INode Visit(IfStatementNode node, SymbolTable symbolTable)
        {
            var tempTable = new SymbolTable(symbolTable);
            return new IfStatementNode(node.Body.Select(c => this.Visit(c, tempTable)).ToList(), node.Expression, node.Child != null ? this.Visit(node.Child, tempTable) : node.Child);
        }

        public INode Visit(ElseStatementNode node, SymbolTable symbolTable)
        {
            var tempTable = new SymbolTable(symbolTable);
            return new ElseStatementNode(node.Body.Select(c => this.Visit(c, tempTable)).ToList());
        }

        public INode Visit(ElseIfStatementNode node, SymbolTable symbolTable)
        {
            var tempTable = new SymbolTable(symbolTable);

            return new ElseIfStatementNode(node.Body.Select(c => this.Visit(c, tempTable)).ToList(), node.Expression, node.Child != null ? this.Visit(node.Child, tempTable) : node.Child);
        }

        public INode Visit(BooleanExpressionNode node, SymbolTable symbolTable)
        {
            return new BooleanExpressionNode(this.Visit(node.Left, symbolTable), this.Visit(node.Right, symbolTable), node.Operation);
        }

        public INode Visit(INode node, SymbolTable symbolTable)
        {
            return this.Visit((dynamic)node, symbolTable);
        }

        public INode Visit(INode node)
        {
            return this.Visit((dynamic)node);
        }
    }
}
