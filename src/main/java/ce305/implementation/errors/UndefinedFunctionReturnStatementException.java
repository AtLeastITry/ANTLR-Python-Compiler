package ce305.implementation.errors;

public class UndefinedFunctionReturnStatementException extends RuntimeException
{
    public UndefinedFunctionReturnStatementException(String message)
    {
        super(message);
    }
}