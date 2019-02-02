package com.sirlang.assembler;

class Symbols {
    static final String LINE_SEPARATOR = System.lineSeparator();
    static final String COMMAND_SEPARATOR = ":";
    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";
    static final String SCREENING_PLUS = "\\+";
    static final String QUOTE = "\"";
    static final String POINT = ".";
    static final String COMMA = ",";
    static final String LONG_POSTFIX = "L";

    public static void main(String[] args) {
        System.out.println("СТРОКА С ЧИСЛАМИ = " + 6 + 2.2);
        System.out.println(2 + 2 + "СТРОКА С ЧИСЛАМИ = " + 6 + 2.2);
    }
}
