namespace Assignment.Abstraction
{
    internal interface IExpressionNode: INode
    {
        INode Left { get; }
        INode Right { get; }
    }
}
