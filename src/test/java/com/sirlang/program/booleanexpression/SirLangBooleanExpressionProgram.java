package com.sirlang.program.booleanexpression;

import lombok.Getter;

import static com.sirlang.program.booleanexpression.JavaBooleanExpressionCode.PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_JAVA_CODE;
import static com.sirlang.program.booleanexpression.JavaBooleanExpressionOutput.PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_OUTPUT;
import static com.sirlang.program.booleanexpression.SirLangBooleanExpression.PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR;

@Getter
public enum SirLangBooleanExpressionProgram {

    PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_PROGRAM(PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR, PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_JAVA_CODE, PRINT_BOOLEAN_EXPRESSION_EQUALS_SIGN_VAR_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangBooleanExpressionProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
