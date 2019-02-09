package com.sirlang.program.vars;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

public interface JavaVarOutput {
    String HELLO_WORLD_WITH_STRING_VAR_OUTPUT = "Моя первая программа на языке Сударь!" + LINE_SEPARATOR;
    String PRINT_WITH_LONG_VAR_OUTPUT = "2019" + LINE_SEPARATOR;
    String PRINT_WITH_DOUBLE_WITH_COMMA_VAR_OUTPUT = "2019.1" + LINE_SEPARATOR;
    String PRINT_WITH_DOUBLE_WITH_POINT_VAR_OUTPUT = "2019.1" + LINE_SEPARATOR;
    String PRINT_WITH_BOOLEAN_VAR_OUTPUT = "true" + LINE_SEPARATOR;
    String PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_OUTPUT = "false" + LINE_SEPARATOR + 2019 + LINE_SEPARATOR
            + 2019.1 + LINE_SEPARATOR + "Моя строка" + LINE_SEPARATOR;
}
