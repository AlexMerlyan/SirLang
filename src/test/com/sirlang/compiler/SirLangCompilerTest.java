package com.sirlang.compiler;

import com.sirlang.AbstractCompilerTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

@Slf4j
public class SirLangCompilerTest extends AbstractCompilerTest {

    private static final String SIR_FILE_NAME = "test_file.sir";
    private static final String FILE_NAME_INCORRECT_EXTENSION = "test_file.txt";
    private static final String FILE_CONTENT = "This is simple example of content";

    private static final String HELLO_WORLD_PROGRAM = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n" +
            "Спасибо вам! Всего хорошего!";

    private static final String PROGRAM_WITHOUT_START = "Сударь, будьте добры, выведите на экран это:" +
            "\"Моя первая программа на языке Сударь!\"\nСпасибо вам! Всего хорошего!";

    private static final String PROGRAM_WITHOUT_END = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n";

    private Compiler defaultCompiler = new SirLangCompiler();

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
    public void shouldThrowExtensionFileException() throws IOException {
        final File testFile = createTestFile(FILE_NAME_INCORRECT_EXTENSION, FILE_CONTENT);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileHelloWorldProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        final File compiledFile = defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFile);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentStartProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_START);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, PROGRAM_WITHOUT_END);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileToMainJavaFile() throws IOException {
        final File testFile = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        final File compiledFile = defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
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
