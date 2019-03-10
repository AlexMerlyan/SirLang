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

}
