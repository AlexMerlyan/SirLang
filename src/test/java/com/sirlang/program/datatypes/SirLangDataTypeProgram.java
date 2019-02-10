package com.sirlang.program.datatypes;

import lombok.Getter;

import static com.sirlang.program.datatypes.JavaDataTypeCode.*;
import static com.sirlang.program.datatypes.JavaDataTypeOutput.*;
import static com.sirlang.program.datatypes.SirLangDataType.*;

@Getter
public enum SirLangDataTypeProgram {

    PRINT_BOOLEAN_TRUE_PROGRAM(PRINT_BOOLEAN_TRUE, PRINT_BOOLEAN_TRUE_JAVA_CODE, PRINT_BOOLEAN_TRUE_OUTPUT),
    PRINT_BOOLEAN_TRUE_ANOTHER_PROGRAM(PRINT_BOOLEAN_TRUE_ANOTHER, PRINT_BOOLEAN_TRUE_JAVA_CODE, PRINT_BOOLEAN_TRUE_OUTPUT),
    PRINT_BOOLEAN_FALSE_PROGRAM(PRINT_BOOLEAN_FALSE, PRINT_BOOLEAN_FALSE_JAVA_CODE, PRINT_BOOLEAN_FALSE_OUTPUT),
    PRINT_BOOLEAN_FALSE_SECOND_VERSION_PROGRAM(PRINT_BOOLEAN_FALSE_SECOND_VERSION, PRINT_BOOLEAN_FALSE_JAVA_CODE, PRINT_BOOLEAN_FALSE_OUTPUT),
    PRINT_BOOLEAN_FALSE_THIRD_VERSION_PROGRAM(PRINT_BOOLEAN_FALSE_THIRD_VERSION, PRINT_BOOLEAN_FALSE_JAVA_CODE, PRINT_BOOLEAN_FALSE_OUTPUT),

    PRINT_DOUBLE_VALUE_PROGRAM(PRINT_DOUBLE_VALUE, PRINT_DOUBLE_VALUE_JAVA_CODE, PRINT_DOUBLE_VALUE_OUTPUT),
    PRINT_DOUBLE_VALUE_ANOTHER_PROGRAM(PRINT_DOUBLE_VALUE_ANOTHER, PRINT_DOUBLE_VALUE_JAVA_CODE, PRINT_DOUBLE_VALUE_OUTPUT),

    PRINT_LONG_VALUE_PROGRAM(PRINT_LONG_VALUE, PRINT_LONG_VALUE_JAVA_CODE, PRINT_LONG_VALUE_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangDataTypeProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
