package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import elements.Checkbox;

/**
 * The type Login page.
 */
@Log4j2
public class LoginPage extends BasePage {

    private static final By REGISTRATION_BUTTON= By.xpath("//*[text()='Зарегистрироваться']");
    private static final By NAME_INPUT = By.name("name");
    private static final By SURNAME_INPUT = By.name("surname");
    private static final By PATRONYMIC_INPUT = By.name("patronymic");
    private static final By PHONE_INPUT = By.name("phone");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By PASSWORD_REPEAT_INPUT = By.name("passwordRepeat");
    private static final By SUBMIT_BUTTON = By.xpath("//*[@type='submit']");
    private static final By ERROR_MESSAGE_SURNAME = By.xpath("(//*[@class='input_message__DoTq9'])[2] ");
    private static final By ERROR_MESSAGE_CHECKBOX = By.xpath("(//div[@class='registration_error__9Npgk'])[2] ");
    private static final By ERROR_MESSAGE_NAME = By.xpath("(//*[@class='input_message__DoTq9'])[1] ");
    private static final By ERROR_MESSAGE_PATRONYMIC = By.xpath("(//*[@class='input_message__DoTq9'])[3] ");
    private static final By ERROR_MESSAGE_PHONE = By.xpath("//*[@class='new-input-phone_message__WsZQD']");
    private static final By ERROR_MESSAGE_EMAIL = By.xpath("(//*[@class='input_message__DoTq9'])[4]");
    private static final By ERROR_MESSAGE_PASSWORDS = By.xpath("(//div[@class='registration_error__9Npgk'])[1]");
    private static final By ERROR_MESSAGE_REPEAT_PASSWORD = By.xpath("//*[contains(@class, 'registration_error')]");
    private static final By SCROLL_DOWN_BUTTON = By.xpath("//*[contains(@class, 'policy-consent_scroll_to_bottom_button__cJgUD')]");
    private static final By MAIN_CHECKBOX_IN_LOGIN_PAGE = By.xpath("//*[@data-test-id=\"checkbox-personal-data\"]");
    private static final By CHECKBOX_IN_MODAL_WINDOW = By.xpath("//*[@data-test-id=\"account-creation-consent\"]");
    private static final By AGREE_BUTTON = By.xpath("//*[contains(text(), 'Согласен')]");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//*[contains(@class, 'btn_btn__jx6SQ') and contains(@class, 'confirm-code_enter_button__vMrHH')]");

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click registration button login page.
     *
     * @return the login page
     */
    public LoginPage clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
        return this;
    }

    /**
     * Fill login form login page.
     *
     * @param user the user
     * @return the login page
     */
    public LoginPage fillLoginForm(User user){
        driver.findElement(NAME_INPUT).sendKeys(user.getName());
        driver.findElement(SURNAME_INPUT).sendKeys(user.getSurname());
        driver.findElement(PATRONYMIC_INPUT).sendKeys(user.getPatronymic());
        driver.findElement(PHONE_INPUT).sendKeys(user.getPhone());
        driver.findElement(EMAIL_INPUT).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(PASSWORD_REPEAT_INPUT).sendKeys(user.getRepeatPassword());
        log.info("Форма логина заполнена");
        return this;
    }

    /**
     * Sets checked agree policy.
     *
     * @return the checked agree policy
     */
    public LoginPage setCheckedAgreePolicy() {
        log.info("Установка чекбокса");
        new Checkbox(driver).setCheckboxValue(true, MAIN_CHECKBOX_IN_LOGIN_PAGE);
        return this;
    }

    /**
     * Click submit button login page.
     *
     * @return the login page
     */
    public LoginPage clickSubmitButton() {
        log.info("Нажатие на кнопку 'Далее'");
        driver.findElement(SUBMIT_BUTTON).click();
        return this;
    }

    /**
     * Click scroll down button login page.
     *
     * @return the login page
     */
    public LoginPage clickScrollDownButton() {
        log.info("Нажатие на кнопку прокрутки вниз");
        driver.findElement(SCROLL_DOWN_BUTTON).click();
        return this;
    }

    /**
     * Click agree button in modal window login page.
     *
     * @return the login page
     */
    public LoginPage clickAgreeButtonInModalWindow() {
        log.info("Нажатие на кнопку 'Согласен' в модальном окне");
        new Checkbox(driver).setCheckboxValue(true, CHECKBOX_IN_MODAL_WINDOW);
        return this;
    }

    /**
     * Gets error message text check box.
     *
     * @return the error message text check box
     */
    public String getErrorMessageTextCheckBox() {
        return driver.findElement(ERROR_MESSAGE_CHECKBOX).getText();
    }

    /**
     * Gets error message text surname.
     *
     * @return the error message text surname
     */
    public String getErrorMessageTextSurname() {
        return driver.findElement(ERROR_MESSAGE_SURNAME).getText();
    }

    /**
     * Gets error message text name.
     *
     * @return the error message text name
     */
    public String getErrorMessageTextName() {
        return driver.findElement(ERROR_MESSAGE_NAME).getText();
    }

    /**
     * Gets error message text patronymic.
     *
     * @return the error message text patronymic
     */
    public String getErrorMessageTextPatronymic() {
        return driver.findElement(ERROR_MESSAGE_PATRONYMIC).getText();
    }

    /**
     * Gets error message text phone.
     *
     * @return the error message text phone
     */
    public String getErrorMessageTextPhone() {
        return driver.findElement(ERROR_MESSAGE_PHONE).getText();
    }

    /**
     * Gets error message text email.
     *
     * @return the error message text email
     */
    public String getErrorMessageTextEmail() {
        return driver.findElement(ERROR_MESSAGE_EMAIL).getText();
    }

    /**
     * Gets error message text passwords.
     *
     * @return the error message text passwords
     */
    public String getErrorMessageTextPasswords() {
        return driver.findElement(ERROR_MESSAGE_PASSWORDS).getText();
    }

    /**
     * Gets error message text repeat password.
     *
     * @return the error message text repeat password
     */
    public String getErrorMessageTextRepeatPassword() {
        return driver.findElement(ERROR_MESSAGE_REPEAT_PASSWORD).getText();
    }

    /**
     * Gets create account text.
     *
     * @return the create account text
     */
    public String getCreateAccountText() {
        return driver.findElement(CREATE_ACCOUNT_BUTTON).getText();
    }
}