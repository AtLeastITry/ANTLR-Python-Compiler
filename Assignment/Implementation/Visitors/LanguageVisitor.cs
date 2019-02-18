using Antlr4.Runtime.Misc;
using Assignment.Abstraction;
using Assignment.Grammar;
using Assignment.Implementation.Errors;
using Assignment.Implementation.Utils;
using System;
using System.Linq;
using System.Reflection;
using System.Text.RegularExpressions;
using static Assignment.Grammar.LanguageParser;

namespace Assignment.Implementation
{
    internal class LanguageVisitor : LanguageBaseVisitor<INode>
    {
        private readonly SymbolTable _symbolTable = new SymbolTable();

        public override INode VisitCompileUnit([NotNull] CompileUnitContext context)
        {
            var result = new ProgramNode();
            // Loop through each of the expressions the ANTLR parser finds
            foreach(var expr in context.expr())
            {
                if (expr.IsEmpty || string.IsNullOrEmpty(expr.ToString()))
                {
                    continue;
                }
                var node = this.Visit(expr);

                // If the node is null then it was probably a new line
                if (node != null)
                    result.Children.Add(node);
            }

            return result;
        }

        public override INode VisitVariableDeclarationExpr([NotNull] VariableDeclarationExprContext context)
        {
            var name = context.name.Text;

            // Throw if the name of the variable matches one of the predefined keywords
            if (KeyWords.GetRegex().IsMatch(name))
            {
                throw new KeywordException($"You cannot use the keyword {name} as an identifier");
            }

            // Throw if an unsupported data type is attempted
            if (Enum.TryParse(context.type.Text, out DataTypes dataType))
            {
                // keep track of the variable name and it's data type in the symbol table
                _symbolTable.Add(new Symbol(name, dataType));

                return new DeclarationNode(name);
            }
            else
            {
                throw new UnsupportedDataTypeException($"The data type: {context.type.Text} is currently unsupported");
            }
        }

        public override INode VisitValueExpr([NotNull] ValueExprContext context)
        {
            // If the value matches a variable in the symbol table then just return a variable node. 
            // This occurs when a user references a varaible in an expression
            if (_symbolTable.Contains(context.value.Text))
            {
                return new VariableNode(context.value.Text);
            }

            // if the value doesnt match a variable in the symbol table but is still an alpha set, throw an error.
            // This occurs when a user attempts to reference an undefined variable
            if (new Regex("a-zA-Z").IsMatch(context.value.Text))
                throw new UndefinedVariableException($"Variable \"{context.value.Text}\" has not been defined");

            return new ValueNode(context.value.Text);
        }

        public override INode VisitParensExpr([NotNull] ParensExprContext context)
        {
            return this.Visit(context.expr());
        }

        public override INode VisitInfixExpr([NotNull] InfixExprContext context)
        {
            // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
            switch(context.op.Type)
            {
                case LanguageLexer.PLUS:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), Operations.ADDITION);
                case LanguageLexer.MINUS:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), Operations.SUBTRACTION);
                case LanguageLexer.MULT:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), Operations.MULTIPLICATION);
                case LanguageLexer.DIV:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), Operations.DIVISION);
                case LanguageLexer.POWER:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), Operations.POWER);
                default:
                    // This occurs when a user has attempted to use an expression operator that is not supported.
                    throw new UnsupportedNodeException("Node is unsupported");
            }
        }

        public override INode VisitAssignmentExpr([NotNull] AssignmentExprContext context)
        {
            // Remove all new line characters
            var name = context.variable.Text.Replace("\r", "").Replace("\n", "");

            // Throw if the variable being assigned to is undefined.
            if (!_symbolTable.TryGet(name, out var symbol))
                throw new UndefinedVariableException($"Variable \"{name}\" has not been defined");

            var right = this.Visit(context.right);

            // If the right side is a value node then attempt to parse the value to either an interger or decimal
            if (right.GetType() == typeof(ValueNode))
            {
                switch (symbol.Type)
                {
                    case DataTypes.INTEGER:
                        if (int.TryParse(((ValueNode)right).Value.ToString(), out int intValue))
                        {
                            right = new ValueNode(intValue);
                        }
                        else
                        {
                            throw new IncorrectDataType($"\"{symbol.Name}\" was expecting data type of {DataTypes.INTEGER.ToString()}");
                        }
                        break;
                    case DataTypes.DECIMAL:
                        if (decimal.TryParse(((ValueNode)right).Value.ToString(), out decimal decimalValue))
                        {
                            right = new ValueNode(decimalValue);
                        }
                        else
                        {
                            throw new IncorrectDataType($"\"{symbol.Name}\" was expecting data type of {DataTypes.DECIMAL.ToString()}");
                        }
                        break;

                }
            }

            return new AssignmentNode(new VariableNode(name), right);
        }

        public override INode VisitUnaryExpr([NotNull] UnaryExprContext context)
        {
            // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
            switch(context.op.Type)
            {
                case LanguageLexer.PLUS:
                    return this.Visit(context.expr());
                case LanguageLexer.MINUS:
                    return new NegateNode(this.Visit(context.expr()));
                default:
                    throw new UnsupportedNodeException("Node is unsupported");
            }
        }

        public override INode VisitFuncExpr([NotNull] FuncExprContext context)
        {
            var funcName = context.func.Text;
            
            // Attempt to generate the mathmatical function
            var func = typeof(Math)
            .GetMethods(BindingFlags.Public | BindingFlags.Static)
            .Where(m => m.ReturnType == typeof(double))
            .Where(m => m.GetParameters().Select(p => p.ParameterType).SequenceEqual(new[] { typeof(double) }))
            .FirstOrDefault(m => m.Name.Equals(funcName, StringComparison.OrdinalIgnoreCase));

            // If unable to generate the function then throw an error
            if (func == null)
                throw new NotSupportedException(string.Format("Function {0} is not supported", funcName));

            return new FunctionNode(funcName, this.Visit(context.expr()));
        }
    }
}
