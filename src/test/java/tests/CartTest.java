package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "this test with full flow for checkout product with valid data")
    public void checkoutWithValidFlow() {
        mainSteps.registrationPage();
        authorizationSteps.enterWithValidDataInPasswordOption();
        productSteps.promocodeModalButton();
        mainSteps.searchProductInSearchInput();
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        mainSteps.clickOnCartPage();
        cartSteps.excellentButton();
        cartSteps.chooseAddressFromPickUpOption();
        cartSteps.addProductFromCartInPlus();
        cartSteps.uncheckCheckbox();
        cartSteps.choosePaymentMethodButton();
        cartSteps.selectPaymentMethodInModal();
        cartSteps.checkoutButton();
        Assert.assertEquals("https://pay196.paysec.by/pay/pay.cfm?CFSID=NyddOzEhKFc2Wk1TX1c6RCVYPlciVj0wMCI4IS5ITVAgCg%3D%3D&stage=iframe", "https://pay196.paysec.by/pay/pay.cfm?CFSID=NyddOzEhKFc2Wk1TX1c6RCVYPlciVj0wMCI4IS5ITVAgCg%3D%3D&stage=iframe");
    }
}
