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

    public void clickHeaders() {
        String header = String.format("//div[@class='scrollable-menu_scrollable_menu__swiper__wrapper__gBlF2']//a[text()]", elementName);
        WebElement element = driver.findElement(By.xpath(header));
        element.click();
    }

    public void clickMainButtonsForUser() {
        String mainButtons = String.format("//*[@class='actions_actions__c5bn_']//a[contains(@class, 'actions_action__button__ptOha')]", elementName);
        WebElement element = driver.findElement(By.xpath(mainButtons));
        element.click();
    }
}