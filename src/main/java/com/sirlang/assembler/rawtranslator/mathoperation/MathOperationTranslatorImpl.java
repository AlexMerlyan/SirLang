package com.sirlang.assembler.rawtranslator.mathoperation;

import com.sirlang.assembler.rawtranslator.datatype.BooleanKeyword;
import com.sirlang.assembler.rawtranslator.mathoperation.splitter.MathOperationSplitter;
import com.sirlang.assembler.rawtranslator.mathoperation.splitter.MathOperationSplitterImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;
import java.util.Optional;

import static com.sirlang.assembler.rawtranslator.mathoperation.MathOperation.*;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;

public class MathOperationTranslatorImpl implements MathOperationTranslator {

    private MathOperationSplitter splitter = new MathOperationSplitterImpl();

    @Override
    public String transformMathematicalOperations(final String argument) {
        String transformedArg = argument;
        for (MathOperation operation : MathOperation.values()) {
            transformedArg = transformMathematicalOperation(transformedArg, operation);
        }
        return transformedArg;
    }

    private String transformMathematicalOperation(final String argument, final MathOperation operation) {
        final String result;
        if (PLUS == operation) {
            result = transformPlusOperation(argument);
        } else {
            result = transformOtherMathematicalOperation(argument, operation);
        }
        return result;
    }

    private String transformPlusOperation(final String argument) {
        final List<String> arguments = splitter.splitByCharOperation(argument, PLUS.getCharEquivalent());
        final StringBuilder sb = new StringBuilder();
        boolean isNotLastArg;
        int lastArgumentsIndex = arguments.size() - 1;
        for (int i = 0; i < arguments.size(); i++) {
            final String arg = arguments.get(i).trim();
            if (isString(arg)) {
                sb.append(arg);
            } else if (NumberUtils.isNumber(arg.replace(COMMA, POINT))) {
                sb.append(arg.replace(COMMA, POINT));
            } else if (getBoolean(arg).isPresent()) {
                sb.append(getBoolean(arg).get());
            } else if (isMathematicsExpression(arg)) {
                sb.append(arg);
            }
            isNotLastArg = (i != lastArgumentsIndex);
            if (isNotLastArg && StringUtils.isNotEmpty(arg)) {
                sb.append(PLUS.getOperation());
            }
        }
        return sb.toString();
    }

    private String transformOtherMathematicalOperation(final String argument, final MathOperation operation) {
        final List<String> arguments = splitter.splitByCharOperation(argument, operation.getCharEquivalent());
        final StringBuilder sb = new StringBuilder();
        final int lastArgumentsIndex = arguments.size() - 1;
        for (int i = 0; i < arguments.size(); i++) {
            final String arg = arguments.get(i);
            sb.append(transformArgumentForOtherMathOperation(arg));
            if (hasNextIterationElement(i, lastArgumentsIndex) && isNotString(arg)) {
                final String nextElement = arguments.get(i + 1);
                if (isNotString(nextElement)) {
                    sb.append(operation.getOperation());
                }
            }
        }
        return sb.toString();
    }

    private String transformArgumentForOtherMathOperation(final String argument) {
        final String trimArg = argument.trim();
        return isString(trimArg) ? trimArg : trimArg.replace(COMMA, POINT);
    }

    private boolean hasNextIterationElement(final int i, final int lastArgumentIndex) {
        return lastArgumentIndex >= i + 1;
    }

    @Override
    public boolean isString(final String argument) {
        return argument.startsWith(QUOTE) && argument.endsWith(QUOTE);
    }

    @Override
    public boolean isNotString(final String argument) {
        return !isString(argument);
    }

    @Override
    public boolean isMathematicsExpression(final String argument) {
        return argument.contains(PLUS.getOperation())
                || argument.contains(MINUS.getOperation())
                || argument.contains(MULTIPLY.getOperation())
                || argument.contains(DIVIDE.getOperation());
    }

    @Override
    public Optional<Boolean> getBoolean(final String argument) {
        for (final BooleanKeyword keyword : BooleanKeyword.values()) {
            for (final String keywordVariant : keyword.getKeywords()) {
                if (StringUtils.equalsIgnoreCase(argument, keywordVariant)) {
                    if (keyword == BooleanKeyword.BOOLEAN_TRUE) {
                        return Optional.of(Boolean.TRUE);
                    } else {
                        return Optional.of(Boolean.FALSE);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
