using Antlr4.Runtime.Misc;
using Assignment.Abstraction;
using Assignment.Grammar;
using Assignment.Implementation.Errors;
using Assignment.Implementation.Utils;
using System;
using System.Linq;
using System.Reflection;
using static Assignment.Grammar.LanguageParser;

namespace Assignment.Implementation
{
    internal class LanguageVisitor : LanguageBaseVisitor<INode>
    {
        private readonly SymbolTable _symbolTable = new SymbolTable();

        public override INode VisitCompileUnit([NotNull] CompileUnitContext context)
        {
            var result = new ProgramNode();

            foreach(var expr in context.expr())
            {
                result.Body.Add(this.Visit(expr));
            }

            return result;
        }

        public override INode VisitVariableDeclarationExpr([NotNull] VariableDeclarationExprContext context)
        {
            var name = context.name.Text;

            if (KeyWords.GetRegex().IsMatch(name))
            {
                throw new KeywordException($"You cannot use the keyword {name} as an identifier");
            }

            if (Enum.TryParse(context.type.Text, out DataTypes dataType))
            {
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
            if (decimal.TryParse(context.value.Text, out decimal value))
            {
                return new ValueNode(value);
            }
            else
            {
                if (!_symbolTable.Contains(context.value.Text))
                    throw new UndefinedVariableException($"Variable \"{context.value.Text}\" has not been defined");
            }

            return new ValueNode(context.value.Text);
        }

        public override INode VisitParensExpr([NotNull] ParensExprContext context)
        {
            return this.Visit(context.expr());
        }

        public override INode VisitInfixExpr([NotNull] InfixExprContext context)
        {
            switch(context.op.Type)
            {
                case LanguageLexer.PLUS:
                    return new AdditionNode(this.Visit(context.left), this.Visit(context.right));
                case LanguageLexer.MINUS:
                    return new SubtractionNode(this.Visit(context.left), this.Visit(context.right));
                case LanguageLexer.MULT:
                    return new MultiplicationNode(this.Visit(context.left), this.Visit(context.right));
                case LanguageLexer.DIV:
                    return new DivisionNode(this.Visit(context.left), this.Visit(context.right));
                default:
                    throw new UnsupportedNodeException("Node is unsupported");
            }
        }

        public override INode VisitAssignmentExpr([NotNull] AssignmentExprContext context)
        {
            var name = context.VAR().GetText();

            if (!_symbolTable.Contains(name))
                throw new UndefinedVariableException($"Variable \"{name}\" has not been defined");

            return new AssignmentNode(new VariableNode(name), this.Visit(context.right));
        }

        public override INode VisitUnaryExpr([NotNull] UnaryExprContext context)
        {
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

            var func = typeof(Math)
            .GetMethods(BindingFlags.Public | BindingFlags.Static)
            .Where(m => m.ReturnType == typeof(double))
            .Where(m => m.GetParameters().Select(p => p.ParameterType).SequenceEqual(new[] { typeof(double) }))
            .FirstOrDefault(m => m.Name.Equals(funcName, StringComparison.OrdinalIgnoreCase));

            if (func == null)
                throw new NotSupportedException(string.Format("Function {0} is not supported", funcName));

            return new FunctionNode(funcName, this.Visit(context.expr()));
        }
    }
}
