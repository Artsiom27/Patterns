package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilPageInObject {
    WebDriver driver;
    By userMenu = By.xpath("//span[@class = 'uname']");
    By logoutButton = By.xpath("//div[@class=\"b-popup-i\"]/a");
    By enterButton = By.xpath("//a[@class = 'enter']");
    By password = By.name("password");

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
