package com.sirlang;

import com.sirlang.program.*;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.After;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Slf4j
public abstract class AbstractTest {

    private static final String BYTE_CODE_FILE_NAME = "Main.class";

    protected static final String COMPILED_FILE_NAME = "Main.java";
    protected static final String SIR_FILE_NAME = "test_file.sir";
    protected static final String LOG_FILE_WAS_DELETED = "File was deleted: {}";

    @After
    public void removeTestFiles() {
        @NotNull File file = new File(COMPILED_FILE_NAME);
        boolean isFileDeleted = file.exists() && file.delete();
        if (isFileDeleted) {
            log.debug(LOG_FILE_WAS_DELETED, COMPILED_FILE_NAME);
        }
        isFileDeleted = new File(BYTE_CODE_FILE_NAME).delete();
        if (isFileDeleted) {
            log.debug(LOG_FILE_WAS_DELETED, BYTE_CODE_FILE_NAME);
        }
        isFileDeleted = new File(SIR_FILE_NAME).delete();
        if (isFileDeleted) {
            log.debug(LOG_FILE_WAS_DELETED, SIR_FILE_NAME);
        }
    }

    @NotNull
    @DataProvider
    public static List<List<Object>> dataProvideSirLangHelloWorldProgram() {
        return getProgramsDataProvider(SirLangHelloWorldProgram.values());
    }

    @NotNull
    @DataProvider
    public static List<List<Object>> dataProvideSirLangConcatProgram() {
        return getProgramsDataProvider(SirLangConcatProgram.values());
    }

    @NotNull
    @DataProvider
    public static List<List<Object>> dataProvideSirLangDataTypeProgram() {
        return getProgramsDataProvider(SirLangDataTypeProgram.values());
    }

    @NotNull
    @DataProvider
    public static List<List<Object>> dataProvideSirLangExpressionProgram() {
        return getProgramsDataProvider(SirLangExpressionProgram.values());
    }

    @NotNull
    @DataProvider
    public static List<List<Object>> dataProvideSirLangVarsProgram() {
        return getProgramsDataProvider(SirLangVarsProgram.values());
    }

    private static List<List<Object>> getProgramsDataProvider(Object[] objects) {
        @NotNull List<List<Object>> programLists = new ArrayList<>();
        for (Object program : objects) {
            @NotNull final ArrayList<Object> programs = new ArrayList<>();
            programs.add(program);
            programLists.add(programs);
        }
        return programLists;
    }

    @NotNull
    protected File createTestFile(@NotNull String fileName, @NotNull String content) throws IOException {
        @NotNull File testFile = new File(fileName);
        @NotNull BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        return testFile;
    }
}
