using System;

namespace Assignment.Implementation.Errors
{
    internal class KeywordException : Exception
    {
        public KeywordException(string message) : base(message)
        {
        }
    }
}
