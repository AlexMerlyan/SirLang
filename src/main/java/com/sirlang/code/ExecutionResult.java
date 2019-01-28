package com.sirlang.code;

import lombok.Getter;

@Getter
public class ExecutionResult {
    private String consoleOutput;

    public ExecutionResult(String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }
}
