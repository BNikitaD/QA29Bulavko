package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;

public class AuthorizationSteps {

    private AuthorizationPage authorizationPage;
    WebDriver driver;

    public AuthorizationSteps(WebDriver driver) {
        authorizationPage = new AuthorizationPage(driver);
        this.driver = driver;
    }

    @Step
    public AuthorizationSteps authorizationWithInvalidPhoneNumber(String tel) {
        authorizationPage.loginWithInvalidPhoneNumber(tel);
        return this;
    }

    @Step
    public AuthorizationSteps authorizationWithNonPhoneNumber(String tel) {
        authorizationPage.loginWithNonPhoneNumber(tel);
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
    public AuthorizationSteps enterWithValidDataInPasswordOption(String password, String tel) {
        authorizationPage.loginWithPasswordOption(password, tel);
        return this;
    }

    @Step
    public AuthorizationSteps enterWithEmptyPasswordInPasswordOption(String tel) {
        authorizationPage.loginWithEmptyPasswordInPasswordOption(tel);
        return this;
    }

    @Step
    public String getErrorMessageInvalidPhoneNumber() {
        return authorizationPage.getErrorMessageInvalidPhoneNumber();
    }

    @Step
    public String getErrorMessageNonLoginedPhoneNumber() {
        return authorizationPage.getErrorMessageNonLoginedPhoneNumber();
    }

    @Step
    public String getErrorMessageEmptyPhoneNumber() {
        return authorizationPage.getErrorMessageEmptyPhoneNumber();
    }

    @Step
    public String getErrorMessageEmptyPasswordAndPhoneNumberInputs() {
        return authorizationPage.getErrorMessageEmptyPasswordAndPhoneNumberInputs();
    }

    @Step
    public String getNameOfProfile() {
        return authorizationPage.getNameOfProfile();
    }

    @Step
    public String getErrorMessageEmptyPasswordInput() {
        return authorizationPage.getErrorMessageEmptyPasswordInput();
    }
}