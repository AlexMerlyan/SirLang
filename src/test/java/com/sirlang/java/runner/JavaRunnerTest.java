package com.sirlang.java.runner;

import com.sirlang.AbstractTest;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sirlang.program.helloworld.JavaHelloWorldCode.HELLO_WORLD_JAVA_CODE;
import static com.sirlang.program.helloworld.JavaHelloWorldOutput.HELLO_WORLD_OUTPUT;

@Slf4j
public class JavaRunnerTest extends AbstractTest {

    private final JavaCodeCompiler codeCompiler = new JavaCodeCompilerImpl();
    private final JavaCodeRunner javaCodeRunner = new JavaCodeRunnerImpl();

    @Test
    public void shouldRunJavaFile() throws IOException, InterruptedException {
        @NotNull final File testFile = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_JAVA_CODE);
        @NotNull final File byteCodeFile = codeCompiler.compileJavaFile(testFile);
        @NotNull final ExecutionResult result = javaCodeRunner.runCompiledCode(byteCodeFile);
        final String consoleOutput = result.getConsoleOutput();
        Assert.assertEquals(HELLO_WORLD_OUTPUT, consoleOutput);
    }
}
