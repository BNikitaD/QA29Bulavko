package Steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

import static Waiters.Waiter.PROMOCODE;

public class ProductSteps {

    Waiter waiter = new Waiter();
    private LoginPage loginPage;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    WebDriver driver;
    private CartPage cartPage;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
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
        waiter.waitPromocodeModalButtonAppeared(driver, PROMOCODE, 7);
        return this;
    }

    @Step
    public ProductSteps addProductFromWidget() {
        productPage.addProductFromWidget();
        return this;
    }
}
