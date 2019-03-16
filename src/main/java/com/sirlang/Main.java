package com.sirlang;

import com.sirlang.java.executor.ExecutionResult;
import lombok.extern.slf4j.Slf4j;

import static com.sirlang.ErrorMessages.NO_ARGUMENTS_TO_COMPILE;
import static com.sirlang.ErrorMessages.SOMETHING_WAS_WRONG;

@Slf4j
class Main {

    private static final Executor EXECUTOR = Executor.getInstance();

    public static void main(String... args) {
        if (args.length > 0) {
            compileByFilePath(args[0]);
        } else {
            System.out.println(NO_ARGUMENTS_TO_COMPILE);
        }
    }

    private static void compileByFilePath(final String sirLangFilePath) {
        try {
            final ExecutionResult executionResult = EXECUTOR.execute(sirLangFilePath);
            System.out.println(executionResult.getConsoleOutput());
        } catch (Exception e) {
            System.out.println(SOMETHING_WAS_WRONG);
        }
    }
    
}
