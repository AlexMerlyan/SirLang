package com.sirlang.assembler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Optional;

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
        } else if(isPlusOperation(argument)) {
            parsedArgument = calculatePlusOperation(argument);
        } else if (NumberUtils.isNumber(argument.replace(COMMA, POINT))) {
            if (argument.contains(POINT)) {
                parsedArgument = Double.valueOf(argument);
            } else if (argument.contains(COMMA)) {
                parsedArgument = Double.valueOf(argument.replace(COMMA, POINT));
            } else {
                parsedArgument = argument + LONG_POSTFIX;
            }
        } else {
            parsedArgument = getBoolean(argument).orElseThrow(() -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE));
        }
        return parsedArgument;
    }

    private boolean isPlusOperation(final String argument) {
        return argument.contains(PLUS);
    }

    private boolean isMathemathicOperation(final String argument) {
        return argument.contains(PLUS) || argument.contains(MINUS) || argument.contains(MULTIPLY) || argument.contains(DIVIDE);
    }

    private String calculatePlusOperation(final String argument) {
        final String[] arguments = argument.split(SCREENING_PLUS);
        final StringBuilder sb = new StringBuilder();
        boolean isNotLastArg;
        for (int i = 0; i < arguments.length; i++) {
            final String arg = arguments[i].trim();
            if (NumberUtils.isNumber(arg.replace(COMMA, POINT))) {
                sb.append(arg.replace(COMMA, POINT));
            } else if (getBoolean(arg).isPresent()) {
                sb.append(getBoolean(arg).get());
            } else {
                sb.append(arg);
            }
            isNotLastArg = i != arguments.length - 1;
            if (isNotLastArg) {
                sb.append(PLUS);
            }
        }

        return sb.toString();
    }

    private Optional<Boolean> getBoolean(final String argument) {
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
