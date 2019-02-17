package com.sirlang.program.concatvars;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface SirLangConcatVars {

    String PRINT_STRING_VAR_PLUS_STRING_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка привет: \"привет\"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка пока: \"пока\"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка привет + строка пока" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_PLUS_LONG_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка о дне рождения: \"число моей даты рождения \"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как день рождения: 27" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка о дне рождения + день рождения " + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_PLUS_DOUBLE_WITH_COMMA_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка о дне рождения: \"число моей даты рождения \"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как день рождения: 27,0" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка о дне рождения + день рождения " + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_PLUS_DOUBLE_WITH_POINT_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка о дне рождения: \"число моей даты рождения \"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как день рождения: 27.0" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка о дне рождения + день рождения " + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_PLUS_BOOLEAN_TRUE_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка о дне рождения: \"число моей даты рождения \"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как день рождения: тру" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка о дне рождения + день рождения " + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_PLUS_BOOLEAN_FALSE_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка о дне рождения: \"число моей даты рождения \"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как день рождения: ложь" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка о дне рождения + день рождения " + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_LONG_VAR_PLUS_DOUBLE_WITH_COMMA_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как лонг: 2" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как дабл с запятой: 2,5" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: лонг + дабл с запятой" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_LONG_VAR_PLUS_DOUBLE_WITH_POINT_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как лонг: 2" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как дабл с точкой: 2.5" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: лонг + дабл с точкой" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_DOUBLE_WITH_COMMA_VAR_PLUS_DOUBLE_WITH_POINT_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как дабл с запятой: 2.5" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как дабл с точкой: 2,5" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: дабл с запятой + дабл с точкой" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_LONG_VAR_PLUS_LONG_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как лонг: 2" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как второй лонг: 3" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: лонг + второй лонг" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_LONG_VAR_PLUS_STRING_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как лонг: 2" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка: \"тестовая строка\"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: лонг + строка" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_BOOLEAN_VAR_PLUS_STRING_VAR = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как булиан: тру" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка: \"тестовая строка\"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: булиан + строка" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_STRING_VAR_WITH_CONCAT = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как строка: \"тестовая строка\" + \" и еще одна тестовая строка\"" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: строка" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_DOUBLE_VAR_WITH_CONCAT = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте добры, запомните это как число: 5,2 + 4.8" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: число" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";
}
