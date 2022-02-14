package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.Constants.WEB_DRIVER_FILE_PATH;

public class SingletonDriver {

    private static WebDriver driver;

    private SingletonDriver() {
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", WEB_DRIVER_FILE_PATH);
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
