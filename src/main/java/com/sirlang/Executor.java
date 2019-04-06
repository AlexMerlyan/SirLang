package com.sirlang;

import com.sirlang.java.executor.ExecutionResult;

import java.io.IOException;

public interface Executor {

    ExecutionResult execute(final String sirLangFilePath) throws IOException, InterruptedException;

    static Executor getInstance() {
        return new ExecutorImpl();
    }

}
