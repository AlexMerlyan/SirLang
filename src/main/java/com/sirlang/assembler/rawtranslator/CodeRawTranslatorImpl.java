package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
import com.sirlang.assembler.rawtranslator.symbols.Symbols;
import com.sirlang.assembler.rawtranslator.variable.JavaVarParser;
import com.sirlang.assembler.rawtranslator.variable.JavaVariable;
import com.sirlang.assembler.rawtranslator.variable.VariableService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.*;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Slf4j
public class CodeRawTranslatorImpl implements CodeRawTranslator {

    private final VariableService variableService;
    private final JavaVarParser javaVarParser;

    public CodeRawTranslatorImpl(final VariableService variableService, final JavaVarParser javaVarParser) {
        this.variableService = variableService;
        this.javaVarParser = javaVarParser;
    }

    public String transformToJava(final String codeRow) {
        if (StringUtils.isNotEmpty(codeRow)) {
            final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
            for (final Command command : Command.values()) {
                if (formattedCodeRow.contains(command.getSirCommand())) {
                    return transformCommandToJava(codeRow, command);
                }
            }
        }
        return EMPTY;
    }

    private String transformCommandToJava(final String codeRow, final Command command) {
        if (command.isContainAdditionalCommand()) {
            return transformAdditionalCommandToJava(codeRow, command);
        } else if (command.isStringFormatNeeded() ) {
            return format(command.getJavaCommand(), getArgument(codeRow));
        } else {
            return command.getJavaCommand();
        }
    }

    private String transformAdditionalCommandToJava(final String codeRow, final Command command) {
        if (command == Command.CYCLE || command == Command.CYCLE_WITH_CONDITION) {
            return transformAdditionalCommandForCycle(codeRow, command);
        } else {
            return defaultTransformAdditionalCommand(codeRow, command);
        }
    }

    private String defaultTransformAdditionalCommand(String codeRow, Command command) {
        final JavaVariable variable = getJavaVariable(codeRow, command);
        final String sirLangVarName = getSirLangVarName(codeRow, command);
        final String javaVarName;
        if (variableService.isVarAlreadyExists(sirLangVarName)) {
            final JavaVariable javaVariable = variableService.getVarByName(sirLangVarName);
            final JavaVariable updatedVariable = variableService.updateVar(sirLangVarName, javaVariable).orElse(javaVariable);
            javaVarName = updatedVariable.getName();
            return format(command.getJavaCommand(), javaVarName, variable.getValue());
        } else {
            javaVarName = variableService.saveNewVar(sirLangVarName, variable);
            final String javaVarType = variable.getType().getSimpleName();
            return format(command.getJavaCommand(), javaVarType + Symbols.SPACE + javaVarName, variable.getValue());
        }
    }

    private String transformAdditionalCommandForCycle(final String codeRow, final Command command) {
        for (int i = 0; ;i++) {
            if (variableService.isVarNotExistsByJavaName(JAVA_COUNTER + i)) {
                final int sirLangCounter = i + 1;
                final String formattedJavaCounter = JAVA_COUNTER + sirLangCounter;
                JavaVariable javaVariable = new JavaVariable(formattedJavaCounter, EMPTY, Long.class);
                String sirLangName = SIRLANG_COUNTER + sirLangCounter;
                variableService.saveVar(sirLangName, javaVariable);
                return formatCycleCommand(codeRow, command, formattedJavaCounter);
            }
        }
    }

    private String formatCycleCommand(final String codeRow, final Command command, final String formattedJavaCounter) {
        if (command == Command.CYCLE_WITH_CONDITION) {
            return format(command.getJavaCommand(), formattedJavaCounter, getArgument(codeRow), formattedJavaCounter);
        } else {
            return format(command.getJavaCommand(), formattedJavaCounter, formattedJavaCounter, getArgument(codeRow),
                    formattedJavaCounter);
        }
    }

    private JavaVariable getJavaVariable(final String codeRow, final Command command) {
        final String commandAndNameValuePair = codeRow.replace(command.getSirCommand(), EMPTY);
        final String notTrimValue = commandAndNameValuePair.split(COMMAND_SEPARATOR)[1];
        final String value = notTrimValue.trim();
        return javaVarParser.parseArgumentToJavaVar(value);
    }

    private String getSirLangVarName(final String codeRow, final Command command) {
        final String formattedCodeRow = codeRow.replaceAll(COMMA, EMPTY).toLowerCase();
        final String notTrimCommandAndVarName = formattedCodeRow.split(COMMAND_SEPARATOR)[0];
        final String notTrimVarName = notTrimCommandAndVarName.replace(command.getSirCommand(), EMPTY);
        return notTrimVarName.trim();
    }


    private Object getArgument(final String codeRow) {
        final String[] methodAndArgument = codeRow.split(COMMAND_SEPARATOR);
        final String formattedArgument = methodAndArgument[1].trim();
        final JavaVariable javaVariable = javaVarParser.parseArgumentToJavaVar(formattedArgument);
        return javaVariable.getName() != null ? javaVariable.getName() : javaVariable.getValue();
    }

}
