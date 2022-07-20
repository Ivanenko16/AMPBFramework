import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static constants.Constants.CHROME_WEB_DRIVER_FILE_PATH;
import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class GridTest {

    WebDriver driver;
    String baseUrl, nodeUrl;

    @Before
    public void setUp() throws MalformedURLException {
        baseUrl = "http://google.com";
        nodeUrl = "http://192.168.1.9:4444/wd/hub";
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_WEB_DRIVER_FILE_PATH);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("local", "true");
        browserstackOptions.put("seleniumVersion", "4.2.1");
        capabilities.setCapability("bstack:options", browserstackOptions);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void simpleTest() {
        driver.get(baseUrl);
        Assertions.assertEquals("Google", driver.getTitle(), "Incorrect page title");
    }
}
