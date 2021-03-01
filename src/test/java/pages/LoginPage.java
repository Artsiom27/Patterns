package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement enterButton;

    @FindBy(name = "login")
    private WebElement userName;

    @FindBy(xpath = "//*[@class=\"button m-green auth__enter\"]")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement password;

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://www.tut.by/");
        driver.manage().window().maximize();
    }

    public ProfilePage inputLogin(String login, String passwd) {
        enterButton.click();
        userName.sendKeys(login);
        password.sendKeys(passwd);
        loginButton.click();
        return new ProfilePage(driver);
    }
}



