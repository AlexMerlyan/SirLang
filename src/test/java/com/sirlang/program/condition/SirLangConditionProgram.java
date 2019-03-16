package com.sirlang.program.condition;

import lombok.Getter;

import static com.sirlang.program.condition.JavaConditionCode.*;
import static com.sirlang.program.condition.JavaConditionOutput.PRINT_IF_CONDITION_IS_TRUE_OUTPUT;
import static com.sirlang.program.condition.JavaConditionOutput.PRINT_IF_ELSE_CONDITION_OUTPUT;
import static com.sirlang.program.condition.JavaConditionOutput.SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_OUTPUT;
import static com.sirlang.program.condition.SirLangCondition.*;

@Getter
public enum SirLangConditionProgram {

    PRINT_IF_CONDITION_IS_TRUE_PROGRAM(PRINT_IF_CONDITION_IS_TRUE, PRINT_IF_CONDITION_IS_TRUE_JAVA_CODE, PRINT_IF_CONDITION_IS_TRUE_OUTPUT),
    SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_PROGRAM(SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE, SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_JAVA_CODE, SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_OUTPUT),
    PRINT_IF_CONDITION_EQUALS_IS_TRUE_PROGRAM(PRINT_IF_CONDITION_EQUALS_IS_TRUE, PRINT_IF_CONDITION_EQUALS_IS_TRUE_JAVA_CODE, PRINT_IF_CONDITION_IS_TRUE_OUTPUT),
    PRINT_IF_ELSE_IF_CONDITION_IS_TRUE_PROGRAM(PRINT_IF_ELSE_IF_CONDITION, PRINT_IF_ELSE_IF_CONDITION_JAVA_CODE, PRINT_IF_CONDITION_IS_TRUE_OUTPUT),
    PRINT_IF_ELSE_CONDITION_PROGRAM(PRINT_IF_ELSE_CONDITION, PRINT_IF_ELSE_CONDITION_JAVA_CODE, PRINT_IF_ELSE_CONDITION_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangConditionProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
