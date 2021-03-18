package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWebDriver {

    private static GetWebDriver instance = null;
    private WebDriver driver = new ChromeDriver();

    private GetWebDriver() {
    }

    public static GetWebDriver getInstance() {
        if (instance == null) {
            instance = new GetWebDriver();
        }
        return instance;
    }

    public WebDriver openBrowser() {
        return driver;
    }
}