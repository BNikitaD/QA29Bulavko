package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class AuthorizationPage extends BasePage {

    public static final By TELL_INPUT = By.id("tel");
    public static final By GET_CODE = By.xpath("//*[@type='submit' and contains(.//span, 'Получить код')]");
    public static final By LOGIN_WITH_PASSWORD_BUTTON = By.xpath("//*[@type='button' and contains(.//span, 'Войти по паролю')]");
    public static final By PASSWORD_INPUT = By.id("current-password");
    public static final By ENTER_BUTTON = By.xpath("//*[@type='submit' and contains(.//span, 'Войти')]");
    public static final By VIEW_PASSWORD_BUTTON = By.xpath("//*[contains(@class, 'input_clickable')]");
    public static final By MESSAGE_INVALID_PHONE_NUMBER = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    public static final By MESSAGE_NON_LOGGED_IN_PHONE_NUMBER = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    public static final By MESSAGE_EMPTY_PHONE_NUMBER= By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    public static final By MESSAGE_EMPTY_PASSWORD_INPUT = By.xpath("//*[@class='password_error_message__SydTB']");
    public static final By MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS = By.xpath("//*[@class='password_error_message__SydTB']");
    //TODO: поменять локатор
    public static final By NAME_OF_PROFILE = By.xpath("//*[contains(@class, 'actions_action__maxWidth__ekofB') and contains(@class, 'actions_action__text__x4EUd')]");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithInvalidPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
        log.info("Нажата кнопка 'Получить код'");
    }

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

    public void loginWithNonPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
        log.info("Нажата кнопка 'Получить код'");
    }

    public String getErrorMessageNonLoginedPhoneNumber() {
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

    public String loginWithoutAnyFieldsInPhoneOption() {
        try {
            WebElement getCodeElement = driver.findElement(GET_CODE);
            if (getCodeElement.isDisplayed()) {
                getCodeElement.click();
                log.info("Нажата кнопка 'Получить код' без ввода значений.");
                return "Нажали кнопку 'Получить код' успешно.";
            } else {
                return "Кнопка 'Получить код' не отображается.";
            }
        } catch (NoSuchElementException e) {
            return "Кнопка 'Получить код' не найдена.";
        }
    }

    public String getErrorMessageEmptyPhoneNumber() {
        log.info("Получаем сообщение об ошибке для пустого номера телефона.");
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PHONE_NUMBER);
            if (errorMessageElement.isDisplayed()) {
                String message = errorMessageElement.getText();
                log.info("Сообщение об ошибке получено: ");
                return message;
            } else {
                return "Элемент сообщения об ошибке не отображается.";
            }
        } catch (NoSuchElementException e) {
            log.error("Элемент сообщения об ошибке не найден.");
            return "Элемент сообщения об ошибке не найден.";
        }
    }

    public void checkLoginWithEmptyFields() {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка 'Войти по паролю'.");
        driver.findElement(ENTER_BUTTON).click();
        log.info("Нажата кнопка 'Войти'.");
    }

    public String getErrorMessageEmptyPasswordAndPhoneNumberInputs() {
        log.info("Получаем сообщение об ошибке для пустых полей пароля и номера телефона.");
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS);
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

    public void loginWithEmptyPasswordInPasswordOption(String tel) {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        log.info("Нажата кнопка 'Войти по паролю'.");
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(ENTER_BUTTON).click();
        log.info("Нажата кнопка 'Войти'.");
    }

    public String getErrorMessageEmptyPasswordInput() {
        log.info("Получаем сообщение об ошибке для пустого поля пароля.");
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PASSWORD_INPUT);
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
}