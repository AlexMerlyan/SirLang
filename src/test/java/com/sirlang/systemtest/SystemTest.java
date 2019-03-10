package com.sirlang.systemtest;

import com.sirlang.AbstractTest;
import com.sirlang.assembler.Assembler;
import com.sirlang.assembler.SirLangAssembler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import com.sirlang.program.booleanexpression.SirLangBooleanExpressionProgram;
import com.sirlang.program.concat.SirLangConcatProgram;
import com.sirlang.program.concatvars.SirLangConcatVarsProgram;
import com.sirlang.program.datatypes.SirLangDataTypeProgram;
import com.sirlang.program.expression.SirLangExpressionProgram;
import com.sirlang.program.helloworld.SirLangHelloWorldProgram;
import com.sirlang.program.vars.SirLangVarsProgram;
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


    private ExecutionResult compileByFilePath(final String sirLangFilePath)
            throws IOException, InterruptedException {
        final File javaFile = ASSEMBLER.compileSourceFile(sirLangFilePath);
        final File byteCodeFile = JAVA_CODE_COMPILER.compileJavaFile(javaFile);
        return JAVA_CODE_RUNNER.runCompiledCode(byteCodeFile);
    }

    @Test
    @UseDataProvider("dataProvideSirLangHelloWorldProgram")
    public void shouldCompileSirLangHelloWorldProgram(SirLangHelloWorldProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangConcatProgram")
    public void shouldCompileSirLangConcatProgram(SirLangConcatProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangDataTypeProgram")
    public void shouldCompileSirLangDataTypeProgram(SirLangDataTypeProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangExpressionProgram")
    public void shouldCompileSirLangExpressionProgram(SirLangExpressionProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangVarsProgram")
    public void shouldCompileSirLangExpressionProgram(final SirLangVarsProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangConcatVarsProgram")
    public void shouldCompileSirLangConcatVarsProgram(final SirLangConcatVarsProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    @Test
    @UseDataProvider("dataProvideSirLangBooleanExpressionProgram")
    public void shouldCompileSirLangBooleanExpressionProgram(final SirLangBooleanExpressionProgram program)
            throws IOException, InterruptedException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaOutputConsole());
    }

    private void compileAndAssertSirLangProgram(final String sirLangProgram, final String javaOutputConsole)
            throws IOException, InterruptedException {
        final File testFile = createTestFile(SIR_FILE_NAME, sirLangProgram);
        final ExecutionResult executionResult = compileByFilePath(testFile.getAbsolutePath());
        Assert.assertEquals(javaOutputConsole, executionResult.getConsoleOutput());
    }

}
