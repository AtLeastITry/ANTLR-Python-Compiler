package compiler.implementation.errors;

public class UnsupportedNodeException extends RuntimeException
{
    public UnsupportedNodeException(String message)
    {
        super(message);
    }
}