package com.sirlang.systemtest;

import com.sirlang.AbstractTest;
import com.sirlang.SirLangProgram;
import com.sirlang.assembler.Assembler;
import com.sirlang.assembler.SirLangAssembler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@Slf4j
@RunWith(DataProviderRunner.class)
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
    @UseDataProvider("dataProvideSirLangProgram")
    public void shouldCompileHelloWorldProgram(SirLangProgram program) throws IOException, InterruptedException {
        log.debug("Start test with program: {}", program.getSirLangProgram());
        final File testFile = createTestFile(SIR_FILE_NAME, program.getSirLangProgram());
        final ExecutionResult executionResult = compileByFilePath(testFile.getAbsolutePath());
        Assert.assertEquals(program.getJavaOutputConsole(), executionResult.getConsoleOutput());
    }

}