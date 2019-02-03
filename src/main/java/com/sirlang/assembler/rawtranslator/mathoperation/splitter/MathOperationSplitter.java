package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import com.sirlang.assembler.rawtranslator.mathoperation.MathOperation;

import java.util.List;

public interface MathOperationSplitter {
    List<String> splitByCharOperation(final String argument, final char operationChar);
    List<String> splitByCharOperation(final String argument, final MathOperation mathOperation);
}
