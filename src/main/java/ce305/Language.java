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
import ce305.services.ASTResult;
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
                ASTResult result = buildAST(contents);
                if (result.tree == null) {
                    Console.setColor(ConsoleColor.GREEN_BOLD);
                    Console.writeLine("Failed " + file.getName());
                    continue;
                }
                visualize(result.tree);
                compileToDot(result, file.getName());
                compileToPython(result.tree, file.getName());

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
            writeFile("python", fileName, "py", result, "");
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

    private static void compileToDot(ASTResult result, String fileName) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine();
        Console.writeLine("    START Compiling file to DOT");

        try {
            writeFile("dot", fileName, "dot", ASTService.compileToDot(result.tree), "");  
            writeFile("dot", fileName, "dot", result.dependencyGraph.buildGraph(), "_dependency_graph");     
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
    }

    private static ASTResult buildAST(String content) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine("    START Building AST");
        ASTResult result = null;
        try
        {
            result = ASTService.compileToAST(content);
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

        return result;
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
        File folder = new File("src/output");
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

    private static void writeFile(String directory, String fileName, String extension, String contents, String afix) throws IOException {
        String filePath = String.format("src/output/%s/%s%s.%s", directory, fileName.replaceFirst("[.][^.]+$", ""),afix, extension);
        File temp = new File(filePath);
        temp.createNewFile();

        FileWriter fw = new FileWriter(temp, false);
        fw.write(contents);
        fw.close();
    }
}
