package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "this test with full flow for checkout product with valid data")
    public void checkoutWithValidFlow() {
        mainSteps.register();
        authorizationSteps.enterWithValidDataInPasswordOption("12345678Emall!", "291561848");
        productSteps.clickPromocodeModalWindow();
        mainSteps.searchProductThroughInputSearchField("кофе", "Кофе молотый «Egoiste» Espresso, 250 г");
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        mainSteps.clickOnCartPage();
        cartSteps.setActionsInProductPage("Кофе молотый «Egoiste» Noir, натуральный, 100 г", 2);
        String expectedUrl = ITestConstants.PAYMENT_PAGE;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
