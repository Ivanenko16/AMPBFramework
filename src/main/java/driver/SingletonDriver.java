package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.Constants.WEB_DRIVER_FILE_PATH;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class SingletonDriver {

    private static WebDriver driver;

    private SingletonDriver() {
        if (driver == null) {
            System.setProperty(CHROME_DRIVER_EXE_PROPERTY, WEB_DRIVER_FILE_PATH);
        }
    }

    public static WebDriver getWebDriverInstance() {
        new SingletonDriver();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;
    }
}
