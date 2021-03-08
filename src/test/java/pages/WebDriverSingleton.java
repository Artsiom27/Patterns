package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriverSingleton instance = null;
    private WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriverSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }

    public WebDriver openBrowser() {
        driver = new ChromeDriver();
        return driver;
    }
}
