package com.sirlang.program;

import lombok.Getter;

import static com.sirlang.program.helloworld.JavaHelloWorldCode.HELLO_WORLD_JAVA_CODE;
import static com.sirlang.program.helloworld.JavaHelloWorldOutput.HELLO_WORLD_OUTPUT;
import static com.sirlang.program.helloworld.SirLangHelloWorld.*;

@Getter
public enum SirLangHelloWorldProgram {

    HELLO_WORLD_PROGRAM(HELLO_WORLD, HELLO_WORLD_JAVA_CODE, HELLO_WORLD_OUTPUT),
    HELLO_WORLD_WITHOUT_COMMAS_PROGRAM(HELLO_WORLD_WITHOUT_COMMAS, HELLO_WORLD_JAVA_CODE, HELLO_WORLD_OUTPUT),
    HELLO_WORLD_WITHOUT_COMMAS_AND_LOWER_CASE_PROGRAM(HELLO_WORLD_WITHOUT_COMMAS_AND_LOWER_CASE, HELLO_WORLD_JAVA_CODE, HELLO_WORLD_OUTPUT);

    private final String sirLangProgram;
    private final String javaEquivalentProgram;
    private final String javaOutputConsole;

    SirLangHelloWorldProgram(final String sirLangProgram, final String javaEquivalentProgram, final String javaOutputConsole) {
        this.sirLangProgram = sirLangProgram;
        this.javaEquivalentProgram = javaEquivalentProgram;
        this.javaOutputConsole = javaOutputConsole;
    }

}
