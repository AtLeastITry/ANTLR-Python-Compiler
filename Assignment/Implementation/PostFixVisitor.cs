using Assignment.Abstraction;

namespace Assignment.Implementation
{
    internal class PostFixVisitor : IASTVisitor<string>
    {
        public string Visit(AdditionNode node)
        {
            return $"{this.Visit(node.Left)} {this.Visit(node.Right)} +";
        }

        public string Visit(SubtractionNode node)
        {
            return $"{this.Visit(node.Left)} {this.Visit(node.Right)} -";
        }

        public string Visit(MultiplicationNode node)
        {
            return $"{this.Visit(node.Left)} {this.Visit(node.Right)} *";
        }

        public string Visit(DivisionNode node)
        {
            return $"{this.Visit(node.Left)} {this.Visit(node.Right)} /";
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

        public string Visit(AssignmentNode node)
        {
            return $"{this.Visit(node.Left)} {this.Visit(node.Right)} =";
        }

        public string Visit(VariableNode node)
        {
            return node.Value;
        }

        public string Visit(INode node)
        {
            return this.Visit((dynamic)node);
        }
    }
}