package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.AuthorizationPage.*;
import static tests.ITestConstants.*;
import static tests.ITestConstants.EMPTY_PASSWORD_INPUT;
import static tests.ITestConstants.NAME;

public class AuthorizationTest extends BaseTest{

    @Test(description = "login to profile with invalid phone number")
    public void authorizationWithInvalidPhoneNumber() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithInvalidPhoneNumber("2341223");
        Assert.assertEquals(authorizationSteps.getErrorMessageInvalidPhoneNumber(), INVALID_PHONE_NUMBER);
    }

    @Test(description = "login with unregistered phone number")
    public void authorizationWithNonLoginedPhoneNumber() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithNonPhoneNumber("291561848");
        Assert.assertEquals(authorizationSteps.getErrorMessageNonLoginedPhoneNumber(), NON_LOGINED_PHONE_NUMBER);
    }

    @Test(description = "login with empty fields in phone option")
    public void authorizationWithoutAnyFieldsInPhoneOption() {
        mainSteps.registrationPage();
        authorizationSteps.authorizationWithoutAnyFieldsInPhoneOption();
        Assert.assertEquals(authorizationSteps.getErrorMessageEmptyPhoneNumber(), EMPTY_PHONE_NUMBER);
    }

    @Test(description = "login with empty fields in password option ")
    public void enterInPasswordWithEmptyFields() {
        mainSteps.registrationPage();
        authorizationSteps.enterInPasswordWithEmptyFields();
        Assert.assertEquals(authorizationSteps.getErrorMessageEmptyPasswordAndPhoneNumberInputs(), EMPTY_PASSWORD_AND_PHONE_NUMBER_INPUTS);
    }

    @Test(description = "login with valid data")
    public void enterWithValidDataInPasswordOption() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithValidDataInPasswordOption("12345678Emall!","291561848");
        Assert.assertEquals(authorizationSteps.getNameOfProfile(), NAME);
    }

    @Test(description = "login with empty password in password option")
    public void enterWithEmptyPasswordInPasswordOption() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithEmptyPasswordInPasswordOption("291561848");
        Assert.assertEquals(authorizationSteps.getErrorMessageEmptyPasswordInput(), EMPTY_PASSWORD_INPUT);
    }
}