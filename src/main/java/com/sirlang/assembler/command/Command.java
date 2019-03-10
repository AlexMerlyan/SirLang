package com.sirlang.assembler.command;

import lombok.Getter;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

@Getter
public enum Command {
    PRINT("сударь будьте добры выведите на экран это", "System.out.println(%s);" + LINE_SEPARATOR, false),
    INIT_VAR("сударь будьте добры запомните это как", "%s %s = %s;" + LINE_SEPARATOR, true),
    IF_CLAUSE("сударь будьте любезны если условие ", "if (%s) {" + LINE_SEPARATOR, false),
    END_CODE_BLOCK("благодарю вас!", "}" + LINE_SEPARATOR, false);

    private final String sirCommand;
    private final String javaCommand;
    private final boolean containAdditionalCommand;

    Command(final String sirCommand, final String javaCommand, final boolean containAdditionalCommand) {
        this.sirCommand = sirCommand;
        this.javaCommand = javaCommand;
        this.containAdditionalCommand = containAdditionalCommand;
    }
}
