package com.sirlang.program.vars;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaVarCode {

    String HELLO_WORLD_WITH_STRING_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"Моя первая программа на языке Сударь!\";" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_WITH_LONG_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 2019L;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_WITH_DOUBLE_WITH_COMMA_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2019.1;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_WITH_DOUBLE_WITH_POINT_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2019.1;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_WITH_BOOLEAN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = true;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_WITH_DOUBLE_LONG_STRING_BOOLEAN_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = false;" + LINE_SEPARATOR +
            "Long var1 = 2019L;" + LINE_SEPARATOR +
            "Double var2 = 2019.1;" + LINE_SEPARATOR +
            "String var3 = \"Моя строка\";" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "System.out.println(var1);" + LINE_SEPARATOR +
            "System.out.println(var2);" + LINE_SEPARATOR +
            "System.out.println(var3);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;


}
