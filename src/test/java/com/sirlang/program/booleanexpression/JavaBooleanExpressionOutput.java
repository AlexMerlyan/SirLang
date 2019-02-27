package com.sirlang.program.booleanexpression;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaBooleanExpressionOutput {
    String PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_OUTPUT = "false" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_EXPRESSION_MORE_SIGN_VAR_OUTPUT = "false" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_EXPRESSION_MORE_OR_EQUALS_SIGN_VAR_OUTPUT = "true" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_EXPRESSION_LESS_SIGN_VAR_OUTPUT = "true" + LINE_SEPARATOR;
    String PRINT_BOOLEAN_EXPRESSION_LESS_OR_EQUALS_SIGN_VAR_OUTPUT = "true" + LINE_SEPARATOR;
}
