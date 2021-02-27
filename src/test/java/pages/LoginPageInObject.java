package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageInObject {
    WebDriver driver;
    By userName = By.name("login");
    By password = By.name("password");
    By enterButton = By.xpath("//a[@class = 'enter']");
    By loginButton = By.xpath("//*[@class=\"button m-green auth__enter\"]");

    public LoginPageInObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLoginAndPassword(String login, String parole) {
        driver.findElement(enterButton).click();
        driver.findElement(userName).sendKeys(login);
        driver.findElement(password).sendKeys(parole);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
