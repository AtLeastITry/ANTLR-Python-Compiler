using Assignment.Services;
using System;
using System.IO;

namespace Assignment
{
    class Program
    {
        static void Main(string[] args)
        {
            VisualiseSourceFiles();
            CompileSourceFiles();
        }

        static void VisualiseSourceFiles()
        {
            string[] files = Directory.GetFiles(@".\source\");

            foreach (var file in files)
            {
                var expression = File.ReadAllText(file);

                Console.WriteLine($"START {Path.GetFileName(file)}");

                try
                {
                    var tree = ASTService.CompileToAST(expression);
                    var target = ASTService.VisualiseTree(tree, "   ");
                    Console.WriteLine(target);                    
                }
                catch(Exception e)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"    Error: {e.Message}");
                    Console.ResetColor();
                }
                finally
                {
                    Console.WriteLine($"END {Path.GetFileName(file)}");
                }
            }
            Console.ReadLine();
        }
        static void CompileSourceFiles()
        {
            string[] files = Directory.GetFiles(@".\source\");

            var targetDirectory = Directory.GetCurrentDirectory() + @"\Target\";

            if (!Directory.Exists(targetDirectory))
            {
                Directory.CreateDirectory(targetDirectory);
            }

            foreach (var file in files)
            {
                var expression = File.ReadAllText(file);

                Console.WriteLine($"START Compiling file: {Path.GetFileName(file)}");

                try
                {
                    var tree = ASTService.CompileToAST(expression);
                    var target = ASTService.CompileToPostFix(tree);

                    var targetFilePath = $"{targetDirectory}/{Path.GetFileName(file)}";

                    var fs = File.Create(targetFilePath);
                    fs.Close();

                    File.WriteAllText(targetFilePath, target);
                }
                catch(Exception e)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.WriteLine($"    Error: {e.Message}");
                    Console.ResetColor();
                }
                finally
                {
                    Console.WriteLine($"END Compiling file: {Path.GetFileName(file)}");
                }                
            }

            Console.WriteLine($"Compiled files can be in the following directory: '{targetDirectory}'");
            Console.ReadLine();
        }
    }
}
