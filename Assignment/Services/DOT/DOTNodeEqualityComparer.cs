using System.Collections.Generic;

namespace Assignment.Services.DOT
{
    internal class DOTNodeEqualityComparer : IEqualityComparer<DOTNode>
    {
        public bool Equals(DOTNode x, DOTNode y)
        {
            return x.Id == y.Id;
        }

        public int GetHashCode(DOTNode obj)
        {
            return obj.GetHashCode();
        }
    }
}
