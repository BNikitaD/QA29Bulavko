package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test(description = "this test with full flow for checkout product with valid data")
    public void checkoutWithValidFlow() {
        mainSteps.register();
        authorizationSteps.enterWithValidDataInPasswordOption("12345678Emall!", "291561848");
        mainSteps.searchProductThroughInputSearchField("кофе", "Кофе в зернах «Minges» Caffe Creme Schumli, 1 кг");
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        mainSteps.clickOnCartPage();
        cartSteps.setActionsInProductPage("Кофе в зернах «Minges» Caffe Creme Schumli, 1 кг", 1);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        String expectedUrl = ITestConstants.PAYMENT_PAGE;
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
