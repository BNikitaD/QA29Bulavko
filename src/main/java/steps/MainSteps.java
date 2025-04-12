package steps;

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
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
        mainPage.clickLoginButton();
        return this;
    }

    @Step
    public MainSteps headerButtons() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
        mainPage.clickOnAllHeaders();
        return this;
    }

    @Step
    public MainSteps clicklMainButtonsForUsers() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
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
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
        return this;
    }

    @Step
    public MainSteps clickOnCartPage() {
        mainPage.clickOnCartPage();
        return this;
    }
}