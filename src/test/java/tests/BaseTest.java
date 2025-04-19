package tests;

import steps.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    MainSteps mainSteps;
    LoginSteps loginSteps;
    AuthorizationPage authorizationPage;
    AuthorizationSteps authorizationSteps;
    ProductPage productPage;
    ProductSteps productSteps;
    CartPage cartPage;
    CartSteps cartSteps;


    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initPages();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        loginSteps = new LoginSteps(driver);
        mainSteps = new MainSteps(driver);
        authorizationSteps = new AuthorizationSteps(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @AfterMethod
    public void endTest(){
        //driver.quit();
    }
}