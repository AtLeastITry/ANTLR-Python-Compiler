using System;

namespace Assignment.Implementation.Visitors
{
    public struct DOTNode
    {
        public readonly string Lable;
        private readonly Guid _id;

        public DOTNode(string label)
        {
            Lable = label;
            _id = Guid.NewGuid();
        }

        public override string ToString()
        {
            return $"{_id}";
        }
    }
}
