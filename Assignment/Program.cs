using Antlr4.Runtime;
using Assignment.Grammar;
using Assignment.Implementation;
using System;
using System.IO;
using System.Text;

namespace Assignment
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] files = Directory.GetFiles("./source/");

            foreach(var file in files)
            {
                var expression = File.ReadAllText(file);
                byte[] bytes = Encoding.ASCII.GetBytes(expression);
                var lexer = new LanguageLexer(new AntlrInputStream(new MemoryStream(bytes)));
                var tokens = new CommonTokenStream(lexer);
                var parser = new LanguageParser(tokens);

                try
                {
                    var tree = new LanguageVisitor().VisitCompileUnit(parser.compileUnit());
                    var value = new PostFixVisitor().Visit(tree);

                    Console.WriteLine(value);
                }
                catch (Exception e)
                {
                    throw e;
                }
            }

            Console.ReadLine();
        }
    }
}
