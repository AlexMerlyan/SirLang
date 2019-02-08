package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MathOperationSplitter {
    @NotNull List<String> splitByCharOperation(final String argument, final char operationChar);
}
