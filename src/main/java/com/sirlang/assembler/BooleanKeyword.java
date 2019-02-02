package com.sirlang.assembler;

import lombok.Getter;

@Getter
public enum BooleanKeyword {
    BOOLEAN_TRUE("Правда", "Тру"),
    BOOLEAN_FALSE("Ложь", "Неправда", "Обман");

    private String[] keywords;

    BooleanKeyword(String... keywords) {
        this.keywords = keywords;
    }

}
