package compiler.utils;

public class Console {
    private static String _color;

    public Console() {
        _color = ConsoleColor.RESET;
    }

    public static void setColor(String color) {
        _color = color;
    }

    public static void resetColor() {
        _color = ConsoleColor.RESET;
    }

    public static void writeLine(String message) {
        System.out.println(_color + message);
    }

    public static void writeLine() {
        System.out.println();
    }

    public static void write(String message) {
        System.out.print(_color + message);
    }
}