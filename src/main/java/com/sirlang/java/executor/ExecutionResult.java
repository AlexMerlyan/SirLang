package com.sirlang.java.executor;

import lombok.Getter;

@Getter
public class ExecutionResult {
    private final String consoleOutput;

    ExecutionResult(final String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }
}
