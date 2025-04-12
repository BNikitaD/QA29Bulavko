package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import elements.Checkbox;

public class CartPage extends BasePage {

    public static final By ADD_ADDRESS_MAIN_BUTTON = By.xpath("//*[@type='button' and .//span[text()='Добавить адрес']]");
    public static final By CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW = By.xpath("//button[contains(@class, 'recipients_add')]");
    public static final By ADD_ADDRESS_FROM_MAP = By.xpath("//*[@class='map_searchRight__list__card__dOW2U']/span[text()='г. Пинск,  Карла Маркса, д. 32']");
    public static final By ADD_ORDER_PICK_UP_POINT_OPTION = By.xpath("//button[@type='submit' and .//span[text()='Выбрать']]");
    public static final By READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS = By.xpath("//*[@type='button' and .//span[text()='Готово']]");
    public static final String INCREASE_PRODUCT_COUNT_BY_NAME = "//*[@aria-label='Добавить' and contains(@class, 'counter_counter__button_plus__bsTiE') and contains(text(), '%s')]";
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@type='button'][.//span[text()='Оформить заказ']]");
    public static final By PAYMENT_METHOD_BUTTON = By.xpath("//*[contains(@class,'select-button_title')]");
    public static final By EXCELLENT_BUTTON = By.xpath("//*[ @type='button'][.//span[text()='Отлично!']]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProductInPlus(String productName, int addQuantity) {
        WebElement addProduct = driver.findElement(By.xpath(String.format(INCREASE_PRODUCT_COUNT_BY_NAME, productName)));
        for (int i = 0; i < addQuantity; i++) {
            addProduct.click();
        }
    }

    public void removeProductInMinus(String productName, int removeQuantity) {
        WebElement removeProduct = driver.findElement(By.xpath("//*[@aria-label='Отнять' and contains(@class, 'counter_counter__button_minus__BJhzD') and contains(text(), '" + productName + "')]"));
        for (int i = 0; i < removeQuantity; i++) {
            removeProduct.click();
        }
    }

    public void uncheckCheckbox() {
        new Checkbox(driver, "removeSecondProduct").setCheckboxValue(false);
    }


    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickOnPaymentMethod() {
        driver.findElement(PAYMENT_METHOD_BUTTON).click();
    }
    public void clickOnExcellentButton() {
        WebElement element = driver.findElement(EXCELLENT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
