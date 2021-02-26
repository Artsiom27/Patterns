package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[@class = 'uname']")
    private WebElement userMenu;

    @FindBy(xpath = "//div[@class=\"b-popup-i\"]/a")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@class = 'enter']")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@class=\"button m-green auth__enter\"]")
    private WebElement loginButton;

    @FindBy(name = "password")
    private WebElement password;

    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }

    public Boolean logoutCheck() {
        userMenu.click();
        logoutButton.click();
        enterButton.click();
        Boolean logoutCheck = password.isDisplayed();
        return logoutCheck;

    }
}

