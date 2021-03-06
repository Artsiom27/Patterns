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
    private static final String USER = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";
    private static final String USER_NAME_EXPECTED = "Selenium Test";


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    void loginTest() throws IOException {
        loginPage.login(USER, PASSWORD);
        profilePage.takeScreenshot("screenAfterLogin");
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }

    @Test
    void logoutTest() {
        loginPage.login(USER, PASSWORD);
        profilePage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed!");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
