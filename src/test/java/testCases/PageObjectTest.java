package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.WebDriverSingletion;
import pages.LoginPage;
import pages.ProfilPage;

@Listeners(ListenerTest.class)

public class PageObjectTest {
    private LoginPage loginPage;
    private ProfilPage profilePage;
    private WebDriver driver;
    private static final String USER = "seleniumtests@tut.by";
    private static final String USER_WRONG = "seleniumtests@tut.ru";
    private static final String PASSWORD = "123456789zxcvbn";
    private static final String USER_NAME_EXPECTED = "Selenium Test";
    private static final String URL = "https://www.tut.by/";

    @BeforeSuite
    public void setUp() {
        driver = WebDriverSingletion.getInstance().openBrowser();
        driver.get(URL);
        loginPage = new LoginPage();
    }

    @Test(priority = 2)
    @Step("Login test")
    @TmsLink("test-1")
    @Description("Some detailed about loginTest ")
    void loginTest() {
        profilePage = loginPage.login(USER, PASSWORD);
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }

    @Test(priority = 1)
    @Step("Logout test")
    @Description("Some details about logoutTest")
    void logoutTest() {
        profilePage = loginPage.login(USER, PASSWORD);
        profilePage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed!");
    }

    @Test(priority = 3)
    @TmsLink("test-1")
    @Step("Login test")
    @Description("Example of faild test")
    void loginTestFaild() {
        profilePage = loginPage.login(USER_WRONG, PASSWORD);
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }

    @AfterSuite
    public void close() {
        driver.quit();
    }
}


