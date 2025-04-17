package tests;

public interface ITestConstants {

    String PAYMENT_PAGE = "https://pay196.paysec.by";
    String URL_OF_PRODUCT = "https://emall.by/product/831332";
    String ENTRY_PAGE = "https://emall.by/login?backurl=/";
    String INVALID_PHONE_NUMBER_ERROR = "Значение поля \"Номер телефона\" должно начинаться с +375 затем код (25|29|33|44) и далее 7 цифр (первая из которых не 0)";
    String NON_LOGINED_PHONE_NUMBER_ERROR = "Пожалуйста, убедитесь, что правильно ввели телефон";
    String EMPTY_PHONE_NUMBER_ERROR = "Поле \"Номер телефона\" обязательно для заполнения.";
    String EMPTY_PASSWORD_ERROR = "Поле \"Пароль\" обязательно для заполнения.";
    String EMPTY_PASSWORD_AND_PHONE_NUMBER_ERROR = "Поле \"Номер телефона\" обязательно для заполнения.\n" + "Поле \"Пароль\" обязательно для заполнения.";
    String NAME = "Vlad";
}
