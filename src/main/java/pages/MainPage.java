package pages;

import elements.Button;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

/**
 * The type Main page.
 */
@Log4j2
public class MainPage extends BasePage {

    private static final By MAIN_BUTTON = By.xpath("//*[contains(@class, 'logo_logo__LbCcG')]");
    private static final By SEARCH_INPUT = By.xpath("//*[@enterkeyhint='search']");
    private static final String RESULT_ELEMENT_TEMPLATE = "//*[@aria-label=\"Переход на страницу с товаром %s\"]";
    private static final By OPENED_ACTIONS_PAGE = By.xpath("//*[contains(@class, 'navigation-sidebar') and contains(@class, 'link_active')]");
    private static final By OPENED_PAYMENT_IN_INSTALLMENTS = By.xpath("//*[contains(@class, 'typography-new_title')]");
    private static final By OPENED_LUCKY_GOODS = By.xpath("//*[contains(@class, 'heading_heading__text') and text()='Товары-везунчики']");
    private static final By OPENED_URGENT_GOODS = By.xpath("//*[contains(@class, 'heading_heading__text') and text()='Срочный товар']");
    private static final By OPENED_TAKE_MORE = By.xpath("//*[contains(@class, 'heading_heading__text') and text()='Упаковкой выгоднее']");
    private static final By OPENED_CATEGORY_DIAPERS = By.xpath("//*[contains(@class, 'heading_heading__text') and text()='Подгузники детские']");
    private static final By OPENED_CATEGORY_BICYCLES = By.xpath("//*[contains(@class, 'heading_heading__text') and text()='Велосипеды']");
    private static final By OPENED_ORDERS = By.xpath("//*[@class='wrapper_title__hxKZS' and text()='Вход']");
    private static final By OPENED_FAVORITES = By.xpath("//*[@class='content_block__by4nx content_empty__dZfWc']");
    /**
     * Instantiates a new Main page.
     *
     * @param driver the driver
     */
    public MainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Click actions.
     */
    public void clickActions() {
        log.info("Нажатие на кнопку 'Акции'");
        new Button(driver, "Акции").clickHeaders();
        waiter.waitForElement(driver, OPENED_ACTIONS_PAGE, 8);
    }

    /**
     * Click payment in installments.
     */
    public void clickPaymentInInstallments() {
        log.info("Нажатие на кнопку 'Оплата частями'");
        new Button(driver, "Оплата частями").clickHeaders();
        waiter.waitForElement(driver, OPENED_PAYMENT_IN_INSTALLMENTS, 8);
    }

    /**
     * Click lucky goods.
     */
    public void clickLuckyGoods() {
        log.info("Нажатие на кнопку 'Товары-везунчики'");
        new Button(driver, "Товары-везунчики").clickHeaders();
        waiter.waitForElement(driver, OPENED_LUCKY_GOODS, 8);
    }

    /**
     * Click urgent goods.
     */
    public void clickUrgentGoods() {
        log.info("Нажатие на кнопку 'Срочный товар!'");
        new Button(driver, "Срочный товар!").clickHeaders();
        waiter.waitForElement(driver, OPENED_URGENT_GOODS, 8);
    }

    /**
     * Click take more.
     */
    public void clickTakeMore() {
        log.info("Нажатие на кнопку 'Упаковкой выгоднее'");
        new Button(driver, "Упаковкой выгоднее").clickHeaders();
        waiter.waitForElement(driver, OPENED_TAKE_MORE, 8);
    }

    /**
     * Click category diapers.
     */
    public void clickCategoryDiapers() {
        log.info("Нажатие на кнопку 'Подгузники'");
        new Button(driver, "Подгузники").clickHeaders();
        waiter.waitForElement(driver, OPENED_CATEGORY_DIAPERS, 8);
    }

    /**
     * Click category bicycles.
     */
    public void clickCategoryBicycles() {
        log.info("Нажатие на кнопку 'Велосипеды'");
        new Button(driver, "Велосипеды").clickHeaders();
        waiter.waitForElement(driver, OPENED_CATEGORY_BICYCLES, 8);
    }

    /**
     * Click enter button.
     */
    public void clickEnterButton() {
        log.info("Нажатие на кнопку 'Войти'");
        new Button(driver, "Войти").clickMainButtonsForUser();
    }

    /**
     * Click main button.
     */
    public void clickMainButton() {
        log.info("Нажатие на главную кнопку(Emall)");
        driver.findElement(MAIN_BUTTON).click();
        waiter.waitForElement(driver, MAIN_BUTTON, 8);
    }

    /**
     * Click orders.
     */
    public void clickOrders() {
        log.info("Нажатие на кнопку 'Заказы'");
        new Button(driver, "Заказы").clickMainButtonsForUser();
        waiter.waitForElement(driver, OPENED_ORDERS, 8);
    }

    /**
     * Click favorites.
     */
    public void clickFavorites() {
        log.info("Нажатие на кнопку 'Избранное'");
        new Button(driver, "Избранное").clickMainButtonsForUser();
        waiter.waitForElement(driver, OPENED_FAVORITES, 8);
    }

    /**
     * Search product through input search field.
     *
     * @param searchName  the search name
     * @param productName the product name
     */
    public void searchProductThroughInputSearchField(String searchName,String productName) {
        driver.findElement(SEARCH_INPUT).sendKeys(searchName);
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.RETURN);
        By resultElement = By.xpath(String.format(RESULT_ELEMENT_TEMPLATE, productName));
        WebElement targetElement = waiter.waitForElement(driver, resultElement, 17);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    }

    /**
     * Click on cart page.
     */
    public void clickOnCartPage() {
        log.info("Нажатие на кнопку 'Корзина'");
        new Button(driver, "Корзина").clickMainButtonsForUser();
        waiter.waitForElement(driver, MAIN_BUTTON, 8);
    }
}