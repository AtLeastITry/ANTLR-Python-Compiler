using System.ComponentModel;

namespace Assignment.Abstraction
{
    internal enum Operations
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
