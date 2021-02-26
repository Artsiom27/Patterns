package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement enterButton;

    @FindBy(name = "login")
    private WebElement userName;

    @FindBy(xpath = "//*[@class=\"button m-green auth__enter\"]")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement password;


    public void inputLogin(String login) {
        enterButton.click();
        userName.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        password.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginButton.click();
    }

}


