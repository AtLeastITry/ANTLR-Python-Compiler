package ce305.implementation.errors;

public class IncorrectDataType extends RuntimeException
{
    public IncorrectDataType(String message)
    {
        super(message);
    }
}