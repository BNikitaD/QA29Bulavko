package steps;

import waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static waiters.Waiter.ACCEPT_COOKIE;
import static constants.IConstants.MAIN_PAGE_URL;

public class MainSteps {

    Waiter waiter = new Waiter();
    private MainPage mainPage;
    WebDriver driver;

    public MainSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        this.driver = driver;
    }

    @Step("open registration page")
    public MainSteps register() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
        mainPage.clickEnterButton();
        return this;
    }

    @Step("click on the logo Emall")
    public MainSteps clickMainButton() {
        mainPage.clickMainButton();
        return this;
    }

    @Step("click on Orders page")
    public MainSteps clickOrders() {
        mainPage.clickOrders();
        return this;
    }

    @Step("click in Favorites page")
    public MainSteps clickFavorites() {
        mainPage.clickFavorites();
        return this;
    }

    @Step("go to the product card using the search bar")
    public MainSteps searchProductThroughInputSearchField(String searchName,String productName) {
        mainPage.searchProductThroughInputSearchField(searchName ,productName);
        return this;
    }

    @Step("accepting Cookes")
    public MainSteps openPageAndAcceptCookies() {
        mainPage.openPage(MAIN_PAGE_URL);
        waiter.waitForElement(driver, ACCEPT_COOKIE, 7).click();
        return this;
    }

    @Step("click on Cart page")
    public MainSteps clickOnCartPage() {
        mainPage.clickOnCartPage();
        return this;
    }

    @Step("click on Actions page")
    public MainSteps clickActions() {
        mainPage.clickActions();
        return this;
    }

    @Step("click payment in installments page")
    public MainSteps clickPaymentInInstallments() {
        mainPage.clickPaymentInInstallments();
        return this;
    }

    @Step(" click lucky goos page")
    public MainSteps clickLuckyGoods() {
        mainPage.clickLuckyGoods();
        return this;
    }

    @Step("click urgent goods page")
    public MainSteps clickUrgentGoods() {
        mainPage.clickUrgentGoods();
        return this;
    }

    @Step("click take more page")
    public MainSteps clickTakeMore() {
        mainPage.clickTakeMore();
        return this;
    }

    @Step("click category diapers page")
    public MainSteps clickCategoryDiapers() {
        mainPage.clickCategoryDiapers();
        return this;
    }

    @Step("click Category for bicycles")
    public MainSteps clickCategoryBicycles() {
        mainPage.clickCategoryBicycles();
        return this;
    }
}