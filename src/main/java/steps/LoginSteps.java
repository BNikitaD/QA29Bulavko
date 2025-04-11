package steps;

import Waiters.Waiter;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

import static Waiters.Waiter.AGREEMENT;

public class LoginSteps {

    Waiter waiter = new Waiter();
    private LoginPage loginPage;
    private MainPage mainPage;
    WebDriver driver;

    public LoginSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        this.driver = driver;
    }

    @Step
    public LoginSteps registrationFieldsandSubmitButton(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.clickSubmitButton();
        return this;
    }

    @Step
    public LoginSteps noValidRegistration(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.checkBox();
        loginPage.clickScrollDownButton();
        return this;
    }
    @Step
    public LoginSteps successfulRegistration(User user) {
        loginPage.clickRegistrationButton();
        loginPage.fillLoginForm(user);
        loginPage.checkBox();
        waiter.agreement(driver, AGREEMENT, 10);
        loginPage.clickScrollDownButton();
        loginPage.clickMainCheckBoxInModal();
        loginPage.clickAgreeButtonInModalWindow();
        loginPage.clickSubmitButton();
        return this;
    }
}

