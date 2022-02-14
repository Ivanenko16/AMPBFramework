package runner;

import desktop.pages.BookDepositoryLoginPage;
import driver.SingletonDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static constants.Constants.HOME_URL;

public class TestRunner {


    WebDriver driver = SingletonDriver.getWebDriverInstance();

    @Test
    public void clearEmailButtonIsAppeared() {

        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .switchToLogInFrame()
                .setEmail("tractor@gmail.com");

        String style = BookDepositoryLoginPage.getStyleClearEmailButton();

        Assert.assertEquals("display: block;", style);
    }

    @Test
    public void navigateToHomePage() {
        new BookDepositoryLoginPage(driver)
                .openBookDepositoryLoginPage()
                .getNavigationBar()
                .navigateToHomePage();

        String url = driver.getCurrentUrl();

        Assert.assertEquals(HOME_URL, url);
    }

    @After

    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}