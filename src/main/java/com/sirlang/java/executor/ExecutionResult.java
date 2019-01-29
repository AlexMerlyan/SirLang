package com.sirlang.java.executor;

import lombok.Getter;

@Getter
public class ExecutionResult {
    private String consoleOutput;

    ExecutionResult(String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }
}
