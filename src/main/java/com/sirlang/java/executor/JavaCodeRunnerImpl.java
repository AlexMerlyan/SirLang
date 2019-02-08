package com.sirlang.java.executor;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;
import static com.sirlang.java.JavaConstants.*;

public class JavaCodeRunnerImpl implements JavaCodeRunner {

    @NotNull
    public ExecutionResult runCompiledCode(@NotNull File byteCodeFile) throws IOException, InterruptedException {
        final String jrePath = System.getProperty(JRE_PROPERTY);
        @NotNull final String javaPath = jrePath.replace(JRE_DIRECTORY, RUN_COMMAND);
        @NotNull final String fileNameWithoutExtension = byteCodeFile.getName().replace(BYTE_CODE_EXTENSION, StringUtils.EMPTY);
        @NotNull final String command = javaPath + fileNameWithoutExtension;
        final Process process = Runtime.getRuntime().exec(command);

        @NotNull final Scanner scanner = new Scanner(process.getInputStream());
        @NotNull final StringBuilder output = new StringBuilder();
        while(scanner.hasNextLine()) {
            output.append(scanner.nextLine()).append(LINE_SEPARATOR);
        }
        scanner.close();

        process.waitFor();
        return new ExecutionResult(output.toString());
    }
}
