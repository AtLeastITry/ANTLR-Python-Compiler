using Antlr4.Runtime.Misc;
using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;
using Assignment.Grammar;
using Assignment.Implementation.Errors;
using Assignment.Implementation.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text.RegularExpressions;
using static Assignment.Grammar.LanguageParser;

namespace Assignment.Implementation
{
    internal class LanguageVisitor : LanguageBaseVisitor<INode>
    {
        public override INode VisitCompileUnit([NotNull] CompileUnitContext context)
        {
            return this.Visit(context.statements());
        }

        public override INode VisitStatements([NotNull] StatementsContext context)
        {
            var result = new ProgramNode();

            // Loop through each of the expressions the ANTLR parser finds
            foreach (var statement in context.statement())
            {
                if (statement.IsEmpty || string.IsNullOrEmpty(statement.ToString()))
                {
                    continue;
                }
                var node = this.Visit(statement);

                // If the node is null then it was probably a new line
                if (node != null)
                    result.Children.Add(node);
            }

            return result;
        }

        public override INode VisitIfElseStatement([NotNull] IfElseStatementContext context)
        {
            IfStatementNode ifStatement = (IfStatementNode)this.Visit(context.ifStat);
            var elseIfStatements = context.elseIfStatement().Select(s => this.Visit(s)).ToList();
            var elseStatement = this.Visit(context.elseStatement());

            if (elseIfStatements != null && elseIfStatements.Count > 0)
            {
                for (int i = elseIfStatements.Count - 2; i >= 0; i--)
                {
                    ElseIfStatementNode current = (ElseIfStatementNode)elseIfStatements[i];
                    ElseIfStatementNode sibling = (ElseIfStatementNode)elseIfStatements[i + 1];

                    if (i == elseIfStatements.Count - 2)
                    {
                        if (elseStatement != null)
                        {
                            elseIfStatements[i + 1] = new ElseIfStatementNode(sibling.Body, sibling.Expression, elseStatement);
                        }
                    }


                    elseIfStatements[i] = new ElseIfStatementNode(current.Body, current.Expression, elseIfStatements[i + 1]);
                }

                return new IfStatementNode(ifStatement.Body, ifStatement.Expression, elseIfStatements[0]);
            }
            else
            {
                if (elseStatement != null)
                {
                    return new IfStatementNode(ifStatement.Body, ifStatement.Expression, elseStatement);
                }
            }



            return new IfStatementNode(ifStatement.Body, ifStatement.Expression, null);
        }

        public override INode VisitIfStatement([NotNull] IfStatementContext context)
        {
            var children = new List<INode>();
            foreach (var statement in context.body.statement())
            {
                if (statement.IsEmpty || string.IsNullOrEmpty(statement.ToString()))
                {
                    continue;
                }
                var node = this.Visit(statement);

                // If the node is null then it was probably a new line
                if (node != null)
                    children.Add(node);
            }

            return new IfStatementNode(children, this.Visit(context.expression), null);
        }

        public override INode VisitElseStatement([NotNull] ElseStatementContext context)
        {
            var children = new List<INode>();
            foreach (var statement in context.body.statement())
            {
                if (statement.IsEmpty || string.IsNullOrEmpty(statement.ToString()))
                {
                    continue;
                }
                var node = this.Visit(statement);

                // If the node is null then it was probably a new line
                if (node != null)
                    children.Add(node);
            }

            return new ElseStatementNode(children);
        }

        public override INode VisitElseIfStatement([NotNull] ElseIfStatementContext context)
        {
            var children = new List<INode>();
            foreach (var statement in context.body.statement())
            {
                if (statement.IsEmpty || string.IsNullOrEmpty(statement.ToString()))
                {
                    continue;
                }
                var node = this.Visit(statement);

                // If the node is null then it was probably a new line
                if (node != null)
                    children.Add(node);
            }

            return new ElseIfStatementNode(children, this.Visit(context.expression), null);
        }

        public override INode VisitBooleanExpr([NotNull] BooleanExprContext context)
        {
            // Check which type of expression has been declared using the type parsed by the ANTLR parser, then return the appropiate value
            switch (context.op.Type)
            {
                case LanguageLexer.EQUALS:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.EQUALS);
                case LanguageLexer.NEGATIVEEQUALS:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.NEGATIVEEQUALS);
                case LanguageLexer.GREATERTHAN:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.GREATERTHAN);
                case LanguageLexer.LESSTHAN:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.LESSTHAN);
                case LanguageLexer.GREATERTHANEQUALS:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.GREATERTHANEQUALS);
                case LanguageLexer.LESSTHANEQUALS:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.LESSTHANEQUALS);
                case LanguageLexer.OR:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.OR);
                case LanguageLexer.AND:
                    return new BooleanExpressionNode(this.Visit(context.left), this.Visit(context.right), BooleanOperations.AND);
                default:
                    // This occurs when a user has attempted to use an expression operator that is not supported.
                    throw new UnsupportedNodeException("Node is unsupported");
            }
        }

        public override INode VisitDeclaration([NotNull] DeclarationContext context)
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
                return new DeclarationNode(name, dataType);
            }
            else
            {
                throw new UnsupportedDataTypeException($"The data type: {context.type.Text} is currently unsupported");
            }
        }

        public override INode VisitValueExpr([NotNull] ValueExprContext context)
        {
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
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), ArithmeticOperations.ADDITION);
                case LanguageLexer.MINUS:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), ArithmeticOperations.SUBTRACTION);
                case LanguageLexer.MULT:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), ArithmeticOperations.MULTIPLICATION);
                case LanguageLexer.DIV:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), ArithmeticOperations.DIVISION);
                case LanguageLexer.POWER:
                    return new BinaryExpressionNode(this.Visit(context.left), this.Visit(context.right), ArithmeticOperations.POWER);
                default:
                    // This occurs when a user has attempted to use an expression operator that is not supported.
                    throw new UnsupportedNodeException("Node is unsupported");
            }
        }

        public override INode VisitAssignment([NotNull] AssignmentContext context)
        {
            // Remove all new line characters
            var name = context.variable.Text.Replace("\r", "").Replace("\n", "");
            return new AssignmentNode(new VariableNode(name), this.Visit(context.right));
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
