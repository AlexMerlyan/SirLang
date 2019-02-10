package com.sirlang.program.concat;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaConcatOutput {
    String PRINT_BOOLEAN_TRUE_PLUS_STRING_OUTPUT = "true это моя строка" + LINE_SEPARATOR;
    String PRINT_STRING_PLUS_BOOLEAN_FALSE_OUTPUT = "Это моя строка false" + LINE_SEPARATOR;
    String PRINT_STRING_PLUS_LONG_PLUS_DOUBLE_OUTPUT = "СТРОКА С ЧИСЛАМИ = 62.2" + LINE_SEPARATOR;
    String PRINT_LONG_PLUS_LONG_STRING_PLUS_LONG_PLUS_DOUBLE_OUTPUT = "4СТРОКА + С + 1,1 + ЧИСЛАМИ = 62.2" + LINE_SEPARATOR;
    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_PLUS_IN_END_OUTPUT = "Это моя строка 555Тестовая строка+" + LINE_SEPARATOR;
    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_MINUS_IN_END_OUTPUT = "Это моя строка 555Тестовая строка-" + LINE_SEPARATOR;
}
