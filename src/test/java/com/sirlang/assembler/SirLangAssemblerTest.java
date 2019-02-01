package com.sirlang.assembler;

import com.sirlang.AbstractTest;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Scanner;

import static com.sirlang.SirLangPrograms.*;

@Slf4j
@RunWith(DataProviderRunner.class)
public class SirLangAssemblerTest extends AbstractTest {

    private static final String SIR_FILE_NAME = "test_file.sir";
    private static final String FILE_NAME_INCORRECT_EXTENSION = "test_file.txt";
    private static final String FILE_CONTENT = "This is simple example of content";

    private Assembler defaultAssembler = new SirLangAssembler();

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
    @UseDataProvider("dataProviderHelloWorldProgram")
    public void shouldCompileHelloWorldProgram(String helloWorldProgram) throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, helloWorldProgram);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @DataProvider
    public static Object[][] dataProviderHelloWorldProgram() {
        return new Object[][] {
                {HELLO_WORLD_PROGRAM},
                {HELLO_WORLD_PROGRAM_WITHOUT_COMMAS},
                {HELLO_WORLD_PROGRAM_WITHOUT_COMMAS_AND_LOWER_CASE},
        };
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
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileToMainJavaFile() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
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
