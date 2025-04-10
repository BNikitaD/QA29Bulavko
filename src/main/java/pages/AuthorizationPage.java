package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

@Log4j2
public class AuthorizationPage extends BasePage {

    public static final By TELL_INPUT = By.id("tel");
    public static final By GET_CODE = By.xpath("//*[@type='submit' and contains(.//span, 'Получить код')]");
    public static final By LOGIN_WITH_PASSWORD_BUTTON = By.xpath("//*[@type='button' and contains(.//span, 'Войти по паролю')]");
    public static final By PASSWORD_INPUT = By.id("current-password");
    public static final By ENTER_BUTTON = By.xpath("//*[@type='submit' and contains(.//span, 'Войти')]");
    public static final By VIEW_PASSWORD_BUTTON = By.xpath("//*[contains(@class, 'input_clickable')]");
    public static final By MESSAGE_INVALID_PHONE_NUMBER = By.xpath("/*[contains(@class, 'password_error_message')]");
    public static final By MESSAGE_NON_LOGINED_PHONE_NUMBER = By.xpath("//*[text()='Пожалуйста, убедитесь, что правильно ввели телефон']");
    public static final By MESSAGE_EMPTY_PHONE_NUMBER= By.xpath("//*[text()='Поле \"Номер телефона\" обязательно для заполнения.']");
    public static final By MESSAGE_EMPTY_PASSWORD_INPUT= By.xpath("//*[text()='Поле \"Пароль\" обязательно для заполнения.']");
    public static final By MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS= By.xpath("//*[contains(text(), 'Номер телефона') and contains(text(), 'Пароль')]");
    public static final By NAME_OF_PROFILE = By.xpath("//*[contains(@class, 'actions_action__maxWidth__ekofB') and contains(@class, 'actions_action__text__x4EUd')]");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void logjnWithInvalidPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
    }

    public String getErrorMessageInvalidPhoneNumber() {
        return driver.findElement(MESSAGE_INVALID_PHONE_NUMBER).getText();
    }

    public void loginWithNonPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
    }

    public String getErrorMessageNonLoginedPhoneNumber() {
        return driver.findElement(MESSAGE_NON_LOGINED_PHONE_NUMBER).getText();
    }

    public void loginWithoutAnyFieldsInPhoneOption() {
        driver.findElement(GET_CODE).click();
        driver.findElement(MESSAGE_EMPTY_PHONE_NUMBER);
    }

    public String getErrorMessageEmptyPhoneNumber() {
        return driver.findElement(MESSAGE_EMPTY_PHONE_NUMBER).getText();
    }

    public void checkLoginWithEmptyFields() {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        driver.findElement(ENTER_BUTTON).click();
    }

    public String getErrorMessageEmptyPasswordAndPhoneNumberInputs() {
        return driver.findElement(MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS).getText();
    }

    public void loginInPasswordOption(String password, String tel) {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(VIEW_PASSWORD_BUTTON).click();
        driver.findElement(ENTER_BUTTON).click();
    }

    public void loginWithEmptyPasswordInPasswordOption(String tel) {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(ENTER_BUTTON).click();
    }

    public String getErrorMessageEmptyPasswordInput() {
        return driver.findElement(MESSAGE_EMPTY_PASSWORD_INPUT).getText();
    }
}