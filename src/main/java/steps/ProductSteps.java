package steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

import static Waiters.Waiter.PROMOCODE;

public class ProductSteps {

    Waiter waiter = new Waiter();
    WebDriver driver;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        productPage = new ProductPage(driver);
        this.driver = driver;
    }

    @Step
    public ProductSteps addMainProduct() {
        productPage.addMainProduct();
        return this;
    }

    @Step
    public ProductSteps promocodeModalButton() {
        waiter.waitForElement(driver, PROMOCODE, 7).click();
        return this;
    }

    @Step
    public ProductSteps addProductFromWidget() {
        productPage.addProductFromWidget();
        return this;
    }

    @Step
    public ProductSteps checkQuantityProductInCart() {
        productPage.checkQuantityProductInCart();
        return this;
    }
}
