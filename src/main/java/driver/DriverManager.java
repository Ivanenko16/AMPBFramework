package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

import static constants.Constants.*;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private static  WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static void createDriverInstance(){
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, WEB_DRIVER_FILE_PATH);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver(){
        if(driverThreadLocal.get() == null){
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
