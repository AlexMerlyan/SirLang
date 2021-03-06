package com.sirlang.assembler.rawtranslator.variable;

import com.sirlang.assembler.rawtranslator.booleanoperation.BooleanOperationTranslator;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperation;
import com.sirlang.assembler.rawtranslator.mathoperation.MathOperationTranslator;

import static com.sirlang.ErrorMessages.BOOLEAN_NOT_FOUND_ERROR_MESSAGE;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class JavaVarParser {

    private final MathOperationTranslator mathOperationTranslator;
    private final BooleanOperationTranslator booleanOperationTranslator;
    private final VariableService variableService;
    private final TypeIdentifier typeIdentifier;

    public JavaVarParser(final MathOperationTranslator mathOperationTranslator, final VariableService variableService,
                         final BooleanOperationTranslator booleanOperationTranslator) {
        this.mathOperationTranslator = mathOperationTranslator;
        this.booleanOperationTranslator = booleanOperationTranslator;
        this.variableService = variableService;
        this.typeIdentifier = new TypeIdentifier(variableService);
    }

    public JavaVariable parseArgumentToJavaVar(final String formattedArgument) {
        return parseArgumentToJavaVar(formattedArgument, EMPTY, false);
    }

    public JavaVariable parseArgumentToJavaVar(final String formattedArgument, final String sirlangName) {
        return parseArgumentToJavaVar(formattedArgument, sirlangName, true);
    }

    private JavaVariable parseArgumentToJavaVar(final String formattedArgument, final String sirlangVarName, final boolean isTypeNeed) {
        JavaVariable javaVariable;
        if (mathOperationTranslator.isString(formattedArgument)) {
            javaVariable = new JavaVariable(formattedArgument, String.class);
        } else if (variableService.isVariableName(formattedArgument)) {
            javaVariable = variableService.getVarByName(formattedArgument);
        }
        else if (variableService.hasVariableName(formattedArgument)) {
            final String transformedArgument = variableService.replaceSirlangNamesToJavaNames(formattedArgument);
            Class type = null;
            if (variableService.isVarNotExists(sirlangVarName) && isTypeNeed) {
                type = getExpressionDataType(transformedArgument);
            }
            javaVariable = new JavaVariable(transformedArgument, type);
        }
        else if (booleanOperationTranslator.isBooleanExpression(formattedArgument)) {
            final String transformedExpression = booleanOperationTranslator.transformBooleanOperations(formattedArgument);
            javaVariable = new JavaVariable(transformedExpression, Boolean.class);
        } else if (mathOperationTranslator.isMathematicsExpression(formattedArgument)) {
            javaVariable = getJavaVariableForMathExpression(formattedArgument);
        } else if (isNumber(formattedArgument.replace(COMMA, POINT))) {
            final Number parsedNumber = typeIdentifier.getParsedNumber(formattedArgument);
            javaVariable = new JavaVariable(parsedNumber.toString(), parsedNumber.getClass());
        } else {
            final Boolean parsedArgument = mathOperationTranslator.getBoolean(formattedArgument).orElseThrow(()
                    -> new IllegalArgumentException(BOOLEAN_NOT_FOUND_ERROR_MESSAGE + formattedArgument));
            javaVariable = new JavaVariable(parsedArgument.toString(), parsedArgument.getClass());
        }
        prepareToJavaValueIfNeeded(javaVariable);
        return javaVariable;
    }

    private JavaVariable getJavaVariableForMathExpression(final String formattedArgument) {
        final String expression = mathOperationTranslator.transformMathematicalOperations(formattedArgument);
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
        if (mathOperationTranslator.isNotMathematicsExpression(javaValue)) {
            if (javaVariable.getType() == Long.class) {
                javaVariable.setValue(javaValue + LONG_POSTFIX);
            }
        }
    }

}
