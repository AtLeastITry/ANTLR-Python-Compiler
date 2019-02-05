using System;

namespace Assignment.Implementation.Errors
{
    public class UndefinedVariableException : Exception
    {
        public UndefinedVariableException(string message) : base(message)
        {
        }
    }
}
