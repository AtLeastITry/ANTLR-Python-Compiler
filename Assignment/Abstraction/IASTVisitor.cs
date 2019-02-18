namespace Assignment.Abstraction
{
    internal interface IASTVisitor<T>
    {
        T Visit(ProgramNode node);
        T Visit(BinaryExpressionNode node);
        T Visit(AssignmentNode node);
        T Visit(NegateNode node);
        T Visit(FunctionNode node);
        T Visit(ValueNode node);
        T Visit(VariableNode node);
        T Visit(DeclarationNode node);
        T Visit(INode node);
    }
}
