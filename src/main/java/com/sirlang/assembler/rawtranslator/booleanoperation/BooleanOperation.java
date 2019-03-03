package com.sirlang.assembler.rawtranslator.booleanoperation;

import lombok.Getter;

@Getter
public enum BooleanOperation {

    EQUALS("=", "=="),
    GREATER_THEN_OR_EQUALS(">=", ">="),
    LESS_THEN_OR_EQUALS("<=", "<="),
    GREATER_THEN(">", ">"),
    LESS_THEN("<", "<"),
    NOT("не ", "!");

    private final String operationSign;
    private final String equivalentJavaSign;

    BooleanOperation(String operationSign, String equivalentJavaSign) {
        this.operationSign = operationSign;
        this.equivalentJavaSign = equivalentJavaSign;
    }

}
