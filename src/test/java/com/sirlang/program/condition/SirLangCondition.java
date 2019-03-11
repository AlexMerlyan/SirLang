package com.sirlang.program.condition;

import static com.sirlang.assembler.rawtranslator.symbols.Symbols.LINE_SEPARATOR;

interface SirLangCondition {

    String PRINT_IF_CONDITION_IS_TRUE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте любезны, сделайте следующее если условие верно: правда" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас!" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String SHOULD_NOT_PRINT_BECAUSE_IF_CONDITION_FALSE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте любезны, сделайте следующее если условие верно: 1<0" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас!" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_IF_CONDITION_EQUALS_IS_TRUE = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте любезны, сделайте следующее если условие верно: 1= 1" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас!" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_IF_ELSE_IF_CONDITION = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте любезны, сделайте следующее если условие верно: правда" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас! Или сделайте следующее если условие верно: правда" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Второе условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас!" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

    String PRINT_IF_ELSE_CONDITION = "Приветствую!" + LINE_SEPARATOR +
            "\tСударь, будьте любезны, сделайте следующее если условие верно: ложь" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Условие верно!\"" + LINE_SEPARATOR +
            "\tИли сделайте следующее:" + LINE_SEPARATOR +
            "\tСударь, будьте добры, выведите на экран это: \"Второе условие верно!\"" + LINE_SEPARATOR +
            "\tБлагодарю вас!" + LINE_SEPARATOR +
            "Спасибо вам! Всего хорошего!";

}
