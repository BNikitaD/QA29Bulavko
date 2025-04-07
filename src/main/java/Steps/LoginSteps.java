package Steps;

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
        loginPage.registrationButton();
        loginPage.login(user);
        loginPage.submitButton();
        return this;
    }

    @Step
    public LoginSteps noValidRegistration(User user) {
        loginPage.registrationButton();
        loginPage.login(user);
        loginPage.checkBox();
        loginPage.scrollDownButton();
        return this;
    }
    @Step
    public LoginSteps validRegistration(User user) {
        loginPage.registrationButton();
        loginPage.login(user);
        loginPage.checkBox();
        waiter.agreement(driver, AGREEMENT, 10);
        loginPage.scrollDownButton();
        loginPage.mainCheckBoxInModal();
        loginPage.agreeButtonInModalWindow();
        loginPage.submitButton();
        return this;
    }
}

