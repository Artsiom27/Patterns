package testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPageInObject;
import pages.ProfilPageInObject;

public class PageObjectTest {
    private LoginPageInObject loginPage;
    private ProfilPageInObject profilePage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPageInObject(driver);
        profilePage = new ProfilPageInObject(driver);
    }

    @Test
    void loginTest() {
        loginPage.userLogin("seleniumtests@tut.by", "123456789zxcvbn");
        String user = profilePage.getLoginTitle();
        Assert.assertEquals("Selenium Test", user);
    }

    @Test
    void logoutTest() {
        loginPage.userLogin("seleniumtests@tut.by", "123456789zxcvbn");
        Assert.assertTrue(profilePage.logoutCheck());
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

