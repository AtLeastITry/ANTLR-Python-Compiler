package compiler;

import java.io.File;
import java.io.IOException;

import compiler.abstraction.INode;
import compiler.services.ASTService;
import compiler.utils.Console;
import compiler.utils.ConsoleColor;
import compiler.utils.FileHelper;

/**
 * Hello world!
 *
 */
public class Program {
    public static void main(String[] args) throws IOException {
        try {
            FileHelper.clearTargetFiles();
            for (File file : FileHelper.getSourceFiles()) {
                Console.setColor(ConsoleColor.GREEN_BOLD);
                Console.writeLine("START " + file.getName());
                String contents = FileHelper.readFile(file.toPath());
                INode tree = buildAST(contents, file.getName());
                if (tree == null) {
                    Console.setColor(ConsoleColor.GREEN_BOLD);
                    Console.writeLine("Failed " + file.getName());
                    continue;
                }
                visualize(tree);
                FileHelper.generateDotFile(tree, file.getName());
                FileHelper.generatePythonFile(tree, file.getName());

                Console.setColor(ConsoleColor.GREEN_BOLD);
                Console.writeLine("END " + file.getName());
            }
        } catch(Exception e) {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
    }

    private static INode buildAST(String content, String fileName) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine("    START Building AST");
        INode tree = null;
        try
        {
            tree = ASTService.compileToAST(content, fileName);
        }
        catch (Exception e)
        {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
        finally
        {
            Console.setColor(ConsoleColor.CYAN_BOLD);
            Console.writeLine("    END Building AST");
        }

        return tree;
    }

    private static void visualize(INode tree) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine();
        Console.writeLine("    START Visualization");

        try {
            Console.resetColor();
            String result = ASTService.visualizeTree(tree);
            Console.writeLine(result);
        }
        catch (Exception e)
        {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
        finally
        {
            Console.setColor(ConsoleColor.CYAN_BOLD);
            Console.writeLine("    END Visualization");
        }
    }
}
