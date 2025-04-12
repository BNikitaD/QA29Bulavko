package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.ProductPage.QUANTITY_IN_CART;

public class ProductTest extends BaseTest{

    @Test(description = "this add main and product from widget in cart")
    public void addMainProductAndFromWidget() {
        mainSteps.searchProductThroughInputSearchField();
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        Assert.assertEquals(productSteps.checkQuantityProductInCart(), QUANTITY_IN_CART);
    }
}
