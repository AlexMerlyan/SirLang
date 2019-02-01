package com.sirlang.assembler;

import com.sirlang.AbstractAssemblerTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

@Slf4j
public class SirLangAssemblerTest extends AbstractAssemblerTest {

    private static final String SIR_FILE_NAME = "test_file.sir";
    private static final String FILE_NAME_INCORRECT_EXTENSION = "test_file.txt";
    private static final String FILE_CONTENT = "This is simple example of content";

    private static final String HELLO_WORLD_PROGRAM = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n" +
            "Спасибо вам! Всего хорошего!";

    private static final String HELLO_WORLD_PROGRAM_WITHOUT_COMMAS = "Приветствую!\n" +
            "\tСударь будьте добры выведите на экран это:\"Моя первая программа на языке Сударь!\"\n" +
            "Спасибо вам! Всего хорошего!";

    private static final String HELLO_WORLD_PROGRAM_WITHOUT_COMMAS_AND_LOWER_CASE = "приветствую!\n" +
            "\tсударь будьте добры выведите на экран это:\"Моя первая программа на языке Сударь!\"\n" +
            "спасибо вам! всего хорошего!";

    private static final String PROGRAM_WITHOUT_START = "Сударь, будьте добры, выведите на экран это:" +
            "\"Моя первая программа на языке Сударь!\"\nСпасибо вам! Всего хорошего!";

    private static final String PROGRAM_WITHOUT_END = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n";

    private Assembler defaultAssembler = new SirLangAssembler();

    @After
    @Override
    public void removeTestFiles() {
        super.removeTestFiles();
        boolean isFileDeleted = new File(SIR_FILE_NAME).delete();
        if (isFileDeleted) {
            log.info(LOG_FILE_WAS_DELETED, SIR_FILE_NAME);
        }
        isFileDeleted = new File(FILE_NAME_INCORRECT_EXTENSION).delete();
        if (isFileDeleted) {
            log.info(LOG_FILE_WAS_DELETED, FILE_NAME_INCORRECT_EXTENSION);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExtensionFileExceptionTest() throws IOException {
        final File testFile = createTestFile(FILE_NAME_INCORRECT_EXTENSION, FILE_CONTENT);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileHelloWorldProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @Test
    public void shouldCompileHelloWorldWithoutCommasProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM_WITHOUT_COMMAS);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @Test
    public void shouldCompileHelloWorldWithoutCommasAndLowerCaseProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM_WITHOUT_COMMAS_AND_LOWER_CASE);
        final File compiledFile = defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentStartProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_START);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentEndProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_END);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowExceptionAbsentEndProgramTest() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        defaultAssembler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileToMainJavaFileTest() throws IOException {
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
