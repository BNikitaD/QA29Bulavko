package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    public String label;
    public static final String CHECKBOX_LOCATOR = "(//span[contains(@class, 'checkbox_checkbox__pseudo__Km_pz') and contains(@class, 'checkbox_checkbox__pseudo_checked__CNCMz')])[3]";
    WebDriver driver;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void setCheckboxValue(boolean selected) {
        WebElement checkbox = driver.findElement(By.xpath(String.format(CHECKBOX_LOCATOR, label)));
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
