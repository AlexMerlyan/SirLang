package com.sirlang.java.runner;

import com.sirlang.AbstractTest;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sirlang.JavaConsoleOutput.HELLO_WORLD_PROGRAM_OUTPUT;
import static com.sirlang.JavaProgramCode.HELLO_WORLD_PROGRAM_AFTER_COMPILE;

@Slf4j
public class JavaRunnerTest extends AbstractTest {

    private JavaCodeCompiler codeCompiler = new JavaCodeCompilerImpl();
    private JavaCodeRunner javaCodeRunner = new JavaCodeRunnerImpl();

    @Test
    public void shouldRunJavaFile() throws IOException, InterruptedException {
        final File testFile = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_PROGRAM_AFTER_COMPILE);
        final File byteCodeFile = codeCompiler.compileJavaFile(testFile);
        final ExecutionResult result = javaCodeRunner.runCompiledCode(byteCodeFile);
        final String consoleOutput = result.getConsoleOutput();
        Assert.assertEquals(HELLO_WORLD_PROGRAM_OUTPUT, consoleOutput);
    }
}