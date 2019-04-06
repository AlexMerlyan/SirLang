package com.sirlang.assembler.command;

import lombok.Getter;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

@Getter
public enum Command {

    PRINT("сударь будьте добры выведите на экран это", "System.out.println(%s);" + LINE_SEPARATOR, false, true),
    INIT_VAR("сударь будьте добры запомните это как", "%s = %s;" + LINE_SEPARATOR, true, true),
    CYCLE("сударь будьте любезны повторите количество раз", "for (int %s = 0; %s < %s; %s++) {" + LINE_SEPARATOR, true, true),
    CYCLE_WITH_CONDITION("сударь будьте любезны повторяйте пока условие верно", "for (int %s = 0; %s; %s++) {" + LINE_SEPARATOR, true, true),
    IF_CLAUSE("сударь будьте любезны сделайте следующее если условие верно", "if (%s) {" + LINE_SEPARATOR, false, true),
    ELSE_IF_CLAUSE("благодарю вас! или сделайте следующее если условие верно", "} else if (%s) {" + LINE_SEPARATOR, false, true),
    ELSE_CLAUSE("или сделайте следующее", "} else {" + LINE_SEPARATOR, false, false),
    END_CODE_BLOCK("благодарю вас!", "}" + LINE_SEPARATOR, false, false);

    private final String sirCommand;
    private final String javaCommand;
    private final boolean containAdditionalCommand;
    private final boolean isStringFormatNeeded;

    Command(final String sirCommand, final String javaCommand,
            final boolean containAdditionalCommand, final boolean isStringFormatNeeded) {
        this.sirCommand = sirCommand;
        this.javaCommand = javaCommand;
        this.containAdditionalCommand = containAdditionalCommand;
        this.isStringFormatNeeded = isStringFormatNeeded;
    }

}
