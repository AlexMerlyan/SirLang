package com.sirlang.program.concatvars;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaConcatVarsOutput {
    String PRINT_STRING_VAR_PLUS_STRING_VAR_OUTPUT = "приветпока" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_PLUS_LONG_VAR_OUTPUT = "число моей даты рождения 27" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_PLUS_DOUBLE_VAR_OUTPUT = "число моей даты рождения 27.0" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_PLUS_BOOLEAN_TRUE_VAR_OUTPUT = "число моей даты рождения true" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_PLUS_BOOLEAN_FALSE_VAR_OUTPUT = "число моей даты рождения false" + LINE_SEPARATOR;
    String PRINT_LONG_VAR_PLUS_DOUBLE_VAR_OUTPUT = "4.5" + LINE_SEPARATOR;
    String PRINT_DOUBLE_WITH_COMMA_VAR_PLUS_DOUBLE_WITH_POINT_VAR_OUTPUT = "5.0" + LINE_SEPARATOR;
    String PRINT_LONG_VAR_PLUS_LONG_VAR_OUTPUT = "5" + LINE_SEPARATOR;
    String PRINT_LONG_VAR_PLUS_STRING_VAR_OUTPUT = "2тестовая строка" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_VAR_PLUS_STRING_VAR_OUTPUT = "trueтестовая строка" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_WITH_CONCAT_OUTPUT = "тестовая строка и еще одна тестовая строка" + LINE_SEPARATOR;
    String PRINT_DOUBLE_VAR_WITH_CONCAT_OUTPUT = "10.0" + LINE_SEPARATOR;
    String PRINT_STRING_VAR_INIT_BY_STRING_VAR_PLUS_STRING_VAR_OUTPUT = "значение строки 1значение строки 2" + LINE_SEPARATOR;
    String PRINT_DOUBLE_VAR_INIT_BY_DOUBLE_VAR_PLUS_LONG_VAR_OUTPUT = "3.2" + LINE_SEPARATOR;
}
