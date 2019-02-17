package com.sirlang.assembler.rawtranslator.variable;

public interface VariableService {
    JavaVariable getVarByName(final String varName);

    String saveVar(final String sirLangVarName, final JavaVariable variable);

    boolean isVariableName(final String formattedArgument);

    boolean containsJavaVar(final String varName);
}
