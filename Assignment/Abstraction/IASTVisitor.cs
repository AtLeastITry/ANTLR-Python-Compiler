using Assignment.Abstraction;

namespace Assignment.Abstraction
{
    internal interface IASTVisitor<T>
    {
        T Visit(AdditionNode node);
        T Visit(SubtractionNode node);
        T Visit(MultiplicationNode node);
        T Visit(DivisionNode node);
        T Visit(NegateNode node);
        T Visit(FunctionNode node);
        T Visit(ValueNode node);
        T Visit(VariableNode node);
        T Visit(AssignmentNode node);
        T Visit(INode node);
    }
}
