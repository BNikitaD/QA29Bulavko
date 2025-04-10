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
        authorizationPage.logjnWithInvalidPhoneNumber("2341223");
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithNonPhoneNumber() {
        authorizationPage.loginWithNonPhoneNumber("291561848");
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
        authorizationPage.loginInPasswordOption("12345678Emall!","291561848" );
        return this;
    }

    @Step
    public AuthorizationSteps enterWithEmptyPasswordInPasswordOption() {
        authorizationPage.loginWithEmptyPasswordInPasswordOption("291561848");
        return this;
    }
}