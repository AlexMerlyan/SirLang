package com.sirlang.program.tasks;

import lombok.Getter;

import static com.sirlang.program.tasks.JavaTaskCode.FACTORIAL_JAVA_CODE;
import static com.sirlang.program.tasks.JavaTaskOutput.FACTORIAL_OUTPUT;
import static com.sirlang.program.tasks.SirLangTask.FACTORIAL;

@Getter
public enum SirLangTaskProgram {

    FACTORIAL_PROGRAM(FACTORIAL, FACTORIAL_JAVA_CODE, FACTORIAL_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangTaskProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }
}
