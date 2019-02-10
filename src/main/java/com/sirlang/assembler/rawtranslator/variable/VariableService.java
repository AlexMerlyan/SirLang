package com.sirlang.assembler.rawtranslator.variable;

import org.jetbrains.annotations.NotNull;

public interface VariableService {
    JavaVariable getVarByName(final String varName);
    @NotNull String saveVar(final String sirLangVarName, final JavaVariable variable);
    boolean isVariableName(final String formattedArgument);
}
