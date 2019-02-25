package ce305.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import ce305.abstraction.INode;
import ce305.gen.LanguageLexer;
import ce305.gen.LanguageParser;
import ce305.implementation.errors.DuplicateDefinitionException;
import ce305.implementation.errors.IncorrectDataType;
import ce305.implementation.errors.UndefinedVariableException;
import ce305.implementation.visitors.*;

public class ASTService {
    public static INode CompileToAST(String source)
            throws IncorrectDataType, UndefinedVariableException, DuplicateDefinitionException {
        Lexer lexer = new LanguageLexer(CharStreams.fromString(source));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokenStream);

        INode tree = new ParseVisitor().visitCompileUnit(parser.compileUnit());
        tree = new SemanticAnalyser().visit(tree);

        return tree;
    }
}