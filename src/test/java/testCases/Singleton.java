package testCases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.WebDriverSingleton;

public class Singleton {
    private WebDriver driver;
    private static final String URL = "https://www.tut.by/";

    @BeforeEach
    public void openBrowser() {
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    void openPage() {
        driver.get(URL);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
