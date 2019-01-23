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

    private Compiler defaultCompiler = new DefaultCompiler();

    @Test
    public void shouldCompileSourceFileToJavaFile() throws IOException {
        File testFile = createTestFile(FILE_NAME, FILE_CONTENT);
        String compiledFilePath = defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
        String content = readContent(compiledFilePath);
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
        Scanner scanner = new Scanner(new File(filePath));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExtensionFileException() throws IOException {
        File testFile = createTestFile(FILE_NAME_INCORRECT_EXTENSION, FILE_CONTENT);
        defaultCompiler.compileSourceFile(testFile.getAbsolutePath());
    }
}
