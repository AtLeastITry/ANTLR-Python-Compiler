package ce305;

import ce305.implementation.errors.DuplicateDefinitionException;
import ce305.implementation.errors.IncorrectDataType;
import ce305.implementation.errors.UndefinedVariableException;
import ce305.services.ASTService;

/**
 * Hello world!
 *
 */
public class Language {
    public static void main(String[] args) {
        String test = "1 + 1";
        try {
            ASTService.CompileToAST(test);
        } catch(Exception e) {
            
        }
    }
}
