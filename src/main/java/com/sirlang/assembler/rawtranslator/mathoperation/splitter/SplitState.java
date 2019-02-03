package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class SplitState {
    private final int lastCharIndex;

    private boolean isString;
    private char currentChar;
    private int iteration;
    private int startIndex;
    private String operand;

    SplitState(final int lastCharIndex) {
        this.lastCharIndex = lastCharIndex;
    }

    void inverseIsStringBooleanField() {
        isString = !isString;
    }

    boolean isNotString() {
        return !isString;
    }

}
