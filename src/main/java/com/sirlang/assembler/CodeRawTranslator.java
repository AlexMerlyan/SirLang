package com.sirlang.assembler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import static com.sirlang.assembler.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.Symbols.*;

class CodeRawTranslator {

    String transformToJava(String codeRow) {
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
        if (argument.startsWith(QUOTE) && argument.endsWith(QUOTE)) {
            parsedArgument = argument;
        } else if (NumberUtils.isNumber(argument.replace(COMMA, POINT))) {
            if (argument.contains(POINT)) {
                parsedArgument = Double.valueOf(argument);
            } else if (argument.contains(COMMA)) {
                parsedArgument = Double.valueOf(argument.replace(COMMA, POINT));
            } else {
                parsedArgument = argument + LONG_POSTFIX;
            }
        } else {
            parsedArgument = getBoolean(argument);
        }
        return parsedArgument;
    }

    private Boolean getBoolean(final String argument) {
        for (final BooleanKeyword keyword : BooleanKeyword.values()) {
            for (final String keywordVariant : keyword.getKeywords()) {
                if (StringUtils.equalsIgnoreCase(argument, keywordVariant)) {
                    if (keyword == BooleanKeyword.BOOLEAN_TRUE) {
                        return Boolean.TRUE;
                    } else {
                        return Boolean.FALSE;
                    }
                }
            }
        }
        throw new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE);
    }

}
