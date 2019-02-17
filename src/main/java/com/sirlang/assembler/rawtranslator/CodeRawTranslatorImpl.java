package com.sirlang.assembler.rawtranslator;

import com.sirlang.assembler.command.Command;
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
        } else {
            return format(command.getJavaCommand(), getArgument(codeRow));
        }
    }

    private String transformAdditionalCommandToJava(final String codeRow, final Command command) {
        final JavaVariable variable = getJavaVariable(codeRow, command);
        final String sirLangVarName = getSirLangVarName(codeRow, command);
        final String javaVarName = variableService.saveVar(sirLangVarName, variable);
        return format(command.getJavaCommand(), variable.getType().getSimpleName(), javaVarName, variable.getValue());
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
