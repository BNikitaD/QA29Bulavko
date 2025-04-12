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
    public static final String INVALID_PHONE_NUMBER = "Значение поля \"Номер телефона\" должно начинаться с +375 затем код (25|29|33|44) и далее 7 цифр (первая из которых не 0)";
    public static final By MESSAGE_NON_LOGINED_PHONE_NUMBER = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    public static final String NON_LOGINED_PHONE_NUMBER = "Пожалуйста, убедитесь, что правильно ввели телефон";
    public static final By MESSAGE_EMPTY_PHONE_NUMBER= By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    public static final String EMPTY_PHONE_NUMBER = "Поле \"Номер телефона\" обязательно для заполнения.";
    public static final By MESSAGE_EMPTY_PASSWORD_INPUT = By.xpath("//*[@class='password_error_message__SydTB']");
    public static final String EMPTY_PASSWORD_INPUT = "Поле \"Пароль\" обязательно для заполнения.";
    public static final By MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS = By.xpath("//*[@class='password_error_message__SydTB']");
    public static final String EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS = "Поле \"Номер телефона\" обязательно для заполнения.\n" + "Поле \"Пароль\" обязательно для заполнения.";
    public static final By NAME_OF_PROFILE = By.xpath("//*[contains(@class, 'actions_action__maxWidth__ekofB') and contains(@class, 'actions_action__text__x4EUd')]");
    public static String NAME = "Vlad";

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

    public String getNameOfProfile() {
        return driver.findElement(NAME_OF_PROFILE).getText();
    }

    public void loginWithNonPhoneNumber(String tel) {
        driver.findElement(TELL_INPUT).sendKeys(tel);
        driver.findElement(GET_CODE).click();
    }

    public String getErrorMessageNonLoginedPhoneNumber() {
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_NON_LOGINED_PHONE_NUMBER);
            if (errorMessageElement != null && errorMessageElement.isDisplayed()) {
                return errorMessageElement.getText();
            } else {
                return "Error message element is not displayed.";
            }
        } catch (NoSuchElementException e) {
            return "Error message element not found.";
        }
    }

    public String loginWithoutAnyFieldsInPhoneOption() {
        try {
            WebElement getCodeElement = driver.findElement(GET_CODE);
            if (getCodeElement != null && getCodeElement.isDisplayed()) {
                getCodeElement.click();
                return "Clicked on Get Code button successfully.";
            } else {
                return "Get Code button is not displayed.";
            }
        } catch (NoSuchElementException e) {
            return "Get Code button not found.";
        }
    }

    public String getErrorMessageEmptyPhoneNumber() {
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PHONE_NUMBER);
            if (errorMessageElement != null && errorMessageElement.isDisplayed()) {
                return errorMessageElement.getText();
            } else {
                return "Error message element is not displayed.";
            }
        } catch (NoSuchElementException e) {
            return "Error message element not found.";
        }
    }


    public void checkLoginWithEmptyFields() {
        driver.findElement(LOGIN_WITH_PASSWORD_BUTTON).click();
        driver.findElement(ENTER_BUTTON).click();
    }

    public String getErrorMessageEmptyPasswordAndPhoneNumberInputs() {
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS);
            if (errorMessageElement != null && errorMessageElement.isDisplayed()) {
                return errorMessageElement.getText();
            } else {
                return "Error message element is not displayed.";
            }
        } catch (NoSuchElementException e) {
            return "Error message element not found.";
        }
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
        try {
            WebElement errorMessageElement = driver.findElement(MESSAGE_EMPTY_PASSWORD_INPUT);
            if (errorMessageElement != null && errorMessageElement.isDisplayed()) {
                return errorMessageElement.getText();
            } else {
                return "Error message element is not displayed.";
            }
        } catch (NoSuchElementException e) {
            return "Error message element not found.";
        }
    }
}