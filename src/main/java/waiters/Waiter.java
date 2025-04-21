package waiters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    public static final By ACCEPT_COOKIE = By.xpath("//*[@type='button' and .//span[text()='Принять']]");
    public static final By AGREEMENT = By.xpath("//*[text()='Согласие']");
    public static final By PROMOCODE = By.xpath("//*[@type='button'][.//span[text()='Отлично!']]");
    public static final By PAYMENT_METHOD = By.xpath("//*[normalize-space(text())='Новой картой онлайн']");

    public WebElement waitForElement(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClicable(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
