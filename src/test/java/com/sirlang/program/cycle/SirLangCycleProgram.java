package com.sirlang.program.cycle;

import lombok.Getter;

import static com.sirlang.program.cycle.JavaCycleCode.PRINT_COUNTER_FIVE_TIMES_JAVA_CODE;
import static com.sirlang.program.cycle.JavaCycleCode.PRINT_HELLO_FIVE_TIMES_JAVA_CODE;
import static com.sirlang.program.cycle.JavaCycleCode.PRINT_HELLO_UNTIL_TRUE_CONDITION_JAVA_CODE;
import static com.sirlang.program.cycle.JavaCycleOutput.PRINT_COUNTER_FIVE_TIMES_OUTPUT;
import static com.sirlang.program.cycle.JavaCycleOutput.PRINT_HELLO_FIVE_TIMES_OUTPUT;
import static com.sirlang.program.cycle.JavaCycleOutput.PRINT_HELLO_UNTIL_TRUE_CONDITION_OUTPUT;
import static com.sirlang.program.cycle.SirLangCycle.PRINT_COUNTER_FIVE_TIMES;
import static com.sirlang.program.cycle.SirLangCycle.PRINT_HELLO_FIVE_TIMES;
import static com.sirlang.program.cycle.SirLangCycle.PRINT_HELLO_UNTIL_TRUE_CONDITION;

@Getter
public enum SirLangCycleProgram {

    PRINT_HELLO_FIVE_TIMES_PROGRAM(PRINT_HELLO_FIVE_TIMES, PRINT_HELLO_FIVE_TIMES_JAVA_CODE, PRINT_HELLO_FIVE_TIMES_OUTPUT),
    PRINT_COUNTER_FIVE_TIMES_PROGRAM(PRINT_COUNTER_FIVE_TIMES, PRINT_COUNTER_FIVE_TIMES_JAVA_CODE, PRINT_COUNTER_FIVE_TIMES_OUTPUT),
    PRINT_HELLO_UNTIL_TRUE_CONDITION_PROGRAM(PRINT_HELLO_UNTIL_TRUE_CONDITION, PRINT_HELLO_UNTIL_TRUE_CONDITION_JAVA_CODE, PRINT_HELLO_UNTIL_TRUE_CONDITION_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangCycleProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
