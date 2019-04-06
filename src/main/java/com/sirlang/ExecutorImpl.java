package com.sirlang;

import com.sirlang.assembler.Assembler;
import com.sirlang.assembler.SirLangAssembler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;

import java.io.File;
import java.io.IOException;

public class ExecutorImpl implements Executor {

    private static final JavaCodeCompiler JAVA_CODE_COMPILER = new JavaCodeCompilerImpl();
    private static final JavaCodeRunner JAVA_CODE_RUNNER = new JavaCodeRunnerImpl();

    public ExecutionResult execute(final String sirLangFilePath) throws IOException, InterruptedException {
        final Assembler assembler = new SirLangAssembler();
        final File javaFile = assembler.compileSourceFile(sirLangFilePath);
        final File byteCodeFile = JAVA_CODE_COMPILER.compileJavaFile(javaFile);
        return JAVA_CODE_RUNNER.runCompiledCode(byteCodeFile);
    }

}
