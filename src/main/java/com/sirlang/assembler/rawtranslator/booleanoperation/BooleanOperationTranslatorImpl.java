package com.sirlang.assembler.rawtranslator.booleanoperation;

import com.sirlang.assembler.rawtranslator.symbols.Symbols;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.contains;

public class BooleanOperationTranslatorImpl implements BooleanOperationTranslator {

    @Override
    public boolean isBooleanExpression(final String argument) {
        if (doesNotContainString(argument)) {
            for (BooleanOperation operation : BooleanOperation.values()) {
                if (contains(argument, operation.getOperationSign())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean doesNotContainString(final String arg) {
        return !contains(arg, Symbols.QUOTE);
    }

    @Override
    public String transformBooleanOperations(final String expression) {
        String result = expression.replaceAll(Symbols.SPACE, EMPTY);
        for (BooleanOperation operation : BooleanOperation.values()) {
            result = result.replaceAll(operation.getOperationSign(), operation.getEquivalentJavaSign());
        }
        return result;
    }

}
