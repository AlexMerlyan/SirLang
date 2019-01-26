package compiler;

import lombok.Getter;

@Getter
public enum Command {
    PRINT("Сударь, будьте добры, выведите на экран это:", "System.out.println(%s);");

    private final String sirCommand;
    private final String javaCommand;

    Command(String sirCommand, String javaCommand) {
        this.sirCommand = sirCommand;
        this.javaCommand = javaCommand;
    }
}
