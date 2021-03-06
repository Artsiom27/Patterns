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

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getLoginTitle() {
        return userMenu.getText();
    }

    public LoginPage logout() {
        userMenu.click();
        logoutButton.click();
        return new LoginPage(driver);
    }

    public void takeScreenshot(String fileName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.moveFile(src, new File(fileName + ".png"));
    }
}

