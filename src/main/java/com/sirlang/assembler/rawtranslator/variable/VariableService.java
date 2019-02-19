package com.sirlang.assembler.rawtranslator.variable;

import java.util.Optional;

public interface VariableService {
    JavaVariable getVarByName(final String varName);

    String saveVar(final String sirLangVarName, final JavaVariable variable);

    boolean isVariableName(final String formattedArgument);

    Optional<JavaVariable> getVarByJavaName(final String javaVarName);

    boolean hasVar(String[] args);
}
