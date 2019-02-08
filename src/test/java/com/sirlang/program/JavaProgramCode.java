package com.sirlang.program;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

public interface JavaProgramCode {

    String PRINT_LONG_PLUS_LONG_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(55+45);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MINUS_LONG_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(55-45);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MULTIPLY_LONG_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(5*8);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_DIVIDE_LONG_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6/2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_PLUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2+0.8);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_MINUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2-0.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_MULTIPLY_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(4.6*0.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_DIVIDE_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2/2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_PLUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MINUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6-2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MULTIPLY_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6*2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_DIVIDE_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6/2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_TRUE_PLUS_STRING_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(true+\" это моя строка\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_BOOLEAN_FALSE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \"+false);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"СТРОКА С ЧИСЛАМИ = \"+6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_PLUS_LONG_STRING_PLUS_LONG_PLUS_DOUBLE_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2+2+\"СТРОКА + С + 1,1 + ЧИСЛАМИ = \"+6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_PLUS_IN_END_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \" + 555 + \"Тестовая строка+\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_MINUS_IN_END_PROGRAM_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \" + 555 + \"Тестовая строка-\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String HELLO_WORLD_PROGRAM_WITH_STRING_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"Моя первая программа на языке Сударь!\";" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_PROGRAM_WITH_LONG_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 2019L;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_PROGRAM_WITH_DOUBLE_WITH_COMMA_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2019.1;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_PROGRAM_WITH_DOUBLE_WITH_POINT_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2019.1;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_PROGRAM_WITH_BOOLEAN_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = true;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_PROGRAM_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_AFTER_COMPILE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = false;" + LINE_SEPARATOR +
            "Long var1 = 2019L;" + LINE_SEPARATOR +
            "Double var2 = 2019.1;" + LINE_SEPARATOR +
            "String var3 = \"Моя строка\";" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "System.out.println(var1);" + LINE_SEPARATOR +
            "System.out.println(var2);" + LINE_SEPARATOR +
            "System.out.println(var3);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
