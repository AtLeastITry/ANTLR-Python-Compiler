using System;
using System.Collections.Generic;
using System.Text;

namespace Assignment.Implementation.Errors
{
    public class UnsupportedNodeException : Exception
    {
        public UnsupportedNodeException(string message) : base(message)
        {
        }
    }
}
