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

    @Step("login to profile with invalid phone number")
    public AuthorizationSteps authorizationWithInvalidPhoneNumber(String tel) {
        authorizationPage.loginWithInvalidPhoneNumber(tel);
        return this;
    }

    @Step("login not unregistered phone number")
    public AuthorizationSteps authorizationWithNonPhoneNumber(String tel) {
        authorizationPage.loginWithNonPhoneNumber(tel);
        return this;
    }

    @Step("login with empty fields in Phone code option")
    public AuthorizationSteps authorizationWithoutAnyFieldsInPhoneOption() {
        authorizationPage.clickGetCode();
        return this;
    }

    @Step("login in profile with empty fields")
    public AuthorizationSteps enterInPasswordWithEmptyFields() {
        authorizationPage.loginWithEmptyFields();
        return this;
    }

    @Step("login with valid data in password option")
    public AuthorizationSteps enterWithValidDataInPasswordOption(String password, String tel) {
        authorizationPage.loginWithPasswordOption(password, tel);
        return this;
    }

    @Step("login in password option with empty password input")
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
        return authorizationPage.getErrorMessageNonLoggedInPhoneNumber();
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