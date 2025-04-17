package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The type Authorization page.
 */
@Log4j2
public class AuthorizationPage extends BasePage {

    private static final By TELL_INPUT = By.id("tel");
    private static final By GET_CODE = By.xpath("//*[@type='submit' and contains(.//span, 'Получить код')]");
    private static final By LOGIN_WITH_PASSWORD_BUTTON = By.xpath("//*[@type='button' and contains(.//span, 'Войти по паролю')]");
    private static final By PASSWORD_INPUT = By.id("current-password");
    private static final By ENTER_BUTTON = By.xpath("//*[@type='submit' and contains(.//span, 'Войти')]");
    private static final By VIEW_PASSWORD_BUTTON = By.xpath("//*[contains(@class, 'input_clickable')]");
    private static final By MESSAGE_INVALID_PHONE_NUMBER = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    private static final By MESSAGE_NON_LOGGED_IN_PHONE_NUMBER = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    private static final By MESSAGE_EMPTY_PHONE_NUMBER= By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    private static final By MESSAGE_EMPTY_PASSWORD_INPUT = By.xpath("//*[@class='password_error_message__SydTB']");
    private static final By MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS = By.xpath("//*[@class='password_error_message__SydTB']");
    private static final By NAME_OF_PROFILE = By.xpath("//*[@class='actions_action__maxWidth__ekofB actions_action__text__x4EUd']");

    /**
     * Instantiates a new Authorization page.
     *
     * @param driver the driver
     */
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login with invalid phone number.
     *
     * @param tel the tel
     */
    public void loginWithInvalidPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
        log.info("Нажата кнопка 'Получить код'");
    }

    /**
     * Gets error message invalid phone number.
     *
     * @return the error message invalid phone number
     */
    public String getErrorMessageInvalidPhoneNumber() {
        log.info("Получаем сообщение об ошибке для некорректного номера телефона.");
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_INVALID_PHONE_NUMBER);
            if (errorMessageElement.isDisplayed()) {
                String message = errorMessageElement.getText();
                log.info("Сообщение об ошибке получено");
                return message;
            } else {
                return "Элемент сообщения об ошибке не отображается.";
            }
        } catch (NoSuchElementException e) {
            return "Элемент сообщения об ошибке не найден.";
        }
    }

    /**
     * Gets name of profile.
     *
     * @return the name of profile
     */
    public String getNameOfProfile() {
        log.info("Получаем имя профиля.");
        try {
            WebElement profileNameElement = driver.findElement(NAME_OF_PROFILE);
            if (profileNameElement.isDisplayed()) {
                String profileName = profileNameElement.getText();
                log.info("Имя профиля найдено");
                return profileName;
            } else {
                return "Элемент с именем профиля не отображается.";
            }
        } catch (NoSuchElementException e) {
            return "Элемент с именем профиля не найден.";
        }
    }

    /**
     * Login with non phone number.
     *
     * @param tel the tel
     */
    public void loginWithNonPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
        log.info("Нажата кнопка 'Получить код'");
    }

    /**
     * Gets error message non logged in phone number.
     *
     * @return the error message non logged in phone number
     */
    public String getErrorMessageNonLoggedInPhoneNumber() {
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_NON_LOGGED_IN_PHONE_NUMBER);
            if (errorMessageElement.isDisplayed()) {
                String message = errorMessageElement.getText();
                log.info("Сообщение об ошибке получено: ");
                return message;
            } else {
                return "Элемент сообщения об ошибке не отображается.";
            }
        } catch (NoSuchElementException e) {
            return "Элемент сообщения об ошибке не найден.";
        }
    }

    /**
     * Click get code.
     */
    public void clickGetCode() {
        driver.findElement(GET_CODE).click();
        log.info("Кнопка Получить код нажата");
    }

    /**
     * Gets error message empty phone number.
     *
     * @return the error message empty phone number
     */
    public String getErrorMessageEmptyPhoneNumber() {
        try {
            log.info("Получаем сообщение об ошибке для пустого номера телефона.");
            return driver.findElement(MESSAGE_EMPTY_PHONE_NUMBER).getText();
        } catch (Exception e) {
            log.error("Элемент сообщения об ошибке не найден.");
            return " ";
        }
    }

    /**
     * Login with empty fields.
     */
    public void loginWithEmptyFields() {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка 'Войти по паролю'.");
        driver.findElement(ENTER_BUTTON).click();
        log.info("Нажата кнопка 'Войти'.");
    }

    /**
     * Gets error message empty password and phone number inputs.
     *
     * @return the error message empty password and phone number inputs
     */
    public String getErrorMessageEmptyPasswordAndPhoneNumberInputs() {
        try {
            log.info("Получаем сообщение об ошибке для пустых полей пароля и номера телефона.");
            return driver.findElement(MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS).getText();
        } catch (Exception e) {
            return " ";
        }
    }

    /**
     * Login with password option.
     *
     * @param password the password
     * @param tel      the tel
     */
    public void loginWithPasswordOption(String password, String tel) {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка 'Войти по паролю'.");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(VIEW_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка для отображения пароля.");
        driver.findElement(ENTER_BUTTON).click();
        log.info("Нажата кнопка 'Войти'.");
    }

    /**
     * Login with empty password in password option.
     *
     * @param tel the tel
     */
    public void loginWithEmptyPasswordInPasswordOption(String tel) {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка 'Войти по паролю'.");
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(ENTER_BUTTON).click();
        log.info("Нажата кнопка 'Войти'.");
    }

    /**
     * Gets error message empty password input.
     *
     * @return the error message empty password input
     */
    public String getErrorMessageEmptyPasswordInput() {
        try {
            log.info("Получаем сообщение об ошибке для пустого поля пароля.");
            return driver.findElement(MESSAGE_EMPTY_PASSWORD_INPUT).getText();
        } catch (Exception e) {
            return " ";
        }
    }
}