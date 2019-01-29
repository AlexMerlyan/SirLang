package com.sirlang.java.compiler;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

import static com.sirlang.java.Constants.*;

public class JavaCodeCompiler implements CodeCompiler {

    @Override
    public String compileJavaFile(final File javaFile) throws InterruptedException, IOException {
        String jrePath = System.getProperty(JRE_PROPERTY);
        String javacPath = jrePath.replace(JRE_DIRECTORY, COMPILE_COMMAND);
        String command = javacPath + javaFile.getAbsolutePath();
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        return javaFile.getPath().replace(JAVA_EXTENSION, StringUtils.EMPTY);
    }
}
