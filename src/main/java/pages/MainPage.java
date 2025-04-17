package pages;

import elements.Button;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

@Log4j2
public class MainPage extends BasePage{

    public static final By MAIN_BUTTON = By.xpath("//*[contains(@class, 'logo_logo__LbCcG')]");
    public static final By SEARCH_INPUT = By.xpath("//*[@enterkeyhint='search']");
    public static final String RESULT_ELEMENT_TEMPLATE = "//*[@aria-label=\"Переход на страницу с товаром %s\"]";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickActions() {
        log.info("Нажатие на кнопку 'Акции'");
        new Button(driver, "Акции").clickHeaders();
    }

    public void clickPaymentInInstallments() {
        log.info("Нажатие на кнопку 'Оплата частями'");
        new Button(driver, "Оплата частями").clickHeaders();
    }

    public void clickLuckyGoods() {
        log.info("Нажатие на кнопку 'Товары-везунчики'");
        new Button(driver, "Товары-везунчики").clickHeaders();
    }

    public void clickUrgentGoods() {
        log.info("Нажатие на кнопку 'Срочный товар!'");
        new Button(driver, "Срочный товар!").clickHeaders();
    }

    public void clickTakeMore() {
        log.info("Нажатие на кнопку 'Упаковкой выгоднее'");
        new Button(driver, "Упаковкой выгоднее").clickHeaders();
    }

    public void clickCategoryDiapers() {
        log.info("Нажатие на кнопку 'Подгузники'");
        new Button(driver, "Подгузники").clickHeaders();
    }

    public void clickCategoryForCleaning() {
        log.info("Нажатие на кнопку 'Для уборки'");
        new Button(driver, "Для уборки").clickHeaders();
    }

    public void clickCategoryBicycles() {
        log.info("Нажатие на кнопку 'Велосипеды'");
        new Button(driver, "Велосипеды").clickHeaders();
    }

    public void clickEnterButton() {
        log.info("Нажатие на кнопку 'Войти'");
        new Button(driver, "Войти").clickMainButtonsForUser();
    }

    public void clickMainButton() {
        log.info("Нажатие на главную кнопку(Emall)");
        driver.findElement(MAIN_BUTTON).click();
    }

    public void clickOrders() {
        log.info("Нажатие на кнопку 'Заказы'");
        new Button(driver, "Заказы").clickMainButtonsForUser();
    }

    public void clickFavorites() {
        log.info("Нажатие на кнопку 'Избранное'");
        new Button(driver, "Избранное").clickMainButtonsForUser();
    }

    public void searchProductThroughInputSearchField(String searchName,String productName) {
        driver.findElement(SEARCH_INPUT).sendKeys(searchName);
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.RETURN);
        By resultElement = By.xpath(String.format(RESULT_ELEMENT_TEMPLATE, productName));
        WebElement targetElement = waiter.waitForElement(driver, resultElement, 7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    }

    public void clickOnCartPage() {
        log.info("Нажатие на кнопку 'Корзина'");
        new Button(driver, "Корзина").clickMainButtonsForUser();
    }
}