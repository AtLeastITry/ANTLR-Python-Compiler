namespace Assignment.Abstraction
{
    internal interface IInfixNode: INode
    {
        INode Left { get; }
        INode Right { get; }
    }
}
