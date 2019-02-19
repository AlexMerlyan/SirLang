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
    private final TypeIdentifier typeIdentifier;

    public JavaVarParser(final MathOperationTranslator operationTranslator, final VariableService variableService) {
        this.operationTranslator = operationTranslator;
        this.variableService = variableService;
        this.typeIdentifier = new TypeIdentifier(variableService);
    }

    public JavaVariable parseArgumentToJavaVar(final String formattedArgument) {
        JavaVariable javaVariable;
        if (operationTranslator.isString(formattedArgument)) {
            javaVariable = new JavaVariable(formattedArgument, String.class);
        } else if (variableService.isVariableName(formattedArgument)) {
            javaVariable = variableService.getVarByName(formattedArgument);
        } else if (operationTranslator.isMathematicsExpression(formattedArgument)) {
            javaVariable = getJavaVariableForMathExpression(formattedArgument);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            final Number parsedNumber = typeIdentifier.getParsedNumber(formattedArgument);
            javaVariable = new JavaVariable(parsedNumber.toString(), parsedNumber.getClass());
        } else {
            final Boolean parsedArgument = operationTranslator.getBoolean(formattedArgument).orElseThrow(()
                    -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE + formattedArgument));
            javaVariable = new JavaVariable(parsedArgument.toString(), parsedArgument.getClass());
        }
        prepareToJavaValueIfNeeded(javaVariable);
        return javaVariable;
    }

    private JavaVariable getJavaVariableForMathExpression(final String formattedArgument) {
        final String expression = operationTranslator.transformMathematicalOperations(formattedArgument);
        final Class type = getExpressionDataType(expression);
        return new JavaVariable(expression, type);
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
        if (variableService.hasVar(expressionArgs)) {
            type = typeIdentifier.getTypeHasVarCase(expressionArgs);
        } else if (typeIdentifier.hasDouble(expressionArgs)) {
            type = Double.class;
        } else {
            type = Long.class;
        }
        return type;
    }

    private void prepareToJavaValueIfNeeded(final JavaVariable javaVariable) {
        final String javaValue = javaVariable.getValue();
        if (operationTranslator.isNotMathematicsExpression(javaValue)) {
            if (javaVariable.getType() == Long.class) {
                javaVariable.setValue(javaValue + LONG_POSTFIX);
            }
        }
    }

}
