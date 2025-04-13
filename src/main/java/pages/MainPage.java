package pages;

import constants.IConstants;
import org.openqa.selenium.*;

public class MainPage extends BasePage{

    public static final By MAIN_BUTTON = By.xpath("//*[@src='https://api-preprod.emall.by/storage/admin/images/2Ndf4o1cG2umQSgVOpE1wAKtgvtiAhCdjNre291A.svg']");
    public static final By ENTER_BUTTON = By.xpath("//*[text()='Войти']");
    public static final By ACTIONS = By.xpath("//*[@href='https://emall.by/actions']");
    public static final By PAYMENT_IN_INSTALLMENTS = By.xpath("//*[@href='https://emall.by/news/3']");
    public static final By LUCKY_GOODS = By.xpath("//*[@href='https://emall.by/actions/lucky-goods']");
    public static final By URGENT_GOODS = By.xpath("//*[@href='https://emall.by/actions/urgent-goods']");
    public static final By TAKE_MORE = By.xpath("//*[@href='https://emall.by/actions/take-more']");
    public static final By CATEGORY4649_DIAPERS = By.xpath("//*[text()='Подгузники' and @href='https://emall.by/category/4649']");
    public static final By CATEGORY3944_FOR_CLEANING = By.xpath("//*[text()='Для уборки' and @href='https://emall.by/category/3944']");
    public static final By CATEGORY4353_BICYCLES = By.xpath("//*[text()='Велосипеды' and @href='https://emall.by/category/4353']");
    public static final By ORDERS = By.xpath("//*[contains(text(),Заказы)]");
    public static final By FAVORITES = By.xpath("//*[contains(text(),Избранное)]");
    public static final By CART = By.xpath("//*[@href='https://emall.by/cart']");
    public static final By SEARCH_INPUT = By.xpath("//*[@enterkeyhint='search']");
    public static final By RESULT_ELEMENT = By.xpath("//*[@aria-label=\"Переход на страницу с товаром Кофе молотый «Egoiste» Noir, натуральный, 100 г\"]");

    public MainPage(WebDriver driver) {
        super(driver);

    }

    public void clickLoginButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    public void clickActions() {
        driver.findElement(ACTIONS).click();
    }

    public void clickPaymentInInstallments() {
        driver.findElement(PAYMENT_IN_INSTALLMENTS).click();
    }

    public void clickLuckyGoods() {
        driver.findElement(LUCKY_GOODS).click();
    }

    public void clickUrgentGoods() {
        driver.findElement(URGENT_GOODS).click();
    }

    public void clickTakeMore() {
        driver.findElement(TAKE_MORE).click();
    }

    public void clickCategoryDiapers() {
        driver.findElement(CATEGORY4649_DIAPERS).click();
    }

    public void clickCategoryForCleaning() {
        driver.findElement(CATEGORY3944_FOR_CLEANING).click();
    }

    public void clickCategoryBicycles() {
        driver.findElement(CATEGORY4353_BICYCLES).click();
    }

    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    public void clickMainButton() {
        driver.findElement(MAIN_BUTTON).click();
    }

    public void clickOrders() {
        driver.findElement(ORDERS).click();
    }

    public void clickFavorites() {
        driver.findElement(FAVORITES).click();
    }

    public void searchProductThroughInputSearchField() {
        driver.findElement(SEARCH_INPUT).sendKeys("кофе");
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.RETURN);
        WebElement targetElement = waiter.waitForElement(driver, RESULT_ELEMENT, 7);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    }

    public void clickOnCartPage() {
        driver.findElement(CART).click();
    }
}