package com.sirlang.assembler.rawtranslator.variable;

import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Override
    public String saveVar(final String sirLangVarName, @NotNull final JavaVariable variable) {
        @NotNull final String javaVarName = VAR + variableCount;
        variable.setName(javaVarName);
        variables.put(sirLangVarName, variable);
        variableCount++;
        return javaVarName;
    }

    @Override
    public boolean isVariableName(final String formattedArgument) {
        final Optional<JavaVariable> optionalVarByName = getOptionalVarByName(formattedArgument);
        return optionalVarByName.isPresent();
    }

}
