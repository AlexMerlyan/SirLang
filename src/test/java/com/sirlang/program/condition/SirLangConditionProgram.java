package com.sirlang.program.condition;

import lombok.Getter;

import static com.sirlang.program.condition.JavaConditionCode.PRINT_IF_CONDITION_IS_TRUE_JAVA_CODE;
import static com.sirlang.program.condition.JavaConditionOutput.PRINT_IF_CONDITION_IS_TRUE_OUTPUT;
import static com.sirlang.program.condition.SirLangCondition.PRINT_IF_CONDITION_IS_TRUE;

@Getter
public enum SirLangConditionProgram {

    PRINT_IF_CONDITION_IS_TRUE_PROGRAM(PRINT_IF_CONDITION_IS_TRUE, PRINT_IF_CONDITION_IS_TRUE_JAVA_CODE, PRINT_IF_CONDITION_IS_TRUE_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangConditionProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
