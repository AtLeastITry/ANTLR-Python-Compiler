using System;

namespace Assignment.Services.DOT
{
    public struct DOTNode
    {
        public readonly string Lable;
        public readonly Guid Id;

        public DOTNode(string label)
        {
            Lable = label;
            Id = Guid.NewGuid();
        }

        public override string ToString()
        {
            return $"{Id}";
        }
    }
}
