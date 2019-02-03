package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class SplitState {
    private final int iteration;
    private final char currentChar;
    private final int lastCharIndex;

    private boolean isString;
    private int startIndex;
    private String operand;

    SplitState(final int iteration, final char currentChar, final int lastCharIndex, final boolean isString) {
        this.iteration = iteration;
        this.currentChar = currentChar;
        this.lastCharIndex = lastCharIndex;
        this.isString = isString;
    }
}
