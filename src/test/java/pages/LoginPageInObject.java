package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageInObject {

    private static final By userName = By.name("login");
    private static final By password = By.name("password");
    private static final By enterButton = By.xpath("//a[@class = 'enter']");
    private static final By loginButton = By.xpath("//*[@class=\"button m-green auth__enter\"]");
    private static final String URL = "https://www.tut.by/";
    private final WebDriver driver;


    public LoginPageInObject(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }

    public ProfilPageInObject userLogin (String login, String parole) {
        driver.findElement(enterButton).click();
        driver.findElement(userName).sendKeys(login);
        driver.findElement(password).sendKeys(parole);
        driver.findElement(loginButton).click();

        return new ProfilPageInObject(driver);
    }
}
