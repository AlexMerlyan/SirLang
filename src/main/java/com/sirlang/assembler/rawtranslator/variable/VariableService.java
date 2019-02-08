package com.sirlang.assembler.rawtranslator.variable;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface VariableService {
    Optional<JavaVariable> getOptionalVarByName(final String varName);
    JavaVariable getVarByName(final String varName);
    @NotNull String saveVar(final String sirLangVarName, final JavaVariable variable);
}
