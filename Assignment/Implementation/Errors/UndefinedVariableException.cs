using System;

namespace Assignment.Implementation.Errors
{
    internal class UndefinedVariableException : Exception
    {
        public UndefinedVariableException(string message) : base(message)
        {
        }
    }
}
