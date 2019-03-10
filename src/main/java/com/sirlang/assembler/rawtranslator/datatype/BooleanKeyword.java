package com.sirlang.assembler.rawtranslator.datatype;

import lombok.Getter;

@Getter
public enum BooleanKeyword {
    BOOLEAN_TRUE("true", "Правда", "Тру"),
    BOOLEAN_FALSE("false", "Ложь", "Неправда", "Обман");

    private final String javaKeyword;
    private final String[] keywords;

    BooleanKeyword(final String javaKeyword, final String... keywords) {
        this.javaKeyword = javaKeyword;
        this.keywords = keywords;
    }

}
