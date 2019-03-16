package com.sirlang.assembler.rawtranslator.variable;

import java.util.Optional;

public interface VariableService {

    Optional<JavaVariable> getOptionalVarByName(String varName);

    JavaVariable getVarByName(final String varName);

    String saveNewVar(final String sirLangVarName, final JavaVariable variable);

    void saveVar(final String sirLangVarName, final JavaVariable variable);

    Optional<JavaVariable> updateVar(final String sirLangVarName, final JavaVariable variable);

    boolean isVariableName(final String sirLangVarName);

    boolean isVarAlreadyExists(final String sirLangVarName);

    boolean isVarNotExistsByJavaName(String javaVarName);

    Optional<JavaVariable> getVarByJavaName(final String javaVarName);

    boolean hasVar(String[] args);

}
