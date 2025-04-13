package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.IConstants.*;
import static tests.ITestConstants.*;

public class MainTest extends BaseTest {

    @Test()
    public void goToRegistrationPage() {
        mainSteps.registrationPage();
        Assert.assertEquals(driver.getCurrentUrl(), ENTRY_PAGE);
    }

    @Test(description = "this test check search input")
    public void searchProductInSearchInput() {
        mainSteps.searchProductThroughInputSearchField();
        Assert.assertEquals(driver.getCurrentUrl(), URL_OF_PRODUCT);
    }

    @DataProvider(name = "mainStepsDataProvider")
    public Object[][] mainStepsDataProvider() {
        return new Object[][]{
                {"clickMainButton"},
                {"clickOrders"},
                {"clickFavorites"},
                {"clickOnCartPage"},
                {"clickActions"},
                {"clickPaymentInInstallments"},
                {"clickLuckyGoods"},
                {"clickUrgentGoods"},
                {"clickTakeMore"},
                {"clickCategoryDiapers"},
                {"clickCategoryForCleaning"},
                {"clickCategoryBicycles"}
        };
    }

    @Test(dataProvider = "mainStepsDataProvider")
    public void clickOnMainButtonForUser(String action) {
        switch (action) {
            case "clickMainButton":
                mainSteps.clickMainButton();
                Assert.assertEquals(driver.getCurrentUrl(), MAIN_PAGE_URL);
                break;
            case "clickOrders":
                mainSteps.clickOrders();
                Assert.assertEquals(driver.getCurrentUrl(), ORDERS);
                break;
            case "clickFavorites":
                mainSteps.clickFavorites();
                Assert.assertEquals(driver.getCurrentUrl(), FAVORITES);
                break;
            case "clickOnCartPage":
                mainSteps.clickOnCartPage();
                Assert.assertEquals(driver.getCurrentUrl(), CART);
                break;
            case "clickActions":
                mainSteps.clickActions();
                Assert.assertEquals(driver.getCurrentUrl(), ACTIONS);
                break;
            case "clickPaymentInInstallments":
                mainSteps.clickPaymentInInstallments();
                Assert.assertEquals(driver.getCurrentUrl(), PAYMENT_IN_INSTALLMENTS);
                break;
            case "clickLuckyGoods":
                mainSteps.clickLuckyGoods();
                Assert.assertEquals(driver.getCurrentUrl(), LUCKY_GOODS);
                break;
            case "clickUrgentGoods":
                mainSteps.clickUrgentGoods();
                Assert.assertEquals(driver.getCurrentUrl(), URGENT_GOODS);
                break;
            case "clickTakeMore":
                mainSteps.clickTakeMore();
                Assert.assertEquals(driver.getCurrentUrl(), TAKE_MORE);
                break;
            case "clickCategoryDiapers":
                mainSteps.clickCategoryDiapers();
                Assert.assertEquals(driver.getCurrentUrl(), CATEGORY4649_DIAPERS);
                break;
            case "clickCategoryForCleaning":
                mainSteps.clickCategoryForCleaning();
                Assert.assertEquals(driver.getCurrentUrl(), CATEGORY3944_FOR_CLEANING);
                break;
            case "clickCategoryBicycles":
                mainSteps.clickCategoryBicycles();
                Assert.assertEquals(driver.getCurrentUrl(), CATEGORY4353_BICYCLES);
                break;
        }
    }
}