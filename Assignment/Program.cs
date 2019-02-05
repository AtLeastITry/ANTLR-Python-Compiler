using Antlr4.Runtime;
using Assignment.Grammar;
using Assignment.Implementation;
using Assignment.Services;
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
                var tree = ASTService.CompileToAST(expression);
                Console.WriteLine(ASTService.CompileToPostFix(tree));
            }

            Console.ReadLine();
        }
    }
}
