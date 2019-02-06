package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslatorImpl;
import com.sirlang.assembler.rawtranslator.variable.JavaVariable;
import com.sirlang.assembler.rawtranslator.variable.VariableService;
import com.sirlang.assembler.rawtranslator.variable.VariableServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

import static com.sirlang.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private final MathOperationTranslator operationTranslator = new MathOperationTranslatorImpl();
    private final VariableService variableService = new VariableServiceImpl();

    public String transformToJava(String codeRow) {
        if (StringUtils.isNotEmpty(codeRow)) {
            final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
            for (Command command : Command.values()) {
                if (formattedCodeRow.contains(command.getSirCommand())) {
                    return transformCommandToJava(codeRow, command);
                }
            }
        }
        return EMPTY;
    }

    private String transformCommandToJava(final String codeRow, final Command command) {
        final String javaRow;
        if (command.isContainAdditionalCommand()) {
            JavaVariable variable = getJavaVariable(codeRow, command);
            final String sirLangVarName = getSirLangVarName(codeRow, command);
            final String javaVarName = variableService.saveVar(sirLangVarName, variable);
            javaRow = String.format(command.getJavaCommand(), variable.getType().getSimpleName(), javaVarName, variable.getValue());
        } else {
            javaRow = String.format(command.getJavaCommand(), getArgument(codeRow));
        }
        return javaRow;
    }

    private JavaVariable getJavaVariable(final String codeRow, final Command command) {
        final String commandAndNameValuePair = codeRow.replace(command.getSirCommand(), EMPTY);
        final String notTrimValue = commandAndNameValuePair.split(COMMAND_SEPARATOR)[1];
        final String value = notTrimValue.trim();
        final Class type = getValueType(value);

        return new JavaVariable(value, type);
    }

    private String getSirLangVarName(final String codeRow, final Command command) {
        final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
        final String notTrimCommandAndVarName = formattedCodeRow.split(COMMAND_SEPARATOR)[0];
        final String notTrimVarName = notTrimCommandAndVarName.replace(command.getSirCommand(), EMPTY);
        return notTrimVarName.trim();
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
        } else if (isVariableName(formattedArgument)) {
            final JavaVariable varByName = variableService.getVarByName(formattedArgument);
            parsedArgument = varByName.getName();
        } else if (operationTranslator.isMathematicsExpression(formattedArgument)) {
            parsedArgument = operationTranslator.transformMathematicalOperations(formattedArgument);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            parsedArgument = getParsedNumber(formattedArgument);
        } else {
            parsedArgument = operationTranslator.getBoolean(formattedArgument).orElseThrow(() -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE));
        }
        return parsedArgument;
    }

    private boolean isVariableName(final String formattedArgument) {
        final Optional<JavaVariable> optionalVarByName = variableService.getOptionalVarByName(formattedArgument);
        return optionalVarByName.isPresent();
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
