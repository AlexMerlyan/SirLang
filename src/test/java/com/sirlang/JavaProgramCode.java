package com.sirlang;

public interface JavaProgramCode {
    String HELLO_WORLD_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(\"Моя первая программа на языке Сударь!\");" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    String PRINT_BOOLEAN_TRUE_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(true);" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    String PRINT_BOOLEAN_FALSE_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(false);" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    String PRINT_DOUBLE_VALUE_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(2.2);" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    String PRINT_LONG_VALUE_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(28784723222L);" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();
}
