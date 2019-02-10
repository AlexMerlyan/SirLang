package com.sirlang.assembler.rawtranslator.mathoperation;

import java.util.Optional;

public interface MathOperationTranslator {
    String transformMathematicalOperations(final String expression);

    boolean isString(final String argument);

    boolean isMathematicsExpression(final String argument);

    Optional<Boolean> getBoolean(final String argument);
}
