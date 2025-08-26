package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends LoginPrecondition {

    @Test(description = "this test with valid data")
    public void loginWithValidData() {
        mainSteps.register();
        loginSteps.successfulRegistration(VALID_USER);
        Assert.assertEquals(loginSteps.getCreateAccountText(), CREATE_ACCOUNT_BUTTON_TEXT);
    }

    @Test(description = "this test with empty checkbox")
    public void loginWithNotSelectedCheckBox() {
        mainSteps.register();
        loginSteps.registrationFieldsAndSubmitButton(VALID_USER);
        Assert.assertEquals(loginSteps.getErrorMessageTextCheckBox(), EMPTY_CHECKBOX_ERROR);
    }

    @Test(description = "Empty repeat password field and checkbox")
    public void loginWithEmptyRepeatPasswordAndCheckBox() {
        mainSteps.register();
        loginSteps.registrationFieldsAndSubmitButton(USER_WITH_EMPTY_REPEAT_PASSWORD);
        softAssert.assertEquals(loginSteps.getErrorMessageTextRepeatPassword(), EMPTY_REPEAT_PASSWORD_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextCheckBox(), EMPTY_CHECKBOX_ERROR);
        softAssert.assertAll();
    }

    @Test(description = "All fields is Empty")
    public void loginWithEmptyAllfields() {
        mainSteps.register();
        loginSteps.registrationFieldsAndSubmitButton(USER_WITH_EMPTY_FIELDS);
        softAssert.assertEquals(loginSteps.getErrorMessageTextSurname(), EMPTY_SURNAME_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextCheckBox(), EMPTY_CHECKBOX_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextName(),EMPTY_SURNAME_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPatronymic(),EMPTY_PATRONYMIC);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPhone(), EMPTY_PHONE_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextEmail(), EMPTY_EMAIL_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPasswords(), EMPTY_PASSWORDS_ERROR);
    }
}
