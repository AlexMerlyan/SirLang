package com.sirlang.java.runner;

import com.sirlang.AbstractCompilerTest;
import com.sirlang.java.compiler.CodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.executor.CodeRunner;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
public class JavaCodeRunnerTest extends AbstractCompilerTest {

    private static final String EXPECTED_CONSOLE_OUTPUT = "Моя первая программа на языке Сударь!";

    private CodeCompiler codeCompiler = new JavaCodeCompiler();
    private CodeRunner codeRunner = new JavaCodeRunner();

    @Test
    public void shouldRunJavaFile() throws IOException, InterruptedException {
        final File testFile = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_PROGRAM_AFTER_COMPILE);
        final String byteCodeFilePath = codeCompiler.compileJavaFile(testFile);
        final ExecutionResult result = codeRunner.runCompiledCode(byteCodeFilePath);
        final String consoleOutput = result.getConsoleOutput();
        Assert.assertEquals(EXPECTED_CONSOLE_OUTPUT, consoleOutput);
    }
}
