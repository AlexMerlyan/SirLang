package com.sirlang.assembler.rawtranslator.booleanoperation;

public interface BooleanOperationTranslator {

    boolean isBooleanExpression(final String argument);

    String transformBooleanOperations(final String expression);

}
