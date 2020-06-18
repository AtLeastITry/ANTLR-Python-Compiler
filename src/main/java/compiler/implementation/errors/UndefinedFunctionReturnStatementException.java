package compiler.implementation.errors;

public class UndefinedFunctionReturnStatementException extends RuntimeException
{
    public UndefinedFunctionReturnStatementException(String message)
    {
        super(message);
    }
}