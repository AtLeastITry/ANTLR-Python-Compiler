using System.ComponentModel;

namespace Assignment.Abstraction
{
    internal enum ArithmeticOperations
    {
        [DisplayName("+")]
        ADDITION,
        [DisplayName("-")]
        SUBTRACTION,
        [DisplayName("*")]
        MULTIPLICATION,
        [DisplayName("/")]
        DIVISION,
        [DisplayName("^")]
        POWER
    }
}
