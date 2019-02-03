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
            final SplitState state = new SplitState(lastCharIndex);
            for (int i = 0; i < symbols.length; i++) {
                state.setCurrentChar(symbols[i]);
                state.setIteration(i);
                splitByCharIfNeeded(state, argument, operationChar);
                if (StringUtils.isNotEmpty(state.getOperand())) {
                    strings.add(state.getOperand());
                }
            }
        }
        return strings;
    }

    private void splitByCharIfNeeded(final SplitState state, final String argument, final char operationChar) {
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
