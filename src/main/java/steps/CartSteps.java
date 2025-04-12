package steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import static Waiters.Waiter.PAYMENT_METHOD;
import static pages.CartPage.*;

public class CartSteps {

    Waiter waiter = new Waiter();

    WebDriver driver;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
        this.driver = driver;
    }

    public CartSteps chooseAddressFromPickUpOption() {
        waiter.waitForElement(driver, ADD_ADDRESS_MAIN_BUTTON, 7).click();
        waiter.waitForElement(driver, CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW, 7).click();
        waiter.waitForElement(driver, ADD_ADDRESS_FROM_MAP, 7).click();
        waiter.waitForElement(driver, ADD_ORDER_PICK_UP_POINT_OPTION, 7).click();
        waiter.waitForElement(driver, READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS, 8).click();
        return this;
    }

    @Step
    public CartSteps addProductFromCartInPlus(String productName, int addQuantity) {
        cartPage.addProductInPlus(productName, addQuantity);
        return this;
    }

    @Step
    public CartSteps uncheckCheckbox() {
        cartPage.uncheckCheckbox();
        return this;
    }

    @Step
    public CartSteps clickCheckout() {
        cartPage.clickCheckout();
        return this;
    }

    @Step
    public CartSteps excellentButton() {
        cartPage.clickOnExcellentButton();
        return this;
    }

    @Step
    public CartSteps paymentMethod() {
        cartPage.clickOnPaymentMethod();
        return this;
    }

    @Step
    public CartSteps selectPaymentMethodInModal() {
        waiter.waitForElement(driver, PAYMENT_METHOD, 7);
        return this;
    }
}
