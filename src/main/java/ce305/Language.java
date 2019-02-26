package ce305;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import ce305.abstraction.INode;
import ce305.services.ASTService;

/**
 * Hello world!
 *
 */
public class Language {
    public static void main(String[] args) {        
        try {
            for (File file : getSourceFiles()) {
                String contents = readFile(file.toPath());
                INode tree = ASTService.CompileToAST(contents);
                String python = ASTService.CompileToPython(tree);
                System.out.print(python);
                System.in.read();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static File[] getSourceFiles() {
        File folder = new File("src/source");
        return folder.listFiles();
    }

    private static String readFile(Path path) throws IOException 
    {
        byte[] encoded = Files.readAllBytes(path);
        return new String(encoded, StandardCharsets.UTF_8);
    }
}
