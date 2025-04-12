package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.IConstants.MAIN_PAGE_URL;
import static tests.ITestConstants.*;

public class MainTest extends BaseTest {

    @Test()
    public void goToRegistrationPage() {
        mainSteps.registrationPage();
        Assert.assertEquals(driver.getCurrentUrl(), ENTRY_PAGE);
    }

    @Test(description = "this test check that all buttons in header are working(opening and return on main page")
    public void checkClicabilityHeaderButtons() {
        mainSteps.headerButtons();
        Assert.assertEquals(driver.getCurrentUrl(),MAIN_PAGE_URL);
    }

    @Test(description = "this test check that all buttons in icons are working")
    public void checkClicabilityOfMainButtonsForUsers() {
        mainSteps.clicklMainButtonsForUsers();
        Assert.assertEquals(driver.getCurrentUrl(),MAIN_PAGE_URL);
    }

    @Test(description = "this test check search input")
    public void searchProductInSearchInput() {
        mainSteps.searchProductThroughInputSearchField();
        Assert.assertEquals(driver.getCurrentUrl(), URL_OF_PRODUCT);
    }
}