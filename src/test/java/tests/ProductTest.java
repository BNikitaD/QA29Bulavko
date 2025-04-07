package tests;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest{

    @Test(description = "this add main and product from widget in cart")
    public void addMainProductAndFromWidget() {
        mainSteps.searchProductInSearchInput();
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
    }
}
