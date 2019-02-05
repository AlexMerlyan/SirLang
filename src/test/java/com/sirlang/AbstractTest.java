package com.sirlang;

import com.sirlang.program.SirLangProgram;
import com.tngtech.java.junit.dataprovider.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractTest {

    private static final String BYTE_CODE_FILE_NAME = "Main.class";

    protected static final String COMPILED_FILE_NAME = "Main.java";
    protected static final String SIR_FILE_NAME = "test_file.sir";
    protected static final String LOG_FILE_WAS_DELETED = "File was deleted: {}";

    @After
    public void removeTestFiles() {
        File file = new File(COMPILED_FILE_NAME);
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

    @SuppressWarnings("unused")
    @DataProvider
    public static List<List<SirLangProgram>> dataProvideSirLangProgram() {
        List<List<SirLangProgram>> sirLangProgramLists = new ArrayList<>();
        for (SirLangProgram sirLangProgram : SirLangProgram.values()) {
            final ArrayList<SirLangProgram> sirLangProgramList = new ArrayList<>();
            sirLangProgramList.add(sirLangProgram);
            sirLangProgramLists.add(sirLangProgramList);
        }
        return sirLangProgramLists;
    }

    protected File createTestFile(String fileName, String content) throws IOException {
        File testFile = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        return testFile;
    }
}
