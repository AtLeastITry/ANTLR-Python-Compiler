package compiler.implementation.errors;

public class UndefinedVariableException extends RuntimeException
{
    public UndefinedVariableException(String message)
    {
        super(message);
    }
}