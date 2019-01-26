package compiler;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class DefaultCompilerTest {

    private static final String FILE_NAME = "test_file.sir";
    private static final String FILE_NAME_INCORRECT_EXTENSION = "test_file.txt";
    private static final String FILE_CONTENT = "This is simple example of content";

    private static final String HELLO_WORLD_PROGRAM = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n" +
            "Спасибо вам! Всего хорошего!";

    private static final String PROGRAM_WITHOUT_START = "Сударь, будьте добры, выведите на экран это:" +
            "\"Моя первая программа на языке Сударь!\"\nСпасибо вам! Всего хорошего!";

    private static final String PROGRAM_WITHOUT_END = "Приветствую!\n" +
            "\tСударь, будьте добры, выведите на экран это:\"Моя первая программа на языке Сударь!\"\n";

    private static final String HELLO_WORLD_PROGRAM_AFTER_COMPILE = "public class Main {\n" +
            "    public static void main(String[] args) {\n" +
            "        System.out.println(\"Моя первая программа на языке Сударь!\");\n" +
            "    }\n" +
            "}";

    private Compiler defaultCompiler = new DefaultCompiler();

    @Test
    public void shouldCompileSourceFileToJavaFile() throws IOException {
        final File testFile = createTestFile(FILE_NAME, FILE_CONTENT);
        final String compiledFilePath = defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFilePath);
        Assert.assertTrue(StringUtils.isNotEmpty(content));
    }

    private File createTestFile(String fileName, String content) throws IOException {
        File testFile = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        return testFile;
    }

    private String readContent(String filePath) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File(filePath));
        final StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExtensionFileException() throws IOException {
        final File testFile = createTestFile(FILE_NAME_INCORRECT_EXTENSION, FILE_CONTENT);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldCompileHelloWorldProgram() throws IOException {
        final File testFile = createTestFile(FILE_NAME, HELLO_WORLD_PROGRAM);
        final String compiledFilePath = defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
        final String content = readContent(compiledFilePath);
        Assert.assertEquals(HELLO_WORLD_PROGRAM_AFTER_COMPILE, content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentStartProgram() throws IOException {
        final File testFile = createTestFile(FILE_NAME, PROGRAM_WITHOUT_START);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(FILE_NAME, PROGRAM_WITHOUT_END);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowExceptionAbsentEndProgram() throws IOException {
        final File testFile = createTestFile(FILE_NAME, HELLO_WORLD_PROGRAM);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }
}
