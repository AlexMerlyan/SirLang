package com.sirlang.program.vars;

import lombok.Getter;

import static com.sirlang.program.vars.JavaVarCode.*;
import static com.sirlang.program.vars.JavaVarOutput.*;
import static com.sirlang.program.vars.SirLangVar.*;

@Getter
public enum SirLangVarsProgram {

    HELLO_WORLD_WITH_STRING_VAR_PROGRAM(HELLO_WORLD_WITH_STRING_VAR, HELLO_WORLD_WITH_STRING_VAR_JAVA_CODE, HELLO_WORLD_WITH_STRING_VAR_OUTPUT),
    PRINT_WITH_LONG_VAR_PROGRAM(PRINT_WITH_LONG_VAR, PRINT_WITH_LONG_VAR_JAVA_CODE, PRINT_WITH_LONG_VAR_OUTPUT),
    PRINT_WITH_DOUBLE_WITH_COMMA_VAR_PROGRAM(PRINT_WITH_DOUBLE_WITH_COMMA_VAR, PRINT_WITH_DOUBLE_WITH_COMMA_VAR_JAVA_CODE, PRINT_WITH_DOUBLE_WITH_COMMA_VAR_OUTPUT),
    PRINT_WITH_DOUBLE_WITH_POINT_VAR_PROGRAM(PRINT_WITH_DOUBLE_WITH_POINT_VAR, PRINT_WITH_DOUBLE_WITH_POINT_VAR_JAVA_CODE, PRINT_WITH_DOUBLE_WITH_POINT_VAR_OUTPUT),
    PRINT_WITH_BOOLEAN_VAR_PROGRAM(PRINT_WITH_BOOLEAN_VAR, PRINT_WITH_BOOLEAN_VAR_JAVA_CODE, PRINT_WITH_BOOLEAN_VAR_OUTPUT),
    PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_PROGRAM(PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR, PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_JAVA_CODE, PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangVarsProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }
}
