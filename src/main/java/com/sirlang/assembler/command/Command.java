package com.sirlang.assembler.command;

import lombok.Getter;

@Getter
public enum Command {
    PRINT("сударь будьте добры выведите на экран это", "System.out.println(%s);", false),
    INIT_VAR("сударь будьте добры запомните это", "%s var%d = %s;", true);

    private final String sirCommand;
    private final String javaCommand;
    private final boolean containAdditionalCommand;

    Command(final String sirCommand, final String javaCommand, final boolean containAdditionalCommand) {
        this.sirCommand = sirCommand;
        this.javaCommand = javaCommand;
        this.containAdditionalCommand = containAdditionalCommand;
    }
}
