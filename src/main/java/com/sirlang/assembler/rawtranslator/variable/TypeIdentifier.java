package com.sirlang.assembler.rawtranslator.variable;

import java.util.Optional;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.COMMA;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.POINT;

class TypeIdentifier {

    private final VariableService variableService;

    TypeIdentifier(VariableService variableService) {
        this.variableService = variableService;
    }

    boolean hasDouble(String[] args) {
        for (final String arg : args) {
            final Number parsedNumber = getParsedNumber(arg);
            if (parsedNumber.getClass() == Double.class) {
                return true;
            }
        }
        return false;
    }

    Class getTypeHasVarCase(final String[] expressionArgs) {
        final Class type;
        if (isMathExpressionOnlyWithNumbers(expressionArgs)) {
            type = hasDoubleJavaVar(expressionArgs) ? Double.class : Long.class;
        } else {
            type = String.class;
        }
        return type;
    }

    private boolean isMathExpressionOnlyWithNumbers(String[] expressionArgs) {
        for (String arg : expressionArgs) {
            final Optional<JavaVariable> optionalJavaVariable = variableService.getVarByJavaName(arg);
            if (optionalJavaVariable.isPresent()) {
                final Class type = optionalJavaVariable.get().getType();
                if (type != Double.class && type != Long.class) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasDoubleJavaVar(String[] javaVarsAndArgs) {
        for (final String arg : javaVarsAndArgs) {
            final Optional<JavaVariable> optionalJavaVariable = variableService.getVarByJavaName(arg);
            if (optionalJavaVariable.isPresent()) {
                if (optionalJavaVariable.get().getType() == Double.class) {
                    return true;
                }
            }
        }
        return false;
    }

    Number getParsedNumber(final String formattedArgument) {
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
