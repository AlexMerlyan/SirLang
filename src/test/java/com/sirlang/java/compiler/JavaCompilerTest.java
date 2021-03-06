package com.sirlang.java.compiler;

import com.sirlang.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sirlang.java.JavaConstants.BYTE_CODE_EXTENSION;
import static com.sirlang.java.JavaConstants.JAVA_EXTENSION;
import static com.sirlang.program.helloworld.JavaHelloWorldCode.HELLO_WORLD_JAVA_CODE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Slf4j
public class JavaCompilerTest extends AbstractTest {

    private final JavaCodeCompiler codeCompiler = new JavaCodeCompilerImpl();

    @Test
    public void shouldCompileJavaClass() throws IOException, InterruptedException {
        File file = createTestFile(COMPILED_FILE_NAME, HELLO_WORLD_JAVA_CODE);
        final String byteCodeFilePath = file.getAbsolutePath().replace(JAVA_EXTENSION, BYTE_CODE_EXTENSION);
        File notExistingByteCodeFile = new File(byteCodeFilePath);
        assertFalse(notExistingByteCodeFile.exists());
        codeCompiler.compileJavaFile(file);
        File byteCodeFile = new File(byteCodeFilePath);
        assertTrue(byteCodeFile.exists());
    }

}
