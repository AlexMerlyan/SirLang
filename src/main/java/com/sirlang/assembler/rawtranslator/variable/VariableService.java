package com.sirlang.assembler.rawtranslator.variable;

import java.util.Optional;

public interface VariableService {
    Optional<JavaVariable> getOptionalVarByName(final String varName);
    JavaVariable getVarByName(final String varName);
    String saveVar(final String sirLangVarName, final JavaVariable variable);
    @SuppressWarnings("unused")
    void removeVarByName(final String varName);
}
