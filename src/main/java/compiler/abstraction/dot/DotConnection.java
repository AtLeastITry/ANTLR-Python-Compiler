package compiler.abstraction.dot;

public class DotConnection {
    public final DotNode a;
    public final DotNode b;

    public DotConnection(DotNode a, DotNode b) {
        this.a = a;
        this.b = b;
    }
}