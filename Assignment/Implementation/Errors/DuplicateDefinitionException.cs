using System;

namespace Assignment.Implementation.Errors
{
    public class DuplicateDefinitionException : Exception
    {
        public DuplicateDefinitionException(string message) : base(message)
        {
        }
    }
}
