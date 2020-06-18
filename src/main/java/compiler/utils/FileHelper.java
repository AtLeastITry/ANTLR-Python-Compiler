package compiler.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import compiler.abstraction.INode;
import compiler.abstraction.dependency.DependencyGraph;
import compiler.services.ASTService;

public class FileHelper {
    public static void generateDotFile(INode tree, String fileName) {
        Console.setColor(ConsoleColor.CYAN_BOLD);
        Console.writeLine();
        Console.writeLine("    START Compiling file to DOT");

        try {
            writeFile("dot", fileName, "dot", ASTService.compileToDot(tree), "");  
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

    public static void generateGraphFile(DependencyGraph dependencyGraph, String fileName) {
        try {
            writeFile("dot", fileName, "dot", dependencyGraph.buildGraph(), "_dependency_graph");   
        }
        catch(Exception e) {
            Console.setColor(ConsoleColor.RED_BOLD);
            Console.writeLine("Error:" + e.getMessage());
            Console.resetColor();
        }
    }

    public static String generatePythonFile(INode tree, String fileName) {
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

    private static void writeFile(String directory, String fileName, String extension, String contents, String afix) throws IOException {
        String filePath = String.format("src/output/%s/%s%s.%s", directory, fileName.replaceFirst("[.][^.]+$", ""),afix, extension);
        File temp = new File(filePath);
        temp.createNewFile();

        FileWriter fw = new FileWriter(temp, false);
        fw.write(contents);
        fw.close();
    }

    public static File[] getSourceFiles() {
        File folder = new File("src/source");
        return folder.listFiles();
    }

    public static void clearTargetFiles() {
        File folder = new File("src/output");
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
    }

    public static String readFile(Path path) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, StandardCharsets.UTF_8);
    }
}