package com.sirlang.program.cycle;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaCycleCode {

    String PRINT_HELLO_FIVE_TIMES_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "for (int i1 = 0; i1 < 5L; i1++) {" + LINE_SEPARATOR +
            "System.out.println(\"Привет!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_COUNTER_FIVE_TIMES_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "for (int i1 = 0; i1 < 5L; i1++) {" + LINE_SEPARATOR +
            "System.out.println(i1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_HELLO_UNTIL_TRUE_CONDITION_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 0L;" + LINE_SEPARATOR +
            "for (int i1 = 0; var0 < 3; i1++) {" + LINE_SEPARATOR +
            "var0 = var0 + 1;" + LINE_SEPARATOR +
            "System.out.println(\"Привет!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
