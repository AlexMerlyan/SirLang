package com.sirlang.assembler;

import com.google.common.base.Preconditions;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Scanner;

import static com.sirlang.assembler.ErrorMessages.*;
import static com.sirlang.assembler.Symbols.LINE_SEPARATOR;
import static com.sirlang.java.JavaConstants.COMPILED_FILE_NAME;

public class SirLangAssembler implements Assembler {

    private static final String SOURCE_FILE_EXTENSION = ".sir";

    private static final String START_PROGRAM = "Приветствую!";
    private static final String END_PROGRAM = "Спасибо вам! Всего хорошего!";

    private static final String JAVA_START_PROGRAM_EQUIVALENT = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR;

    private static final String JAVA_END_PROGRAM_EQUIVALENT = "}" + LINE_SEPARATOR + "}";

    private final CodeRawTranslator rawTranslator = new CodeRawTranslator();

    public File compileSourceFile(@NonNull final String sourcePath) throws IOException {
        Preconditions.checkArgument(sourcePath.contains(SOURCE_FILE_EXTENSION), FILE_EXTENSION_ERROR_MESSAGE);
        final String sourceCode = readSourceFile(sourcePath);
        final int startFileNameIndex = sourcePath.lastIndexOf("/") + 1;
        final String fileNameWithExtension = sourcePath.substring(startFileNameIndex);
        final String javaFilePath = sourcePath.replace(fileNameWithExtension, COMPILED_FILE_NAME);
        return compileToJava(javaFilePath, sourceCode);
    }

    private String readSourceFile(@NonNull final String path) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File(path));
        final StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append(LINE_SEPARATOR);
        }
        scanner.close();
        return sb.toString();
    }

    private File compileToJava(@NonNull final String javaFilePath, @NonNull final String sourceCode) throws IOException {
        final char[] javaSourceCode = convertToJava(sourceCode);
        return writeJavaFile(javaFilePath, javaSourceCode);
    }

    private File writeJavaFile(@NonNull final String javaFilePath, @NonNull final char[] javaSourceCode) throws IOException {
        final File file = new File(javaFilePath);
        final BufferedWriter br = new BufferedWriter(new FileWriter(file));
        for (char symbol : javaSourceCode) {
            br.write(symbol);
        }
        br.close();
        return file;
    }

    private char[] convertToJava(@NonNull final String sourceCode) {
        checkOnErrors(sourceCode);
        final String methodMainBodyCode = getSourceCodeForMethodMain(sourceCode);
        final String methodMainBodyJavaCode = compileToBodyMethodMain(methodMainBodyCode);
        final String javaCode = JAVA_START_PROGRAM_EQUIVALENT + methodMainBodyJavaCode + JAVA_END_PROGRAM_EQUIVALENT;
        return javaCode.toCharArray();
    }

    private String getSourceCodeForMethodMain(@NonNull final String sourceCode) {
        final String[] codeRows = sourceCode.split(LINE_SEPARATOR);
        final String startProgramCode = getStartProgramToReplace(codeRows);
        final String endProgramCode = getEndProgramToReplace(codeRows);
        return sourceCode.replace(startProgramCode, StringUtils.EMPTY).replace(endProgramCode, StringUtils.EMPTY);
    }

    private String getStartProgramToReplace(final String[] codeRows) {
        for (final String codeRow : codeRows) {
            if (StringUtils.equalsIgnoreCase(codeRow, START_PROGRAM)) {
                return codeRow;
            }
        }
        throw new IllegalArgumentException(START_PROGRAM_ABSENT_ERROR_MESSAGE);
    }

    private String getEndProgramToReplace(final String[] codeRows) {
        for (int i = codeRows.length - 1; i >= 0; i--) {
            if (StringUtils.equalsIgnoreCase(codeRows[i], END_PROGRAM)) {
                return codeRows[i];
            }
        }
        throw new IllegalArgumentException(END_PROGRAM_ABSENT_ERROR_MESSAGE);
    }

    private String compileToBodyMethodMain(@NonNull final String methodMainBodyCode) {
        final StringBuilder sb = new StringBuilder();
        final String[] codeRows = methodMainBodyCode.split(LINE_SEPARATOR);
        for (String codeRow : codeRows) {
            sb.append(rawTranslator.transformToJava(codeRow));
        }
        return sb.toString();
    }

    private void checkOnErrors(@NonNull final String sourceCode) {
        final boolean isStartProgramExists = StringUtils.containsIgnoreCase(sourceCode, START_PROGRAM);
        Preconditions.checkArgument(isStartProgramExists, START_PROGRAM_ABSENT_ERROR_MESSAGE);

        final boolean isEndProgramExists = StringUtils.containsIgnoreCase(sourceCode, END_PROGRAM);
        Preconditions.checkArgument(isEndProgramExists, END_PROGRAM_ABSENT_ERROR_MESSAGE);
    }

}
