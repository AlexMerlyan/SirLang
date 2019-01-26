package compiler;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Scanner;

public class DefaultCompiler implements Compiler {
    private static final String FILE_EXTENSION_ERROR_MESSAGE = "The source file should be with .sir extension!";
    private static final String START_PROGRAM_ABSENT_ERROR_MESSAGE = "The source code should contains end of program!";
    private static final String END_PROGRAM_ABSENT_ERROR_MESSAGE = "The source code should contains end of program!";

    private static final String SOURCE_FILE_EXTENSION = ".sir";
    private static final String COMPILED_FILE_EXTENSION = ".java";

    private static final String START_PROGRAM = "Приветствую!";
    private static final String END_PROGRAM = "Спасибо вам! Всего хорошего!";

    public String compileSourceFile(String sourcePath) throws IOException {
        Preconditions.checkArgument(sourcePath.contains(SOURCE_FILE_EXTENSION), FILE_EXTENSION_ERROR_MESSAGE);
        String sourceCode = readSourceFile(sourcePath);
        String javaFilePath = sourcePath.replace(SOURCE_FILE_EXTENSION, COMPILED_FILE_EXTENSION);
        File javaFile = compileToJava(javaFilePath, sourceCode);
        return javaFile.getAbsolutePath();
    }

    private String readSourceFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

    private File compileToJava(String javaFilePath, String sourceCode) throws IOException {
        Preconditions.checkArgument(!StringUtils.contains(sourceCode, START_PROGRAM), START_PROGRAM_ABSENT_ERROR_MESSAGE);
        Preconditions.checkArgument(!StringUtils.contains(sourceCode, END_PROGRAM), END_PROGRAM_ABSENT_ERROR_MESSAGE);
        return writeJavaFile(javaFilePath, sourceCode);
    }

    private File writeJavaFile(String javaFilePath, String javaCode) throws IOException {
        File file = new File(javaFilePath);
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        br.write(javaCode);
        br.close();
        return file;
    }

}
