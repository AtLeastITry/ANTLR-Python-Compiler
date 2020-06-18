package compiler.implementation.errors;

public class IncorrectDataType extends RuntimeException
{
    public IncorrectDataType(String message)
    {
        super(message);
    }
}