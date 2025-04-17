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
    }

    /**
     * Click payment in installments.
     */
    public void clickPaymentInInstallments() {
        log.info("Нажатие на кнопку 'Оплата частями'");
        new Button(driver, "Оплата частями").clickHeaders();
    }

    /**
     * Click lucky goods.
     */
    public void clickLuckyGoods() {
        log.info("Нажатие на кнопку 'Товары-везунчики'");
        new Button(driver, "Товары-везунчики").clickHeaders();
    }

    /**
     * Click urgent goods.
     */
    public void clickUrgentGoods() {
        log.info("Нажатие на кнопку 'Срочный товар!'");
        new Button(driver, "Срочный товар!").clickHeaders();
    }

    /**
     * Click take more.
     */
    public void clickTakeMore() {
        log.info("Нажатие на кнопку 'Упаковкой выгоднее'");
        new Button(driver, "Упаковкой выгоднее").clickHeaders();
    }

    /**
     * Click category diapers.
     */
    public void clickCategoryDiapers() {
        log.info("Нажатие на кнопку 'Подгузники'");
        new Button(driver, "Подгузники").clickHeaders();
    }

    /**
     * Click category for cleaning.
     */
    public void clickCategoryForCleaning() {
        log.info("Нажатие на кнопку 'Для уборки'");
        new Button(driver, "Для уборки").clickHeaders();
    }

    /**
     * Click category bicycles.
     */
    public void clickCategoryBicycles() {
        log.info("Нажатие на кнопку 'Велосипеды'");
        new Button(driver, "Велосипеды").clickHeaders();
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
    }

    /**
     * Click orders.
     */
    public void clickOrders() {
        log.info("Нажатие на кнопку 'Заказы'");
        new Button(driver, "Заказы").clickMainButtonsForUser();
    }

    /**
     * Click favorites.
     */
    public void clickFavorites() {
        log.info("Нажатие на кнопку 'Избранное'");
        new Button(driver, "Избранное").clickMainButtonsForUser();
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
        WebElement targetElement = waiter.waitForElement(driver, resultElement, 7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    }

    /**
     * Click on cart page.
     */
    public void clickOnCartPage() {
        log.info("Нажатие на кнопку 'Корзина'");
        new Button(driver, "Корзина").clickMainButtonsForUser();
    }
}