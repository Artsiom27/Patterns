package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilPage {

    private static final By USERMENU = By.xpath("//span[@class = 'uname']");
    private static final By LOGOUT_BUTTON = By.xpath("//div[@class=\"b-popup-i\"]/a");

    private final WebDriver driver;

    public ProfilPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginTitle() {
        return driver.findElement(USERMENU).getText();
    }

    public LoginPage logout() {
        driver.findElement(USERMENU).click();
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }
}
