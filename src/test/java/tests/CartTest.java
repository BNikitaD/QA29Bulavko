package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "this test with full flow for checkout product with valid data")
    public void checkoutWithValidFlow() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithValidDataInPasswordOption("12345678Emall!", "291561848");
        productSteps.promocodeModalButton();
        mainSteps.searchProductThroughInputSearchField();
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        mainSteps.clickOnCartPage();
        cartSteps.excellentButton()
                .chooseAddressFromPickUpOption()
                .addProductFromCartInPlus("Кофе молотый «Egoiste» Noir, натуральный, 100 г", 3)
                .uncheckCheckbox()
                .paymentMethod()
                .selectPaymentMethodInModal()
                .clickCheckout();
        String expectedUrl = ITestConstants.PAYMENT_PAGE;
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
