package com.sirlang.java.compiler;

import java.io.File;
import java.io.IOException;

public interface JavaCodeCompiler {
    File compileJavaFile(final File javaFile) throws InterruptedException, IOException;
}
