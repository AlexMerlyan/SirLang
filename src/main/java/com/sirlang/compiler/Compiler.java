package com.sirlang.compiler;

import java.io.File;
import java.io.IOException;

public interface Compiler {
    File compileSourceFile(String sourcePath) throws IOException;
}
