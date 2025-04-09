package Steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static Waiters.Waiter.ACCEPT_COOKIE;
import static constants.IConstants.MAIN_PAGE_URL;

public class MainSteps {

    Waiter waiter = new Waiter();
    private MainPage mainPage;
    WebDriver driver;

    public MainSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        this.driver = driver;
    }

    @Step
    public MainSteps registrationPage() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.acceptCookie(driver, ACCEPT_COOKIE, 7);
        mainPage.clickLoginButton();
        return this;
    }

    @Step
    public MainSteps headerButtons() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.acceptCookie(driver, ACCEPT_COOKIE, 7);
        mainPage.clickOnAllHeaders();
        return this;
    }

    @Step
    public MainSteps mainButtonsForUsers() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.acceptCookie(driver, ACCEPT_COOKIE, 7);
        mainPage.clickOnMainButtonsForUsers();
        return this;
    }

    @Step
    public MainSteps searchProductThroughInputSearchField() {
        mainPage.searchProductThroughInputSearchField();
        return this;
    }

    @Step
    public MainSteps openPageAndAcceptCookies() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.acceptCookie(driver, ACCEPT_COOKIE, 7);
        return this;
    }

    @Step
    public MainSteps clickOnCartPage() {
        mainPage.clickOnCartPage();
        return this;
    }
}