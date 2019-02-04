using System;
using System.Collections.Generic;
using System.Text;

namespace Assignment.Implementation.Errors
{
    internal class UnsupportedNodeException : Exception
    {
        public UnsupportedNodeException(string message) : base(message)
        {
        }
    }
}
