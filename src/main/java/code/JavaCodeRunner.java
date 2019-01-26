package code;

import org.apache.commons.lang3.StringUtils;

public class JavaCodeRunner implements CodeRunner {

    public ExecutionResult runCompiledCode(String compiledFilePath) {
        return new ExecutionResult(StringUtils.EMPTY);
    }
}
