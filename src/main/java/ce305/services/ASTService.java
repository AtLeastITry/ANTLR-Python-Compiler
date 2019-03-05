package ce305.services;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import ce305.abstraction.INode;
import ce305.abstraction.expressions.ProgramNode;
import ce305.gen.*;
import ce305.implementation.visitors.ASTSorter;
import ce305.implementation.visitors.DotVisitor;
import ce305.implementation.visitors.ParseVisitor;
import ce305.implementation.visitors.PythonVisitor;
import ce305.implementation.visitors.SemanticAnalyser;
import ce305.implementation.visitors.VisualizationVisitor;

public class ASTService {
    public static INode compileToAST(String source) {
        Lexer lexer = new LanguageLexer(CharStreams.fromString(source));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokenStream);

        // Generate AST
        ProgramNode tree = (ProgramNode)new ParseVisitor().visitCompileUnit(parser.compileUnit());

        // Do Semantics
        tree = new SemanticAnalyser().analyse(tree);

        //Re-order AST so that functions declarations are at the start of each body
        tree = (ProgramNode)new ASTSorter(tree).visit(tree);

        return tree;
    }

    public static String compileToPython(INode tree) {
        String result = new PythonVisitor().visit(tree);
        return result;
    }

    public static String visualizeTree(INode tree) {
        String result = new VisualizationVisitor().visit(tree);
        return result;
    }

    public static String compileToDot(INode tree) {
        String result = new DotVisitor().visit(tree);
        return result;
    }
}