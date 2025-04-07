package tests;

import entity.User;
import org.testng.asserts.SoftAssert;

public class LoginPrecondition extends BaseTest {
    public static final String EMPTYSURNAMEERROR = "Фамилия обязательна для заполнения";
    public static final String EMPTYCHECKBOX = "Необходимо согласие";
    public static final String EMPTYNAME = "Имя обязательно для заполнения";
    public static final String EMPTYPATRONYMIC = "Отчество обязательно для заполнения";
    public static final String EMPTYPHONE = "Номер телефона введён некорректно";
    public static final String EMPTYEMAIL = "Email обязателен для заполнения";
    public static final String EMPTYPASSWORDS = "Создание пароля обязательно";
    public static final String EMPTYREPEATPASSWORD = "Пароли не совпадают";

    public SoftAssert softAssert = new SoftAssert();
    protected final User VALIDUSER = User.builder()
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

    protected final User USER_WITH_EMPTY_FIELDS= User.builder()
            .name(PropertyReader.getProperty(""))
            .surname(PropertyReader.getProperty(""))
            .patronymic(PropertyReader.getProperty(""))
            .phone(PropertyReader.getProperty(""))
            .email(PropertyReader.getProperty(""))
            .password(PropertyReader.getProperty(""))
            .repeatPassword(PropertyReader.getProperty(""))
            .build();
}