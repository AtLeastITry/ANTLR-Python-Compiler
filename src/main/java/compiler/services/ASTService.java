package compiler.services;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import compiler.abstraction.INode;
import compiler.abstraction.expressions.ProgramNode;
import compiler.gen.*;
import compiler.implementation.visitors.ASTSorter;
import compiler.implementation.visitors.DotVisitor;
import compiler.implementation.visitors.ParseVisitor;
import compiler.implementation.visitors.PythonVisitor;
import compiler.implementation.visitors.SemanticAnalyser;
import compiler.implementation.visitors.VisualizationVisitor;

public class ASTService {
    public static INode compileToAST(String source, String fileName) {
        Lexer lexer = new LanguageLexer(CharStreams.fromString(source));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokenStream);

        // Generate AST
        ProgramNode tree = (ProgramNode)new ParseVisitor().visitCompileUnit(parser.compileUnit());

        // Do Semantics
        tree = new SemanticAnalyser().analyse(tree);

        //Re-order AST based on dependencies of nodes. i.e. function definitions
        ASTSorter sorter = new ASTSorter(tree, fileName);
        tree = (ProgramNode)sorter.visit(tree);

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