package ce305.implementation.errors;

public class UndefinedVariableException extends RuntimeException
{
    public UndefinedVariableException(String message)
    {
        super(message);
    }
}