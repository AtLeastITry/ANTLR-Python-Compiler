using System;

namespace Assignment.Implementation.Errors
{
    public class KeywordException : Exception
    {
        public KeywordException(string message) : base(message)
        {
        }
    }
}
