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
    private static final String HEADER_BUTTON_LOCATOR = "//*[contains(@class, 'scrollable-menu')]//*[contains(text(), '%s')]";
    private static final String ACTIONS_BUTTON_LOCATOR = "//*[contains(@class, 'actions')]//*[contains(text(), '%s')]";

    public void clickHeaders() {
        String headerXpath = String.format(HEADER_BUTTON_LOCATOR, elementName);
        WebElement element = driver.findElement(By.xpath(headerXpath));
        element.click();
    }

    public void clickMainButtonsForUser() {
        String mainButtonsXpath = String.format(ACTIONS_BUTTON_LOCATOR, elementName);
        WebElement element = driver.findElement(By.xpath(mainButtonsXpath));
        element.click();
    }
}
