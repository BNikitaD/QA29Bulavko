package steps;

import waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import static waiters.Waiter.PAYMENT_METHOD;

public class CartSteps {

    Waiter waiter = new Waiter();

    WebDriver driver;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        this.driver = driver;
    }

    //TODO: сделать комменты
    @Step("Selecting the delivery address for the product to the order pick-up point")
    public CartSteps chooseAddressFromPickUpOption() {
        cartPage.clickAddAddressMainButton();
        cartPage.clickChooseAddressButtonInModalWindow();
        cartPage.clickAddressFromMap();
        cartPage.clickAddOrderPickUpPointOption();
        cartPage.clickReadyButtonInModalWindowForChoosingAddress();
        return this;
    }

    @Step("increase the quantity of product through plus in the cart")
    public CartSteps increaseProductQuantityInCart(String productName, int addQuantity) {
        cartPage.increaseProductQuantityInCart(productName, addQuantity);
        return this;
    }

    @Step("remove the quantity of product through plus in the cart")
    public CartSteps removeProductInMinus(String productName, int removeQuantity) {
        cartPage.removeProductInMinus(productName, removeQuantity);
        return this;
    }

    @Step("unchecking the second product")
    public CartSteps uncheckCheckboxSecondProduct() {
        cartPage.uncheckCheckboxSecondProduct();
        return this;
    }

    @Step("click checkout")
    public CartSteps clickCheckout() {
        cartPage.clickCheckout();
        return this;
    }

    @Step("click Excellent button")
    public CartSteps clickOnExcellentButton() {
        cartPage.clickOnExcellentButton();
        return this;
    }

    @Step("clicking on the payment method button")
    public CartSteps paymentMethod() {
        cartPage.clickOnPaymentMethod();
        return this;
    }

    @Step("select payment method 'New card online' in modal window")
    public CartSteps selectNewCardOnlinePaymentMethodInModalWindow() {
        waiter.waitForElement(driver, PAYMENT_METHOD, 7).click();
        return this;
    }

    @Step("full flow in Cart page for checkout after user added product from website")
    public CartSteps setActionsInProductPage(String productName, int addQuantity) {
        clickOnExcellentButton();
        chooseAddressFromPickUpOption();
        increaseProductQuantityInCart(productName, addQuantity);
        uncheckCheckboxSecondProduct();
        paymentMethod();
        selectNewCardOnlinePaymentMethodInModalWindow();
        clickCheckout();
        return this;
    }
}
