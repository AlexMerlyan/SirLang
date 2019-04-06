package com.sirlang.program.tasks;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaTaskCode {

    String FACTORIAL_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 1L;" + LINE_SEPARATOR +
            "for (int i1 = 0; i1 < 4L; i1++) {" + LINE_SEPARATOR +
            "var0 = var0 * (i1 + 1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
