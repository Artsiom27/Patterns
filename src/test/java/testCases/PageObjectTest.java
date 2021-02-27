package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPageInObject;
import pages.ProfilPageInObject;

public class PageObjectTest {
    public static LoginPageInObject loginPage;
    public static ProfilPageInObject profilePage;
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPageInObject(driver);
        profilePage = new ProfilPageInObject(driver);
        driver.get("https://www.tut.by/");
    }

    @Test
    public void loginTest() {
        loginPage.inputLoginAndPassword("seleniumtests@tut.by","123456789zxcvbn" );
        loginPage.clickLoginButton();
        String user = profilePage.getLoginTitle();
        Assert.assertEquals("Selenium Test", user);
    }

    @Test
    public void logoutTest() {
        Assert.assertTrue(profilePage.logoutCheck());
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}

