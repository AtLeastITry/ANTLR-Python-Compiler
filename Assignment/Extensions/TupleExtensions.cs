using System;
using System.Collections.Generic;

namespace Assignment.Extensions
{
    internal static class TupleExtensions
    {
        public static IEnumerable<T1> Flatten<T1>(this IEnumerable<Tuple<T1, T1>> source)
        {
            foreach(var (a, b) in source)
            {
                yield return a;
                yield return b;
            }
        }
    }
}
