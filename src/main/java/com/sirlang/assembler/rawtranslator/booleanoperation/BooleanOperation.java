package com.sirlang.assembler.rawtranslator.booleanoperation;

import lombok.Getter;

@Getter
public enum BooleanOperation {

    EQUALS("=", "=="),
    GREATER_THEN_OR_EQUALS(">=", ">="),
    LESS_THEN_OR_EQUALS("<=", "<="),
    GREATER_THEN(">", ">"),
    LESS_THEN("<", "<"),
    NOT("не(", "!(", "не\\("),
    AND(" и ", "&&", "и"),
    OR(" или ", "||", "или");

    private final String operationSign;
    private final String equivalentJavaSign;
    private final String operationRegexSign;

    BooleanOperation(String operationSign, String equivalentJavaSign) {
        this(operationSign, equivalentJavaSign, operationSign);
    }

    BooleanOperation(String operationSign, String equivalentJavaSign, String operationRegexSign) {
        this.operationSign = operationSign;
        this.equivalentJavaSign = equivalentJavaSign;
        this.operationRegexSign = operationRegexSign;
    }
}
