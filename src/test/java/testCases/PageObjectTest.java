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

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilPage(driver);
    }

    @Test
    void loginTest() {
        loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        String user = profilePage.getLoginTitle();
        Assert.assertEquals("Selenium Test", user);
    }

    @Test
    void logoutTest() {
        loginPage.login("seleniumtests@tut.by", "123456789zxcvbn");
        profilePage.logout();
        Assert.assertTrue(profilePage.logoutCheck());
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

