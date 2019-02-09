package com.sirlang.program.concat;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

public interface JavaConcatCode {

    String PRINT_BOOLEAN_TRUE_PLUS_STRING_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(true+\" это моя строка\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_BOOLEAN_FALSE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \"+false);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"СТРОКА С ЧИСЛАМИ = \"+6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_PLUS_LONG_STRING_PLUS_LONG_PLUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2+2+\"СТРОКА + С + 1,1 + ЧИСЛАМИ = \"+6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_PLUS_IN_END_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \" + 555 + \"Тестовая строка+\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_MINUS_IN_END_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(\"Это моя строка \" + 555 + \"Тестовая строка-\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
