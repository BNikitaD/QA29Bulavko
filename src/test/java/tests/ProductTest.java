package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductTest extends BaseTest{

    @Test(description = "this add main and product from widget in cart")
    public void addMainProductAndFromWidgetTest() {
        mainSteps.openPageAndAcceptCookies();
        mainSteps.searchProductThroughInputSearchField("кофе", "Кофе молотый Dallmayr prodomo 500гр");
        productSteps.addMainProduct();
        productSteps.addProductFromWidget();
        Assert.assertEquals(productSteps.getQuantityProductInCart(), "2");
    }
}