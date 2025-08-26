package pages;

import waiters.Waiter;
import constants.IConstants;
import org.openqa.selenium.WebDriver;

public abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiter waiter;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter();
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
