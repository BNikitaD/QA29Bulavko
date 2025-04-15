package steps;

import waiters.Waiter;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import static waiters.Waiter.AGREEMENT;

public class LoginSteps {

    Waiter waiter = new Waiter();
    private LoginPage loginPage;
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        this.driver = driver;
    }

    @Step
    public LoginSteps registrationFieldsandSubmitButton(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.clickSubmitButton();
        return this;
    }

    @Step
    public LoginSteps noValidRegistration(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.setCheckbox();
        loginPage.clickScrollDownButton();
        return this;
    }

    @Step
    public LoginSteps successfulRegistration(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.setCheckbox();
        waiter.waitForElement(driver, AGREEMENT, 10);
        loginPage.clickScrollDownButton();
        loginPage.clickMainCheckBoxInModal();
        loginPage.clickAgreeButtonInModalWindow();
        loginPage.clickSubmitButton();
        return this;
    }

    @Step
    public String getCreateAccountText() {
        return loginPage.getCreateAccountText();
    }

    @Step
    public String getErrorMessageTextCheckBox() {
        return loginPage.getErrorMessageTextCheckBox();
    }

    @Step
    public String getErrorMessageTextRepeatPassword() {
        return loginPage.getErrorMessageTextRepeatPassword();
    }

    @Step
    public String getErrorMessageTextSurname() {
        return loginPage.getErrorMessageTextSurname();
    }

    @Step
    public String getErrorMessageTextName() {
        return loginPage.getErrorMessageTextName();
    }

    @Step
    public String getErrorMessageTextPatronymic() {
        return loginPage.getErrorMessageTextPatronymic();
    }

    @Step
    public String getErrorMessageTextPhone() {
        return loginPage.getErrorMessageTextPhone();
    }

    @Step
    public String getErrorMessageTextEmail() {
        return loginPage.getErrorMessageTextEmail();
    }

    @Step
    public String getErrorMessageTextPasswords() {
        return loginPage.getErrorMessageTextPasswords();
    }
}

