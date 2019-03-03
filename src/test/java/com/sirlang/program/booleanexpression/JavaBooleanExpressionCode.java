package com.sirlang.program.booleanexpression;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaBooleanExpressionCode {

    String PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = 1+1==5;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_EXPRESSION_MORE_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = 1+1>5;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_EXPRESSION_MORE_OR_EQUALS_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = 1+1>=2;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_EXPRESSION_LESS_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = 1+1<5;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_EXPRESSION_LESS_OR_EQUALS_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = 1+1<=2;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_EXPRESSION_NOT_LESS_OR_EQUALS_SIGN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = !(1+1<=2);" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
