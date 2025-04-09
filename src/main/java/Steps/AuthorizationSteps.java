package Steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.LoginPage;
import pages.MainPage;

public class AuthorizationSteps {

    Waiter waiter = new Waiter();
    private LoginPage loginPage;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    WebDriver driver;

    public AuthorizationSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        this.driver = driver;
    }

    @Step
    public AuthorizationSteps authorizationWithInvalidPhoneNumber() {
        authorizationPage.logjnWithInvalidPhoneNumber();
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithNonPhoneNumber() {
        authorizationPage.loginWithNonPhoneNumber();
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithoutAnyFieldsInPhoneOption() {
        authorizationPage.loginWithoutAnyFieldsInPhoneOption();
        return this;
    }

    @Step
    public AuthorizationSteps enterInPasswordWithEmptyFields() {
        authorizationPage.checkLoginWithEmptyFields();
        return this;
    }

    @Step
    public AuthorizationSteps enterWithValidDataInPasswordOption() {
        authorizationPage.loginInPasswordIption();
        return this;
    }

    @Step
    public AuthorizationSteps enterWithEmptyPasswordInPasswordOption() {
        authorizationPage.loginWithEmptyPasswordInPasswordOption();
        return this;
    }
}