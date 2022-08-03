package configuration.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Optional;

import static constants.Constants.*;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static void setDriverSetup() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driverThreadLocal.set(driver);
    }

    private static void createDriverInstance() {
        String browser = System.getProperty("browser").toLowerCase();
        switch (browser) {
            case "chrome":
                System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_WEB_DRIVER_FILE_PATH);
                driver = new ChromeDriver();
                setDriverSetup();
                break;
            case "firefox":
                System.setProperty(GECKO_DRIVER_EXE_PROPERTY, GECKO_WEB_DRIVER_FILE_PATH);
                driver = new FirefoxDriver();
                setDriverSetup();
                break;
            default:
                throw new IllegalStateException("This driver is not supported");
        }
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            createDriverInstance();
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver -> {
            webDriver.quit();
            driverThreadLocal.remove();
        });
    }
}
