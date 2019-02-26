package ce305.abstraction.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.DataType;

public class KeyWords {
    public static final String INTEGER = "int";
    public static final String FLOAT = "float";

    public static DataType getType(String input) {
        if (input.equals(INTEGER)) {
            return DataType.INTEGER;
        }

        if (input.equals(FLOAT)) {
            return DataType.FLOAT;
        }

        return null;
    }

    public static final boolean check(String input) {
        Pattern p = Pattern.compile(String.format("(%s|%s)", INTEGER, FLOAT));
        Matcher m = p.matcher(input);
        return m.find();
    }
}