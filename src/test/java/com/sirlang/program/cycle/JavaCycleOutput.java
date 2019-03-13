package com.sirlang.program.cycle;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaCycleOutput {
    String PRINT_HELLO_FIVE_TIMES_OUTPUT = "Привет!" + LINE_SEPARATOR + "Привет!" + LINE_SEPARATOR +
            "Привет!" + LINE_SEPARATOR + "Привет!" + LINE_SEPARATOR + "Привет!" + LINE_SEPARATOR;
    String PRINT_COUNTER_FIVE_TIMES_OUTPUT = "0" + LINE_SEPARATOR + "1" + LINE_SEPARATOR + "2" + LINE_SEPARATOR +
            "3" + LINE_SEPARATOR + "4" + LINE_SEPARATOR;
}
