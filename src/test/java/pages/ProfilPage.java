package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ProfilPage {

    private static final By USERMENU = By.xpath("//span[@class = 'uname']");
    private static final By LOGOUT_BUTTON = By.xpath("//div[@class=\"b-popup-i\"]/a");

    private final WebDriver driver = WebDriverSingletion.getInstance().openBrowser();

    /*public ProfilPage(WebDriver driver) {
        this.driver = driver;
    }*/

    public String getLoginTitle() {
        return driver.findElement(USERMENU).getText();
    }

    public LoginPage logout() {
        driver.findElement(USERMENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage();
    }

    public void takeScreenshot(String fileName, String fileWithPath) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(src, DestFile);
        FileUtils.moveFile(src, new File(fileName + ".png"));
    }
}
