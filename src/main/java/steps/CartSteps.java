package steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AuthorizationPage;
import pages.CartPage;
import pages.LoginPage;
import pages.MainPage;

import static Waiters.Waiter.PAYMENT_METHOD;
import static pages.CartPage.*;

public class CartSteps {

    Waiter waiter = new Waiter();
    private LoginPage loginPage;
    private MainPage mainPage;
    private AuthorizationPage authorizationPage;
    WebDriver driver;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
        this.driver = driver;
    }

    public CartSteps chooseAddressFromPickUpOption() {
        waiter.addAddressButtonInCartPage(driver, ADD_ADDRESS_MAIN_BUTTON, 7);
        waiter.addAddressButtonInCartPage(driver, CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW, 7);
        waiter.addAddressButtonInCartPage(driver, ADD_ADDRESS_FROM_MAP, 7);
        waiter.addAddressButtonInCartPage(driver, ADD_ORDER_PICK_UP_POINT_OPTION, 7);
        waiter.addAddressButtonInCartPage(driver, READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS, 8);
        return this;
    }

    @Step
    public CartSteps addProductFromCartInPlus() {
        cartPage.addProductInPlus("Кофе молотый «Egoiste» Noir, натуральный, 100 г", 3);
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
        waiter.excellentButton(driver);
        return this;
    }

    @Step
    public CartSteps paymentMethod() {
        cartPage.paymentMethod();
        return this;
    }

    @Step
    public CartSteps selectPaymentMethodInModal() {
        waiter.selectPaymentMethodInModal(driver, PAYMENT_METHOD, 7);
        return this;
    }
}
