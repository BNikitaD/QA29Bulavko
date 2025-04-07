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
        authorizationPage.inValidPhoneNumber();
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithNonPhoneNumber() {
        authorizationPage.nonLoginedPhoneNumber();
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithoutAnyFieldsInPhoneOption() {
        authorizationPage.emptyPhoneNumberInput();
        return this;
    }

    @Step
    public AuthorizationSteps enterInPasswordWithEmptyFields() {
        authorizationPage.enterInPasswordWithEmptyFields();
        return this;
    }

    @Step
    public AuthorizationSteps enterWithValidDataInPasswordOption() {
        authorizationPage.enterWithValidDataInPasswordOption();
        return this;
    }

    @Step
    public AuthorizationSteps enterWithEmptyPasswordInPasswordOption() {
        authorizationPage.enterWithEmptyPasswordInPasswordOption();
        return this;
    }
}