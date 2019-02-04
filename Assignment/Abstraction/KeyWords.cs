using System.Text.RegularExpressions;

namespace Assignment.Abstraction
{
    public static class KeyWords
    {
        public const string VARIABLE = "VARIABLE";
        public const string INTERGER = "INTERGER";
        public const string STRING = "STRING";
        public const string AS = "as";

        public static Regex GetRegex()
        {
            return new Regex($"({VARIABLE}|{INTERGER}|{STRING}|{AS})");
        }
    }
}
