package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import elements.Checkbox;

/**
 * The type Cart page.
 */
@Log4j2
public class CartPage extends BasePage {

    private static final By ADD_ADDRESS_MAIN_BUTTON = By.xpath("//*[@type='button' and .//span[text()='Добавить адрес']]");
    private static final By CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW = By.xpath("//button[contains(@class, 'recipients_add')]");
    private static final By ADD_ADDRESS_FROM_MAP = By.xpath("//*[@class='map_searchRight__list__card__dOW2U']/span[text()='г. Пинск,  Карла Маркса, д. 32']");
    private static final By ADD_ORDER_PICK_UP_POINT_OPTION = By.xpath("//button[@type='submit' and .//span[text()='Выбрать']]");
    private static final By READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS = By.xpath("//*[@type='button' and .//span[text()='Готово']]");
    private static final String INCREASE_PRODUCT_COUNT_BY_NAME = "//*[@aria-label='Добавить' and contains(@class, 'counter_counter__button_plus__bsTiE') and contains(text(), '%s')]";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@type='button'][.//span[text()='Оформить заказ']]");
    private static final By PAYMENT_METHOD_BUTTON = By.xpath("//*[contains(@class,'select-button_title')]");
    private static final By EXCELLENT_BUTTON = By.xpath("//*[ @type='button'][.//span[text()='Отлично!']]");
    private static final String CHECKBOX_LOCATOR = "//span[contains(text(), '%s')]/preceding-sibling::input[@type='checkbox']";

    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Increase product quantity in cart.
     *
     * @param productName the product name
     * @param addQuantity the add quantity
     */
    public void increaseProductQuantityInCart(String productName, int addQuantity) {
        WebElement addProduct = driver.findElement(By.xpath(String.format(INCREASE_PRODUCT_COUNT_BY_NAME, productName)));
        for (int i = 0; i < addQuantity; i++) {
            addProduct.click();
            log.info("Нажато увеличения количества товара");
        }
    }

    /**
     * Remove product in minus.
     *
     * @param productName    the product name
     * @param removeQuantity the remove quantity
     */
    public void removeProductInMinus(String productName, int removeQuantity) {
        WebElement removeProduct = driver.findElement(By.xpath("//*[@aria-label='Отнять' and contains(@class, 'counter_counter__button_minus__BJhzD') and contains(text(), '" + productName + "')]"));
        for (int i = 0; i < removeQuantity; i++) {
            removeProduct.click();
            log.info("Нажато уменьшения количества товара");
        }
    }

    /**
     * Uncheck checkbox second product.
     */
    public void uncheckCheckboxSecondProduct() {
        log.info("Снятие отметки с чекбокса для второго товара");
        new Checkbox("removeSecondProduct", driver).setCheckboxValue(false, CHECKBOX_LOCATOR);
    }

    /**
     * Click checkout.
     */
    public void clickCheckout() {
        log.info("Нажатие на кнопку оформления заказа");
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    /**
     * Click on payment method.
     */
    public void clickOnPaymentMethod() {
        log.info("Нажатие на кнопку выбора способа оплаты");
        driver.findElement(PAYMENT_METHOD_BUTTON).click();
    }

    /**
     * Click on excellent button.
     */
    public void clickOnExcellentButton() {
        WebElement element = driver.findElement(EXCELLENT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Click add address main button.
     */
    public void clickAddAddressMainButton() {
        waiter.waitForElement(driver, ADD_ADDRESS_MAIN_BUTTON,7).click();
        log.info("Кнопка Добавить адрес нажата");
    }

    /**
     * Click choose address button in modal window.
     */
    public void clickChooseAddressButtonInModalWindow() {
        waiter.waitForElement(driver, CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW, 7).click();
    }

    /**
     * Click address from map.
     */
    public void clickAddressFromMap() {
        waiter.waitForElement(driver, ADD_ADDRESS_FROM_MAP, 7).click();
    }

    /**
     * Click add order pick up point option.
     */
    public void clickAddOrderPickUpPointOption() {
        waiter.waitForElement(driver, ADD_ORDER_PICK_UP_POINT_OPTION, 7).click();
    }

    /**
     * Click ready button in modal window for choosing address.
     */
    public void clickReadyButtonInModalWindowForChoosingAddress() {
        waiter.waitForElement(driver, READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS, 7).click();
        log.info("Кнопка Готово нажата");
    }
}
