package com.sirlang.java.compiler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

import static com.sirlang.java.JavaConstants.*;

public class JavaCodeCompilerImpl implements JavaCodeCompiler {

    @NotNull
    @Override
    public File compileJavaFile(@NotNull final File javaFile) throws InterruptedException, IOException {
        final String jrePath = System.getProperty(JRE_PROPERTY);
        @NotNull final String javacPath = jrePath.replace(JRE_DIRECTORY, COMPILE_COMMAND);
        @NotNull final String command = javacPath + javaFile.getAbsolutePath();
        final Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        @NotNull final String byteCodeFilePath = javaFile.getPath().replace(JAVA_EXTENSION, BYTE_CODE_EXTENSION);
        return new File(byteCodeFilePath);
    }
}
