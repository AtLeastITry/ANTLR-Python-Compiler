package compiler.implementation.errors;

public class UnsupportedDataTypeException extends RuntimeException
{
    public UnsupportedDataTypeException(String message)
    {
        super(message);
    }
}