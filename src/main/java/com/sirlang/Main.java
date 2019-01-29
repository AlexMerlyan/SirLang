package com.sirlang;

import com.sirlang.compiler.Compiler;
import com.sirlang.compiler.SirLangCompiler;
import com.sirlang.java.compiler.JavaCodeCompiler;
import com.sirlang.java.compiler.JavaCodeCompilerImpl;
import com.sirlang.java.executor.ExecutionResult;
import com.sirlang.java.executor.JavaCodeRunner;
import com.sirlang.java.executor.JavaCodeRunnerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
public class Main {

    private static final Compiler COMPILER = new SirLangCompiler();
    private static final JavaCodeCompiler JAVA_CODE_COMPILER = new JavaCodeCompilerImpl();
    private static final JavaCodeRunner JAVA_CODE_RUNNER = new JavaCodeRunnerImpl();

    private static final String NO_ARGUMENTS_TO_COMPILE = "Через пробел укажите пожалуйста полный путь к файлу с разширением .sir";
    private static final String SOMETHING_WAS_WRONG = "Видимо что-то пошло не так, обратитесь к разработчику-рукожопу";

    public static void main(String[] args) {
        if (args.length > 0) {
            compileByFilePath(args[0]);
        } else {
            System.out.println(NO_ARGUMENTS_TO_COMPILE);
        }
    }

    private static void compileByFilePath(final String sirLangFilePath) {
        try {
            final File javaFile = COMPILER.compileSourceFile(sirLangFilePath);
            final File byteCodeFile = JAVA_CODE_COMPILER.compileJavaFile(javaFile);
            final ExecutionResult executionResult = JAVA_CODE_RUNNER.runCompiledCode(byteCodeFile);
            System.out.println(executionResult.getConsoleOutput());
        } catch (InterruptedException e) {
            System.out.println(SOMETHING_WAS_WRONG);
        } catch (IOException e) {
            System.out.println(SOMETHING_WAS_WRONG);
        }
    }
}
