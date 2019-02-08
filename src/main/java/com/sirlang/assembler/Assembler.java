package com.sirlang.assembler;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public interface Assembler {
    @NotNull File compileSourceFile(String sourcePath) throws IOException;
}
