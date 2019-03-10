package com.sirlang.assembler.rawtranslator.mathoperation.splitter;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.CHAR_QUOTE;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class MathOperationSplitterImpl implements MathOperationSplitter {

    @Override
    public List<String> splitByCharOperation(final String argument, final char operationChar) {
        final List<String> arguments = new ArrayList<>();
        if (StringUtils.isNotEmpty(argument)) {
            final char[] symbols = argument.toCharArray();
            final int lastCharIndex = symbols.length - 1;
            final SplitState state = new SplitState(lastCharIndex);
            for (int i = 0; i < symbols.length; i++) {
                state.setCurrentChar(symbols[i]);
                state.setIteration(i);
                updateState(state, argument, operationChar);
                if (StringUtils.isNotEmpty(state.getOperand())) {
                    arguments.add(state.getOperand());
                }
            }
        }
        return arguments;
    }

    private void updateState(final SplitState state, final String argument, final char operationChar) {
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

    private void updateStateStringCase(SplitState state, String argument) {
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
        final String operand = argument.substring(state.getStartIndex(), state.getIteration());
        state.setStartIndex(updateStartIndexForOperationCase(state.getIteration()));
        state.setOperand(operand);
    }

    private void updateStateLastIndexCase(final SplitState state, final String argument) {
        final String operand = argument.substring(state.getStartIndex());
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
