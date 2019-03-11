package com.sirlang.assembler.rawtranslator.variable;

import java.util.Optional;

public interface VariableService {
    JavaVariable getVarByName(final String varName);

    String saveNewVar(final String sirLangVarName, final JavaVariable variable);

    Optional<JavaVariable> updateVar(final String sirLangVarName, final JavaVariable variable);

    boolean isVariableName(final String varName);

    boolean isVarAlreadyExists(final String varName);

    Optional<JavaVariable> getVarByJavaName(final String javaVarName);

    boolean hasVar(String[] args);
}
