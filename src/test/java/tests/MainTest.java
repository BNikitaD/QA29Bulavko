package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test()
    public void goToRegistrationPage() {
        mainSteps.registrationPage();
        Assert.assertEquals("https://emall.by/login?backurl=/", "https://emall.by/login?backurl=/");
    }

    @Test(description = "this test check that all buttons in header are working(opening and return on main page")
    public void checkClicabilityHeaderButtons() {
        mainSteps.headerButtons();
        Assert.assertEquals(MAIN_PAGE_URL,MAIN_PAGE_URL);
    }

    @Test(description = "this test check that all buttons in icons are working")
    public void checkClicabilityOfMainButtonsForUsers() {
        mainSteps.mainButtonsForUsers();
        Assert.assertEquals(MAIN_PAGE_URL,MAIN_PAGE_URL);
    }

    @Test(description = "this test check search input")
    public void searchProductInSearchInput() {
        mainSteps.searchProductInSearchInput();
    }
}