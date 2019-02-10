package com.sirlang.java.executor;

import java.io.File;
import java.io.IOException;

public interface JavaCodeRunner {
    ExecutionResult runCompiledCode(File byteCodeFile) throws IOException, InterruptedException;
}
