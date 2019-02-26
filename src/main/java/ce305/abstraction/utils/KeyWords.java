package ce305.abstraction.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ce305.abstraction.DataType;

public class KeyWords {
    public static final String INTEGER = "int";
    public static final String DECIMAL = "decimal";

    public static DataType getType(String input) {
        if (input.equals(INTEGER)) {
            return DataType.INTEGER;
        }

        if (input.equals(DECIMAL)) {
            return DataType.INTEGER;
        }

        return null;
    }

    public static final boolean check(String input) {
        Pattern p = Pattern.compile(String.format("(%s|%s)", KeyWords.INTEGER, KeyWords.DECIMAL));
        Matcher m = p.matcher(input);
        return m.find();
    }
}