package com.sirlang.java.runner;

import com.sirlang.AbstractCompilerTest;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
public class JavaCodeRunnerImplTest extends AbstractCompilerTest {

    private static final String EXPECTED_CONSOLE_OUTPUT = "Моя первая программа на языке Сударь!";

    private JavaCodeCompiler codeCompiler = new JavaCodeCompilerImpl();
    private JavaCodeRunner javaCodeRunner = new JavaCodeRunnerImpl();

    @Test
    public void shouldRunJavaFile() throws IOException, InterruptedException {
        final File testFile = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_PROGRAM_AFTER_COMPILE);
        final File byteCodeFile = codeCompiler.compileJavaFile(testFile);
        final ExecutionResult result = javaCodeRunner.runCompiledCode(byteCodeFile);
        final String consoleOutput = result.getConsoleOutput();
        Assert.assertEquals(EXPECTED_CONSOLE_OUTPUT, consoleOutput);
    }
}
