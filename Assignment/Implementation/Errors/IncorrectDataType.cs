using System;

namespace Assignment.Implementation.Errors
{
    public class IncorrectDataType : Exception
    {
        public IncorrectDataType(string message) : base(message)
        {
        }
    }
}
