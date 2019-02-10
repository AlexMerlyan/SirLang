package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.variable.JavaVariable;
import com.sirlang.assembler.rawtranslator.variable.VariableService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import static com.sirlang.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

@Slf4j
public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private final VariableService variableService;
    private final MathOperationTranslator operationTranslator;

    public CodeRawTranslatorImpl(final VariableService variableService, final MathOperationTranslator operationTranslator) {
        this.variableService = variableService;
        this.operationTranslator = operationTranslator;
    }

    public String transformToJava(final String codeRow) {
        if (StringUtils.isNotEmpty(codeRow)) {
            final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
            for (final Command command : Command.values()) {
                if (formattedCodeRow.contains(command.getSirCommand())) {
                    return transformCommandToJava(codeRow, command);
                }
            }
        }
        return EMPTY;
    }

    private String transformCommandToJava(final String codeRow, final Command command) {
        if (command.isContainAdditionalCommand()) {
            return transformAdditionalCommandToJava(codeRow, command);
        } else {
            return String.format(command.getJavaCommand(), getArgument(codeRow));
        }
    }

    private String transformAdditionalCommandToJava(final String codeRow, final Command command) {
        final JavaVariable variable = getJavaVariable(codeRow, command);
        final String sirLangVarName = getSirLangVarName(codeRow, command);
        final String javaVarName = variableService.saveVar(sirLangVarName, variable);
        return String.format(command.getJavaCommand(), variable.getType().getSimpleName(), javaVarName, variable.getValue());
    }

    private JavaVariable getJavaVariable(final String codeRow, final Command command) {
        final String commandAndNameValuePair = codeRow.replace(command.getSirCommand(), EMPTY);
        final String notTrimValue = commandAndNameValuePair.split(COMMAND_SEPARATOR)[1];
        final String value = notTrimValue.trim();
        final Object parsedValue = getParsedArgument(value);
        final String javaValue = prepareToJavaValue(parsedValue).toString();
        return new JavaVariable(javaValue, parsedValue.getClass());
    }

    private String getSirLangVarName(final String codeRow, final Command command) {
        final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
        final String notTrimCommandAndVarName = formattedCodeRow.split(COMMAND_SEPARATOR)[0];
        final String notTrimVarName = notTrimCommandAndVarName.replace(command.getSirCommand(), EMPTY);
        return notTrimVarName.trim();
    }


    private Object getArgument(final String codeRow) {
        final String[] methodAndArgument = codeRow.split(COMMAND_SEPARATOR);
        final String formattedArgument = methodAndArgument[1].trim();
        final Object parsedArgument = getParsedArgument(formattedArgument);
        return prepareToJavaValue(parsedArgument);
    }


    private Object prepareToJavaValue(final Object arg) {
        return arg.getClass() == Long.class ? arg + LONG_POSTFIX : arg;
    }

    private Object getParsedArgument(final String formattedArgument) {
        Object parsedArgument;
        if (operationTranslator.isString(formattedArgument)) {
            parsedArgument = formattedArgument;
        } else if (variableService.isVariableName(formattedArgument)) {
            final JavaVariable varByName = variableService.getVarByName(formattedArgument);
            parsedArgument = varByName.getName();
        } else if (operationTranslator.isMathematicsExpression(formattedArgument)) {
            parsedArgument = operationTranslator.transformMathematicalOperations(formattedArgument);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            parsedArgument = getParsedNumber(formattedArgument);
        } else {
            parsedArgument = operationTranslator.getBoolean(formattedArgument).orElseThrow(()
                    -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE + formattedArgument));
        }
        return parsedArgument;
    }

    private Object getParsedNumber(final String formattedArgument) {
        Object parsedArgument;
        if (formattedArgument.contains(POINT)) {
            parsedArgument = Double.valueOf(formattedArgument);
        } else if (formattedArgument.contains(COMMA)) {
            parsedArgument = Double.valueOf(formattedArgument.replace(COMMA, POINT));
        } else {
            parsedArgument = Long.valueOf(formattedArgument);
        }
        return parsedArgument;
    }

}
