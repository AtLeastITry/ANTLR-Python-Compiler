package compiler.implementation.errors;

public class UndefinedFunctionException extends RuntimeException
{
    public UndefinedFunctionException(String message)
    {
        super(message);
    }
}