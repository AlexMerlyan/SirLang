package com.sirlang.assembler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sirlang.assembler.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.MathOperation.*;
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
        if (isString(argument)) {
            parsedArgument = argument;
        } else if(isMathematicsExpression(argument)) {
            parsedArgument = transformMathematicalOperations(argument);
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

    private boolean isString(final String argument) {
        return argument.startsWith(QUOTE) && argument.endsWith(QUOTE);
    }

    private boolean isStringPart(final String argument) {
        return argument.contains(QUOTE);
    }

    private boolean isMathematicsExpression(final String argument) {
        return argument.contains(PLUS.getOperation())
                || argument.contains(MINUS.getOperation())
                || argument.contains(MULTIPLY.getOperation())
                || argument.contains(DIVIDE.getOperation());
    }

    private String transformMathematicalOperations(final String argument) {
        String transformedArg = argument;
        for (MathOperation operation : MathOperation.values()) {
            transformedArg = transformMathematicalOperation(transformedArg, operation);
        }
        return transformedArg;
    }

    private String transformPlusOperation(final String argument) {
        //final String[] arguments = argument.split(PLUS.getScreeningOperation());
        final List<String> arguments = splitByOperation(argument, PLUS);
        final StringBuilder sb = new StringBuilder();
        boolean isNotLastArg;
        for (int i = 0; i < arguments.size(); i++) {
            final String arg = arguments.get(i).trim();
            if (isString(arg)) {
                sb.append(arg);
            } else if (NumberUtils.isNumber(arg.replace(COMMA, POINT))) {
                sb.append(arg.replace(COMMA, POINT));
            } else if (getBoolean(arg).isPresent()) {
                sb.append(getBoolean(arg).get());
            } else {
                sb.append(arg);
            }
            isNotLastArg = i != arguments.size() - 1;
            if (isNotLastArg && StringUtils.isNotEmpty(arg)) {
                sb.append(PLUS.getOperation());
            }
        }
        return sb.toString();
    }

    private List<String> splitByOperation(final String argument, MathOperation operation) {
        final List<String> strings = new ArrayList<>();
        final char[] symbols = argument.toCharArray();
        int startIndex = 0;
        final char operationChar = operation.getCharEquivalent();
        boolean isString = false;
        for (int i = 0; i < symbols.length; i++) {
            if (CHAR_QUOTE == symbols[i]) {
                if (!isString) {
                    strings.add(argument.substring(startIndex, i));
                    startIndex = i;
                }
                isString = !isString;
                if (!isString) {
                    strings.add(argument.substring(startIndex, i + 1));
                    startIndex = i + 1;
                }
            } else if (operationChar == symbols[i] && !isString) {
                strings.add(argument.substring(startIndex, i));
                startIndex = i + 1;
            } else if (i == symbols.length - 1) {
                strings.add(argument.substring(startIndex));
            }
        }
        return strings;
    }

    private String transformOtherMathematicalOperation(final String argument, final MathOperation operation) {
        final List<String> arguments = splitByOperation(argument, operation);
        final StringBuilder sb = new StringBuilder();
        boolean isNotLastArg;
        for (int i = 0; i < arguments.size(); i++) {
            final String arg = arguments.get(i).trim();
            if (isString(arg)) {
                sb.append(arg);
            } else {
                sb.append(arg.replace(COMMA, POINT));
            }
            isNotLastArg = i != arguments.size() - 1;
            if (isNotLastArg && !isString(arg)) {
                if (i + 1 < arguments.size()) {
                    if (!isString(arguments.get(i + 1))) {
                        sb.append(operation.getOperation());
                    }
                }
            }
        }
        return sb.toString();
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
