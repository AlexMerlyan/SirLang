package com.sirlang.program.cycle;

import lombok.Getter;

import static com.sirlang.program.cycle.JavaCycleCode.PRINT_HELLO_FIVE_TIMES_JAVA_CODE;
import static com.sirlang.program.cycle.JavaCycleOutput.PRINT_HELLO_FIVE_TIMES_OUTPUT;
import static com.sirlang.program.cycle.SirLangCycle.PRINT_HELLO_FIVE_TIMES;

@Getter
public enum SirLangCycleProgram {

    PRINT_HELLO_FIVE_TIMES_PROGRAM(PRINT_HELLO_FIVE_TIMES, PRINT_HELLO_FIVE_TIMES_JAVA_CODE, PRINT_HELLO_FIVE_TIMES_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangCycleProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
