package ce305;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import ce305.abstraction.INode;
import ce305.implementation.utils.Console;
import ce305.implementation.utils.ConsoleColor;
import ce305.services.ASTService;

/**
 * Hello world!
 *
 */
public class Language {
    public static void main(String[] args) throws IOException {
        try {
            clearTargetFiles();
            for (File file : getSourceFiles()) {
                Console.setColor(ConsoleColor.GREEN_BOLD);
                Console.writeLine("START " + file.getName());
                String contents = readFile(file.toPath());
                INode tree = buildAST(contents);
                if (tree == null) {
                    Console.setColor(ConsoleColor.GREEN_BOLD);
                    Console.writeLine("Failed " + file.getName());
                    continue;
                }
                visualize(tree);
                String dot = compileToDot(tree, file.getName());
                String python = compileToPython(tree, file.getName());

                Console.setColor(ConsoleColor.GREEN_BOLD);
                Console.writeLine("END " + file.getName());
            }
        } catch(Exception e) {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
    }

    private static String compileToPython(INode tree, String fileName) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine();
        Console.writeLine("    START Compiling file to python");

        String result = "";

        try {
            result = ASTService.compileToPython(tree); 
            writeFile("python", fileName, "py", result);
        }
        catch(Exception e) {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
        finally {
            Console.setColor(ConsoleColor.CYAN_BOLD);
            Console.writeLine("    END Compiling file to python");
        }

        return result;
    }

    private static String compileToDot(INode tree, String fileName) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine();
        Console.writeLine("    START Compiling file to DOT");

        String result = "";

        try {
            result = ASTService.compileToDot(tree);
            writeFile("dot", fileName, "dot", result);     
        }
        catch(Exception e) {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("        Error:" + e.getMessage());
            Console.resetColor();
        }
        finally {
            Console.setColor(ConsoleColor.CYAN_BOLD);
            Console.writeLine("    END Compiling file to DOT");
        }

        return result;
    }

    private static INode buildAST(String content) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine("    START Building AST");
        INode tree = null;
        try
        {
            tree = ASTService.compileToAST(content);
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

    private static File[] getSourceFiles() {
        File folder = new File("src/source");
        return folder.listFiles();
    }

    private static void clearTargetFiles() {
        File folder = new File("src/target");
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
    }

    private static String readFile(Path path) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, StandardCharsets.UTF_8);
    }

    private static void writeFile(String directory, String fileName, String extension, String contents) throws IOException {
        String filePath = String.format("src/target/%s/%s.%s", directory, fileName.replaceFirst("[.][^.]+$", ""), extension);
        File temp = new File(filePath);
        temp.createNewFile();

        FileWriter fw = new FileWriter(temp, false);
        fw.write(contents);
        fw.close();
    }
}
