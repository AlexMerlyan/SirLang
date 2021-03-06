package com.sirlang;

public interface ErrorMessages {
    String BOOLEAN_NOT_FOUND_ERROR_MESSAGE = "Boolean value was not found!";
    String FILE_EXTENSION_ERROR_MESSAGE = "The source file should be with .sir extension!";
    String START_PROGRAM_ABSENT_ERROR_MESSAGE = "The source code of SirLang should contains start of program!";
    String END_PROGRAM_ABSENT_ERROR_MESSAGE = "The source code of SirLang should contains end of program!";
    String NO_ARGUMENTS_TO_COMPILE = "Через пробел укажите пожалуйста полный путь к файлу с разширением .sir";
    String SOMETHING_WAS_WRONG = "Видимо что-то пошло не так, обратитесь к разработчику-рукожопу";
}
