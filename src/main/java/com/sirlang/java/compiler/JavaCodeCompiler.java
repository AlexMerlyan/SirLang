package com.sirlang.java.compiler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public interface JavaCodeCompiler {
    @NotNull File compileJavaFile(final File javaFile) throws InterruptedException, IOException;
}
