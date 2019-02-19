package com.sirlang;

import com.sirlang.assembler.Assembler;
import com.sirlang.assembler.SirLangAssembler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

import static com.sirlang.ErrorMessages.NO_ARGUMENTS_TO_COMPILE;
import static com.sirlang.ErrorMessages.SOMETHING_WAS_WRONG;

@Slf4j
class Main {

    private static final Assembler ASSEMBLER = new SirLangAssembler();
    private static final JavaCodeCompiler JAVA_CODE_COMPILER = new JavaCodeCompilerImpl();
    private static final JavaCodeRunner JAVA_CODE_RUNNER = new JavaCodeRunnerImpl();

    public static void main(String... args) {
        if (args.length > 0) {
            compileByFilePath(args[0]);
        } else {
            System.out.println(NO_ARGUMENTS_TO_COMPILE);
        }
    }

    private static void compileByFilePath(final String sirLangFilePath) {
        try {
            final File javaFile = ASSEMBLER.compileSourceFile(sirLangFilePath);
            final File byteCodeFile = JAVA_CODE_COMPILER.compileJavaFile(javaFile);
            final ExecutionResult executionResult = JAVA_CODE_RUNNER.runCompiledCode(byteCodeFile);
            System.out.println(executionResult.getConsoleOutput());
        } catch (Exception e) {
            System.out.println(SOMETHING_WAS_WRONG);
        }
    }
    
}
