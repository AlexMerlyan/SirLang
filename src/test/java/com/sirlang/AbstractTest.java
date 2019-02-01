package com.sirlang;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public abstract class AbstractTest {

    private static final String BYTE_CODE_FILE_NAME = "Main.class";

    protected static final String COMPILED_FILE_NAME = "Main.java";
    protected static final String SIR_FILE_NAME = "test_file.sir";
    protected static final String EXPECTED_CONSOLE_OUTPUT = "Моя первая программа на языке Сударь!";
    protected static final String LOG_FILE_WAS_DELETED = "File was deleted: {}";
    protected static final String HELLO_WORLD_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(\"Моя первая программа на языке Сударь!\");" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    @After
    public void removeTestFiles() {
        File file = new File(COMPILED_FILE_NAME);
        boolean isFileDeleted = file.exists() && file.delete();
        if (isFileDeleted) {
            log.info(LOG_FILE_WAS_DELETED, COMPILED_FILE_NAME);
        }
        isFileDeleted = new File(BYTE_CODE_FILE_NAME).delete();
        if (isFileDeleted) {
            log.info(LOG_FILE_WAS_DELETED, BYTE_CODE_FILE_NAME);
        }
    }

    protected File createTestFile(String fileName, String content) throws IOException {
        File testFile = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        return testFile;
    }
}
