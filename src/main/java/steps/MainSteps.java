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
    public MainSteps clickEnterButton() {
        mainPage.clickEnterButton();
        return this;
    }

    @Step
    public MainSteps clickMainButton() {
        mainPage.clickMainButton();
        return this;
    }

    @Step
    public MainSteps clickOrders() {
        mainPage.clickOrders();
        return this;
    }

    @Step
    public MainSteps clickFavorites() {
        mainPage.clickFavorites();
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

    @Step
    public MainSteps clickActions() {
        mainPage.clickActions();
        return this;
    }

    @Step
    public MainSteps clickPaymentInInstallments() {
        mainPage.clickPaymentInInstallments();
        return this;
    }

    @Step
    public MainSteps clickLuckyGoods() {
        mainPage.clickLuckyGoods();
        return this;
    }

    @Step
    public MainSteps clickUrgentGoods() {
        mainPage.clickUrgentGoods();
        return this;
    }

    @Step
    public MainSteps clickTakeMore() {
        mainPage.clickTakeMore();
        return this;
    }

    @Step
    public MainSteps clickCategoryDiapers() {
        mainPage.clickCategoryDiapers();
        return this;
    }

    @Step
    public MainSteps clickCategoryForCleaning() {
        mainPage.clickCategoryForCleaning();
        return this;
    }

    @Step
    public MainSteps clickCategoryBicycles() {
        mainPage.clickCategoryBicycles();
        return this;
    }
}