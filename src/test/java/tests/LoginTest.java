package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends LoginPrecondition {

    @Test(description = "this test with valid data")
    public void loginWithValidData() {
        mainSteps.registrationPage();
        loginSteps.successfulRegistration(VALIDUSER);
        Assert.assertEquals("https://emall.by/login/confirm-code?newAccount=true", "https://emall.by/login/confirm-code?newAccount=true");
    }

    @Test(description = "this test with empty checkbox")
    public void loginWithNotSelectedCheckBox() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(VALIDUSER);
        Assert.assertEquals(loginPage.getErrorMessageTextCheckBox(), EMPTYCHECKBOX);
    }

    @Test(description = "Empty repeat password field and checkbox")
    public void loginWithEmptyRepeatPasswordAndCheckBox() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(USER_WITH_EMPTY_REPEAT_PASSWORD);
        softAssert.assertEquals(loginPage.getErrorMessageTextREPEATPASSWORD(), EMPTYREPEATPASSWORD);
        softAssert.assertEquals(loginPage.getErrorMessageTextCheckBox(), EMPTYCHECKBOX);
        softAssert.assertAll();
    }

    @Test(description = "All fields is Empty")
    public void loginWithEmptyAllfields() {
        mainSteps.registrationPage();
        loginSteps.registrationFieldsandSubmitButton(USER_WITH_EMPTY_FIELDS);
        softAssert.assertEquals(loginPage.getErrorMessageTextSurname(), EMPTYSURNAMEERROR);
        softAssert.assertEquals(loginPage.getErrorMessageTextCheckBox(),EMPTYCHECKBOX);
        softAssert.assertEquals(loginPage.getErrorMessageTextName(),EMPTYNAME);
        softAssert.assertEquals(loginPage.getErrorMessageTextPatronymic(),EMPTYPATRONYMIC);
        softAssert.assertEquals(loginPage.getErrorMessageTextPhone(),EMPTYPHONE);
        softAssert.assertEquals(loginPage.getErrorMessageTextEmail(),EMPTYEMAIL);
        softAssert.assertEquals(loginPage.getErrorMessageTextPasswords(),EMPTYPASSWORDS);
    }
}
