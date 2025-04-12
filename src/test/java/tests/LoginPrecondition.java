package tests;

import entity.User;
import org.testng.asserts.SoftAssert;

public class LoginPrecondition extends BaseTest {
    public static final String EMPTY_SURNAME_ERROR = "Фамилия обязательна для заполнения";
    public static final String EMPTY_CHECKBOX = "Необходимо согласие";
    public static final String EMPTY_NAME = "Имя обязательно для заполнения";
    public static final String EMPTY_PATRONYMIC = "Отчество обязательно для заполнения";
    public static final String EMPTY_PHONE = "Номер телефона введён некорректно";
    public static final String EMPTY_EMAIL = "Email обязателен для заполнения";
    public static final String EMPTY_PASSWORDS = "Создание пароля обязательно";
    public static final String EMPTY_REPEAT_PASSWORD = "Пароли не совпадают";
    public static final String CREATE_ACCOUNT = "Создать аккаунт";

    public SoftAssert softAssert = new SoftAssert();
    protected final User VALID_USER = User.builder()
            .name(PropertyReader.getProperty("name"))
            .surname(PropertyReader.getProperty("name"))
            .patronymic(PropertyReader.getProperty("patronymic"))
            .phone(PropertyReader.getProperty("phone"))
            .email(PropertyReader.getProperty("email"))
            .password(PropertyReader.getProperty("password"))
            .repeatPassword(PropertyReader.getProperty("password"))
            .build();

    protected final User USER_WITH_EMPTY_REPEAT_PASSWORD = User.builder()
            .name(PropertyReader.getProperty("name"))
            .surname(PropertyReader.getProperty("name"))
            .patronymic(PropertyReader.getProperty("patronymic"))
            .phone(PropertyReader.getProperty("phone"))
            .email(PropertyReader.getProperty("email"))
            .password(PropertyReader.getProperty("password"))
            .repeatPassword("")
            .build();

    protected final User USER_WITH_EMPTY_FIELDS = User.builder()
            .name(PropertyReader.getProperty(""))
            .surname(PropertyReader.getProperty(""))
            .patronymic(PropertyReader.getProperty(""))
            .phone(PropertyReader.getProperty(""))
            .email(PropertyReader.getProperty(""))
            .password(PropertyReader.getProperty(""))
            .repeatPassword(PropertyReader.getProperty(""))
            .build();
}