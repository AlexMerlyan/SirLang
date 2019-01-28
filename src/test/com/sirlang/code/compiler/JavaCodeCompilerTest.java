package com.sirlang.code.compiler;

import com.sirlang.AbstractTest;
import org.junit.After;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JavaCodeCompilerTest extends AbstractTest {

    private static final String COMPILE_COMMAND = "/bin/javac -cp . ";
    private static final String JRE_PROPERTY = "java.home";
    private static final String JRE_DIRECTORY = "/jre";

    @After
    public void removeAllTestFiles() {
        new File(COMPILED_FILE_NAME).delete();
        new File(BYTE_CODE_FILE_NAME).delete();
    }

    @Test
    public void shouldCompileJavaClass() throws IOException, InterruptedException {
        File file = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_PROGRAM_AFTER_COMPILE);
        final String byteCodeFilePath = file.getAbsolutePath().replace(JAVA_EXTENSION, BYTE_CODE_EXTENSION);
        File notExistingByteCodeFile = new File(byteCodeFilePath);
        assertFalse(notExistingByteCodeFile.exists());
        String jrePath = System.getProperty(JRE_PROPERTY);
        String javacPath = jrePath.replace(JRE_DIRECTORY, COMPILE_COMMAND);
        String command = javacPath + file.getAbsolutePath();
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        File byteCodeFile = new File(byteCodeFilePath);
        assertTrue(byteCodeFile.getAbsoluteFile().exists());
    }

}
