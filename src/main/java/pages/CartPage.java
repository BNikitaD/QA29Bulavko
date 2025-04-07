package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public static final By ADD_ADDRESS_MAIN_BUTTON = By.xpath("//*[@type='button' and .//span[text()='Добавить адрес']]");
    public static final By CHOOSE_ADDRESS_BUTTON_IN_MODAL_WINDOW = By.xpath("//*[contains(@class, 'recipients_add__oZYbK')]");
    public static final By ADD_ADDRESS_FROM_MAP = By.xpath("//*[@class='map_searchRight__list__card__dOW2U']/span[text()='г. Пинск,  Карла Маркса, д. 32']");
    public static final By ADD_ORDER_PICK_UP_POINT_OPTION = By.xpath("//button[@type='submit' and .//span[text()='Выбрать']]");
    public static final By READY_BUTTON_IN_MODAL_WINDOW_FOR_CHOOSING_ADDRESS = By.xpath("//*[@type='button' and .//span[text()='Готово']]");
    public static final By ADD_FIRST_PRODUCT_IN_CART_IN_PLUS = By.xpath("(//*[contains(@class, 'counter_counter__button') and @aria-label='Добавить'])[1]");
    public static final By REMOVE_CHECKBOX_FOR_SECOND_PRODUCT = By.xpath("(//span[contains(@class, 'checkbox_checkbox__pseudo__Km_pz') and contains(@class, 'checkbox_checkbox__pseudo_checked__CNCMz')])[3]");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@type='button'][.//span[text()='Оформить заказ']]");
    public static final By PAYMENT_METHOD_BUTTON = By.xpath("//*[@class='content_block__by4nx payment_block__0OMeY content_block_clickable__oEcTj']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProductFromCartInPlus() {
        driver.findElement(ADD_FIRST_PRODUCT_IN_CART_IN_PLUS).click();
        driver.findElement(ADD_FIRST_PRODUCT_IN_CART_IN_PLUS).click();
    }

    public void uncheckCheckbox() {
        WebElement checkbox = driver.findElement(REMOVE_CHECKBOX_FOR_SECOND_PRODUCT);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void checkoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void choosePaymentMethodButton() {
        driver.findElement(PAYMENT_METHOD_BUTTON).click();
    }
}
