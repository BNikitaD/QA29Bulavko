package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public static final By ADD_PRODUCT_FROM_WIDGET = By.xpath("//*[contains(@class, 'icon-cart-20')]");
    public static final By ADD_MAIN_PRODUCT = By.xpath("//*[@class='adult-wrapper_adult__yIhdE buy_adult__OKX2j']//button[.//span[text()='В корзину']]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addMainProduct() {
        driver.findElement(ADD_MAIN_PRODUCT).click();
    }

    public void addProductfromWidget() {
        driver.findElement(ADD_PRODUCT_FROM_WIDGET).click();
    }
}
