package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import waiters.Waiter;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test(description = "this test with full flow for checkout product with valid data", retryAnalyzer = Retry.class)
    public void checkoutWithValidFlow() {
        mainSteps.register();
        authorizationSteps.enterWithValidDataInPasswordOption("12345678Emall!", "291561848");
        mainSteps.searchProductThroughInputSearchField("кофе", "Кофе в зернах «Minges» Caffe Creme Schumli, 1 кг");
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        mainSteps.clickOnCartPage();
        cartSteps.setActionsInProductPage("Кофе в зернах «Minges» Caffe Creme Schumli, 1 кг", 1);
        String expectedUrl = ITestConstants.PAYMENT_PAGE;
        Waiter.WaitUtils.waitForUrlContains(driver, expectedUrl, 8);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
