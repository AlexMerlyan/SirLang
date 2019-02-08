package com.sirlang.java.executor;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public interface JavaCodeRunner {
    @NotNull ExecutionResult runCompiledCode(File byteCodeFile) throws IOException, InterruptedException;
}
