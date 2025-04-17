package elements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@NoArgsConstructor
@AllArgsConstructor
public class Button {

    private WebDriver driver;
    private String elementName;

    private static final By ENTER_BUTTON = By.xpath("//*[text()='Войти']");
    private static final By ACTIONS = By.xpath("//*[@href='https://emall.by/actions']");
    private static final By PAYMENT_IN_INSTALLMENTS = By.xpath("//*[@href='https://emall.by/news/3']");
    private static final By LUCKY_GOODS = By.xpath("//*[@href='https://emall.by/actions/lucky-goods']");
    private static final By URGENT_GOODS = By.xpath("//*[@href='https://emall.by/actions/urgent-goods']");
    private static final By TAKE_MORE = By.xpath("//*[@href='https://emall.by/actions/take-more']");
    private static final By CATEGORY4649_DIAPERS = By.xpath("//*[text()='Подгузники' and @href='https://emall.by/category/4649']");
    private static final By CATEGORY3944_FOR_CLEANING = By.xpath("//*[text()='Для уборки' and @href='https://emall.by/category/3944']");
    private static final By CATEGORY4353_BICYCLES = By.xpath("//*[text()='Велосипеды' and @href='https://emall.by/category/4353']");
    private static final By ORDERS = By.xpath("//*[contains(text(),'Заказы')]");
    private static final By FAVORITES = By.xpath("//*[contains(text(),'Избранное')]");
    private static final By CART = By.xpath("//*[@href='https://emall.by/cart']");

    public void clickHeaders() {
        String header = String.format("//*[@class=\"scrollable-menu_scrollable_menu__swiper__wrapper__gBlF2\" and contains(text(), '%s')]", elementName);
        WebElement element = driver.findElement(By.xpath(header));
        element.click();
    }

    public void clickMainButtonsForUser() {
        String mainButtons = String.format("//*[@class='actions_actions__c5bn_' and contains(text(), '%s')]", elementName);
        WebElement element = driver.findElement(By.xpath(mainButtons));
        element.click();
    }
}
