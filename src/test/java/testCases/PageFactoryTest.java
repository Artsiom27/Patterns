package testCases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;


public class PageFactoryTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.get("https://www.tut.by/");
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin("seleniumtests@tut.by");
        loginPage.inputPasswd("123456789zxcvbn");
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
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
