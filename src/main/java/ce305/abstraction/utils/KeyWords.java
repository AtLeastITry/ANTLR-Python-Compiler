package ce305.abstraction.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWords {
    public static final String INTEGER = "INTEGER";
    public static final String DECIMAL = "DECIMAL";

    public static final boolean check(String input) {
        Pattern p = Pattern.compile(String.format("(%|%)", KeyWords.INTEGER, KeyWords.DECIMAL));
        Matcher m = p.matcher(input);
        return m.find();
    }
}