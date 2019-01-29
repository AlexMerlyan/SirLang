package com.sirlang.compiler;

import java.io.IOException;

public interface Compiler {
    String compileSourceFile(String sourcePath) throws IOException;
}
