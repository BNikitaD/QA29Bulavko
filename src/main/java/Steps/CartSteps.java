package Steps;

import Waiters.Waiter;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @SneakyThrows
    public CartSteps chooseAddressFromPickUpOption() {
        waiter.addAddressButtonInCartPage(driver, ADD_ADDRESS_MAIN_BUTTON, 7);
        waiter.addAddressButtonInCartPage(driver, CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW, 7);
        waiter.addAddressButtonInCartPage(driver, ADD_ADDRESS_FROM_MAP, 7);
        waiter.addAddressButtonInCartPage(driver, ADD_ORDER_PICK_UP_POINT_OPTION, 7);
        Thread.sleep(1500);
        waiter.addAddressButtonInCartPage(driver, READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS, 8);
        return this;
    }

    @Step
    public CartSteps addProductFromCartInPlus() {
        cartPage.addProductFromCartInPlus();
        return this;
    }

    @Step
    public CartSteps uncheckCheckbox() {
        cartPage.uncheckCheckbox();
        return this;
    }

    @Step
    public CartSteps checkoutButton() {
        cartPage.checkoutButton();
        return this;
    }

    @Step
    public CartSteps excellentButton() {
        waiter.excellentButton(driver);
        return this;
    }

    @Step
    public CartSteps choosePaymentMethodButton() {
        cartPage.choosePaymentMethodButton();
        return this;
    }

    @Step
    public CartSteps selectPaymentMethodInModal() {
        waiter.selectPaymentMethodInModal(driver, PAYMENT_METHOD, 7);
        return this;
    }
}
