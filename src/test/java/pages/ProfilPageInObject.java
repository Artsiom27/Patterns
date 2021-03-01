package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilPageInObject {

    private static final By userMenu = By.xpath("//span[@class = 'uname']");
    private static final By logoutButton = By.xpath("//div[@class=\"b-popup-i\"]/a");
    private static final By enterButton = By.xpath("//a[@class = 'enter']");
    private static final By password = By.name("password");

    private final WebDriver driver;

    public ProfilPageInObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getLoginTitle(){
        return    driver.findElement(userMenu).getText();

    }
    public Boolean logoutCheck() {
        driver.findElement(userMenu).click();
        driver.findElement(logoutButton).click();
        driver.findElement(enterButton).click();
        Boolean logoutCheck = driver.findElement(password).isDisplayed();
        return logoutCheck;

    }
}
