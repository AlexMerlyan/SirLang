package com.sirlang.assembler.rawtranslator.booleanoperation;

import com.sirlang.assembler.rawtranslator.symbols.Symbols;

import static com.sirlang.assembler.rawtranslator.booleanoperation.BooleanOperation.NOT;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.*;

public class BooleanOperationTranslatorImpl implements BooleanOperationTranslator {

    @Override
    public boolean isBooleanExpression(final String argument) {
        if (doesNotContainString(argument)) {
            for (BooleanOperation operation : BooleanOperation.values()) {
                if (containsIgnoreCase(argument, operation.getOperationSign())) {
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
        result = replaceSingleEqualsSign(result);
        return result.replaceAll(NOT.getOperationSign(), NOT.getEquivalentJavaSign());
    }

    private String replaceSingleEqualsSign(final String expression) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == CHAR_EQUALS) {
                char previousChar = expression.charAt(i - 1);
                if (previousChar == CHAR_MORE || previousChar == CHAR_LESS) {
                    sb.append(CHAR_EQUALS);
                } else {
                    sb.append(CHAR_EQUALS).append(CHAR_EQUALS);
                }
            } else {
                sb.append(expression.charAt(i));
            }
        }
        return sb.toString();
    }

}
