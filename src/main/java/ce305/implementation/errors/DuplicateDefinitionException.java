package ce305.implementation.errors;

public class DuplicateDefinitionException extends RuntimeException
{
    public DuplicateDefinitionException(String message)
    {
        super(message);
    }
}