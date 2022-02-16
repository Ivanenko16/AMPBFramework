package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.Constants.WEB_DRIVER_FILE_PATH;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class SingletonDriver {

    private static WebDriver driver;

    private SingletonDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, WEB_DRIVER_FILE_PATH);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public static WebDriver getWebDriverInstance() {
        if (driver == null) {
            new SingletonDriver();
        }
        return driver;
    }
}
