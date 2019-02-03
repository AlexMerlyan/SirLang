package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import static com.sirlang.assembler.error.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;

public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private MathOperationTranslator operationTranslator = new MathOperationTranslatorImpl();

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
        final Object parsedArgument;
        final String[] methodAndArgument = codeRow.split(COMMAND_SEPARATOR);
        final String argument = methodAndArgument[1].trim();
        if (operationTranslator.isString(argument)) {
            parsedArgument = argument;
        } else if(operationTranslator.isMathematicsExpression(argument)) {
            parsedArgument = operationTranslator.transformMathematicalOperations(argument);
        } else if (NumberUtils.isNumber(argument.replace(COMMA, POINT))) {
            if (argument.contains(POINT)) {
                parsedArgument = Double.valueOf(argument);
            } else if (argument.contains(COMMA)) {
                parsedArgument = Double.valueOf(argument.replace(COMMA, POINT));
            } else {
                parsedArgument = argument + LONG_POSTFIX;
            }
        } else {
            parsedArgument = operationTranslator.getBoolean(argument).orElseThrow(() -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE));
        }
        return parsedArgument;
    }

}
