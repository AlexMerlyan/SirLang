package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslatorImpl;
import org.apache.commons.lang3.StringUtils;

import static com.sirlang.assembler.error.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private final MathOperationTranslator operationTranslator = new MathOperationTranslatorImpl();

    public String transformToJava(String codeRow) {
        if (StringUtils.isNotEmpty(codeRow)) {
            final String formattedCodeRow = codeRow.replaceAll(COMMA, StringUtils.EMPTY).toLowerCase();
            for (Command command : Command.values()) {
                if (formattedCodeRow.contains(command.getSirCommand())) {
                    return String.format(command.getJavaCommand(), getArgument(codeRow)) + LINE_SEPARATOR;
                }
            }
        }
        return StringUtils.EMPTY;
    }

    private Object getArgument(final String codeRow) {
        final String[] methodAndArgument = codeRow.split(COMMAND_SEPARATOR);
        final String formattedArgument = methodAndArgument[1].trim();
        return getParsedArgument(formattedArgument);
    }

    private Object getParsedArgument(String formattedArgument) {
        Object parsedArgument;
        if (operationTranslator.isString(formattedArgument)) {
            parsedArgument = formattedArgument;
        } else if(operationTranslator.isMathematicsExpression(formattedArgument)) {
            parsedArgument = operationTranslator.transformMathematicalOperations(formattedArgument);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            parsedArgument = getParsedNumber(formattedArgument);
        } else {
            parsedArgument = operationTranslator.getBoolean(formattedArgument).orElseThrow(() -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE));
        }
        return parsedArgument;
    }

    private Object getParsedNumber(String formattedArgument) {
        Object parsedArgument;
        if (formattedArgument.contains(POINT)) {
            parsedArgument = Double.valueOf(formattedArgument);
        } else if (formattedArgument.contains(COMMA)) {
            parsedArgument = Double.valueOf(formattedArgument.replace(COMMA, POINT));
        } else {
            parsedArgument = formattedArgument + LONG_POSTFIX;
        }
        return parsedArgument;
    }

}
