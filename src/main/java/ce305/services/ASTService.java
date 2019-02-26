package ce305.services;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import ce305.abstraction.INode;
import ce305.gen.*;
import ce305.implementation.visitors.ParseVisitor;
import ce305.implementation.visitors.PythonVisitor;
import ce305.implementation.visitors.SemanticAnalyser;

public class ASTService {
    public static INode CompileToAST(String source) {
        Lexer lexer = new LanguageLexer(CharStreams.fromString(source));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokenStream);

        INode tree = new ParseVisitor().visitCompileUnit(parser.compileUnit());
        tree = new SemanticAnalyser().visit(tree);

        return tree;
    }

    public static String CompileToPython(INode tree) {
        String result = new PythonVisitor().visit(tree);
        return result;
    }
}