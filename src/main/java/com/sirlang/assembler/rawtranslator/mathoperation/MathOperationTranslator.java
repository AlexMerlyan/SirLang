package com.sirlang.assembler.rawtranslator.mathoperation;

import java.util.Optional;

public interface MathOperationTranslator {
    String transformMathematicalOperations(final String argument);
    boolean isString(final String argument);
    boolean isNotString(final String argument);
    boolean isMathematicsExpression(final String argument);
    Optional<Boolean> getBoolean(final String argument);
}
