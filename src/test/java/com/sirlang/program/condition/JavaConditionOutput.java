package com.sirlang.program.condition;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;
import static org.apache.commons.lang3.StringUtils.EMPTY;

interface JavaConditionOutput {
    String PRINT_IF_CONDITION_IS_TRUE_OUTPUT = "Условие верно!" + LINE_SEPARATOR;
    String SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE_OUTPUT = EMPTY;
    String PRINT_IF_ELSE_CONDITION_OUTPUT = "Второе условие верно!" + LINE_SEPARATOR;
}
