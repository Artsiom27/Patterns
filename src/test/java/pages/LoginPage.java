package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private static final By USERNAME = By.name("login");
    private static final By PASSWORD = By.name("password");
    private static final By ENTER_BUTTON = By.xpath("//a[@class = 'enter']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@class=\"button m-green auth__enter\"]");
    private static final String URL = "https://www.tut.by/";
    private final WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
    }

    public ProfilPage login(String login, String parole) {
        driver.findElement(ENTER_BUTTON).click();
        driver.findElement(USERNAME).sendKeys(login);
        driver.findElement(PASSWORD).sendKeys(parole);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProfilPage(driver);
    }

    public Boolean isLoginPageDisplayed() {
        return driver.findElement(ENTER_BUTTON).isDisplayed();
    }
}
