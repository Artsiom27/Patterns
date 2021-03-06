package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilPage;


public class PageObjectTest {
    private LoginPage loginPage;
    private ProfilPage profilePage;
    private WebDriver driver;
    private static final String USER = "seleniumtests@tut.by";
    private static final String PASSWORD = "123456789zxcvbn";
    private static final String USER_NAME_EXPECTED = "Selenium Test";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilPage(driver);
    }

    @Test
    void loginTest() {
        loginPage.login(USER, PASSWORD);
        String user = profilePage.getLoginTitle();
        Assert.assertEquals(USER_NAME_EXPECTED, user);
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

