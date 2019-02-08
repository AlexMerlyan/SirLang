package com.sirlang;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static com.sirlang.ErrorMessages.NO_ARGUMENTS_TO_COMPILE;
import static com.sirlang.ErrorMessages.SOMETHING_WAS_WRONG;
import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;
import static com.sirlang.program.JavaConsoleOutput.HELLO_WORLD_PROGRAM_OUTPUT;
import static com.sirlang.program.SirLangProgramCode.HELLO_WORLD_PROGRAM;
import static org.junit.Assert.assertEquals;

public class MainTest extends AbstractTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreOutStream() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldCompileSirLangFileThroughMainMethod() throws IOException {
        @NotNull File file = createTestFile(SIR_FILE_NAME, HELLO_WORLD_PROGRAM);
        Main.main(file.getAbsolutePath());
        assertEquals(HELLO_WORLD_PROGRAM_OUTPUT + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void shouldPrintNoArgumentsMessageMainMethod() {
        Main.main();
        assertEquals(NO_ARGUMENTS_TO_COMPILE + LINE_SEPARATOR, outContent.toString());
    }

    @Test
    public void shouldPrintErrorMessageMainMethod() {
        Main.main(StringUtils.EMPTY);
        assertEquals(SOMETHING_WAS_WRONG + LINE_SEPARATOR, outContent.toString());
    }

}
