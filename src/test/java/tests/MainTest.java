package tests;

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
        mainSteps.searchProductThroughInputSearchField("кофе", "Кофе молотый «Egoiste» Espresso, 250 г");
        Assert.assertEquals(driver.getCurrentUrl(), URL_OF_PRODUCT);
    }

    @DataProvider(name = "mainStepsDataProvider")
    public Object[][] mainStepsDataProvider() {
        return new Object[][]{
                {"clickMainButton", MAIN_PAGE_URL},
                {"clickOrders", ORDERS},
                {"clickFavorites", FAVORITES},
                {"clickOnCartPage", CART},
                {"clickActions", ACTIONS},
                {"clickPaymentInInstallments", PAYMENT_IN_INSTALLMENTS},
                {"clickLuckyGoods", LUCKY_GOODS},
                {"clickUrgentGoods", URGENT_GOODS},
                {"clickTakeMore", TAKE_MORE},
                {"clickCategoryDiapers", CATEGORY4649_DIAPERS},
                {"clickCategoryForCleaning", CATEGORY3944_FOR_CLEANING},
                {"clickCategoryBicycles", CATEGORY4353_BICYCLES}
        };
    }

    @Test(dataProvider = "mainStepsDataProvider")
    public void clickOnMainButtonForUser(String action, String expectedResult) {
        switch (action) {
            case "clickMainButton":
                mainSteps.clickMainButton();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickOrders":
                mainSteps.clickOrders();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickFavorites":
                mainSteps.clickFavorites();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickOnCartPage":
                mainSteps.clickOnCartPage();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickActions":
                mainSteps.clickActions();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickPaymentInInstallments":
                mainSteps.clickPaymentInInstallments();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickLuckyGoods":
                mainSteps.clickLuckyGoods();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickUrgentGoods":
                mainSteps.clickUrgentGoods();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickTakeMore":
                mainSteps.clickTakeMore();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickCategoryDiapers":
                mainSteps.clickCategoryDiapers();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickCategoryForCleaning":
                mainSteps.clickCategoryForCleaning();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
            case "clickCategoryBicycles":
                mainSteps.clickCategoryBicycles();
                Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
                break;
        }
    }
}