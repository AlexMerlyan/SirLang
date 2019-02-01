package com.sirlang.system_test;

import com.sirlang.AbstractTest;
import com.sirlang.assembler.Assembler;
import com.sirlang.assembler.SirLangAssembler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sirlang.SirLangPrograms.HELLO_WORLD_PROGRAM;

public class SystemTest extends AbstractTest {

    private static final Assembler ASSEMBLER = new SirLangAssembler();
    private static final JavaCodeCompiler JAVA_CODE_COMPILER = new JavaCodeCompilerImpl();
    private static final JavaCodeRunner JAVA_CODE_RUNNER = new JavaCodeRunnerImpl();

    private ExecutionResult compileByFilePath(final String sirLangFilePath) throws IOException, InterruptedException {
        final File javaFile = ASSEMBLER.compileSourceFile(sirLangFilePath);
        final File byteCodeFile = JAVA_CODE_COMPILER.compileJavaFile(javaFile);
        return JAVA_CODE_RUNNER.runCompiledCode(byteCodeFile);
    }

    @Test
    public void shouldCompileHelloWorldProgramTest() throws IOException, InterruptedException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        final ExecutionResult executionResult = compileByFilePath(testFile.getAbsolutePath());
        Assert.assertEquals(EXPECTED_CONSOLE_OUTPUT, executionResult.getConsoleOutput());
    }
}
