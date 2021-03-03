package testCases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.io.IOException;

public class PageFactoryTest {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    void loginTest() throws IOException {
        loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");

        profilePage.takeScreenshot("screenAfterLogin");
        String user = profilePage.getUserName();

        Assert.assertEquals("Selenium Test", user);
    }

    @Test
    void logoutTest() {
        loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        profilePage.logout();
        Assert.assertTrue(loginPage.);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
