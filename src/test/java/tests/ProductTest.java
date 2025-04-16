package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ProductPage.QUANTITY_IN_CART;

public class ProductTest extends BaseTest{

    @Test(description = "this add main and product from widget in cart")
    public void addMainProductAndFromWidget() {
        mainSteps.openPageAndAcceptCookies();
        mainSteps.searchProductThroughInputSearchField("кофе");
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        Assert.assertEquals(productSteps.getQuantityProductInCart(), QUANTITY_IN_CART);
    }
}
