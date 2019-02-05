package com.sirlang.assembler.rawtranslator.variable;

public interface VariableService {
    void getVarByName(String varName);
    void saveVar(SirLangVariable variable);
    void removeVarByName(String varName);
}
