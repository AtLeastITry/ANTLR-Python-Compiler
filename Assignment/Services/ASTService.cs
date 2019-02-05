using Antlr4.Runtime;
using Assignment.Abstraction;
using Assignment.Grammar;
using Assignment.Implementation;
using Assignment.Implementation.Visitors;
using System;
using System.IO;
using System.Text;

namespace Assignment.Services
{
    public static class ASTService
    {
        public static INode CompileToAST(string source)
        {
            byte[] bytes = Encoding.ASCII.GetBytes(source);
            var lexer = new LanguageLexer(new AntlrInputStream(new MemoryStream(bytes)));
            var tokens = new CommonTokenStream(lexer);
            var parser = new LanguageParser(tokens);

            try
            {
                var tree = new LanguageVisitor().VisitCompileUnit(parser.compileUnit());
                return tree;
            }
            catch (Exception e)
            {
                throw e;
            }
        }

        public static string CompileToPostFix(INode tree)
        {
            try
            {
                var value = new PostFixVisitor().Visit(tree);
                return value;
            }
            catch (Exception e)
            {
                throw e;
            }
        }

        public static string VisualiseTree(INode tree, string indent = "")
        {
            return new VisualizationVisitor().Visit(tree, indent);
        }
    }
}
