package com.sirlang.program.datatypes;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

public interface JavaDataTypeOutput {
    String PRINT_BOOLEAN_TRUE_OUTPUT = "true" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_FALSE_OUTPUT = "false" + LINE_SEPARATOR;
    String PRINT_DOUBLE_VALUE_OUTPUT = "2.2" + LINE_SEPARATOR;
    String PRINT_LONG_VALUE_OUTPUT = "28784723222" + LINE_SEPARATOR;
}
