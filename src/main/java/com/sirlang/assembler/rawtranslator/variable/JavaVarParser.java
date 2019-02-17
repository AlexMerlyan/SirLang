package com.sirlang.assembler.rawtranslator.variable;

import com.sirlang.assembler.rawtranslator.mathoperation.MathOperation;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;

import static com.sirlang.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class JavaVarParser {

    private final MathOperationTranslator operationTranslator;
    private final VariableService variableService;

    public JavaVarParser(final MathOperationTranslator operationTranslator, final VariableService variableService) {
        this.operationTranslator = operationTranslator;
        this.variableService = variableService;
    }

    public JavaVariable parseArgumentToJavaVar(final String formattedArgument) {
        JavaVariable javaVariable;
        if (operationTranslator.isString(formattedArgument)) {
            javaVariable = new JavaVariable(formattedArgument, String.class);
        } else if (variableService.isVariableName(formattedArgument)) {
            javaVariable = variableService.getVarByName(formattedArgument);
        } else if (operationTranslator.isMathematicsExpression(formattedArgument)) {
            final String expression = operationTranslator.transformMathematicalOperations(formattedArgument);
            final Class type = getExpressionDataType(expression);
            javaVariable = new JavaVariable(expression, type);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            final Number parsedNumber = getParsedNumber(formattedArgument);
            javaVariable = new JavaVariable(parsedNumber.toString(), parsedNumber.getClass());
        } else {
            final Boolean parsedArgument = operationTranslator.getBoolean(formattedArgument).orElseThrow(()
                    -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE + formattedArgument));
            javaVariable = new JavaVariable(parsedArgument.toString(), parsedArgument.getClass());
        }

        if (!operationTranslator.isMathematicsExpression(formattedArgument)) {
            final String javaValue = prepareToJavaValue(javaVariable.getValue(), javaVariable.getType());
            javaVariable.setValue(javaValue);
        }
        return javaVariable;
    }

    private Class getExpressionDataType(String expression) {
        if (expression.contains(QUOTE)) {
            return String.class;
        }
        String formattedExpression = expression.replaceAll(SPACE, EMPTY);
        for (MathOperation operation : MathOperation.values()) {
            formattedExpression = formattedExpression.replaceAll(operation.getScreeningOperation(), SPACE);
        }
        final String[] expressionArgs = formattedExpression.split(SPACE);
        final Class type;
        if (hasVar(expressionArgs)) {
            type = String.class;
        } else if (hasDouble(expressionArgs)) {
            type = Double.class;
        } else {
            type = Long.class;
        }
        return type;
    }

    private boolean hasVar(String[] args) {
        for (final String arg : args) {
            if (variableService.containsJavaVar(arg)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDouble(String[] args) {
        for (final String arg : args) {
            final Number parsedNumber = getParsedNumber(arg);
            if (parsedNumber.getClass() == Double.class) {
                return true;
            }
        }
        return false;
    }

    private String prepareToJavaValue(final Object arg, final Class type) {
        return type == Long.class ? arg + LONG_POSTFIX : arg.toString();
    }

    private Number getParsedNumber(final String formattedArgument) {
        Number parsedArgument;
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
