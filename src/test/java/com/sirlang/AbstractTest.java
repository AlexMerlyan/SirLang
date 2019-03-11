package com.sirlang;

import com.sirlang.program.booleanexpression.SirLangBooleanExpressionProgram;
import com.sirlang.program.concat.SirLangConcatProgram;
import com.sirlang.program.concatvars.SirLangConcatVarsProgram;
import com.sirlang.program.condition.SirLangConditionProgram;
import com.sirlang.program.cycle.SirLangCycleProgram;
import com.sirlang.program.datatypes.SirLangDataTypeProgram;
import com.sirlang.program.expression.SirLangExpressionProgram;
import com.sirlang.program.helloworld.SirLangHelloWorldProgram;
import com.sirlang.program.vars.SirLangVarsProgram;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Slf4j
public abstract class AbstractTest {

    private static final String BYTE_CODE_FILE_NAME = "Main.class";

    protected static final String COMPILED_FILE_NAME = "Main.java";
    protected static final String SIR_FILE_NAME = "test_file.sir";
    protected static final String LOG_FILE_WAS_DELETED = "File was deleted: {}";

    @After
    public void removeTestFiles() {
        final File file = new File(COMPILED_FILE_NAME);
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


    @DataProvider
    public static List<List<Object>> dataProvideSirLangHelloWorldProgram() {
        return getProgramsDataProvider(SirLangHelloWorldProgram.values());
    }


    @DataProvider
    public static List<List<Object>> dataProvideSirLangConcatProgram() {
        return getProgramsDataProvider(SirLangConcatProgram.values());
    }


    @DataProvider
    public static List<List<Object>> dataProvideSirLangDataTypeProgram() {
        return getProgramsDataProvider(SirLangDataTypeProgram.values());
    }


    @DataProvider
    public static List<List<Object>> dataProvideSirLangExpressionProgram() {
        return getProgramsDataProvider(SirLangExpressionProgram.values());
    }


    @DataProvider
    public static List<List<Object>> dataProvideSirLangVarsProgram() {
        return getProgramsDataProvider(SirLangVarsProgram.values());
    }


    @DataProvider
    public static List<List<Object>> dataProvideSirLangConcatVarsProgram() {
        return getProgramsDataProvider(SirLangConcatVarsProgram.values());
    }

    @DataProvider
    public static List<List<Object>> dataProvideSirLangBooleanExpressionProgram() {
        return getProgramsDataProvider(SirLangBooleanExpressionProgram.values());
    }

    @DataProvider
    public static List<List<Object>> dataProvideSirLangConditionProgram() {
        return getProgramsDataProvider(SirLangConditionProgram.values());
    }

    @DataProvider
    public static List<List<Object>> dataProvideSirLangCycleProgram() {
        return getProgramsDataProvider(SirLangCycleProgram.values());
    }

    private static List<List<Object>> getProgramsDataProvider(final Object[] objects) {
        List<List<Object>> programLists = new ArrayList<>();
        for (Object program : objects) {
            final ArrayList<Object> programs = new ArrayList<>();
            programs.add(program);
            programLists.add(programs);
        }
        return programLists;
    }


    protected File createTestFile(final String fileName, final String content) throws IOException {
        final File testFile = new File(fileName);
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        return testFile;
    }
}
