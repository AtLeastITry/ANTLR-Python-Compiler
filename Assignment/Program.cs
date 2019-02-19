using Assignment.Abstraction;
using Assignment.Graphviz;
using Assignment.Services;
using System;
using System.IO;
using System.Reflection;

namespace Assignment
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] files = Directory.GetFiles(@".\source\");

            var targetDirectory = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location) + @"\Target\";

            if (!Directory.Exists(targetDirectory))
            {
                Directory.CreateDirectory(targetDirectory);
            }
            else
            {
                string[] targetFiles = Directory.GetFiles(targetDirectory);

                foreach(var file in targetFiles)
                {
                    File.Delete(file);
                }
            }

            foreach(var file in files)
            {
                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine($"START {Path.GetFileName(file)}");

                var expression = File.ReadAllText(file);
                var tree = BuildAST(expression);

                if (tree != null)
                {
                    VisualiseSourceFile(file, tree);
                    CompileFileToGraph(file, targetDirectory, tree);
                    CompileSourceFile(file, targetDirectory, tree);
                }                

                Console.ForegroundColor = ConsoleColor.Green;
                Console.WriteLine($"END {Path.GetFileName(file)}");
            }

            Console.ResetColor();
            Console.WriteLine($"");
            Console.WriteLine($"Compiled files can be in the following directory: '{targetDirectory}'");
            Console.ReadLine();
        }

        static INode BuildAST(string expression)
        {
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine($"    START Building AST");

            try
            {
                return ASTService.CompileToAST(expression);
            }
            catch (Exception e)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"        Error: {e.Message}");
                Console.ResetColor();
            }
            finally
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine($"    END Building AST");
            }

            return null;
        }

        static void VisualiseSourceFile(string file, INode tree)
        {
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine($"");
            Console.WriteLine($"    START Visualisation");

            try
            {
                var target = ASTService.VisualiseTree(tree, "       ");
                Console.ForegroundColor = ConsoleColor.Cyan;
                Console.WriteLine(target);                    
            }
            catch(Exception e)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"        Error: {e.Message}");
                Console.ResetColor();
            }
            finally
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine($"    END Visualisation");
            }
        }

        static void CompileFileToGraph(string file, string targetDirectory, INode tree)
        {
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine($"");
            Console.WriteLine($"    START Generating graph");

            try
            {
                var target = ASTService.CompileToDOT(tree);                    
                GraphEngine.Execute(new Graph { Content = target }, $"{targetDirectory}{Path.GetFileNameWithoutExtension(file)}");
            }
            catch (Exception e)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"        Error: {e.Message}");
                Console.ResetColor();
            }
            finally
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine($"    END Generating graph");
            }
        }

        static void CompileSourceFile(string file, string targetDirectory, INode tree)
        {
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.WriteLine($"");
            Console.WriteLine($"    START Compiling file");

            try
            {
                var target = ASTService.CompileToPostFix(tree);

                var targetFilePath = $"{targetDirectory}/{Path.GetFileName(file)}";

                var fs = File.Create(targetFilePath);
                fs.Close();

                File.WriteAllText(targetFilePath, target);
            }
            catch(Exception e)
            {
                Console.ForegroundColor = ConsoleColor.Red;
                Console.WriteLine($"        Error: {e.Message}");
                Console.ResetColor();
            }
            finally
            {
                Console.ForegroundColor = ConsoleColor.DarkYellow;
                Console.WriteLine($"    END Compiling file");
            }   
        }
    }
}
