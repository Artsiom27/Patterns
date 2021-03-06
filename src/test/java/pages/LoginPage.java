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
    private static final String URL = "https://www.tut.by/";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(URL);
        this.driver.manage().window().maximize();
    }

    public ProfilePage login(String login, String passwd) {
        enterButton.click();
        userName.sendKeys(login);
        password.sendKeys(passwd);
        loginButton.click();
        return new ProfilePage(driver);
    }

    public Boolean isLoginPageDisplayed() {
        return enterButton.isDisplayed();
    }
}



