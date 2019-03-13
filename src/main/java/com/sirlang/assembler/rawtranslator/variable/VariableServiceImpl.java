package com.sirlang.assembler.rawtranslator.variable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VariableServiceImpl implements VariableService {

    private static final String VAR = "var";

    private int variableCount;
    private final Map<String, JavaVariable> variables = new HashMap<>();

    private Optional<JavaVariable> getOptionalVarByName(String varName) {
        return Optional.ofNullable(variables.get(varName));
    }

    @Override
    public JavaVariable getVarByName(String varName) {
        return variables.get(varName);
    }

    @Override
    public String saveNewVar(final String sirLangVarName, final JavaVariable variable) {
        final String javaVarName = VAR + variableCount;
        variable.setName(javaVarName);
        variables.put(sirLangVarName, variable);
        variableCount++;
        return javaVarName;
    }

    @Override
    public void saveVar(String sirLangVarName, JavaVariable variable) {
        variables.put(sirLangVarName, variable);
    }

    @Override
    public Optional<JavaVariable> updateVar(String sirLangVarName, JavaVariable variable) {
        return Optional.ofNullable(variables.put(sirLangVarName, variable));
    }

    @Override
    public boolean isVariableName(final String sirLangVarName) {
        final Optional<JavaVariable> optionalVarByName = getOptionalVarByName(sirLangVarName);
        return optionalVarByName.isPresent();
    }

    @Override
    public boolean isVarAlreadyExists(String sirLangVarName) {
        return isVariableName(sirLangVarName);
    }

    private boolean containsJavaVar(String varName) {
        for (final JavaVariable javaVariable : variables.values()) {
            if (javaVariable.getName().equals(varName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<JavaVariable> getVarByJavaName(String javaVarName) {
        for (final JavaVariable javaVariable : variables.values()) {
            if (javaVariable.getName().equals(javaVarName)) {
                return Optional.of(javaVariable);
            }
        }
        return Optional.empty();
    }

    private boolean isVarExistsByJavaName(String javaVarName) {
        return getVarByJavaName(javaVarName).isPresent();
    }

    @Override
    public boolean isVarNotExistsByJavaName(String javaVarName) {
        return !isVarExistsByJavaName(javaVarName);
    }

    @Override
    public boolean hasVar(String[] args) {
        for (final String arg : args) {
            if (containsJavaVar(arg)) {
                return true;
            }
        }
        return false;
    }

}
