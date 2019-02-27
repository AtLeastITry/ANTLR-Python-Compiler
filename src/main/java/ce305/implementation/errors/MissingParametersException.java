package ce305.implementation.errors;

public class MissingParametersException extends RuntimeException
{
    public MissingParametersException(String message)
    {
        super(message);
    }
}