using Assignment.Abstraction;
using Assignment.Abstraction.Expressions;
using Assignment.Abstraction.Statements;
using Assignment.Extensions;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Assignment.Services.DOT
{
    internal class DOTBuilder
    {
        private const string labelParams = "shape=\"ellipse\" fontsize=8 width=5 height=1]";

        private readonly List<Tuple<DOTNode, DOTNode>> _connections = new List<Tuple<DOTNode, DOTNode>>();
        private IEnumerable<string> _connectionsList => _connections.Select(a => $"\"{a.Item1}\" -> \"{a.Item2}\";");
        private IEnumerable<string> _connectionDefinitions => _connections.Flatten()
            .Distinct(new DOTNodeEqualityComparer())
            .Select(dn => $"\"{dn}\" [label=\"{dn.Lable}\" {labelParams};");

        public string Build(INode tree, string graphName)
        {
            this.Visit(tree);

            return $@"
digraph {graphName} {{
    {string.Join(Environment.NewLine, _connectionDefinitions)}
    {string.Join(Environment.NewLine, _connectionsList)}
}}";
        }

        #region Helpers
        private void Visit(ProgramNode node)
        {
            var parent = new DOTNode(node.DisplayName());

            foreach (var child in node.Children)
            {
                this.Visit(child, parent);
            }
        }

        private void Visit(BinaryExpressionNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Left, childNode);
            this.Visit(node.Right, childNode);
        }

        private void Visit(AssignmentNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Left, childNode);
            this.Visit(node.Right, childNode);
        }

        private void Visit(NegateNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.InnerNode, childNode);
        }

        private void Visit(FunctionNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Argument, childNode);
        }

        private void Visit(ValueNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        private void Visit(VariableNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        private void Visit(DeclarationNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        private void Visit(IfStatementNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Expression, childNode);

            foreach(var child in node.Body)
            {
                this.Visit(child, childNode);
            }

            if (node.Child != null)
            {
                this.Visit(node.Child, childNode);
            }
        }

        private void Visit(ElseStatementNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            foreach (var child in node.Body)
            {
                this.Visit(child, childNode);
            }
        }

        private void Visit(ElseIfStatementNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Expression, childNode);

            foreach (var child in node.Body)
            {
                this.Visit(child, childNode);
            }

            if (node.Child != null)
            {
                this.Visit(node.Child, childNode);
            }
        }

        private void Visit(BooleanExpressionNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Left, childNode);
            this.Visit(node.Right, childNode);
        }

        private void Visit(INode node, DOTNode parent)
        {
            this.Visit((dynamic)node, parent);
        }

        private void Visit(INode node)
        {
            this.Visit((dynamic)node);
        }
        #endregion
    }
}
