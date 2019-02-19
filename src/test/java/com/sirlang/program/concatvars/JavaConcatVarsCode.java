package com.sirlang.program.concatvars;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface JavaConcatVarsCode {

    String PRINT_STRING_VAR_PLUS_STRING_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"привет\";" + LINE_SEPARATOR +
            "String var1 = \"пока\";" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_PLUS_LONG_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"число моей даты рождения \";" + LINE_SEPARATOR +
            "Long var1 = 27L;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_PLUS_DOUBLE_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"число моей даты рождения \";" + LINE_SEPARATOR +
            "Double var1 = 27.0;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_PLUS_BOOLEAN_TRUE_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"число моей даты рождения \";" + LINE_SEPARATOR +
            "Boolean var1 = true;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_PLUS_BOOLEAN_FALSE_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"число моей даты рождения \";" + LINE_SEPARATOR +
            "Boolean var1 = false;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_VAR_PLUS_DOUBLE_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 2L;" + LINE_SEPARATOR +
            "Double var1 = 2.5;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_WITH_COMMA_VAR_PLUS_DOUBLE_WITH_POINT_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2.5;" + LINE_SEPARATOR +
            "Double var1 = 2.5;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_VAR_PLUS_LONG_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 2L;" + LINE_SEPARATOR +
            "Long var1 = 3L;" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_LONG_VAR_PLUS_STRING_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Long var0 = 2L;" + LINE_SEPARATOR +
            "String var1 = \"тестовая строка\";" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_BOOLEAN_VAR_PLUS_STRING_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Boolean var0 = true;" + LINE_SEPARATOR +
            "String var1 = \"тестовая строка\";" + LINE_SEPARATOR +
            "System.out.println(var0+var1);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_WITH_CONCAT_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"тестовая строка\" + \" и еще одна тестовая строка\";" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_VAR_WITH_CONCAT_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 5.2+4.8;" + LINE_SEPARATOR +
            "System.out.println(var0);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_STRING_VAR_INIT_BY_STRING_VAR_PLUS_STRING_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "String var0 = \"значение строки 1\";" + LINE_SEPARATOR +
            "String var1 = \"значение строки 2\";" + LINE_SEPARATOR +
            "String var2 = var0+var1;" + LINE_SEPARATOR +
            "System.out.println(var2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

    String PRINT_DOUBLE_VAR_INIT_BY_DOUBLE_VAR_PLUS_LONG_VAR_JAVA_CODE = "public class Main {" + LINE_SEPARATOR +
            "public static void main(String[] args) {" + LINE_SEPARATOR +
            "Double var0 = 2.2;" + LINE_SEPARATOR +
            "Long var1 = 1L;" + LINE_SEPARATOR +
            "Double var2 = var0+var1;" + LINE_SEPARATOR +
            "System.out.println(var2);" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR +
            "}" + LINE_SEPARATOR;

}
