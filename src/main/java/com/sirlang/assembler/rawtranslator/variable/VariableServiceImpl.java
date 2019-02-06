package com.sirlang.assembler.rawtranslator.variable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VariableServiceImpl implements VariableService {

    private static final String VAR = "var";

    private int variableCount;
    private final Map<String, JavaVariable> variables = new HashMap<>();


    @Override
    public Optional<JavaVariable> getOptionalVarByName(String varName) {
        return Optional.ofNullable(variables.get(varName));
    }

    @Override
    public JavaVariable getVarByName(String varName) {
        return variables.get(varName);
    }

    @Override
    public String saveVar(final String sirLangVarName, final JavaVariable variable) {
        final String javaVarName = VAR + variableCount;
        variable.setName(javaVarName);
        variables.put(sirLangVarName, variable);
        variableCount++;
        return javaVarName;
    }

    @Override
    public void removeVarByName(String varName) {
        variables.remove(varName);
    }
}
