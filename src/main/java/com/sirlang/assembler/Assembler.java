package com.sirlang.assembler;

import java.io.File;
import java.io.IOException;

public interface Assembler {
    File compileSourceFile(String sourcePath) throws IOException;
}
