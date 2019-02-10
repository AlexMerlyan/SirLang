package com.sirlang.program.expression;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaExpressionCode {

    String PRINT_LONG_PLUS_LONG_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(55+45);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MINUS_LONG_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(55-45);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MULTIPLY_LONG_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(5*8);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_DIVIDE_LONG_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6/2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_PLUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2+0.8);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_MINUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2-0.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_MULTIPLY_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(4.6*0.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_DIVIDE_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(2.2/2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_PLUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6+2.2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MINUS_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6-2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_MULTIPLY_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6*2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_DIVIDE_DOUBLE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "System.out.println(6/2.5);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
