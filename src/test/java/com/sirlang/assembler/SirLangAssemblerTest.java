package com.sirlang.assembler;

import com.sirlang.AbstractTest;
import com.sirlang.program.booleanexpression.SirLangBooleanExpressionProgram;
import com.sirlang.program.concat.SirLangConcatProgram;
import com.sirlang.program.concatvars.SirLangConcatVarsProgram;
import com.sirlang.program.condition.SirLangConditionProgram;
import com.sirlang.program.cycle.SirLangCycleProgram;
import com.sirlang.program.datatypes.SirLangDataTypeProgram;
import com.sirlang.program.expression.SirLangExpressionProgram;
import com.sirlang.program.helloworld.SirLangHelloWorldProgram;
import com.sirlang.program.tasks.SirLangTaskProgram;
import com.sirlang.program.vars.SirLangVarsProgram;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.sirlang.program.IncorrectSirLangProgramCode.PROGRAM_WITHOUT_END;
import static com.sirlang.program.IncorrectSirLangProgramCode.PROGRAM_WITHOUT_START;
import static com.sirlang.program.helloworld.SirLangHelloWorld.HELLO_WORLD;

@Slf4j
@RunWith(DataProviderRunner.class)
public class SirLangAssemblerTest extends AbstractTest {

    private static final String SIR_FILE_NAME = "test_file.sir";
    private static final String FILE_NAME_INCORRECT_EXTENSION = "test_file.txt";
    private static final String FILE_CONTENT = "This is simple example of content";

    private final Assembler defaultAssembler = new SirLangAssembler();

    @After
    @Override
    public void removeTestFiles() {
        super.removeTestFiles();
        boolean isFileDeleted = new File(FILE_NAME_INCORRECT_EXTENSION).delete();
        if (isFileDeleted) {
            log.debug(LOG_FILE_WAS_DELETED, FILE_NAME_INCORRECT_EXTENSION);
        }
    }

    @Test
    @UseDataProvider("dataProvideSirLangHelloWorldProgram")
    public void shouldCompileSirLangHelloWorldProgram(SirLangHelloWorldProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangConcatProgram")
    public void shouldCompileSirLangConcatProgram(SirLangConcatProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangDataTypeProgram")
    public void shouldCompileSirLangDataTypeProgram(SirLangDataTypeProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangExpressionProgram")
    public void shouldCompileSirLangExpressionProgram(SirLangExpressionProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangVarsProgram")
    public void shouldCompileSirLangExpressionProgram(SirLangVarsProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangConcatVarsProgram")
    public void shouldCompileSirLangConcatVarsProgram(SirLangConcatVarsProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangBooleanExpressionProgram")
    public void shouldCompileSirLangBooleanExpressionProgram(SirLangBooleanExpressionProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangConditionProgram")
    public void shouldCompileSirLangConditionProgram(SirLangConditionProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangCycleProgram")
    public void shouldCompileSirLangCycleProgram(SirLangCycleProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    @Test
    @UseDataProvider("dataProvideSirLangTaskProgram")
    public void shouldCompileSirLangTaskProgram(SirLangTaskProgram program) throws IOException {
        compileAndAssertSirLangProgram(program.getSirLangProgram(), program.getJavaEquivalentProgram());
    }

    private void compileAndAssertSirLangProgram(String sirLangProgram, String javaEquivalentProgram) throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, sirLangProgram);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(javaEquivalentProgram, content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExtensionFileException() throws IOException {
        final File testFile = createTestFile(FILE_NAME_INCORRECT_EXTENSION, FILE_CONTENT);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentStartProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_START);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_END);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileToMainJavaFile() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        Assert.assertTrue(compiledFile.getPath().contains(COMPILED_FILE_NAME));
    }

    private String readContent(File file) throws FileNotFoundException {
        final Scanner scanner = new Scanner(file);
        final StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(System.lineSeparator());
        }
        scanner.close();
        return sb.toString();
    }
}
