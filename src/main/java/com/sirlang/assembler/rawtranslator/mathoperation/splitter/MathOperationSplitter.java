package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import java.util.List;

public interface MathOperationSplitter {
    List<String> splitByCharOperation(final String argument, final char operationChar);
}
