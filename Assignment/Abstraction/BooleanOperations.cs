using System.ComponentModel;

namespace Assignment.Abstraction
{
    internal enum BooleanOperations
    {
        [DisplayName("==")]
        EQUALS,
        [DisplayName("!=")]
        NEGATIVEEQUALS,
        [DisplayName(">")]
        GREATERTHAN,
        [DisplayName("<")]
        LESSTHAN,
        [DisplayName(">=")]
        GREATERTHANEQUALS,
        [DisplayName("<=")]
        LESSTHANEQUALS,
        [DisplayName("||")]
        OR,
        [DisplayName("&&")]
        AND
    }
}
