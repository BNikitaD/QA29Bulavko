package elements;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    public String label;
    WebDriver driver;

    public Checkbox(WebDriver driver) {
        this.driver = driver;
    }

    public Checkbox(String label, WebDriver driver) {
        this.label = label;
        this.driver = driver;
    }

    public void setCheckboxValue(boolean selected, String locator) {
        WebElement checkbox = driver.findElement(By.xpath(String.format(locator, label)));
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void setCheckboxValue(boolean selected, By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (selected && !checkbox.isSelected()) {
            checkbox.click();
        } else if (!selected && checkbox.isSelected()) {
            checkbox.click();
        }
    }
}