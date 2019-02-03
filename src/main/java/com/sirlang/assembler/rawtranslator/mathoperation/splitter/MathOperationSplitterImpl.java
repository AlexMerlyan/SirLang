package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import com.sirlang.assembler.rawtranslator.mathoperation.MathOperation;
import com.sirlang.assembler.rawtranslator.mathoperation.splitter.MathOperationSplitter;
import com.sirlang.assembler.rawtranslator.mathoperation.splitter.SplitState;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.CHAR_QUOTE;

public class MathOperationSplitterImpl implements MathOperationSplitter {

    @Override
    public List<String> splitByCharOperation(final String argument, final char operationChar) {
        final List<String> strings = new ArrayList<>();
        if (StringUtils.isNotEmpty(argument)) {
            final char[] symbols = argument.toCharArray();
            final int lastCharIndex = symbols.length - 1;
            int startIndex = 0;
            boolean isString = false;
            SplitState state = new SplitState(0, symbols[0], lastCharIndex, false);
            for (int i = 1; i < symbols.length; i++) {
                state = splitByCharIfNeeded(state, argument, operationChar);
                strings.add(state.getOperand());
            }
        }
        return strings;
    }

    @Override
    public List<String> splitByCharOperation(String argument, MathOperation mathOperation) {
        final List<String> strings = new ArrayList<>();
        final char[] symbols = argument.toCharArray();
        int startIndex = 0;
        final char operationChar = mathOperation.getCharEquivalent();
        boolean isString = false;
        for (int i = 0; i < symbols.length; i++) {
            if (CHAR_QUOTE == symbols[i]) {
                if (!isString) {
                    strings.add(argument.substring(startIndex, i));
                    startIndex = i;
                }
                isString = !isString;
                if (!isString) {
                    strings.add(argument.substring(startIndex, i + 1));
                    startIndex = i + 1;
                }
            } else if (operationChar == symbols[i] && !isString) {
                strings.add(argument.substring(startIndex, i));
                startIndex = i + 1;
            } else if (i == symbols.length - 1) {
                strings.add(argument.substring(startIndex));
            }
        }
        return strings;
    }

    private SplitState splitByCharIfNeeded(final SplitState state, final String argument, final char operationChar) {
        String operand = StringUtils.EMPTY;
        if (isStartOrEndString(state.getCurrentChar())) {
            if (!state.isString()) {
                operand = argument.substring(state.getStartIndex(), state.getIteration());
                state.setStartIndex(state.getIteration());
            }
            state.setString(!state.isString());
            if (!state.isString()) {
                final int nextIndex = state.getIteration() + 1;
                operand = argument.substring(state.getStartIndex(), nextIndex);
                state.setStartIndex(nextIndex);
            }
        } else if (operationChar == state.getCurrentChar() && !state.isString()) {
            operand = argument.substring(state.getStartIndex(), state.getIteration());
            state.setStartIndex(updateStartIndexForOperationCase(state.getIteration()));
        } else if (isLastIndex(state.getIteration(), state.getLastCharIndex())) {
            operand = argument.substring(state.getStartIndex());
        }
        state.setOperand(operand);
        return state;
    }

    private boolean isLastIndex(final int iteration, final int lastCharIndex) {
        return iteration == lastCharIndex;
    }

    private int updateStartIndexForOperationCase(int iteration) {
        return ++iteration;
    }

    private boolean isStartOrEndString(final char symbol) {
        return CHAR_QUOTE == symbol;
    }

}
