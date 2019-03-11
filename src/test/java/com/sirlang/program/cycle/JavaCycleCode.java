package com.sirlang.program.cycle;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaCycleCode {

    String PRINT_HELLO_FIVE_TIMES_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "for (int i = 0; i < 5L; i++) {" + LINE_SEPARATOR +
            "System.out.println(\"Привет!\");" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
