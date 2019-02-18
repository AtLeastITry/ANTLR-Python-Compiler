using Assignment.Abstraction;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Assignment.Implementation.Visitors
{
    internal class DOTVisitor
    {
        private readonly List<Tuple<DOTNode, DOTNode>> _connections = new List<Tuple<DOTNode, DOTNode>>();

        private const string labelParams = "shape=\"ellipse\" fontsize=8 width=5 height=1]";

        private IEnumerable<string> _connectionsList => _connections.Select(a => $"\"{a.Item1}\" -> \"{a.Item2}\";");
        private HashSet<string> _distinctDefinitions
        {
            get
            {
                HashSet<string> temp = new HashSet<string>();
                foreach (var (a, b) in _connections)
                {
                    var tempA = $"\"{a}\" [label=\"{a.Lable}\" {labelParams};";
                    var tempB = $"\"{b}\" [label=\"{b.Lable}\" {labelParams};";

                    if (!temp.Contains(tempA))
                        temp.Add(tempA);

                    if (!temp.Contains(tempB))
                        temp.Add(tempB);
                }

                return temp;
            }
        }

        public string CompileDOT(string graphName)
        {
            return $@"
digraph {graphName} {{
    {string.Join(Environment.NewLine, _distinctDefinitions)}
    {string.Join(Environment.NewLine, _connectionsList)}
}}";
        }

        public void Visit(ProgramNode node)
        {
            var parent = new DOTNode(node.DisplayName());

            foreach(var child in node.Children)
            {
                this.Visit(child, parent);
            }
        }

        public void Visit(BinaryExpressionNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Left, childNode);
            this.Visit(node.Right, childNode);
        }

        public void Visit(AssignmentNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Left, childNode);
            this.Visit(node.Right, childNode);
        }

        public void Visit(NegateNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.InnerNode, childNode);            
        }

        public void Visit(FunctionNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));

            this.Visit(node.Argument, childNode);
        }

        public void Visit(ValueNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        public void Visit(VariableNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        public void Visit(DeclarationNode node, DOTNode parent)
        {
            var childNode = new DOTNode(node.DisplayName());
            _connections.Add(new Tuple<DOTNode, DOTNode>(parent, childNode));
        }

        public void Visit(INode node, DOTNode parent)
        {
            this.Visit((dynamic)node, parent);
        }

        public void Visit(INode node)
        {
            this.Visit((dynamic)node);
        }
    }
}
