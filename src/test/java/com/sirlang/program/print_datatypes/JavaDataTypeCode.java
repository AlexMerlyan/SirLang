package com.sirlang.program.print_datatypes;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

public interface JavaDataTypeCode {

    String PRINT_BOOLEAN_TRUE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(true);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_FALSE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(false);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_VALUE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_VALUE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(28784723222L);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
