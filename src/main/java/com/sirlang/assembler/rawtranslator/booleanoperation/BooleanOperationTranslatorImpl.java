package com.sirlang.assembler.rawtranslator.booleanoperation;

import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.symbols.Symbols;

import static com.sirlang.assembler.rawtranslator.booleanoperation.BooleanOperation.NOT;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.contains;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

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
        return replaceNotOperation(result);
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

    private String replaceNotOperation(final String expression) {
        final StringBuilder sb = new StringBuilder();
        int closeBracketCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            final char currentChar = expression.charAt(i);
            if (currentChar == Symbols.RUSSIAN_LOWER_N || currentChar == RUSSIAN_UPPER_N) {
                if (i + 1 < expression.length()) {
                    final char nextChar = expression.charAt(i + 1);
                    if (nextChar == RUSSIAN_LOWER_E || nextChar == RUSSIAN_UPPER_E) {
                        if (i + 2 < expression.length()) {
                            final char afterNextChar = expression.charAt(i + 2);
                            if (afterNextChar == CHAR_SPACE) {
                                i++;
                                sb.append(NOT.getEquivalentJavaSign());
                                sb.append(OPEN_BRACKET);
                                closeBracketCount++;
                                continue;
                            }
                        }
                    }
                }
            }
            sb.append(currentChar);
        }
        for (int i = 0; i < closeBracketCount; i++) {
            sb.append(CLOSE_BRACKET);
        }
        return sb.toString();
    }

}
