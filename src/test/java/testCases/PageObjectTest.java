package testCases;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GetWebDriver;
import pages.LoginPage;
import pages.ProfilPage;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class PageObjectTest {
    private LoginPage loginPage;
    private ProfilPage profilePage;
    private WebDriver driver;
    private static final String USER = "seleniumtests@tut.by";
    private static final String USER_WRONG = "seleniumtests@tut.ru";
    private static final String PASSWORD = "123456789zxcvbn";
    private static final String USER_NAME_EXPECTED = "Selenium Test";

    @BeforeMethod
    public void setUp() {
        driver = GetWebDriver.getInstance().openBrowser();
        loginPage = new LoginPage(driver);
    }

    /*@Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }*/

    @Attachment(value = "driverOptions")
    protected DesiredCapabilities driverOptions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.VERSION, "89");
        capabilities.setCapability("platform", "win10");
        return capabilities;
    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws Exception {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("screenshot for the failed test", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @AfterMethod
    public void browserOptions(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("browserOptions", String.valueOf(driverOptions()));
        }
    }

    @Test
    @Step("Login test")
    @TmsLink("test-1")
    @Description("Some detailed about loginTest ")
    void loginTest() throws IOException {
        profilePage = loginPage.login(USER, PASSWORD);
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
        profilePage.logout();
    }

    @Test
    @TmsLink("test-1")
    @Step("Login test")
    @Description("Example of faild test")
    void loginTestFaild() throws Exception {
        profilePage = loginPage.login(USER_WRONG, PASSWORD);
        Assert.assertEquals(USER_NAME_EXPECTED, profilePage.getLoginTitle());
    }

    @Test
    @Step("Logout test")
    @Description("Some details about logoutTest")
    void logoutTest() {
        profilePage = loginPage.login(USER, PASSWORD);
        profilePage.logout();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page is not displayed!");
    }

    @AfterSuite
    public void close() {
        driver.quit();
    }
}


