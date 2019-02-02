package com.sirlang.assembler;

import lombok.Getter;

@Getter
public enum MathOperation {
    PLUS("+", "\\+", '+'),
    MINUS("-", "-", '-'),
    MULTIPLY("*", "\\*", '*'),
    DIVIDE("/", "/", '/');

    private final String operation;
    private final String screeningOperation;
    private final char charEquivalent;

    MathOperation(final String operation, final String screeningOperation, final char charEquivalent) {
        this.operation = operation;
        this.screeningOperation = screeningOperation;
        this.charEquivalent = charEquivalent;
    }
}
