package pages;

import entity.User;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Checkbox;

@Log4j2
public class LoginPage extends BasePage {

    public static final By REGISTRATION_BUTTON= By.xpath("//*[text()='Зарегистрироваться']");
    public static final By NAME_INPUT = By.name("name");
    public static final By SURNAME_INPUT = By.name("surname");
    public static final By PATRONYMIC_INPUT = By.name("patronymic");
    public static final By PHONE_INPUT = By.name("phone");
    public static final By EMAIL_INPUT = By.name("email");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By PASSWORDREPEAT_INPUT = By.name("passwordRepeat");
    //public static final By CHECK_BOX = By.xpath("//*[@data-test-id='checkbox-personal-data']/following-sibling::span[contains(@class, 'checkbox_checkbox__pseudo')]");
    public static final By SUBMIT_BUTTON = By.xpath("//*[@type='submit']");
    public static final By ERROR_MESSAGE_SURNAME = By.xpath("//*[contains(text(), 'Фамилия обязательна для заполнения')]");
    public static final By ERROR_MESSAGE_CHECKBOX = By.xpath("//*[contains(text(), 'Необходимо согласие')]");
    public static final By ERROR_MESSAGE_NAME = By.xpath("//*[contains(text(), 'Имя обязательно для заполнения')]");
    public static final By ERROR_MESSAGE_PATRONYMIC = By.xpath("//*[contains(text(), 'Отчество обязательно для заполнения')]");
    public static final By ERROR_MESSAGE_PHONE = By.xpath("//*[contains(text(), 'Номер телефона введён некорректно')]");
    public static final By ERROR_MESSAGE_EMAIL = By.xpath("//*[contains(text(), 'Email обязателен для заполнения')]");
    public static final By ERROR_MESSAGE_PASSWORDS = By.xpath("//*[contains(text(), 'Создание пароля обязательно')]");
    public static final By ERROR_MESSAGERE_PEATPASSWORD = By.xpath("//*[contains(text(), 'Пароли не совпадают')]");
    public static final By SCROLL_DOWN_BUTTON = By.xpath("//*[contains(@class, 'policy-consent_scroll_to_bottom_button__cJgUD')]");
    public static final By MAIN_CHECKBOX_IN_MODAL_WINDOW = By.xpath("//*[contains(text(), '* Создание и администрирование личного кабинета')]");
    public static final By AGREE_BUTTON = By.xpath("//*[contains(text(), 'Согласен')]");



    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    public void fillLoginForm(User user){
        driver.findElement(NAME_INPUT).sendKeys(user.getName());
        driver.findElement(SURNAME_INPUT).sendKeys(user.getSurname());
        driver.findElement(PATRONYMIC_INPUT).sendKeys(user.getPatronymic());
        driver.findElement(PHONE_INPUT).sendKeys(user.getPhone());
        driver.findElement(EMAIL_INPUT).sendKeys(user.getEmail());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(PASSWORDREPEAT_INPUT).sendKeys(user.getRepeatPassword());
        log.info("Форма заполнена");
    }
    public void checkBox() {
        Checkbox checkBox = new Checkbox(driver, "removeSecondProduct");
        checkBox.setCheckboxValue(true);
    }
    public void clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void clickScrollDownButton() {
        log.info("Нажатие на кнопку прокрутки вниз");
        driver.findElement(SCROLL_DOWN_BUTTON).click();
    }
    public void clickMainCheckBoxInModal() {
        log.info("Нажатие на основной чекбокс в модальном окне");
        driver.findElement(MAIN_CHECKBOX_IN_MODAL_WINDOW).click();
    }
    public void clickAgreeButtonInModalWindow() {
        driver.findElement(AGREE_BUTTON).click();
    }

    public String getErrorMessageTextCheckBox() {
        return driver.findElement(ERROR_MESSAGE_CHECKBOX).getText();
    }

    public String getErrorMessageTextSurname() {
        return driver.findElement(ERROR_MESSAGE_SURNAME).getText();
    }

    public String getErrorMessageTextName() {
        return driver.findElement(ERROR_MESSAGE_NAME).getText();
    }

    public String getErrorMessageTextPatronymic() {
        return driver.findElement(ERROR_MESSAGE_PATRONYMIC).getText();
    }

    public String getErrorMessageTextPhone() {
        return driver.findElement(ERROR_MESSAGE_PHONE).getText();
    }

    public String getErrorMessageTextEmail() {
        return driver.findElement(ERROR_MESSAGE_EMAIL).getText();
    }

    public String getErrorMessageTextPasswords() {
        return driver.findElement(ERROR_MESSAGE_PASSWORDS).getText();
    }

    public String getErrorMessageTextREPEATPASSWORD() {
        return driver.findElement(ERROR_MESSAGERE_PEATPASSWORD).getText();
    }
}