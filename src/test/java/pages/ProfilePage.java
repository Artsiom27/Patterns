package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class ProfilePage {

    @FindBy(xpath = "//span[@class = 'uname']")
    private WebElement userMenu;

    @FindBy(xpath = "//div[@class=\"b-popup-i\"]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class=\"button m-green auth__enter\"]")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement password;

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }

    public Boolean logoutCheck() {
        userMenu.click();
        logoutButton.click();
        enterButton.click();
        Boolean logoutCheck = password.isDisplayed();
        return logoutCheck;
    }

    public void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(src, new File(fileName + ".png"));
    }
}

