package com.sirlang.assembler.rawtranslator.variable;

import lombok.Data;

@Data
public class SirLangVariable {

    private String name;
    private String value;
    private Class type;

    public SirLangVariable(final String name, final String value, final Class type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }
}
