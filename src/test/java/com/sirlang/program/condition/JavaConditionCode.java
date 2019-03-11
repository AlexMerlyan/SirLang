package com.sirlang.program.condition;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaConditionCode {

    String PRINT_IF_CONDITION_IS_TRUE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "if (true) {" + LINE_SEPARATOR +
            "System.out.println(\"Условие верно!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "if (1<0) {" + LINE_SEPARATOR +
            "System.out.println(\"Условие верно!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_IF_CONDITION_EQUALS_IS_TRUE_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "if (1==1) {" + LINE_SEPARATOR +
            "System.out.println(\"Условие верно!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_IF_ELSE_IF_CONDITION_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "if (true) {" + LINE_SEPARATOR +
            "System.out.println(\"Условие верно!\");" + LINE_SEPARATOR +
            "} else if (true) {" + LINE_SEPARATOR +
            "System.out.println(\"Второе условие верно!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_IF_ELSE_CONDITION_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "if (false) {" + LINE_SEPARATOR +
            "System.out.println(\"Условие верно!\");" + LINE_SEPARATOR +
            "} else {" + LINE_SEPARATOR +
            "System.out.println(\"Второе условие верно!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
