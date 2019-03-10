package com.sirlang.program.concat;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface SirLangConcat {

    String PRINT_BOOLEAN_TRUE_PLUS_STRING = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: правда + \" это моя строка\"" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_PLUS_BOOLEAN_FALSE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Это моя строка \" + ложь" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_PLUS_LONG_PLUS_DOUBLE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"СТРОКА С ЧИСЛАМИ = \" + 6 + 2,2" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_LONG_PLUS_LONG_PLUS_STRING_PLUS_LONG_PLUS_DOUBLE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: 2+2+ \"СТРОКА + С + 1,1 + ЧИСЛАМИ = \" + 6 + 2,2" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_PLUS_IN_END = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Это моя строка \" + 555 + \"Тестовая строка+\"" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_PLUS_LONG_PLUS_STRING_WITH_MINUS_IN_END = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Это моя строка \" + 555 + \"Тестовая строка-\"" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

}
