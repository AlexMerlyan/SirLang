package com.sirlang.assembler.rawtranslator.variable;

import lombok.Data;

@Data
public class JavaVariable {

    private String name;
    private String value;
    private Class type;

    JavaVariable(final String value, final Class type) {
        this.value = value;
        this.type = type;
    }

}
