package com.sirlang.java.executor;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;
import static com.sirlang.java.JavaConstants.*;

public class JavaCodeRunnerImpl implements JavaCodeRunner {

    public ExecutionResult runCompiledCode(File byteCodeFile) throws IOException, InterruptedException {
        final String jrePath = System.getProperty(JRE_PROPERTY);
        final String javaPath = jrePath.replace(JRE_DIRECTORY, RUN_COMMAND);
        final String fileNameWithoutExtension = byteCodeFile.getName().replace(BYTE_CODE_EXTENSION, StringUtils.EMPTY);
        final String command = javaPath + fileNameWithoutExtension;
        final Process process = Runtime.getRuntime().exec(command);

        final Scanner scanner = new Scanner(process.getInputStream());
        final StringBuilder output = new StringBuilder();
        while (scanner.hasNextLine()) {
            output.append(scanner.nextLine()).append(LINE_SEPARATOR);
        }
        scanner.close();

        process.waitFor();
        return new ExecutionResult(output.toString());
    }

}
