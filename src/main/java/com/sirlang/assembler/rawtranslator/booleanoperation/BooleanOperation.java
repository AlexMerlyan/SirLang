package com.sirlang.assembler.rawtranslator.booleanoperation;

import lombok.Getter;

@Getter
public enum BooleanOperation {

    EQUALS("=", "=="),
    GREATER_THEN(">", ">"),
    LESS_THEN("<", "<"),
    GREATER_THEN_OR_EQUALS(">=", ">="),
    LESS_THEN_OR_EQUALS("<=", "<=");

    private final String operationSign;
    private final String equivalentJavaSign;

    BooleanOperation(String operationSign, String equivalentJavaSign) {
        this.operationSign = operationSign;
        this.equivalentJavaSign = equivalentJavaSign;
    }

}
