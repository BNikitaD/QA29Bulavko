package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends LoginPrecondition {

    @Test(description = "this test with valid data")
    public void loginWithValidData() {
        mainSteps.registrationPage();
        loginSteps.successfulRegistration(VALID_USER);
        Assert.assertEquals(loginSteps.getCreateAccountText(), CREATE_ACCOUNT);
    }

    @Test(description = "this test with empty checkbox")
    public void loginWithNotSelectedCheckBox() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(VALID_USER);
        Assert.assertEquals(loginSteps.getErrorMessageTextCheckBox(), EMPTY_CHECKBOX);
    }

    @Test(description = "Empty repeat password field and checkbox")
    public void loginWithEmptyRepeatPasswordAndCheckBox() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(USER_WITH_EMPTY_REPEAT_PASSWORD);
        softAssert.assertEquals(loginSteps.getErrorMessageTextRepeatPassword(), EMPTY_REPEAT_PASSWORD);
        softAssert.assertEquals(loginSteps.getErrorMessageTextCheckBox(), EMPTY_CHECKBOX);
        softAssert.assertAll();
    }

    @Test(description = "All fields is Empty")
    public void loginWithEmptyAllfields() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(USER_WITH_EMPTY_FIELDS);
        softAssert.assertEquals(loginSteps.getErrorMessageTextSurname(), EMPTY_SURNAME_ERROR);
        softAssert.assertEquals(loginSteps.getErrorMessageTextCheckBox(),EMPTY_CHECKBOX);
        softAssert.assertEquals(loginSteps.getErrorMessageTextName(),EMPTY_NAME);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPatronymic(),EMPTY_PATRONYMIC);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPhone(),EMPTY_PHONE);
        softAssert.assertEquals(loginSteps.getErrorMessageTextEmail(),EMPTY_EMAIL);
        softAssert.assertEquals(loginSteps.getErrorMessageTextPasswords(),EMPTY_PASSWORDS);
    }
}
