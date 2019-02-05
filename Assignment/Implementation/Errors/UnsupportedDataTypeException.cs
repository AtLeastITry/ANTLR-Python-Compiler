using System;

namespace Assignment.Implementation.Errors
{
    public class UnsupportedDataTypeException : Exception
    {
        public UnsupportedDataTypeException(string message) : base(message)
        {
        }
    }
}
