package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.AuthorizationPage.*;

public class AuthorizationTest extends BaseTest{

    @Test(description = "login to profile with invalid phone number")
    public void authorizationWithInvalidPhoneNumber() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithInvalidPhoneNumber();
        Assert.assertEquals(authorizationPage.getErrorMessageInvalidPhoneNumber(), MESSAGE_INVALID_PHONE_NUMBER);
    }

    @Test(description = "login with unregistered phone number")
    public void authorizationWithNonLoginedPhoneNumber() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithNonPhoneNumber();
        Assert.assertEquals(authorizationPage.getErrorMessageNonLoginedPhoneNumber(), MESSAGE_NON_LOGINED_PHONE_NUMBER);
    }

    @Test(description = "login with empty fields in phone option")
    public void authorizationWithoutAnyFieldsInPhoneOption() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithoutAnyFieldsInPhoneOption();
        Assert.assertEquals(authorizationPage.getErrorMessageEmptyPhoneNumber(), MESSAGE_EMPTY_PHONE_NUMBER);
    }

    @Test(description = "login with empty fields in password option ")
    public void enterInPasswordWithEmptyFields() {
        mainSteps.registrationPage();
        authorizationSteps.enterInPasswordWithEmptyFields();
        Assert.assertEquals(authorizationPage.getErrorMessageEmptyPasswordAndPhoneNumberInputs(), MESSAGE_EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS);
    }

    @Test(description = "login with valid data")
    public void enterWithValidDataInPasswordOption() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithValidDataInPasswordOption();
        String expectedName = "Vlad";
        Assert.assertEquals(expectedName, NAME_OF_PROFILE);
    }

    @Test(description = "login with empty password in password option")
    public void enterWithEmptyPasswordInPasswordOption() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithEmptyPasswordInPasswordOption();
        Assert.assertEquals(authorizationPage.getErrorMessageEmptyPasswordInput(), MESSAGE_EMPTY_PASSWORD_INPUT);
    }
}