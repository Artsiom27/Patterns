package testCases;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProfilPage;
import io.qameta.allure.Attachment;

import java.io.IOException;


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
        //profilePage = new ProfilPage(driver);
    }

    @Test(groups = {"loginTests"})
    @Description("Some detailed about loginTest ")
    @Attachment(value = "Page screenshot", type = "png")
    void loginTest() throws IOException {
        profilePage = loginPage.login(USER, PASSWORD);
        profilePage.takeScreenshot("screenAfterLogin");
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }


    @Test(groups = {"logoutTests"})
    @Description("Some details about logoutTest")
    void logoutTest() {
        profilePage = loginPage.login(USER, PASSWORD);
        profilePage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed!");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}

