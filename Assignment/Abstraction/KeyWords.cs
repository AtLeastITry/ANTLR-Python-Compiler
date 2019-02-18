using System.Text.RegularExpressions;

namespace Assignment.Abstraction
{
    public static class KeyWords
    {
        public const string INTERGER = "INTEGER";
        public const string DECIMAL = "DECIMAL";

        public static Regex GetRegex()
        {
            return new Regex($"({INTERGER}|{DECIMAL})");
        }
    }
}
