package pages;

import constants.IConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.IConstants.LOGIN_PAGE_URL;

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

    public void loginButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    public void headerButtons() {
        driver.findElement(ACTIONS).click();
        driver.get(IConstants.ACTIONS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(PAYMENT_IN_INSTALLMENTS).click();
        driver.get(IConstants.PAYMENT_IN_INSTALLMENTS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(LUCKY_GOODS).click();
        driver.get(IConstants.LUCKY_GOODS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(URGENT_GOODS).click();
        driver.get(IConstants.URGENT_GOODS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(TAKE_MORE).click();
        driver.get(IConstants.TAKE_MORE);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(CATEGORY4649_DIAPERS).click();
        driver.get(IConstants.CATEGORY4649_DIAPERS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(CATEGORY3944_FOR_CLEANING).click();
        driver.get(IConstants.CATEGORY3944_FOR_CLEANING);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(CATEGORY4353_BICYCLES).click();
        driver.get(IConstants.CATEGORY4353_BICYCLES);
        driver.findElement(MAIN_BUTTON).click();

    }

    public void mainButtonsForUsers() {
        driver.findElement(ENTER_BUTTON).click();
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(ORDERS).click();
        driver.get(IConstants.ORDERS);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(FAVORITES).click();
        driver.get(IConstants.FAVORITES);
        driver.findElement(MAIN_BUTTON).click();
        driver.findElement(CART).click();
        driver.get(IConstants.CART);
        driver.findElement(MAIN_BUTTON).click();
    }

    public void searchProductInSearchInput() {
        driver.findElement(SEARCH_INPUT).sendKeys("кофе");
        driver.findElement(SEARCH_INPUT).sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(RESULT_ELEMENT));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    }

    public void clickOnCartPage() {
        driver.findElement(CART).click();
    }
}