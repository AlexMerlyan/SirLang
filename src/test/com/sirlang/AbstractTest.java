package com.sirlang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractTest {

    protected static final String JAVA_EXTENSION = ".java";
    protected static final String BYTE_CODE_EXTENSION = ".class";

    protected static final String HELLO_WORLD_PROGRAM_AFTER_COMPILE = "public class Main {" + System.lineSeparator() +
            "public static void main(String[] args) {" + System.lineSeparator() +
            "System.out.println(\"Моя первая программа на языке Сударь!\");" + System.lineSeparator() +
            "}" + System.lineSeparator() +
            "}" + System.lineSeparator();

    protected static final String COMPILED_FILE_NAME = "Main.java";
    protected static final String BYTE_CODE_FILE_NAME = "Main.class";

    protected File createTestFile(String fileName, String content) throws IOException {
        File testFile = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(testFile));
        bufferedWriter.write(content);
        bufferedWriter.close();
        testFile.createNewFile();
        return testFile;
    }
}
