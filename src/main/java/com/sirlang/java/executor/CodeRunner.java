package com.sirlang.java.executor;

import java.io.IOException;

public interface CodeRunner {
    ExecutionResult runCompiledCode(String compiledFilePath) throws IOException, InterruptedException;
}
