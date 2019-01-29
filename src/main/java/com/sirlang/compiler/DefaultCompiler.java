package com.sirlang.compiler;

import com.google.common.base.Preconditions;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Scanner;

public class DefaultCompiler implements Compiler {
    private static final String FILE_EXTENSION_ERROR_MESSAGE = "The source file should be with .sir extension!";
    private static final String START_PROGRAM_ABSENT_ERROR_MESSAGE = "The source com.sirlang.java should contains start of program!";
    private static final String END_PROGRAM_ABSENT_ERROR_MESSAGE = "The source com.sirlang.java should contains end of program!";

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String COMMAND_SEPARATOR = ":";
    private static final String QUOTE = "\"";
    private static final String POINT = ".";

    private static final String SOURCE_FILE_EXTENSION = ".sir";
    private static final String COMPILED_FILE_NAME = "Main.java";

    private static final String START_PROGRAM = "Приветствую!";
    private static final String END_PROGRAM = "Спасибо вам! Всего хорошего!";

    private static final String JAVA_START_PROGRAM_EQUIVALENT = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR;

    private static final String JAVA_END_PROGRAM_EQUIVALENT = "}" + LINE_SEPARATOR + "}";

    public String compileSourceFile(@NonNull String sourcePath) throws IOException {
        Preconditions.checkArgument(sourcePath.contains(SOURCE_FILE_EXTENSION), FILE_EXTENSION_ERROR_MESSAGE);
        final String sourceCode = readSourceFile(sourcePath);
        final int startFileNameIndex = sourcePath.lastIndexOf("/") + 1;
        final String fileNameWithExtension = sourcePath.substring(startFileNameIndex);
        final String javaFilePath = sourcePath.replace(fileNameWithExtension, COMPILED_FILE_NAME);
        final File javaFile = compileToJava(javaFilePath, sourceCode);
        return javaFile.getAbsolutePath();
    }

    private String readSourceFile(@NonNull String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        scanner.close();
        return sb.toString();
    }

    private File compileToJava(@NonNull String javaFilePath, @NonNull String sourceCode) throws IOException {
        final char[] javaSourceCode = convertToJava(sourceCode);
        return writeJavaFile(javaFilePath, javaSourceCode);
    }

    private File writeJavaFile(@NonNull String javaFilePath, @NonNull char[] javaSourceCode) throws IOException {
        File file = new File(javaFilePath);
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
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

    private String getSourceCodeForMethodMain(@NonNull String sourceCode) {
        return sourceCode.replace(START_PROGRAM, StringUtils.EMPTY).replace(END_PROGRAM, StringUtils.EMPTY);
    }

    private String compileToBodyMethodMain(@NonNull final String methodMainBodyCode) {
        final StringBuilder sb = new StringBuilder();
        final String[] codeRows = methodMainBodyCode.split(LINE_SEPARATOR);
        for (String codeRow : codeRows) {
            for (Command command : Command.values()) {
                if (StringUtils.isNotEmpty(codeRow)) {
                    if (codeRow.contains(command.getSirCommand())) {
                        final String javaCodeRow = String.format(command.getJavaCommand(), getArgument(codeRow)) + LINE_SEPARATOR;
                        sb.append(javaCodeRow);
                    }
                }
            }
        }

        return sb.toString();
    }

    private void checkOnErrors(@NonNull String sourceCode) {
        final boolean isStartProgramExists = StringUtils.contains(sourceCode, START_PROGRAM);
        Preconditions.checkArgument(isStartProgramExists, START_PROGRAM_ABSENT_ERROR_MESSAGE);

        final boolean isEndProgramExists = StringUtils.contains(sourceCode, END_PROGRAM);
        Preconditions.checkArgument(isEndProgramExists, END_PROGRAM_ABSENT_ERROR_MESSAGE);
    }

    private Object getArgument(String codeRow) {
        Object argument;
        String[] methodAndArgument = codeRow.split(COMMAND_SEPARATOR);
        final String argumentRow = methodAndArgument[1];
        if (argumentRow.startsWith(QUOTE) && argumentRow.endsWith(QUOTE)) {
            argument = argumentRow;
        } else if (argumentRow.contains(POINT)) {
            argument = Double.valueOf(argumentRow);
        } else {
            argument = Long.valueOf(argumentRow);
        }
        return argument;
    }

}
