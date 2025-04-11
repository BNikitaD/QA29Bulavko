package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public static final By ADD_PRODUCT_FROM_WIDGET = By.xpath("//*[contains(@class, 'icon-cart-20')]");
    public static final By ADD_MAIN_PRODUCT = By.xpath("//*[@class='adult-wrapper_adult__yIhdE buy_adult__OKX2j']//button[.//span[text()='В корзину']]");
    public static final By QUANTITY_PRODUCT_IN_CART_PAGE = By.xpath("//*[@class='badge-animation_badge__nBsm5 medium']");
    public static final String QUANTITY_IN_CART = "2";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addMainProduct() {
        driver.findElement(ADD_MAIN_PRODUCT).click();
    }

    public void addProductFromWidget() {
        driver.findElement(ADD_PRODUCT_FROM_WIDGET).click();
    }
    public String checkQuantityProductInCart() {
        return driver.findElement(QUANTITY_PRODUCT_IN_CART_PAGE).getText();
    }
}
