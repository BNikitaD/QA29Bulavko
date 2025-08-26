package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The type Product page.
 */
@Log4j2
public class ProductPage extends BasePage {

    private static final By ADD_PRODUCT_FROM_WIDGET = By.xpath("//*[contains(@class, 'btn_btn__jx6SQ') and contains(@class, 'offer-card_button')]");
    private static final By ADD_MAIN_PRODUCT = By.xpath("//*[contains(@class, 'adult-wrapper_adult__yIhdE b')]");
    private static final By QUANTITY_PRODUCT_IN_CART_PAGE = By.xpath("//*[@class='badge-animation_badge__nBsm5 medium']");

    /**
     * Instantiates a new Product page.
     *
     * @param driver the driver
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Add main product.
     */
    public void addMainProduct() {
        driver.findElement(ADD_MAIN_PRODUCT).click();
        log.info("Основной продукт добавлен в корзину");
    }

    /**
     * Add product from widget.
     */
    public void addProductFromWidget() {
        driver.findElement(ADD_PRODUCT_FROM_WIDGET).click();
        log.info("Продукт из виджета добавлен в корзину");
    }

    /**
     * Gets quantity product in cart.
     *
     * @return the quantity product in cart
     */
    public String getQuantityProductInCart() {
        return driver.findElement(QUANTITY_PRODUCT_IN_CART_PAGE).getText();
    }
}
