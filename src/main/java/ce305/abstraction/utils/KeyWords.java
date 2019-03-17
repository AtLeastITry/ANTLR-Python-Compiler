package ce305.abstraction.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.DataType;

public class KeyWords {
    public static final String INTEGER = "int";
    public static final String FLOAT = "float";
    public static final String BOOL = "bool";
    public static final String VOID = "void";
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public static DataType getType(String input) {
        if (input.equals(INTEGER)) {
            return DataType.INTEGER;
        }

        if (input.equals(FLOAT)) {
            return DataType.FLOAT;
        }

        if (input.equals(BOOL)) {
            return DataType.BOOL;
        }

        if (input.equals(VOID)) {
            return DataType.VOID;
        }

        return null;
    }

    public static final boolean check(String input) {
        if (input == INTEGER || input == FLOAT || input == BOOL || input == VOID || input == TRUE || input == FALSE) {
            return true;
        }

        return false;
    }
}