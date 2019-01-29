package com.sirlang.java.compiler;

import java.io.File;
import java.io.IOException;

public interface CodeCompiler {
    String compileJavaFile(final File javaFile) throws InterruptedException, IOException;
}
