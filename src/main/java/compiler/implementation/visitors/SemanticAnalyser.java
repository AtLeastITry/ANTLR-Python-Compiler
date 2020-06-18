package compiler.implementation.visitors;

import java.util.ArrayList;

import compiler.abstraction.INode;
import compiler.abstraction.expressions.ProgramNode;
import compiler.implementation.binders.BinderType;
import compiler.implementation.binders.SyntaxBinder;

public class SemanticAnalyser {
    private SyntaxBinder _binder = new SyntaxBinder();

    public ProgramNode analyse(ProgramNode node) {
        ProgramNode result = (ProgramNode)_binder.bind(node, BinderType.All);

        ArrayList<INode> declarationChildren = new ArrayList<>();
        ArrayList<INode> syntaxChildren = new ArrayList<>();

        // First do a declaration pass to allow function declarations to occur before the calls.
        for (INode child : result.children) {
            declarationChildren.add(_binder.bind(child, BinderType.DeclarationOnly));
        }

        // Next do a syntax pass to check any syntax errors
        for (INode child : declarationChildren) {
            syntaxChildren.add(_binder.bind(child, BinderType.SyntaxOnly));
        }

        return new ProgramNode(syntaxChildren);
    }
}