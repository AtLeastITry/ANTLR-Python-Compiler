using System;

namespace Assignment.Abstraction.Utils
{
    internal struct Scope
    {
        public Scope(Guid id)
        {
            this.Id = id;
        }

        public Guid Id { get; }
    }
}
