package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslatorImpl;
import com.sirlang.assembler.rawtranslator.variable.SirLangVariable;
import org.apache.commons.lang3.StringUtils;

import static com.sirlang.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private final MathOperationTranslator operationTranslator = new MathOperationTranslatorImpl();

    public String transformToJava(String codeRow) {
        if (StringUtils.isNotEmpty(codeRow)) {
            final String formattedCodeRow = codeRow.replaceAll(COMMA, StringUtils.EMPTY).toLowerCase();
            for (Command command : Command.values()) {
                if (formattedCodeRow.contains(command.getSirCommand())) {
                    if (command.isContainAdditionalCommand()) {
                        getSirVariable(codeRow, command);
                    }
                    return String.format(command.getJavaCommand(), getArgument(codeRow)) + LINE_SEPARATOR;
                }
            }
        }
        return StringUtils.EMPTY;
    }

    private SirLangVariable getSirVariable(final String codeRow, final Command command) {
        final String formattedCodeRow = codeRow.replaceAll(COMMA, StringUtils.EMPTY).toLowerCase();
        final String notTrimVarName = formattedCodeRow.split(COMMAND_SEPARATOR)[0];
        final String name = notTrimVarName.trim();

        final String commandAndNameValuePair = codeRow.replace(command.getSirCommand(), StringUtils.EMPTY);
        final String notTrimValue = commandAndNameValuePair.split(COMMAND_SEPARATOR)[1];
        final String value = notTrimValue.trim();
        final Class type = getValueType(value);

        return new SirLangVariable(name, value, type);
    }

    private Class getValueType(final String value) {
        final Class type;
        if (operationTranslator.isString(value)) {
            type = String.class;
        } else if (isNumber(value)) {
            Object parsedNumber = getParsedNumber(value);
            type = parsedNumber.getClass();
        } else {
            type = Boolean.class;
        }
        return type;
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
