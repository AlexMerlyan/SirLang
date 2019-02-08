package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.CHAR_QUOTE;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class MathOperationSplitterImpl implements MathOperationSplitter {

    @NotNull
    @Override
    public List<String> splitByCharOperation(@NotNull final String argument, final char operationChar) {
        @NotNull final List<String> strings = new ArrayList<>();
        if (StringUtils.isNotEmpty(argument)) {
            @NotNull final char[] symbols = argument.toCharArray();
            final int lastCharIndex = symbols.length - 1;
            @NotNull final SplitState state = new SplitState(lastCharIndex);
            for (int i = 0; i < symbols.length; i++) {
                state.setCurrentChar(symbols[i]);
                state.setIteration(i);
                updateState(state, argument, operationChar);
                if (StringUtils.isNotEmpty(state.getOperand())) {
                    strings.add(state.getOperand());
                }
            }
        }
        return strings;
    }

    private void updateState(final SplitState state, @NotNull final String argument, final char operationChar) {
        if (isStartOrEndString(state.getCurrentChar())) {
            updateStateStringCase(state, argument);
        } else if (operationChar == state.getCurrentChar() && !state.isString()) {
            updateStateOperationCharCase(state, argument);
        } else if (isLastIndex(state.getIteration(), state.getLastCharIndex())) {
            updateStateLastIndexCase(state, argument);
        } else {
            state.setOperand(EMPTY);
        }
    }

    private void updateStateStringCase(@NotNull SplitState state, @NotNull String argument) {
        String operand = EMPTY;
        if (isStartOfString(state)) {
            operand = argument.substring(state.getStartIndex(), state.getIteration());
            state.setStartIndex(state.getIteration());
        } else if (isEndOfString(state)) {
            final int nextIndex = state.getIteration() + 1;
            operand = argument.substring(state.getStartIndex(), nextIndex);
            state.setStartIndex(nextIndex);
        }
        state.inverseIsStringBooleanField();
        state.setOperand(operand);
    }

    private void updateStateOperationCharCase(final SplitState state, final String argument) {
        @NotNull final String operand = argument.substring(state.getStartIndex(), state.getIteration());
        state.setStartIndex(updateStartIndexForOperationCase(state.getIteration()));
        state.setOperand(operand);
    }

    private void updateStateLastIndexCase(final SplitState state, final String argument) {
        @NotNull final String operand = argument.substring(state.getStartIndex());
        state.setOperand(operand);
    }

    private boolean isStartOfString(final SplitState state) {
        return state.isNotString();
    }

    private boolean isEndOfString(final SplitState state) {
        return state.isString();
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
