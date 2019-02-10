package com.sirlang.java.compiler;

import java.io.File;
import java.io.IOException;

import static com.sirlang.java.JavaConstants.*;

public class JavaCodeCompilerImpl implements JavaCodeCompiler {


    @Override
    public File compileJavaFile(final File javaFile) throws InterruptedException, IOException {
        final String jrePath = System.getProperty(JRE_PROPERTY);
        final String javacPath = jrePath.replace(JRE_DIRECTORY, COMPILE_COMMAND);
        final String command = javacPath + javaFile.getAbsolutePath();
        final Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        final String byteCodeFilePath = javaFile.getPath().replace(JAVA_EXTENSION, BYTE_CODE_EXTENSION);
        return new File(byteCodeFilePath);
    }
}
